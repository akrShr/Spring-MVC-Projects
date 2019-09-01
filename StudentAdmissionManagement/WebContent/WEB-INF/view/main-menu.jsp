<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
	<style>
	.error{color:red}
	</style>
</head>
<body>
<i>Fields marked with * are required!</i>
<br><br>
<form:form action="processForm" method="post" modelAttribute="studentData">
<table>
	<tr>
	<td><label><b>Student Details</b></label></td>
	</tr>
	<tr>
	<td><label>First Name*</label></td>
	<td><form:input path="firstName" placeholder="Enter your name" />
	<form:errors path="firstName" cssClass="error"/></td>
	</tr>
	<tr>
	<td><label>Last Name*</label></td>
	<td><form:input path="lastName" placeholder="Enter your surname" />
	<form:errors path="lastName" cssClass="error"/></td>
	</tr>
	<tr>
	<td><label>Student ID*</label></td>
	<td><form:input path="studentID" placeholder="Student ID" />
	<form:errors path="studentID" cssClass="error"/></td>
	</tr>
	<tr>
	<td><label>Country</label></td>
	<td><form:select path="countryOfResidence">
	<form:options items="${studentData.countryOptions}"/>
	</form:select></td>
	</tr>
	<tr>
	<td><label>Native Country</label></td>
	<td><form:select path="nativeCountry">
	<form:options items="${nativeOptions}"/>
	</form:select></td>
	</tr>
	<tr>
	<td><label>Age*</label></td>
	<td><form:input path="age" placeholder="Enter your age" />
	<form:errors path="age" cssClass="error"/></td>
	</tr>
	<tr>
	<td><label>Mobile</label></td>
	<td><form:input path="mobile" placeholder="Enter your phone" />
	<form:errors path="mobile" cssClass="error"/></td>
	</tr>
	<tr>
	<td><label>Favorite Programming Language</label></td>
	<td><form:radiobutton path="favProgLanguage" value="Java"/>Java
	<form:radiobutton path="favProgLanguage" value="Python"/>Python
	<form:radiobutton path="favProgLanguage" value="C#"/>C#
	</td>
	</tr>
	<tr>
	<td><label>Operating Systems</label></td>
	<td><form:checkbox path="operatingSystems" value="Linux"/>Linux
	<form:checkbox path="operatingSystems" value="Windows"/>Windows
	<form:checkbox path="operatingSystems" value="Mac OS"/>Mac OS
	</td>
	</tr>
	<tr>
	<td></td>
	<td><input type ="submit" value="Submit" /></td>
	</tr>
	</table>
</form:form>

</body>
</html>