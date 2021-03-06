﻿<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/common/_tag.jsp" %>
<%@ include file="/WEB-INF/jsp/common/_meta.jsp" %>
<title>药品列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 药品管理 <span
        class="c-gray en">&gt;</span> 药品列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<div class="page-container">


    <input type="hidden" id="path" value="${basePath}"/>
    <c:forEach items="returnMessage" var="message" varStatus="s">

    </c:forEach>

    <div class="cl pd-5 bg-1 bk-gray mt-20">
		<span class="l">

			<a class="btn btn-primary radius" onclick="picture_add('添加药品','${basePath}/medicineAdd')"
               href="javascript:;">
				<i class="Hui-iconfont">&#xe600;</i> 添加药品
			</a>
			<a class="btn btn-primary radius" onclick="picture_add('添加供应商','${basePath}/supplierAdd')"
               href="javascript:;">
				<i class="Hui-iconfont">&#xe600;</i> 添加供应商
			</a>
		</span>
        <span class="r">
			<a href="javascript:;" onclick="datadel()" class="btn btn-danger radius">
				<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
			</a>
		</span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort">
            <thead>
            <tr class="text-c">
                <th width="40"><input name="" type="checkbox" value=""></th>
                <th width="90">国药准字</th>
                <th width="150">图片</th>
                <th width="100">药品名称</th>
                <th width="80">供应商</th>
                <th width="120">过期日期</th>
                <th width="100">库存数量(盒)</th>
                <th width="100">操作</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${medicineList}" var="item" varStatus="s">
                <%--<input type="hidden" id="warningNumber${s.index}"  >--%>
                <p id="warningNumber${s.index}" hidden="hidden">${item.warningNumber}</p>
                <tr class="text-c">
                    <td><input name="subCheck" type="checkbox" value="${item.medicineId}"></td>
                    <td>${item.medicinePermitment}</td>
                    <td><a href="javascript:;" onClick="member_show('','${basePath}/member-show/'+${item.medicineId},'10001','360','400')"><img width="210"
                                                                                                     class="picture-thumb"
                                                                                                     src="${item.imgUrl}"></a>
                    </td>
                    <td>${item.medicineName}</td>
                    <td>${item.supplierName}</td>
                    <td>${item.expirationStringDate}</td>
                    <td id="number${s.index}">${item.medicineNumber}</td>
                    <td class="td-manage"><a style="text-decoration:none" onClick="picture_stop(this,'10001')"
                                             href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a> <a
                            style="text-decoration:none" class="ml-5"
                            onClick="picture_edit('药品资料编辑','medicine-modify',${item.medicineId})" href="javascript:;"
                            title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a> <a style="text-decoration:none"
                                                                                   class="ml-5"
                                                                                   onClick="picture_del(this,${item.medicineId})"
                                                                                   href="javascript:;" title="删除"><i
                            class="Hui-iconfont">&#xe6e2;</i></a></td>
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
    $(function () {
        for (var i = 0; i< ${fn:length(medicineList)}; i++){
            var number = $('#number'+i).text();
            var  warningNumber = $('#warningNumber'+i).text();
            console.log(number);
            console.log(warningNumber);
            if( parseInt(number)< parseInt(warningNumber)){
               $('#number'+i).html(number+'<span id="test" style="color: red">(需要补充)</span>');

            }
        }
    });
    /*批量删除*/

    function datadel() {
        var basePath = $("#path").val();
        var checkNum = $("input[name='subCheck']:checked").length;
        if (checkNum == 0) {
            alert("请至少选择一项！");
            return;
        }
        layer.confirm('确认要删除吗？', function (index) {
            var checkedList = new Array();
            $("input[name='subCheck']:checked").each(function () {
                checkedList.push($(this).val());
            });
            console.log(checkedList.toString());
            $.ajax({
                type: "POST",
                dataType:"json",
                data: {'itemList':checkedList.toString()},
                url: basePath + '/deleteMore',
                success: function (result) {

                    console.log(result);

                    for (info in result){
                      if(info['message'] != "操作成功"){
                          layer.msg(info['message'], {icon: 2, time: 1000});
                      }
                    }
//                    $("[name='subCheck']:checked").attr("check", false);
                    layer.msg("操作成功", {icon: 1, time: 1000});
                    window.location.reload();
                },
                error: function (message) {
                    layer.msg('网络错误', {icon: 5, time: 1000});
                }
            });
        });

    };


    //$(function () {
    //
    //    var message = $("#message").val()
    //    if (message == null) {
    //        return
    //    }
    //    window.parent.location.reload();
    //    layer.open({
    //        type: 1,
    //        area: ['300px', '200px'],
    //        fix: false, //不固定
    //        maxmin: true,
    //        shade: 0.4,
    //        title: message,
    //        content: message
    //    });
    //})
    /*用户-查看*/
    function member_show(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /*图片-添加*/
    function picture_add(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*图片-查看*/
    function picture_show(title, url, id) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*图片-审核*/
    function picture_shenhe(obj, id) {
        layer.confirm('审核文章？', {
                btn: ['通过', '不通过'],
                shade: false
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_start(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
                $(obj).remove();
                layer.msg('已发布', {icon: 6, time: 1000});
            },
            function () {
                $(obj).parents("tr").find(".td-manage").prepend('<a class="c-primary" onClick="picture_shenqing(this,id)" href="javascript:;" title="申请上线">申请上线</a>');
                $(obj).parents("tr").find(".td-status").html('<span class="label label-danger radius">未通过</span>');
                $(obj).remove();
                layer.msg('未通过', {icon: 5, time: 1000});
            });
    }

    /*图片-下架*/
    function picture_stop(obj, id) {
        layer.confirm('确认要下架吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_start(this,id)" href="javascript:;" title="发布"><i class="Hui-iconfont">&#xe603;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已下架</span>');
            $(obj).remove();
            layer.msg('已下架!', {icon: 5, time: 1000});
        });
    }

    /*图片-发布*/
    function picture_start(obj, id) {
        layer.confirm('确认要发布吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="picture_stop(this,id)" href="javascript:;" title="下架"><i class="Hui-iconfont">&#xe6de;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发布</span>');
            $(obj).remove();
            layer.msg('已发布!', {icon: 6, time: 1000});
        });
    }

    /*图片-申请上线*/
    function picture_shenqing(obj, id) {
        $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">待审核</span>');
        $(obj).parents("tr").find(".td-manage").html("");
        layer.msg('已提交申请，耐心等待审核!', {icon: 1, time: 2000});
    }

    /*图片-编辑*/
    function picture_edit(title, url, id) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }

    /*图片-删除*/
    function picture_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {

            var data = {}
            data.medicineId = id

            var basePath = $("#path").val()

            $.ajax({
                type: 'POST',
                url: basePath + '/medicineDelete',
                dataType: 'json',
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function (backData) {
                    var statusMessage = backData['message'].trim()
                    if (statusMessage == "删除成功") {
                        $(obj).parents("tr").remove();
                        layer.msg(statusMessage, {icon: 1, time: 1500});
                    } else {
                        layer.msg(statusMessage, {icon: 2, time: 1500});
                    }

                },
                error: function (backData) {
                    console.log(backData.msg);
                    layer.msg("网络错误", {icon: 2, time: 1500});
                },
            });
        });
    }
</script>
</body>
</html>