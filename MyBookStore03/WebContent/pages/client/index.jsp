<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/style.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	//addCartItemBtn
	$(function() {
		//点击加入购物车，这里要判断购物车中的购物项的数量和库存量
		$(".addCartItemBtn")
				.click(
						function() {
							var id = this.value;
							//使用ajax先判断是否没有超出库存
							var url = "${pageContext.request.contextPath}/clientCartHandler/booleanAdd?id="
									+ id;
							$
									.post(
											url,
											function(data) {
												if (data == 1) {
													//可以购买
													location = "${pageContext.request.contextPath}/clientCartHandler/addCartItem?id="
															+ id
															+ "&pageNo=${page.pageNo}";
												} else {
													alert('您要购买的数量超出库存');
												}
											});

						});
	});
</script>

</head>
<body>

	<div id="header">
		<img class="logo_img" alt=""
			src="${pageContext.request.contextPath}/static/img/logo.gif"> <span
			class="wel_word">网上书城</span>
		<jsp:include page="/WEB-INF/include/menue.jsp"></jsp:include>
	</div>

	<div id="main">
		<div id="book">
			<div class="book_cond">
				价格：<input type="text" name="min"> 元 - <input type="text"
					name="max"> 元
				<button>查询</button>
			</div>
			<div style="text-align: center">
				<span>您的购物车中有3件商品</span>
				<div>
					您刚刚将<span style="color: red">时间简史</span>加入到了购物车中
				</div>
			</div>
			<c:forEach items="${list}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt=""
							src="${pageContext.request.contextPath}/${book.imgPath }" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span> <span class="sp2">${book.title }</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span> <span class="sp2">${book.author }</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span> <span class="sp2">${book.price }</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span> <span class="sp2">${book.sales }</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span> <span class="sp2">${book.stock }</span>
						</div>
						<div class="book_add">
							<button class="addCartItemBtn" value="${book.id}">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

		<div id="page_nav">
			<c:if test="${pageInfo.hasPreviousPage}">
				<a href="#">首页</a>
				<a
					href="${pageContext.request.contextPath}/client/getBooks?pageNo=${pageInfo.pageNum-1}">上一页</a>
			</c:if>
			&nbsp;&nbsp;&nbsp;
			<!-- <a href="#">3</a> 【4】 <a href="#">5</a> -->
			<c:forEach items="${pageInfo.navigatepageNums}" var="code">
				<c:if test="${code==pageInfo.pageNum}">
					<a href="">【${code}】</a>
				</c:if>
				
				<c:if test="${code!=pageInfo.pageNum}">
					<a href="">${code}</a>
				</c:if>

			</c:forEach>
			&nbsp;&nbsp;&nbsp;
			<c:if test="${pageInfo.hasNextPage}">
				<a
					href="${pageContext.request.contextPath}/client/getBooks?pageNo=${pageInfo.pageNum+1}">下一页</a>
				<a href="#">末页</a>
			</c:if>
			&nbsp;&nbsp;&nbsp; <span style="color: black;">共${pageInfo.pages }页，${pageInfo.total}条记录</span>
			&nbsp;&nbsp;&nbsp; 到第<input value="${pageInfo.pageNum }" name="pn"
				id="pn_input" />页 <input type="button" value="确定">
		</div>

	</div>

	<div id="bottom">
		<span> 尚硅谷书城.Copyright &copy;2015 </span>
	</div>
</body>
</html>