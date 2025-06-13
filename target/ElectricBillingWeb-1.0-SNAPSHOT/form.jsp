<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Electricity Billing - Web Form</title>
</head>
<body>
    <h2>Enter Appliance Details</h2>

    <form action="calculate" method="post">
        <label>Appliance Name:</label><br>
        <input type="text" name="appliance" required><br><br>

        <label>Wattage (W):</label><br>
        <input type="number" name="wattage" required><br><br>

        <label>Usage Time (hours):</label><br>
        <input type="number" name="usage" required><br><br>

        <label>Usage Type:</label><br>
        <input type="radio" name="usageType" value="Day" checked> Day
        <input type="radio" name="usageType" value="Month"> Month<br><br>

        <label>Quantity:</label><br>
        <input type="number" name="quantity" required><br><br>

        <input type="submit" value="Calculate">
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>
