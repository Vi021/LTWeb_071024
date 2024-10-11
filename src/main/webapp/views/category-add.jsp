<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="utils.js"></script>

<form action="${pageContext.request.contextPath}/category/insert"
	method="post" enctype="multipart/form-data">
	<div>
		<label for="catename">Category Name</label><br>
		<input type="text" id="catename" name="catename">
		<br><br>
		<label for="cateimgfile">Image</label><br>
		<img alt="No image selected" src="" height="150" width="200" id="catImg"><br>
		<input type="file" onchange="showImage(this)" id="cateimgfile" name="cateimgfile">
		<br><br>
        <label>Status<br>
            <input type="radio" name="status" value="true" id="statusActive">Active
            <input type="radio" name="status" value="false" id="statusLocked">Locked
        </label>
		<br><br>
		<input type="submit" value="Submit">
	</div>
</form>
