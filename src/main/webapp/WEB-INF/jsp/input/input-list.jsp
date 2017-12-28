<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/common/_tag.jsp" %>
<%@ include file="/WEB-INF/jsp/common/_meta.jsp" %>
<title>药品列表</title>
</head>
<body>

<div class="page-container">
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort">
            <thead>
            <tr class="text-c">
                <th width="10"></th>
                <th width="100">入库记录id</th>
                <th width="160">药品名称</th>
                <th width="100">入库数量</th>
                <th width="100">经手人</th>
                <th width="100">入库日期</th>
                <th width="100">进价（元/盒）</th>
                <th width="10"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${inputList}" var="item" varStatus="s">
            <tr class="text-c">
                <td></td>
                    <td>${item.replenishId}</td>
                    <td>${item.replenishMedicineName}</td>
                    <td>${item.replenishMedicineNumber}</td>
                    <td>${item.replenishWorkerName}</td>
                    <td>${item.createStringTime}</td>
                    <td>${item.replenishMedicinePrice}</td>
                <td class="td-manage"></td>
            </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<%@ include file="/WEB-INF/jsp/common/_footer.jsp" %>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${basePath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $('.table-sort').dataTable({
        "aaSorting": [[1, "desc"]],//默认第几个排序
        "bStateSave": true,//状态保存
        "aoColumnDefs": [
            //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
            {"orderable": false, "aTargets": [0, 7]}// 制定列不参与排序
        ]
    });

</script>
</body>
</html>