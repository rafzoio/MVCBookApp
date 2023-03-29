<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
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
                <td><a href="${pageContext.request.contextPath}/MVCBookApp/bookDetail?id=${book.id}">Details</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
