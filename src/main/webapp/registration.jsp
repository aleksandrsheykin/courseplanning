<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/starter-template.css" rel="stylesheet">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index">Planning</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="index">Index</a></li>
                <li><a href="main">Main</a></li>
                <li><a href="login">Login</a></li>
                <li class="active"><a href="registration">Registration</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div>

<div class="container">

    <div class="starter-template">
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">

                <form class="form" action="/planning/registration" method="post">
                    <h2 class="form-signin-heading">Registration</h2>

                    <input type="text" class="form-control" placeholder="firstName" name="firstName" required autofocus>
                    <input type="text" class="form-control" placeholder="lastName" name="lastName" required>
                    <input type="number" class="form-control" placeholder="limit" name="limit" required>
                    <input type="email" class="form-control" placeholder="Mail" name="mail" required>
                    <input type="password" class="form-control" placeholder="Password" name="password" required>
                    <button class="btn btn-lg btn-success btn-block" type="submit" name="registration">Registration</button>
                </form>

            </div>
            <div class="col-md-4"></div>
        </div>
    </div>
</div>

</body>
</html>