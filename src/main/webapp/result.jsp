<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bill Result</title>
</head>
<body>
<h2>Electricity Bill Result</h2>

<p>Total Consumption: ${consumption} kWh/month</p>
<p>Amount: ${amount} ETB</p>
<p>Service Charge: ${serviceCharge} ETB</p>
<p><strong>Total Billable Amount: ${total} ETB</strong></p>

<a href="form.jsp">Calculate Again</a>

</body>
</html>
