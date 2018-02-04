<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="en_GB"/>
<%--value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"--%>
<%--scope="session"/>--%>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>
<!DOCTYPE html>
<html lang="${language}">
<head>
    <meta charset="UTF-8"/>
    <title><fmt:message key="home.appName" bundle="${finAppLanguage}"/></title>
    <link rel="stylesheet" href="../css/style.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
          integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/portal/home"><fmt:message key="home.appName" bundle="${finAppLanguage}"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#"><fmt:message key="home.homePage" bundle="${finAppLanguage}"/> <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#"><fmt:message key="home.contact" bundle="${finAppLanguage}"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout"><fmt:message key="home.logout" bundle="${finAppLanguage}"/></a>
            </li>
        </ul>
    </div>
    <div>
        <ul style="list-style-type: none">
            <li value="pl" style="display: inline">
                <img src="../img/pl.gif" alt="polski" title="pl">
            </li>
            <li value="en" style="display: inline">
                <img src="../img/en.gif" alt="english" title="en">
            </li>
            <li value="de" style="display: inline">
                <img src="../img/de.gif" alt="deutsch" title="de">
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col col-sm-12 col-lg-8 offset-lg-2" style="background-color: rgba(255,255,255,0.7)">

            <%-- Here you need to set total number of form steps --%>
            <c:set var="steps" scope="application" value="3"/>

            <h2>Krok <c:out value="${step} z ${steps}"/></h2>

            <c:set var="progress" scope="request" value="${(100/steps)*step}"/>

            <div class="progress">
                <div class="progress-bar progress-bar-striped bg-info progress-bar-animated" role="progressbar"
                     style="width: <c:out value="${progress}"/>%"
                     aria-valuenow="<c:out value="${progress}"/>"
                     aria-valuemin="0" aria-valuemax="100">
                </div>
            </div>

            <jsp:include page="form-step-${step}.jsp"/>

        </div>
    </div>
</div>

<script src="../js/jquery-3.2.1.slim.min.js"></script>
<script src="../js/popper.min.js"></script>

<script>
    (function () {
        'use strict';

        window.addEventListener('load', function () {
            var form = document.getElementById('form');
            document.getElementById('next').addEventListener('click', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        }, false);
    })();
</script>

</body>
</html>