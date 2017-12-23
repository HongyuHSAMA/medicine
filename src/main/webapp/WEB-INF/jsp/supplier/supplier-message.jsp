<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
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

    <link rel="stylesheet" type="text/css" href="${basePath}/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="${basePath}/static/h-ui.admin/css/style.css"/>

    <title>库存后台管理系统</title>
</head>
</head>
<body>
<input type="hidden" id="message" value="${message.stateInfo}"/>
<!--_footer 作为公共模版分离出去-->
<%@ include file="/WEB-INF/jsp/common/_footer.jsp"%>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${basePath}/lib/webuploader/0.1.5/webuploader.min.js"></script>

<script type="text/javascript">

   /* $(function () {
        layer.open({
            type: 1,
            area: ['300px', '200px'],
            fix: false, //不固定
            maxmin: true,
            shade: 0.4,
            title: '操作结果',
            content: '<div align="center">${message.stateInfo}</div>'
        });
    });*/

   $(function () {
        var message = $('#message').val();
       $.Huimodalalert(message,3000)

       setTimeout("window.parent.location.reload()",3000);
   })

</script>
</body>
</html>