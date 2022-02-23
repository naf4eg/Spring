<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registered Car</title>
</head>
<body>
    Car: ${car.modelName}
    <br><br>
    Color: ${car.color}
    <br><br>
    Country: ${car.country}
    <br><br>
    Car fuel: ${car.engineFuel}
    <br><br>
    <ul>
        <c:forEach var="temp" items="${car.listChooseCarOptions}">
            <li>${temp}</li>
        </c:forEach>
    </ul>
    <br><br>
    Driver Full Name: ${driver.firstName} ${driver.lastName}
    <br><br>
    Driving experience: ${driver.drivingExperience}
    <br><br>
    Driver's license: ${driver.driversLicense}
</body>
</html>
