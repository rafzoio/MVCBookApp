<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="books" scope="request" type="java.util.List"/>
<jsp:useBean id="pageNumber" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="numberOfPages" scope="request" type="java.lang.Integer"/>
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
                <td>
                    <div style="display: flex; flex-direction: column">
                        <a href="${pageContext.request.contextPath}/bookDetail?id=${book.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/updateBook?id=${book.id}">Update</a>
                        <a href="${pageContext.request.contextPath}/deleteBook?id=${book.id}">Delete</a>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<nav>
    <ul class="page-selector">

        <c:if test="${pageNumber > 1}">
            <li><a href="${pageContext.request.contextPath}/books?page=${pageNumber-1}">Previous</a></li>
        </c:if>
        <c:forEach var="i" begin="${(pageNumber-2) <= 1 ? 1 : (pageNumber-2)}" end="${pageNumber + 2}">
                <li class="${i == pageNumber ? 'active' : ''}"><a href="${pageContext.request.contextPath}/books?page=${i}">${i}</a></li>
        </c:forEach>
        <li><a href="${pageContext.request.contextPath}/books?page=${pageNumber+1}">Next</a></li>
        <li><a href="${pageContext.request.contextPath}/books?page=${numberOfPages}">Last</a></li>
    </ul>
</nav>
</body>
</html>
