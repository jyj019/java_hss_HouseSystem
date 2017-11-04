<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>高大上租房网 - 用户注册(By Freemarker)</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="images/logo.png" />
			</div>
		</div>
		<div id="regLogin" class="wrap">
			<div class="dialog">
				<dl class="clearfix">
					<dt>新用户注册</dt>
					<dd class="past">填写个人信息</dd>
				</dl>
				<div class="box">
					<form action="register" method="post" id="RegisterFrom">
						<div class="infos">
							<table class="field">
								<tr>
									<td>&nbsp;</td>
									<td style="color: red">${hint}</td>
								</tr>
								<tr>
									<td class="field">用 户 名：</td>
									<td>
										<input id="username" type="text" class="text" name="username"> 
										<span id="isValid"></span>
									</td>
								</tr>
								<tr>
									<td class="field">密 码：</td>
									<td><input type="password" class="text" name="password"></td>
								</tr>
								<tr>
									<td class="field">确认密码：</td>
									<td><input type="password" class="text" name="repassword"></td>
								</tr>
								<tr>
									<td class="field">电 话：</td>
									<td><input type="text" class="text" name="tel"></td>
								</tr>
								<tr>
									<td class="field">用户姓名：</td>
									<td><input type="text" class="text" name="realname"></td>
								</tr>
								<tr>
									<td class="field">验 证 码：</td>
									<td>
										<input id="codeStr" type="text" class="text" name="code">
										<img id="code" src="code.do" width="80" height="30" title="图片看不清？点击重新得到验证码" style="cursor:pointer;">
									</td>
								</tr>
							</table>
							<div class="buttons">
								<input type="submit"  value="立即注册" />
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
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script type="text/javascript">
			/*$('#username').on('blur', function() {
				var username = $(this).val();
				$.ajax({
					url: 'check.do',
					data: { 'username': username },
					success: function(data) {
						if (data.indexOf('used') >= 0) {
							showErrorHint();
						} else {
							showCorrectHint();
						}
					}
				});
			});
			function showErrorHint() {
				$('#isValid').text('X').css('color', 'red');
			}
			function showCorrectHint() {
				$('#isValid').text('√').css('color', 'green');
			}*/
			$(function(){
				/*$('#RegisterFrom').on('submit',function(evt){
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
					$(this).attr('src', 'code.do?' + Math.random());
				});
				*/
				$('#username').on('blur', function() {
					var username = $(this).val();
					$.getJSON('check?username=' + username, function(json) {
						isValid = json.valid;
						$('#isValid').children().remove();
						$('#isValid').append($('<img>').attr('src', 'images/' + json.picture));
					});
				});
			});			
		</script>
	</body>
</html>

