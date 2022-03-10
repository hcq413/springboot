<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jsp初次使用</title>
</head>
<body>
<ul>
    <c:forEach items="${User}" var="user">
        <li>
                ${user.name};${user.age};${user.hobby}
        </li>
    </c:forEach>
</ul>
</body>
</html>
