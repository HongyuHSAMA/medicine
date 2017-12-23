<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/common/_tag.jsp"%>
<%@ include file="/WEB-INF/jsp/common/_meta.jsp"%>
<title>药品图片展示</title>
<link href="lib/lightbox2/2.8.1/css/lightbox.css" rel="stylesheet" type="text/css" >
</head>
<body>
<div class="cl pd-20" style=" background-color:#5bacb6">

    <dl style="text-align:center; color:#fff">
        <dt>
            <span class="f-18 " style="text-align:center">${medicine.medicineName}</span>
            <%--<span class="pl-10 f-12">余额：40</span>--%>
        </dt>
        <%--<dd class="pt-10 f-12" style="margin-left:0">啥信息也没有留下</dd>--%>
    </dl>
    <%--<img class="avatar size-XL l" src="${basePath}/static/h-ui/images/ucnter/avatar-default.jpg">--%>
</div>
<div class="pd-20">
    <table class="table">
        <tbody>
        <tr>
            <th class="text-r" width="80">商品Id：</th>
            <td>${medicine.medicineId}</td>
        </tr>
        <tr>
            <th class="text-r">国药准字：</th>
            <td>${medicine.medicinePermitment}</td>
        </tr>
        <tr>
            <th class="text-r">生产日期：</th>
            <td>${medicine.productionStringDate}</td>
        </tr>
        <tr>
            <th class="text-r">过期日期：</th>
            <td>${medicine.expirationStringDate}</td>
        </tr>
        <tr>
            <th class="text-r">预警数量线：</th>
            <td>${medicine.warningNumber}</td>
        </tr>
        <tr>
            <th class="text-r">描述：</th>
            <td>${medicine.description}</td>
        </tr>
        </tbody>
    </table>
</div>



<!--_footer 作为公共模版分离出去-->
<%@include file="/WEB-INF/jsp/common/_footer.jsp"%>


<!--请在下方写此页面业务相关的脚本-->
</body>
</html>