<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Car Registration Form</title>
</head>
<body>
    <form:form action="showRegisteredForm" modelAttribute="car">
        Car model name: <form:input path="modelName"/>
        <br><br>
        Car color: <form:input path="color"/>
        <br><br>
        Country:
        <form:select path="country">
            <form:options items="${car.countryList}"/>
        </form:select>
        <br><br>
        <form:radiobuttons items="${car.engineFuelList}"  path="engineFuel"/>
        <br><br>
        <form:checkboxes items="${car.listCarOptions}" path="listChooseCarOptions" />
        <br><br>
        <input type="submit" name="submit"/>
    </form:form>
</body>
</html>
