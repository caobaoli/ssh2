<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页</title>
<c:import url="../common.jsp" />
</head>
<body>
	<!--    第一行  -->
	<c:import url="_head.jsp" />
	<!--   主要内容   -->
	<div class="container">
		<div id="login_form">
			<form class="form-horizontal" action="dologin.action" method="post">
				<fieldset>
					<legend>登录 </legend>
					<div
						class="control-group ${empty account?'':'error'} ${empty isEmpty?'':'error'}">
						<label class="control-label" for="inputAccount">用户名</label>
						<div class="controls ">
							<input name="account" type="text" id="inputAccount"
								placeholder="用户名/Email/手机" value="${param.account}"> <span
								class="help-inline">${empty account?'':account}
								${empty isEmpty?'':isEmpty}</span>
						</div>
					</div>

					<div
						class="control-group ${empty password?'':'error'} ${empty isEmpty?'':'error'}">
						<label class="control-label" for="inputPassword">密码</label>
						<div class="controls">
							<input name="password" value="${param.password}" type="password"
								id="inputPassword"> <span class="help-inline">${empty password?'':password}
								${empty isEmpty?'':isEmpty}</span>
						</div>
					</div>
					<div class="control-group ${empty kaptcha?'' :'error' }">
						<label class="control-label" for="kaptcha">验证码</label>
						<div class="controls">
							<input name="kaptcha" class="span1" type="text" id="kaptcha">
							<img src="kaptcha.jpg" id="kaptchaImage" /> <span
								class="help-inline" id="help-inline">${empty kaptcha?'':kaptcha}</span>
						</div>
					</div>
					<div class="form-actions">
						<input type="submit" class="btn" id="loginbtn" value="登录"/>
						<a href="regist" class="btn btn-primary" >新用户注册</a>
							<a href="#">回到首页</a> <a href="#">忘记密码</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<!--   页脚   -->
	<c:import url="_footer.jsp"></c:import>
</body>
</html>
