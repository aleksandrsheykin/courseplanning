<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
    <h2>Main</h2>
    <a href="/">index</a>
    <a href="/login">login</a><br/>
    <a href="/registration">registration</a><br/>
    <a href="/main">main</a><br/>

    <table>
        <c:forEach items="${requestScope.planList}" var="plan">
            <tr>
                <td><c:out value="${plan.id_plan}"></c:out></td>
                <td><c:out value="${plan.datePlan}"></c:out></td>
                <td><c:out value="${plan.quantity}"></c:out></td>
                <td><c:out value="${plan.cost}"></c:out></td>
                <td><c:out value="${plan.user_id}"></c:out></td>
                <td><c:out value="${plan.product_id}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
