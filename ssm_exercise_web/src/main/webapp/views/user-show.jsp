<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>数据 - AdminLTE2定制版</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/plugins/bootstrap-slider/slider.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
			<h1>
				用户管理 <small>全部用户</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/static/index.jsp"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a
					href="${pageContext.request.contextPath}/static/user/findAll.do">用户管理</a></li>

				<li class="active">全部用户</li>
			</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content"> <!-- .box-body -->
			<div class="box box-primary">
				<div class="box-header with-border">
					<h3 class="box-title">列表</h3>
				</div>

				<div class="box-body">

					<!-- 数据表格 -->
					<div class="table-box">

						<!--工具栏-->
						<div class="pull-left">
							<div class="form-group form-inline">
								<div class="btn-group">
									<button type="button" class="btn btn-default" title="新建">
										<i class="fa fa-file-o"></i> 新建
									</button>

									<button type="button" class="btn btn-default" title="刷新">
										<i class="fa fa-refresh"></i> 刷新
									</button>
								</div>
							</div>
						</div>
						<div class="box-tools pull-right">
							<div class="has-feedback">
								<input type="text" class="form-control input-sm"
									placeholder="搜索"> <span
									class="glyphicon glyphicon-search form-control-feedback"></span>
							</div>
						</div>
						<!--工具栏/-->

						<!--数据列表-->
						<div class="tab-pane" id="tab-treetable">
							<table id="collapse-table" class="table table-bordered table-hover dataTable">
								<thead>
									<tr>
										<th>名称</th>
										<th>描述</th>
									</tr>
								</thead>

								<tr data-tt-id="0">
									<td colspan="2">${user.username}</td>
								</tr>

								<tbody>
									<c:forEach items="${user.roles}" var="role" varStatus="status">
										<tr data-tt-id="${status.index + 1}" data-tt-parent-id="0">
											<td>${role.roleName }</td>
											<td>${role.roleDesc }</td>
										</tr>
										<c:forEach items="${role.permissions}" var="permission">
											<tr data-tt-id="1-${status.index}" data-tt-parent-id="${status.index + 1}">
												<td>${permission.permissionName}</td>
												<td>${permission.url}</td>
											</tr>

										</c:forEach>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<!--数据列表/-->

					</div>
					<!-- 数据表格 /-->

				</div>
				<!-- /.box-body -->

				<!-- .box-footer-->
				<div class="box-footer">
					<div class="pull-left">
						<div class="form-group form-inline">
							总共2 页，共14 条数据。 每页 <select class="form-control">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
							</select> 条
						</div>
					</div>

					<div class="box-tools pull-right">
						<ul class="pagination">
							<li><a href="#" aria-label="Previous">首页</a></li>
							<li><a href="#">上一页</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">下一页</a></li>
							<li><a href="#" aria-label="Next">尾页</a></li>
						</ul>
					</div>

				</div>
				<!-- /.box-footer-->

			</div>

			</section>
			<!-- 正文区域 /-->

		</div>
		<!-- @@close -->
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2014-2017 <a
			href="http://www.itcast.cn">研究院研发部</a>.
		</strong> All rights reserved. </footer>
		<!-- 底部导航 /-->

	</div>

	<script src="${pageContext.request.contextPath}/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/raphael/raphael-min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/morris/morris.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/knob/jquery.knob.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/daterangepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/daterangepicker/daterangepicker.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/fastclick/fastclick.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/iCheck/icheck.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/adminLTE/js/app.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/treeTable/jquery.treetable.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/select2/select2.full.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/ckeditor/ckeditor.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/input-mask/jquery.inputmask.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/chartjs/Chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/flot/jquery.flot.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/flot/jquery.flot.resize.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/flot/jquery.flot.pie.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/flot/jquery.flot.categories.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale: 'zh-CN'
			});
		});


		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}



		$(document).ready(function() {

			// 颜色选取器
			$(".my-colorpicker1").colorpicker();
			$(".my-colorpicker2").colorpicker();

		});




		$(document).ready(function() {
			// 选择框
			$(".select2").select2();
		});




		$(document).ready(function() {

			//Date picker
			$('#datepicker').datepicker({
				autoclose: true,
				language: 'zh-CN'
			});

			//Date range picker
			$('#reservation').daterangepicker({
				locale: {
					applyLabel: '确认',
					cancelLabel: '取消',
					fromLabel: '起始时间',
					toLabel: '结束时间',
					customRangeLabel: '自定义',
					firstDay: 1
				},
				opens: 'left', // 日期选择框的弹出位置
				separator: ' 至 '
				//showWeekNumbers : true,     // 是否显示第几周
			});

			//Date range picker with time picker
			$('#reservationtime').daterangepicker({
				timePicker: true,
				timePickerIncrement: 30,
				format: 'MM/DD/YYYY h:mm A',
				locale: {
					applyLabel: '确认',
					cancelLabel: '取消',
					fromLabel: '起始时间',
					toLabel: '结束时间',
					customRangeLabel: '自定义',
					firstDay: 1
				},
				opens: 'right', // 日期选择框的弹出位置
				separator: ' 至 '
			});

			//Date range as a button
			$('#daterange-btn').daterangepicker({
						locale: {
							applyLabel: '确认',
							cancelLabel: '取消',
							fromLabel: '起始时间',
							toLabel: '结束时间',
							customRangeLabel: '自定义',
							firstDay: 1
						},
						opens: 'right', // 日期选择框的弹出位置
						separator: ' 至 ',
						ranges: {
							'今日': [moment(), moment()],
							'昨日': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
							'最近7日': [moment().subtract(6, 'days'), moment()],
							'最近30日': [moment().subtract(29, 'days'), moment()],
							'本月': [moment().startOf('month'), moment().endOf('month')],
							'上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
						},
						startDate: moment().subtract(29, 'days'),
						endDate: moment()
					},
					function(start, end) {
						$('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
					}
			);

		});




		$(document).ready(function() {

			/*table tree*/
			$("#collapse-table").treetable({
				expandable: true
			});

		});




		$(document).ready(function() {

			$("#markdown-textarea").markdown({
				language: 'zh',
				autofocus: false,
				savable: false
			});

		});



		$(document).ready(function() {

			// 激活导航位置
			setSidebarActive("admin-dataform");

		});
	</script>
</body>

</html>