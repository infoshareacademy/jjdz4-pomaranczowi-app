<%--
  Created by IntelliJ IDEA.
  User: mateusz
  Date: 11.03.18
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${sessionScope.language == null}">
    <c:set var="language" scope="session" value="en_GB"/>
</c:if>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="fin-app" var="finAppLanguage"/>


<html lang="${language}">
<head>
    <meta charset="UTF-8"/>
    <title><fmt:message key="home.appName" bundle="${finAppLanguage}"/></title>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/index.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/portal/home">Financial Analyser</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home page <span
                        class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Contact</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
        </ul>
    </div>
    <div>
        <ul style="list-style-type: none">
            <li value="pl" style="display: inline">
                <a href="?lang=pl_PL">
                    <img src="../img/pl.gif" alt="polski" title="pl">
                </a>
            </li>
            <li value="en" style="display: inline">
                <a href="?lang=en_GB">
                    <img src="../img/en.gif" alt="english" title="en">
                </a>
            </li>
            <li value="de" style="display: inline">
                <a href="?lang=de_DE">
                    <img src="../img/de.gif" alt="deutsch" title="de">
                </a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <content class="col col-sm-12 col-lg-8 offset-lg-2">
            <div class="jumbotron vertical-center opacity">
                    <h4>
                        <fmt:message key="report.Report" bundle="${finAppLanguage}"/>
                    </h4>


                    <jsp:include page="../report/currency_from_report_module.jsp"/>
            </div>
        </content>
    </div>
    <div class="row">
        <content class="col col-sm-12 col-lg-8 offset-lg-2">
            <div class="jumbotron vertical-center opacity">
                <h4>
                    <fmt:message key="report.Report" bundle="${finAppLanguage}"/>
                </h4>


                <jsp:include page="../report/investments-from-report-module.jsp"/>
            </div>
        </content>
    </div>
</div>

<script src="js/jquery-3.2.1.slim.min.js"></script>
<script src="js/popper.min.js"></script>
</body>
</html>


