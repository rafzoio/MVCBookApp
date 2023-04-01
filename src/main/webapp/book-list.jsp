<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Books</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet">
</head>
<body>
<h1>All Books</h1>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Date</th>
            <th>Genres</th>
            <th>Options</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.date}</td>
                <td>${book.genres}</td>
                <td><a href="${pageContext.request.contextPath}/bookDetail?id=${book.id}">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<nav>
    <ul class="page-selector">
        <c:forEach var = "i" begin = "1" end = "${numPages}">
            <li><a href="${pageContext.request.contextPath}/books?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>
