<%@ page contentType="text/html; charset=utf-8" %>
	<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
			<title>글 목록</title>
		</head>

		<body>
			<h1> 직원 목록 </h1>

			<table border="1">
				<tr>
					<th bgcolor="orange" width="100">사원번호</th>
					<th bgcolor="orange" width="200">사원명</th>
					<th bgcolor="orange" width="150">업무</th>
					<th bgcolor="orange" width="150">입사일</th>
					<th bgcolor="orange" width="100">부서명</th>
					<th bgcolor="orange" width="100">월급</th>
				</tr>
				<c:forEach items="${emp }" var="emp">
					<tr>
						<td>${emp[0].empno}</td>
						<td>${emp[0].ename}</td>
						<td>${emp[0].job}</td>
						<td>${emp[0].hiredate}</td>
						<td>${emp[0].dept.dname}</td>
						<td>${emp[0].sal}</td>
					</tr>
				</c:forEach>

			</table>

		</body>

		</html>