<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Car Registration Form</title>

    <style>
        .error{color:red}
    </style>
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
        <br><br><br><br>

        <form:form action="showRegisteredForm" modelAttribute="driver">
            Driver first name (*): <form:input path="firstName"/>  <form:errors path="firstName" cssClass="error"/>
            <br><br>
            Driver last name (*):<form:input path="lastName"/>  <form:errors path="lastName" cssClass="error"/>
            <br><br>
            Driving experience (0-50):<form:input path="drivingExperience"/>  <form:errors path="drivingExperience" cssClass="error"/>
            <br><br>
            Driver's license:<form:input path="driversLicense"/>  <form:errors path="driversLicense" cssClass="error"/>
            <br><br>
            <input type="submit" name="submit"/>
        </form:form>
    </form:form>

</body>
</html>
