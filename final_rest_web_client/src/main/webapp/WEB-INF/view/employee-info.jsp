<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<form:form action="saveEmployee" modelAttribute="employee">

    <form:hidden path="id"/>

    Login <form:input path="login"/>
    <br>
    <br>
    Password <form:input path="password"/>
    <br>
    <br>
    Full Name <form:input path="fullName"/>
    <br>
    <br>
    Phone Number <form:input path="phoneNumber"/>
    <br>
    <br>
    Address <form:input path="address"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>