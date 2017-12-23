<%--
  Created by IntelliJ IDEA.
  User: hyh47
  Date: 2017/12/20
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/_tag.jsp" %>


<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link href="${basePath}/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css"/>
    <link href="${basePath}/lib/jquery.validation/1.14.0/jquery.validate.js"/>
    <link href="${basePath}/lib/jquery.validation/1.14.0/validate-methods.js"/>
    <link href="${basePath}/lib/jquery.validation/1.14.0/additional-methods.js"/>
    <link href="${basePath}/lib/jquery.validation/1.14.0/messages_zh.js"/>


    <title>后台登录 - H-ui.admin v3.1</title>
    <script>
        $.validator.setDefaults({
            submitHandler: function() {
                alert("提交事件!");
            }
        });
        $().ready(function() {
            $("#loginFormH").validate();
        });
    </script>

</head>
<body >

    <input type="hidden" id="TenantId" name="TenantId" value=""/>
    <div class="header"></div>
    <div class="loginWraper" >
        <div id="loginform" class="loginBox">
            <form class="form form-horizontal" action="index" method="post" id="loginFormH">
                <div class="row cl">
                    <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                    <div class="formControls col-xs-8">
                        <input id="workerId" name="workerId" type="text" placeholder="账户" class="input-text size-L" value="${worker1.workerId}" required >
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                    <div class="formControls col-xs-8">
                        <input id="workerPassword" name="workerPassword" type="password" placeholder="密码" class="input-text size-L" value="${worker1.workerPassword}" required>
                    </div>
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-8 col-xs-offset-3">
                        <%--&lt;%&ndash;<input class="input-text size-L" type="text" placeholder="验证码"&ndash;%&gt;--%>
                               <%--&lt;%&ndash;onblur="if(this.value==''){this.value='验证码:'}"&ndash;%&gt;--%>
                               <%--&lt;%&ndash;onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">&ndash;%&gt;--%>
                        <%--&lt;%&ndash;<img src=""> <a id="kanbuq" href="javascript:;">看不清，换一张</a>--%>
                        <p id ="messageShow" ></p>
                    </div>
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-8 col-xs-offset-3">
                        <label for="online">
                            <input type="checkbox" name="online" id="online" value="">
                            使我保持登录状态</label>
                    </div>
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-8 col-xs-offset-3">
                        <input onclick="login_submit" name="" type="submit" class="btn btn-success radius size-L"
                               value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                        <input name="" type="reset" class="btn btn-default radius size-L"
                               value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="footer">Copyright ~~~~~~ by H-ui.admin v3.1</div>
    <script type="text/javascript" src="${basePath}/lib/jquery/1.9.1/jquery.min.js"></script>
    <script type="text/javascript" src="${basePath}/static/h-ui/js/H-ui.min.js"></script>

    <script type="text/javascript">
        $(function () {
            var messageShow = $('#messageShow');
            var message = "${error}";
            if (message.length != 0) {
                messageShow.html('<span style="color: red">登录密码或者账户错误</span>');
                "<% request.removeAttribute("error");%>";

            }
        });


    </script>
</body>
</html>