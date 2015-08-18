<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册页</title>
<c:import url="../common.jsp"></c:import>
</head>
<body>
	<!--    第一行  -->
	<c:import url="_head.jsp" />
	<!--   主要内容   -->
	<div class="container">
		<div id="reg_form">
			<form class="form-horizontal" action="auth.action"
				method="post">
				<fieldset>
					<legend>新用户注册</legend>
					<div class="control-group ${empty account?'':'error'}">
						<label class="control-label" for="inputAccount">账户名</label>
						<div class="controls">
							<input name="account" type="text" id="inputAccount"
								placeholder="Email" value="${param.account}"> <span
								class="help-inline">${empty account?'':account}</span>
						</div>
					</div>

					<div class="control-group ${empty password?'':'error'}">
						<label class="control-label" for="inputPassword">请设置密码</label>
						<div class="controls">
							<input name="password" type="password" value="${param.password}" id="inputPassword">
							<span class="help-inline">${empty password?'':password}</span>
						</div>
					</div>

					<div class="control-group ${empty passwordConfirm?'':'error'}">
						<label class="control-label" for="inputPassword">请确认</label>
						<div class="controls">
							<input name="passwordConfirm" value="${param.passwordConfirm}" type="password"  id="inputPassword">
							<span class="help-inline">${empty passwordConfirm?'':passwordConfirm}</span>
						</div>
					</div>
					<div class="control-group ${empty kaptcha?'' :'error' }">
						<label class="control-label" for="inputPassword">验证码</label>
						<div class="controls">
							<input name="kaptcha" class="span1" type="text" id="kaptcha">
							<img src="kaptcha.jpg" id="kaptchaImage" /> <span
								class="help-inline">${empty kaptcha?'':kaptcha}</span>
						</div>
					</div>

					<div class="form-actions">
						<button type="submit" class="btn btn-primary">立即注册</button>
						<a href="login" class="btn">去登录
							</button> <a href="#">回到首页</a> <a href="#">忘记密码</a>
					</div>
					
					
				</fieldset>
			</form>
		</div>
	</div>
	<!--   页脚   -->
	<c:import url="_footer.jsp"></c:import>
</body>
</html>
