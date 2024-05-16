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
import java.util.List;

@WebServlet(name = "createShipmentController", value = "/create-shipment")
public class CreateShipmentController extends BaseServlet {

    private CollectionPointDao collectionPointDao;
    private DeliveryAddressDao deliveryAddressDao;

    @Override
    public void init() {
        collectionPointDao = new CollectionPointDao();
        deliveryAddressDao = new DeliveryAddressDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CollectionPoint> collectionPoints = collectionPointDao.listAllCollectionPoints();
        List<DeliveryAddress> deliveryAddresses = deliveryAddressDao.listAllDeliveryAddresses();

        request.setAttribute("collectionPoints", collectionPoints);
        request.setAttribute("deliveryAddresses", deliveryAddresses);

        serveJSP(request, response, "createShipment.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cpId = Integer.parseInt(request.getParameter("cpId"));
        int daId = Integer.parseInt(request.getParameter("daId"));

        CollectionPoint collectionPoint = collectionPointDao.getCollectionPointById(cpId);
        DeliveryAddress deliveryAddress = deliveryAddressDao.getDeliveryAddressById(daId);

        request.getSession().setAttribute("collectionPoint", collectionPoint);
        request.getSession().setAttribute("deliveryAddress", deliveryAddress);

        response.sendRedirect("shipment-detail");
    }
}
