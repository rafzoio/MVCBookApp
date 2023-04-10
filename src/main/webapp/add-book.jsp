<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/form.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet">
</head>
<body>
<%@ include file="/WEB-INF/jspf/navbar.jspf" %>
<h1>Add a new book</h1>
<div class="form-container">
    <form action="${pageContext.request.contextPath}/addBook" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required><br>

        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br>

        <label for="date">Date:</label>
        <input type="date" id="date" name="date"><br>

        <label for="genres">Genres:</label>
        <input type="text" id="genres" name="genres"><br>

        <label for="characters">Characters:</label>
        <input type="text" id="characters" name="characters"><br>

        <label for="synopsis">Synopsis:</label><br>
        <textarea id="synopsis" name="synopsis" rows="5" cols="40"></textarea><br>

        <input type="submit" value="Submit">
    </form>
</div>
</body>
</html>
