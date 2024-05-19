package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.CollectionPointDao;
import isdwrk04.group5.iotbay.dao.DeliveryAddressDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteShipmentController", value = "/delete-shipment")
public class DeleteShipmentController extends BaseServlet {

    private CollectionPointDao collectionPointDao;
    private DeliveryAddressDao deliveryAddressDao;

    @Override
    public void init() {
        collectionPointDao = new CollectionPointDao();
        deliveryAddressDao = new DeliveryAddressDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serveJSP(request, response, "deleteShipment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpId = Integer.parseInt(request.getParameter("cpId"));
        int daId = Integer.parseInt(request.getParameter("daId"));

        collectionPointDao.deleteCollectionPoint(cpId);
        deliveryAddressDao.deleteDeliveryAddress(daId);

        response.sendRedirect("list-shipment");
    }
}
