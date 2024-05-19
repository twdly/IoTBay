package isdwrk04.group5.iotbay.controller;

import isdwrk04.group5.iotbay.model.CollectionPoint;
import isdwrk04.group5.iotbay.model.DeliveryAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "shipmentDetailsController", value = "/shipment-details")
public class ShipmentDetailsController extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CollectionPoint collectionPoint = (CollectionPoint) request.getSession().getAttribute("collectionPoint");
        DeliveryAddress deliveryAddress = (DeliveryAddress) request.getSession().getAttribute("deliveryAddress");

        request.setAttribute("collectionPoint", collectionPoint);
        request.setAttribute("deliveryAddress", deliveryAddress);

        serveJSP(request, response, "shipmentDetails.jsp");
    }
}
