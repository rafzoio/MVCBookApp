<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="book" scope="request" type="com.rz.mvcbookapp.model.Book"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet">
</head>
<body>
<h1>Update the book </h1>
<form action="${pageContext.request.contextPath}/updateBook" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${book.title}" required readonly><br>

    <label for="author">Author:</label>
    <input type="text" id="author" name="author" value="${book.author}" required><br>

    <label for="date">Date:</label>
    <input type="date" id="date" name="date" value="${book.date}"><br>

    <label for="genres">Genres:</label>
    <input type="text" id="genres" name="genres" value="${book.genres}"><br>

    <label for="characters">Characters:</label>
    <input type="text" id="characters" name="characters" value="${book.characters}"><br>

    <label for="synopsis">Synopsis:</label><br>
    <textarea id="synopsis" name="synopsis" rows="5" cols="40">${book.synopsis}</textarea><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
