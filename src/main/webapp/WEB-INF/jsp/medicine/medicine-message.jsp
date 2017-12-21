<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/common/_tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common/_meta.jsp"%>
<title>信息</title>
</head>
<body>



<input type="hidden" id="message" value="${message.msg}"/>

<!--_footer 作为公共模版分离出去-->
<%@ include file="/WEB-INF/jsp/common/_footer.jsp"%>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${basePath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${basePath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${basePath}/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript">

    $(function () {

        var message = $("#message").val()

        $.Huimodalalert(message,3000)

        setTimeout("window.parent.location.reload()",3000);
    })




</script>
</body>
</html>


