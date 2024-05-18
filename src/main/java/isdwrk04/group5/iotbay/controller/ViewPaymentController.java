package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.PaymentDao;
import isdwrk04.group5.iotbay.model.PaymentDetails;
import isdwrk04.group5.iotbay.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "viewPaymentController", value = "/view-payment")
public class ViewPaymentController extends BaseServlet {

    private static final String LOGIN_VIEW = "login.jsp";
    private static final String PAYMENT_VIEW = "viewPayment.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(USER_ATTRIBUTE);
        if (user == null) {
            serveJSP(request, response, LOGIN_VIEW);
            return;
        }

        PaymentDao paymentDao = new PaymentDao();
        List<PaymentDetails> paymentDetailsList = paymentDao.getPaymentsByUserId(user.getId());

        request.setAttribute("payments", paymentDetailsList);
        serveJSP(request, response, PAYMENT_VIEW);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(USER_ATTRIBUTE);
        if (user == null) {
            serveJSP(request, response, LOGIN_VIEW);
            return;
        }

        String filterType = request.getParameter("filterType");
        PaymentDao paymentDao = new PaymentDao();
        List<PaymentDetails> paymentDetailsList;

        if (filterType != null) {
            switch (filterType) {
                case "dateRange":
                    String startDate = request.getParameter("startDate");
                    String endDate = request.getParameter("endDate");
                    paymentDetailsList = paymentDao.getPaymentsByDateRange(user.getId(), startDate, endDate);
                    break;
                case "status":
                    String status = request.getParameter("status");
                    paymentDetailsList = paymentDao.getPaymentsByStatus(user.getId(), PaymentDetails.Status.valueOf(status));
                    break;
                case "method":
                    String method = request.getParameter("method");
                    paymentDetailsList = paymentDao.getPaymentsByMethod(user.getId(), PaymentDetails.Method.valueOf(method));
                    break;
                default:
                    paymentDetailsList = paymentDao.getPaymentsByUserId(user.getId());
            }
        } else {
            paymentDetailsList = paymentDao.getPaymentsByUserId(user.getId());
        }

        request.setAttribute("payments", paymentDetailsList);
        serveJSP(request, response, PAYMENT_VIEW);
    }
}
