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

	$('#help-inline').click(
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
	 * 登录、注册验证
	 */
	var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    // 验证用户名
    $('#inputAccount').focus(function(){
        $(this).next().text('用户名应该为6-20位之间').removeClass('state1').addClass('state2');
    }).blur(function(){
        if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok1=true;
        }else{
            $(this).next().text('用户名应该为6-20位之间').removeClass('state1').addClass('state3');
        }
         
    });

    //验证密码
    $('input[name="password"]').focus(function(){
        $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state2');
    }).blur(function(){
        if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok2=true;
        }else{
            $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state3');
        }
         
    });

    //验证确认密码
        $('input[name="passwordConfirm"]').focus(function(){
        $(this).next().text('输入的确认密码要和上面的密码一致,规则也要相同').removeClass('state1').addClass('state2');
    }).blur(function(){
        if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!='' && $(this).val() == $('input[name="password"]').val()){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok3=true;
        }else{
            $(this).next().text('输入的确认密码要和上面的密码一致,规则也要相同').removeClass('state1').addClass('state3');
        }
         
    });

    //验证邮箱
    $('input[name="email"]').focus(function(){
        $(this).next().text('请输入正确的EMAIL格式').removeClass('state1').addClass('state2');
    }).blur(function(){
        if($(this).val().search(/\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/)==-1){
            $(this).next().text('请输入正确的EMAIL格式').removeClass('state1').addClass('state3');
        }else{                  
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok4=true;
        }
         
    });
    
    //验证码
    $('input[name="kaptcha"]').focus(function(){
        $(this).next().next().text('验证码不能为空').removeClass('state1').addClass('state2');
    }).blur(function(){
        if($(this).val().length >= 1 && $(this).val()!=''){
            $(this).next().next().text('输入成功').removeClass('state1').addClass('state4');
            ok5=true;
        }else{
            $(this).next().next().text('验证码不能为空').removeClass('state1').addClass('state3');
        }
         
    });
    //提交按钮,所有验证通过方可提交
    //登录提交
    $('#loginbtn').click(function(){
        if(ok1 && ok2 && ok5){
            $('form').submit();
        }else{
            return false;
        }
    });
    
    //注册提交
    $('#registbtn').click(function(){
        if(ok1 && ok2 && ok3 &&ok5){
            $('form').submit();
        }else{
            return false;
        }
    });
     
});
