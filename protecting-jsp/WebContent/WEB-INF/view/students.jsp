<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>

	
	<h1>Students JSP</h1>
	<p><a href="go?page=student-form">add student</a></p>
<%-- 	${result} --%>
	<!-- expression language - EL -->

	<table>
		<thead>
			<tr>
				<th>register number</th>
				<th>name</th>
				<th></th>
				<th></th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="s">
	 			<tr>
	 				<td> ${s.registerNumber} </td>
	 				<td> ${s.name} </td>
	 				<td><a href="students?registerNumber=${s.registerNumber}&operation=edit">edit</a></td>
	 				<td><a href="students?registerNumber=${s.registerNumber}&operation=delete">delete</a></td>
	 			</tr> 
			</c:forEach>
		</tbody>

	</table>




</body>
</html>