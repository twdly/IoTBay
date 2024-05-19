package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.dao.CollectionPointDao;
import isdwrk04.group5.iotbay.dao.DeliveryAddressDao;
import isdwrk04.group5.iotbay.model.CollectionPoint;
import isdwrk04.group5.iotbay.model.DeliveryAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewShipmentController", value = "/view-shipment")
public class ViewShipmentController extends HttpServlet {

    private CollectionPointDao collectionPointDao;
    private DeliveryAddressDao deliveryAddressDao;

    @Override
    public void init() {
        collectionPointDao = new CollectionPointDao();
        deliveryAddressDao = new DeliveryAddressDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpIdStr = request.getParameter("cpId");
        String daIdStr = request.getParameter("daId");

        if (cpIdStr == null || daIdStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters.");
            return;
        }

        try {
            int cpId = Integer.parseInt(cpIdStr);
            int daId = Integer.parseInt(daIdStr);

            CollectionPoint collectionPoint = collectionPointDao.getCollectionPointById(cpId);
            DeliveryAddress deliveryAddress = deliveryAddressDao.getDeliveryAddressById(daId);

            if (collectionPoint == null || deliveryAddress == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Shipment not found.");
                return;
            }

            request.setAttribute("collectionPoint", collectionPoint);
            request.setAttribute("deliveryAddress", deliveryAddress);

            request.getRequestDispatcher("viewShipment.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid parameters.");
        }
    }
}
