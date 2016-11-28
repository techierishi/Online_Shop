<%@ taglib uri="../tlds/tlds.tld" prefix="e"%>
<!DOCTYPE html>
<html>
<jsp:include page="includes/head.jsp"></jsp:include>
<body>

	<jsp:include page="includes/nav.jsp"></jsp:include>
	<jsp:include page="includes/sidebar.jsp"></jsp:include>

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home">
							<use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Icons</li>
			</ol>
		</div>
		<!--/.row-->

		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Category</h1>
			</div>
		</div>
		<!--/.row-->


		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Form Elements</div>
					<div class="panel-body">
						<div id="message_are"></div>
						<e:form isToken="true" css_class=""
							action="${pageContext.request.contextPath}/backend/product/add"
							id="" method="post">
							<div class="col-md-6">




								<div class="form-group">
									<label>Product name</label> <input type="text"
										name="product_name" class="form-control">
								</div>

								<div class="form-group">
									<label>Product Price</label> <input type="text"
										name="product_price" class="form-control">
								</div>

								<div class="form-group">
									<label>Product Quantity</label> <input type="text"
										name="product_qty" class="form-control">
								</div>

								<div class="form-group">
									<label>Product Category</label> <select class="form-control"
										name="product_category">
										<option>Option 1</option>
										<option>Option 2</option>
										<option>Option 3</option>
										<option>Option 4</option>
									</select>
								</div>

								<div class="form-group">
								<label>Product Images</label> 
									<div>

										<input id="fileupload" type="file" name="files[]"
											data-url="uploadimg" multiple>

										<div id="dropzone" class="fade well">Drop files here</div>

										<div id="progress"></div>
										<h5 style="text-align: center">
											<i style="color: #ccc"><small>Max File Size: 2 Mb
													- Display last 20 files</small></i>
										</h5>

										<table id="uploaded-files" class="table">
											<tr>
												<th>File Name</th>
												<th>File Size</th>
												<th>File Type</th>
											</tr>
										</table>
									</div>
								</div>



								<button type="submit" class="btn btn-primary">Submit
									Button</button>
								<button type="reset" class="btn btn-default">Reset
									Button</button>


							</div>

						</e:form>

					</div>
				</div>
			</div>
			<!-- /.col-->
		</div>
		<!-- /.row -->

	</div>
	<!--/.main-->


	<jsp:include page="includes/script.jsp"></jsp:include>


	<script>
		
	<%String message_str = (String) request.getSession().getAttribute("message");
			if (message_str != null && !message_str.isEmpty()) {
				request.getSession().removeAttribute("message");%>
				
				jQuery(document).ready(
							function() {
								
								jQuery("#message_are").html(ADMIN.showMessage('bg-success','<%=message_str%>
		'));
				});
	<%}%>
		
	</script>
</body>

</html>
