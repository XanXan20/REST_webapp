<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>

<table>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>full name</th>
        <th>phone number</th>
        <th>address</th>

    </tr>

    <c:forEach var="emp" items="${allEmployees}">

        <c:url var="updateButton" value="/updateEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>
        <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

        <tr>
            <td>${emp.login}</td>
            <td>${emp.password}</td>
            <td>${emp.fullName}</td>
            <td>${emp.phoneNumber}</td>
            <td>${emp.address}</td>
            <td>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/>
                <input type="button" value="Delete"
                       onclick="window.location.href = '${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<br>
<input type="button" value="Add"
       onclick="window.location.href='addNewEmployee'">

</body>
</html>