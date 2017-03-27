<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Show All Users</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>
				<th>City</th>
				<th>Country</th>
				<th>Attractions</th>
				<th>Visited</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cities}" var="city">
				<tr>
					<td><c:out value="${city.cityName}" /></td>
					<td><c:out value="${city.country}" /></td>
					<td><c:out value="${city.attractions}" /></td>
					<td><a
						href="CityController?action=edit&cityId=<c:out value="${city.cityId}"/>">
						<c:choose>
						    <c:when test="${city.visited=='0'}">
						        not visited 
						        <br />
						    </c:when>    
						    <c:otherwise>
						        visited 
						        <br />
						    </c:otherwise>
						</c:choose>
						</a>
						
						</td>
					<td><a
						href="CityController?action=delete&cityId=<c:out value="${city.cityId}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="CityController?action=insert">Add City</a>
	</p>
</body>
</html>