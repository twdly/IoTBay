package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.CollectionPointDao;
import isdwrk04.group5.iotbay.dao.DeliveryAddressDao;
import isdwrk04.group5.iotbay.model.CollectionPoint;
import isdwrk04.group5.iotbay.model.DeliveryAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateShipmentController", value = "/update-shipment")
public class UpdateShipmentController extends BaseServlet {

    private CollectionPointDao collectionPointDao;
    private DeliveryAddressDao deliveryAddressDao;

    @Override
    public void init() {
        collectionPointDao = new CollectionPointDao();
        deliveryAddressDao = new DeliveryAddressDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        serveJSP(request, response, "updateShipment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpId = Integer.parseInt(request.getParameter("cpId"));
        String cpName = request.getParameter("cpName");
        String cpAddress = request.getParameter("cpAddress");
        int cpCityId = Integer.parseInt(request.getParameter("cpCityId"));

        int daId = Integer.parseInt(request.getParameter("daId"));
        String daAddress = request.getParameter("daAddress");
        int daCityId = Integer.parseInt(request.getParameter("daCityId"));

        CollectionPoint collectionPoint = new CollectionPoint(cpId, cpName, cpAddress, cpCityId);
        DeliveryAddress deliveryAddress = new DeliveryAddress(daId, daAddress, daCityId);

        collectionPointDao.updateCollectionPoint(collectionPoint);
        deliveryAddressDao.updateDeliveryAddress(deliveryAddress);

        response.sendRedirect("list-shipment");
    }
}
