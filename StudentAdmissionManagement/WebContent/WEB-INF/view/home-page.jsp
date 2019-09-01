<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Students</title>
</head>
<body>
<h3>Hello!!!</h3>
<br>
<b>Student :</b> ${studentData.fullName}
<br>
<b>Student ID :</b> ${studentData.studentID}
<br>
<b>Country :</b> ${studentData.countryOfResidence}
<br>
<b>Native :</b> ${studentData.nativeCountry}
<br>
<b>Age :</b> ${studentData.age}
<br>
<b>Mobile :</b> ${studentData.mobile}
<br>
<b>Language :</b> ${studentData.favProgLanguage}
<br>
<b>Operating Systems :</b> 
<c:forEach var="temp" items="${studentData.operatingSystems}">
			${temp}<%System.out.print("");%>
</c:forEach>

</body>
</html>