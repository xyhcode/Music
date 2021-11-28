//登录操作
$(document).ready(function(){
	if(screen.width < 780 && $(window).width() < 780) {
		$(".content_list").hide();
	}else{
		$(".content_list").show();
	}
	$(window).resize(function(){
		 $(".content_list").show();
	});
});

//登录操作
var phone =/[1][3-9][0-9]{9,9}/;
var validCode=true;
function cliLogin() {
	var txtUser = $.trim($("#username").val());
	var txtPwd = $("#password").val();
	
	if ($.trim(txtUser) == "") {
		Tip('请输入你的手机号');
		$("#txtUser").focus();
		return;
	}
	if(!phone.exec(txtUser)){
		Tip('手机输入格式不正确,请从新输入');
		$("#txtUser").focus();
		return;
	}
	
	if ($.trim(txtPwd) == "") {
		Tip('请输入密码！');
		$("#Userpwd").focus();
		return;
	}

	$.ajax({
		url:'/login',
		type:'post',
		data:{
			"phone":txtUser,
			"password":txtPwd,
		},
		dataType : "json",
		complete : function(xhr, status) {
			//拦截器拦截没有权限跳转
			// 通过xhr取得响应头
			var REDIRECT = xhr.getResponseHeader("REDIRECT");
			//如果响应头中包含 REDIRECT 则说明是拦截器返回的
			if (REDIRECT == "REDIRECT") {
				document.location.href = xhr.getResponseHeader("CONTEXTPATH");
			}
		},
		success:function(da){
			// console.log(da);
			if(da.code==500){
				layer.msg(da.msg);
				$("#username").val("");
				$("#password").val("");
			}else if(da.code==200){
				// layer.msg(da.msg);
				location.href="/index.html";
			}
		}
	});
	return false;
}

var zt=0;
var code;
//注册操作
function Sendpwd(sender) {
	zt=0;
	var time=60;
	var phones = $.trim($("#phone").val());
	if ($.trim(phones) == "") {
		Tip('请填写手机号码！');
		$("#phone").focus();
		return;
	}
	$.ajax({
		url:"veryphone/"+phones,
		type:"POST",
		success: function(da){
			if(da.code==200){
				layer.open({
					type : 1,
					title: false,
					shadeClose : false, //点击遮罩关闭
					content : $('#cf'),//添加层
					closeBtn:1,
					success: function(){
						$("#captcha").html("");
						$(".layui-layer-setwin a").attr("class", "layui-layer-ico layui-layer-close layui-layer-close1");
						var captcha=sliderCaptcha({
							id: 'captcha',
							setSrc: function () {
								//设置图片路径2
								return 'https://sls-study-cloud-1301165591.cos.ap-guangzhou.myqcloud.com/Captcha/Pic' + Math.round(Math.random() * 45) + '.jpg';
								/*return 'https://imgs.blazor.zone/images/Pic' + Math.round(Math.random() * 136) + '.jpg';*/
							},
							onSuccess: function () {
								$("#captcha").html("");
								captcha.reset();
								layer.closeAll();
								$.ajax({
									url:'sendcode/'+phones,
									type:'post',
									success: function (data){
										if(data.code==200){
											layer.msg("验证码发送成功！");
											var code=$(sender);
											if(validCode){
												validCode=false;
												code.add("msg1").attr("disabled",true);
												var t=setInterval(function (){
													time--;
													code.val(time+"秒");
													if(time==0){
														zt=1;
														clearInterval(t);
														code.val("重新获取");
														code.removeClass("msg1").attr("disabled",false);
														validCode=true;
													}
												},1000);
											}
										}else{
											layer.msg("验证码发送失败！");
										}
									}
								})
							}
						});
					}
				});
			}else{
				layer.msg("该电话已注册！");
				return;
			}
		}
	})
}

$(function() {
	var step= $("#myStep").step({
		animate:true,
		initStep:1,
		speed:1000
	});
	$("#preBtn").click(function(event) {
		var yes=step.preStep();

	});
	$("#applyBtn").click(function(event) {

		var code = $.trim($("#Verification").val());
		var phone =/[1][3-9][0-9]{9,9}/;
		var phones = $.trim($("#phone").val());
		if ($.trim(phones) == "") {
			Tip('请填写手机号码！');
			$("#phone").focus();
			return;
		}
		if(!phone.exec(phones)){

			Tip('手机输入格式不正确,请从新输入');
			$("#phones").focus();
			return;
		}
		if ($.trim(code) == "") {
			Tip('动态密码未填写！');
			$("#Verification").focus();
			return;
		}

		if(zt==1){
			layer.msg("验证码已过期！");
			return;
		}

		if(code!="" && phones!="" && zt==0){
			$.ajax({
				url:'verycode/'+phones+"/"+code,
				type:'POST',
				success:function(data){
					if(data.code==200){
						return true;
					}else{
						layer.msg("验证码错误！");
						return;
					}
				}
			})
		}
		var yes=step.nextStep();
		return;
	});
	$("#submitBtn").click(function(event) {
		var txtconfirm = $.trim($("#confirmpwd").val());
		var txtPwd = $("#password").val();

		if ($.trim(txtPwd) == "") {

			Tips('请输入你要设置的密码！');
			$("#txtPwd").focus();
			return;

		}
		if($.trim(txtconfirm) == "") {

			Tips('请再次输入密码！');
			$("#txtconfirm").focus();
			return;

		}
		if( $.trim(txtconfirm) != $.trim(txtPwd) ) {

			Tips('你输入的密码不匹配，请从新输入！');
			$("#txtconfirm").focus();
			return;

		}else{
			$.ajax({
				url:'regis/'+txtconfirm,
				type:'POST',
				success: function (data){
					if(data.code==200){
						layer.msg("注册成功！");
						location.href ="/login.html";
					}else{
						layer.msg("注册失败！");
					}
				}
			})
		}
		var yes=step.nextStep();
	});
});

