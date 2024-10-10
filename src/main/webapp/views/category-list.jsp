<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<button style="float: right; margin: 10px" 
onclick="location.href='${pageContext.request.contextPath}/category/add'">Add Category</button>

<table border="1" width="100%">
	<tr>
		<th>STT</th>
		<th>Images</th>
		<th>CategoryID</th>
		<th>Category Name</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<tr>

	<c:forEach items="${listcat}" var="cate" varStatus="STT" >
 		<tr>
 			<td>${STT.index+1}</td>
 			<td>
 				<c:choose>
					<c:when test="${cate.images.contains('http')}">
						<img height="150" width="200" src="${cate.images}"
							alt="Image not found" />
					</c:when>
					<c:otherwise>
						<c:url value="/image?filename=${cate.images}" var="imgUrl"></c:url>
						<img height="150" width="200" src="${imgUrl}"
							alt="Image not found" />
					</c:otherwise>
				</c:choose>
			</td>
 			<td>${cate.categoryid}</td>
 			<td>${cate.categoryname}</td>
 			<td>
 				<c:if test="${cate.status == 1}">
 					<span>Active</span></c:if>
 				<c:if test="${cate.status != 1}">
 					<span>Locked</span></c:if>
 			</td>
			<td>
			<a href="<c:url value='/category/edit?id=${cate.categoryid}'/>">Edit</a>
			 | <a href="<c:url value='/category/delete?id=${cate.categoryid}'/>">Delete</a>
			</td>
 		</tr>
 	</c:forEach>
 	
	</tr>
</table>
