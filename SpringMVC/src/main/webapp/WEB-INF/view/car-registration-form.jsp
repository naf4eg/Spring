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
            <form:option value="Japan" label="Japan"/>
            <form:option value="Germany" label="Germany"/>
            <form:option value="Russia" label="Russia"/>
            <form:option value="USA" label="USA"/>
        </form:select>
        <br><br>
        <input type="submit" name="submit"/>
    </form:form>
</body>
</html>