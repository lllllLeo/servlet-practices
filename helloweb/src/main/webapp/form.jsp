<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action='join.jsp' method="post">
		이메일 : <input type ="text" name="email" value=""/><br/>
		비밀번호 : <input type ="password" name="password" value=""/><br/>
		ㅌㅇㄴㅇㄷ :
		<select name ="birth">
			<option value="1996">1996</option>
			<option value="1997">1997</option>
			<option value="1998">1998</option>
		</select>
		<br/>
		
		성별:
		여<input type="radio" name="gender" value="female" checked="checked"/>
		남<input type="radio" name="gender" value="male"/>
		<br/>
		
		취미:
		코딩 <input type="checkbox" name="hobby" value="coding"/>
		쳐자기 <input type="checkbox" name="hobby" value="stormsleep"/>
		수학 <input type="checkbox" name="hobby" value="math" checked="checked"/>
		
		자기소개:
		<textarea>이욜</textarea>
		
		<input type="submit" value="가입"/>
	</form>
	<a href='tag.jsp'>태그로슝</a>
	<a href='index.jsp?name=yujun&email=k@gmail.com'>인덱스로슝</a>
</body>
</html>