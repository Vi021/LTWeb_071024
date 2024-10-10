<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath}/category/insert"
	method="post" enctype="multipart/form-data">
	<div>
		<label for="catename">Category Name</label><br>
		<input type="text" id="catename" name="catename">
		<br><br>
		<label for="cateimg">Image</label><br>
		<img alt="No image to show" src="" height="150" width="200" id="catImg"><br>
		<input type="file" onchange="chooseFile(this)" id="cateimgfile" name="cateimg">
		<br><br>
		<label for="status">Status</label><br>
		<input type="text" id="status" name="status">
		<br><br>
		<input type="submit" value="Submit">
	</div>
</form>
