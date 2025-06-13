package com.mycompany.electricbillingweb;

import com.mycompany.electricbillingweb.logic.Calculator;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/calculate")
public class BillingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String appliance = request.getParameter("appliance");
            int wattage = Integer.parseInt(request.getParameter("wattage"));
            int usage = Integer.parseInt(request.getParameter("usage"));
            String usageType = request.getParameter("usageType");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            int adjustedUsage = usageType.equals("Day") ? (usage * 30) : usage;

            double consumption = Calculator.calculateConsumption(wattage, adjustedUsage, quantity);
            double amount = Calculator.calculateBillAmount(consumption);
            double serviceCharge = Calculator.calculateServiceCharge(amount);
            double total = Calculator.calculateTotalBill(amount, serviceCharge);

            // Set attributes to pass to JSP
            request.setAttribute("appliance", appliance);
            request.setAttribute("consumption", consumption);
            request.setAttribute("amount", amount);
            request.setAttribute("serviceCharge", serviceCharge);
            request.setAttribute("total", total);

            // Forward to result.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Please enter valid numeric input.");
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }
}
