package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.PaymentDetails;
import isdwrk04.group5.iotbay.dao.PaymentDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebServlet(name = "paymentController", value = "/payment")
public class PaymentController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("currentOrder");
        if (order == null) {
            redirectToUrl(request, response, "/place-order");
            return;
        }
        serveJSP(request, response, "/WEB-INF/payment.jsp");
    }

    private final PaymentDao paymentDao = new PaymentDao();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("userId");

        // Retrieving payment details from the request parameters
        String nameOnCard = request.getParameter("nameOnCard");
        String cardNumber = request.getParameter("cardNumber");
        String cvv = request.getParameter("cvv");
        String expDate = request.getParameter("expDate");
        String billingAddress = request.getParameter("billingAddress");

        // Validating payment details
        List<String> errors = new ArrayList<>();
        if (isNullOrEmpty(nameOnCard)) {
            errors.add("Please enter the name on the card.");
        }
        if (!isValidCardNumber(cardNumber)) {
            errors.add("Please enter a valid card number.");
        }
        if (!isValidCVV(cvv)) {
            errors.add("Please enter a valid CVV.");
        }
        if (!isValidExpDate(expDate)) {
            errors.add("Please enter a valid expiration date.");
        }
        if (isNullOrEmpty(billingAddress)) {
            errors.add("Please enter the billing address.");
        }

        // If there are validation errors, serve the payment page again with error messages
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            serveJSP(request, response, "/WEB-INF/payment.jsp");
            return;
        }

        // Creating a PaymentDetails object with the provided payment details
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCardholder(nameOnCard);
        paymentDetails.setCardNumber(cardNumber);
        paymentDetails.setCvv(cvv);
        paymentDetails.setExpirationDate(LocalDate.parse(expDate));
        paymentDetails.setBillingAddress(billingAddress);

        // Adding payment details to the database using PaymentDao
        paymentDao.addPaymentDetails(paymentDetails, userId);

        // Setting the paymentDetails attribute in the session
        request.getSession().setAttribute("paymentDetails", paymentDetails);

        // Redirecting to the confirmation page or the next step
        response.sendRedirect("/confirmOrder");
    }


    private boolean isValidCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.matches("^\\d{16}$");
    }

    private boolean isValidCVV(String cvv) {
        return cvv != null && (cvv.matches("^\\d{3}$") || cvv.matches("^\\d{4}$"));
    }

    private boolean isValidExpDate(String expDate) {
        if (expDate != null && expDate.matches("^\\d{2}/\\d{2}$")) {
            String[] parts = expDate.split("/");
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);

            // Check if the month is between 1 and 12 and the year is in the future
            return month >= 1 && month <= 12 && (year > Calendar.getInstance().get(Calendar.YEAR) || (year == Calendar.getInstance().get(Calendar.YEAR) && month >= Calendar.getInstance().get(Calendar.MONTH) + 1));
        }
        return false;
    }
    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
