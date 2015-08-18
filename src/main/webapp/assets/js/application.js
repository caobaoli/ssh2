$(function() {

	/**
	 * 搜索按钮
	 */
	$('#search_button').button({
		icons : {
			primary : 'ui-icon-search',
		},
	});

	/**
	 * 验证码
	 */
	$('#kaptchaImage').click(
			function() {
				$(this).hide().attr('src',
						'kaptcha.jpg?' + Math.floor(Math.random() * 100))
						.fadeIn();
			});

	$('.help-inline').click(
			function() {
				$('#kaptchaImage').hide().attr('src',
						'kaptcha.jpg?' + Math.floor(Math.random() * 100))
						.fadeIn();
			});

	/**
	 * 用户名自动填充
	 */

	$('#inputAccount')
			.autocomplete(
					{
						delay : 0,
						autoFocus : true,
						source : function(request, response) {
							// 获取用户输入的内容
							// alert(request.term);
							// 绑定数据源的
							// response(['aa', 'aaaa', 'aaaaaa', 'bb']);

							var hosts = [ '126.com', 'qq.com', '163.com',
									'sina.com.cn', 'gmail.com', 'hotmail.com' ], term = request.term, // 获取用户输入的内容
							name = term, // 邮箱的用户名
							host = '', // 邮箱的域名
							ix = term.indexOf('@'), // @的位置
							result = []; // 最终呈现的邮箱列表

							result.push(term);

							// 当有@的时候，重新分别用户名和域名
							if (ix > -1) {
								name = term.slice(0, ix);
								host = term.slice(ix + 1);
							}

							if (name) {
								// 如果用户已经输入@和后面的域名，
								// 那么就找到相关的域名提示，比如bnbbs@1，就提示bnbbs@163.com
								// 如果用户还没有输入@或后面的域名，
								// 那么就把所有的域名都提示出来

								var findedHosts = (host ? $.grep(hosts,
										function(value, index) {
											return value.indexOf(host) > -1
										}) : hosts), findedResult = $.map(
										findedHosts, function(value, index) {
											return name + '@' + value;
										});

								result = result.concat(findedResult);
							}

							response(result);
						},
					});

	/**
	 * 登录验证
	 */
	
});
