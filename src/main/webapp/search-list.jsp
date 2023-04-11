<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="books" scope="request" type="java.util.List"/>
<jsp:useBean id="searchQuery" scope="request" type="java.lang.String"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Books</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/list.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<h1>Results for "${searchQuery}":</h1>
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
                <td>
                    <div style="display: flex; flex-direction: column">
                        <a href="${pageContext.request.contextPath}/bookDetail?id=${book.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/updateBook?id=${book.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/deleteBook?id=${book.id}">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
