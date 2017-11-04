
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>高大上租房网 - 用户登录(By Freemarker)</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">
			<img src="images/logo.png" />
		</div>
	</div>
	<div id="regLogin" class="wrap">
		<div class="dialog">
			<div class="box">
				<h4>用户登录</h4>
				<form action="login" method="post" id="loginForm">
					<div class="infos">
						<table class="field">
							<tr>
								<td>&nbsp;</td>
								<td style="color: red;" id="hint">${hint}</td>
							</tr>
							<tr>
								<td class="field">用 户 名：</td>
								<td>
									<!--  <#if test="${not empty cookie.uid}">
										<c:set var="currentUid" value="${cookie.uid.value}" />
									</#if> 
									<#if test="${not empty username}">
										<c:set var="currentUid" value="${username}" />
									</#if> -->
									<input id="username" type="text" class="text" name="username" value="${currentUid}">
								</td>
							</tr>
							<tr>
								<td class="field">密 码：</td>
								<td>
									<input id="password" type="password" class="text" name="password">
								</td>
							</tr>
							<tr>
								<td class="field">验 证 码：</td>
								<td>
									<input id="codeStr" type="text" class="text" name="code">
									<img id="code" src="code" width="80" height="30" title="图片看不清？点击重新得到验证码" style="cursor:pointer;">
								</td>
							</tr>
							<tr>
								<td></td>
								<td>
									<input type="checkbox" name="save"> 
									<label>下次自动登录</label>
								</td>
							</tr>
						</table>
						<div class="buttons">
							<input type="submit" value="立即登录">
							<input id="Register" type="button" value="注册">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div id="footer" class="wrap">
		<dl>
			<dt>高大上租房网 &copy; 2013 攀峰科技 川ICP证1000001号</dt>
			<dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
		</dl>
	</div>
	<script src="js/jquery-1.11.1.min.js"></script>
	<script>
		$(function(){
			$('#loginForm').on('submit',function(evt){
				//阻止时间默认行为
				evt.preventDefault();
				var username=$('#username').val();
				var password=$('#password').val();
				if (checkUsername(username) && checkPassword(password)) {
					this.submit();
				}
			});			
			function checkUsername(username){
				//6个字符到20个字符
				var flag=/^\w{2,20}$/.test(username);
				flag?$('#hint').text(''):$('#hint').text('无效用户名');
				//flag=true;
				return flag;
			}
			function checkPassword(password){
				//return /^\W{2,20}$/
				var flag=password.length>=2;
				flag? $('#hint').text(''):$('#hint').text('密码字数太少');
				//flag=true;
				return flag;
			}
			$('#code').on('click', function() {
				//避免缓存
				$(this).attr('src', 'code?' + Math.random());
			});
			$('#Register').on('click', function() {
				location.href="toregister";
			});
			
		});		
	</script>
</body>
</html>


