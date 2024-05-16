package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.Order;
import isdwrk04.group5.iotbay.model.PaymentDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "paymentController", value = "/payment")
public class PaymentController extends BaseServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order currentOrder = (Order) session.getAttribute("currentOrder");

        if (currentOrder == null) {
            // If there's no current order, redirect to the place order page
            redirectToUrl(request, response, "/place-order");
        } else {
            // Otherwise, serve the payment creation page
            serveJSP(request, response, "payment_create.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            handleDelete(request, response);
        } else {
            handlePaymentCreation(request, response);
        }
    }

    private void handlePaymentCreation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameOnCard = request.getParameter("nameOnCard");
        String cardNumber = request.getParameter("cardNumber");
        String cvv = request.getParameter("cvv");
        String expDate = request.getParameter("expDate");
        String billingAddress = request.getParameter("billingAddress");

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCardholder(nameOnCard);
        paymentDetails.setCardNumber(cardNumber);
        paymentDetails.setCvv(cvv);
        paymentDetails.setExpirationDate(expDate);
        paymentDetails.setBillingAddress(billingAddress);

        request.getSession().setAttribute("paymentDetails", paymentDetails);

        // Redirect to confirmation page
        response.sendRedirect("/confirmOrder");
    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PaymentDetails paymentDetails = (PaymentDetails) session.getAttribute("paymentDetails");
        if (paymentDetails != null) {
            session.removeAttribute("paymentDetails");
            redirectToUrl(request, response, "/payment");
        } else {
            redirectToUrl(request, response, "/confirmOrder?error=true");
        }
    }
}
