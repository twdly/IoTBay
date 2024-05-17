package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.PaymentDao;
import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.PaymentDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
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
        String nameOnCard = request.getParameter("nameOnCard");
        String cardNumber = request.getParameter("cardNumber");
        String cvv = request.getParameter("cvv");
        String expDate = request.getParameter("expDate");
        String billingAddress = request.getParameter("billingAddress");

        if (isNullOrEmpty(nameOnCard) || isNullOrEmpty(cardNumber) || isNullOrEmpty(cvv) || isNullOrEmpty(expDate) || isNullOrEmpty(billingAddress)) {
            List<String> errors = new ArrayList<>();
            errors.add("Please enter your Payment Details");
            request.getSession().setAttribute("errors", errors);
            serveJSP(request, response, "payment.jsp");
            return;
        }

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCardholder(nameOnCard);
        paymentDetails.setCardNumber(cardNumber);
        paymentDetails.setCvv(cvv);
        paymentDetails.setExpirationDate(expDate);
        paymentDetails.setBillingAddress(billingAddress);

        paymentDao.addPaymentDetails(paymentDetails, paymentDetails.getId());

        request.getSession().setAttribute("paymentDetails", paymentDetails);

        // Redirect to the confirmation page or the next step
        response.sendRedirect("/confirmOrder");
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
