<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${sessionScope.language == null}">
    <c:set var="language" scope="session" value="en_GB"/>
</c:if>

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
</head>

<body>

<form method="post" action="/portal/upload" enctype="multipart/form-data">
    <jsp:include page="general/navbar.jsp"/>
    <div class="container-fluid">
        <div class="row vertical-center">
            <div class="col col-md-12 col-lg-6 offset-lg-3" style="background-color: rgba(255,255,255,0.7)">
                <h2><fmt:message key="upload.selectFile" bundle="${finAppLanguage}"/></h2>
                <p>(<fmt:message key="upload.maxFileSize" bundle="${finAppLanguage}"/> 10 Mb)</p>

                <input type="file" name="dataFile" id="fileChooser"/>

                <input type="submit" id="upload"
                       value="<fmt:message key="upload.upload"
                       bundle="${finAppLanguage}"/>"
                       class="btn btn-dark"
                       style="margin-top: 1.5rem"/>

                <br/><br/>
                <c:choose>
                    <c:when test="${file != null}">
                        <div class="alert alert-success" role="alert">
                            <fmt:message key="upload.fileUploaded" bundle="${finAppLanguage}"/>
                                ${file}

                        </div>
                    </c:when>
                </c:choose>
                <c:choose>
                    <c:when test="${hasFile == 0}">
                        <div class="alert alert-danger" role="alert">
                            <fmt:message key="upload.pleasefile" bundle="${finAppLanguage}"/>
                        </div>
                    </c:when>
                </c:choose>
                <div id="message"></div>

                <br/><br/>
            </div>
        </div>
    </div>
</form>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="../js/bootstrap-filestyle.min.js"></script>
<script>
    $("#fileChooser").filestyle({
        'text': '<fmt:message key="home.browse" bundle="${finAppLanguage}"/>',
        'btnClass': 'btn-dark'
    });
</script>
</body>
</html>