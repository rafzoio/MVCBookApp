<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${book.title}</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap" rel="stylesheet">
</head>
<body>
<h1>Book Details</h1>

<div class="book-info">
    <div>
        <h2>ID</h2>
        <p>${book.id}</p>
    </div>
    <div>
        <h2>Title</h2>
        <p>${book.title}</p>
    </div>
    <div>
        <h2>Author</h2>
        <p>${book.author}</p>
    </div>
    <div>
        <h2>Date</h2>
        <p>${book.date}</p>
    </div>
    <div>
        <h2>Genres</h2>
        <p>${book.genres}</p>
    </div>
    <div>
        <h2>Characters</h2>
        <p>${book.characters}</p>
    </div>
    <div>
        <h2>Synopsis</h2>
        <p>${book.synopsis}</p>
    </div>
</div>
</body>
</html>