function Tip(msg) {
	$(".tishi").show().html("<div class='prompt'><i class='tishi_icon'></i>"+msg+"</div>");
}
function Tips(msg) {
	
	$(".tishis").show().html("<div class='prompt'><i class='tishi_icon'></i>"+msg+"</div>");
}
jQuery(function(){
	"use strict";
		$(".navList .navLi").hover(function(){
		$(this).addClass("active");
		$(this).find(".navSub").stop().slideDown();	
	},function(){
		$(this).removeClass("active");
		$(this).find(".navSub").stop().slideUp();
		$(".navThrList").slideUp();
		$(".navFouList").slideUp();
	});
	function scro(){
			if($(document).scrollTop()>50){$(".headerbg").addClass("active");}else{$(".headerbg").removeClass("active");}
		}
		scro();
		$(window).scroll(function(){
			scro();
		});
			$(".benefits_name").hover(function(){
			$(this).addClass("hover");
			$(this).stop().animate({bottom: "0px", opacity:1 , height:"400px"}, "fast");
		},function(){
			$(this).removeClass("hover");
			$(this).stop().animate({bottom: "0px", opacity:1 , height:"400px"}, "fast") ; 			
		}
	);
		$(".Program_name ").hover(function() {
	    $(this).addClass("hover");
		$(this).find(".Program_title").stop()
		.animate({ opacity:1 , height:"100%"}, "fast")
		.css("display","block");

	}, function() {
	    $(this).removeClass("hover");  
		$(this).find(".Program_title").stop()
		.animate({ opacity: 1,height:"40px"}, "fast")
		.css("display","block");
	});
		$(".user_casestyle").hover(function(){
			$(this).addClass("hover");
			$(this).find(".hd a").css("display","block");
			//$(this).stop().animate({bottom: "0px", opacity:1 , height:""}, "fast")
		},function(){
			$(this).removeClass("hover");
			$(this).find(".hd a").css("display","none");
			//$(this).stop().animate({bottom: "0px", opacity:1 , height:""}, "fast")  			
		}
	);
	//置顶图标显示
$('#top-back').hide();
$(window).scroll(function(){
	 if($(this).scrollTop() > 350){
		$("#top-back").fadeIn();
	 }
	 else{
		$("#top-back").fadeOut();
	 }
  });
$(".bannerNimg").css("background-image", "url(" + $(".bannerNimg").find("img").attr("src") + ")");
//置顶事件
function topBack(){
  $('body,html').animate({scrollTop:0},300);
}
});

$.fn.countTo = function (options) {
	"use strict";
	options = options || {};	
	return $(this).each(function () {
		// set options for current element
		var settings = $.extend({}, $.fn.countTo.defaults, {
			from:            $(this).data('from'),
			to:              $(this).data('to'),
			speed:           $(this).data('speed'),
			refreshInterval: $(this).data('refresh-interval'),
			decimals:        $(this).data('decimals')
		}, options);
		
		// how many times to update the value, and how much to increment the value on each update
		var loops = Math.ceil(settings.speed / settings.refreshInterval),
			increment = (settings.to - settings.from) / loops;
		
		// references & variables that will change with each update
		var self = this,
			$self = $(this),
			loopCount = 0,
			value = settings.from,
			data = $self.data('countTo') || {};
		
		$self.data('countTo', data);
		
		// if an existing interval can be found, clear it first
		if (data.interval) {
			clearInterval(data.interval);
		}
		data.interval = setInterval(updateTimer, settings.refreshInterval);
		
		// initialize the element with the starting value
		render(value);
		
		function updateTimer() {
			value += increment;
			loopCount++;
			
			render(value);
			
			if (typeof(settings.onUpdate) == 'function') {
				settings.onUpdate.call(self, value);
			}
			
			if (loopCount >= loops) {
				// remove the interval
				$self.removeData('countTo');
				clearInterval(data.interval);
				value = settings.to;
				
				if (typeof(settings.onComplete) == 'function') {
					settings.onComplete.call(self, value);
				}
			}
		}
		
		function render(value) {
			var formattedValue = settings.formatter.call(self, value, settings);
			$self.html(formattedValue);
		}
	});
};

$.fn.countTo.defaults = {
	from: 0,               // the number the element should start at
	to: 0,                 // the number the element should end at
	speed: 300,           // how long it should take to count between the target numbers
	refreshInterval: 100,  // how often the element should be updated
	decimals: 0,           // the number of decimal places to show
	formatter: formatter,  // handler for formatting the value before rendering
	onUpdate: null,        // callback method for every time the element is updated
	onComplete: null       // callback method for when the element finishes updating
};

function formatter(value, settings) {
	return value.toFixed(settings.decimals);
}


