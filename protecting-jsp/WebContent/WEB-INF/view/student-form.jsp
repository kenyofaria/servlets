<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
</head>
<body>

	<form action="students" id="form" method="post">
		<p>
			<input type="text" id="register-number-input" name="register-number-input" value="${student.registerNumber}"
				size="30" />
		</p>
		<p>
			<input type="text" id="name-input" name="name-input" size="100" value="${student.name}"/>
		</p>
		<p>
			<input type="submit" id="save-button" name="save-button" value="save" />
		</p>
	</form>

</body>
</html>