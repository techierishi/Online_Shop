<!DOCTYPE HTML>
<%@page import="com.ekart.entity.*"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>Surfhouse Bootstarp Website Template | Register :: w3layouts</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/component.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Roboto:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<script src="js/jquery.easydropdown.js"></script>
<!-- Add fancyBox main JS and CSS files -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>
		<script type="text/javascript">
		function submit(){
			var alphaExp = /^[a-zA-Z]+$/;
			var inputtext=document.getElementById("name");
			if(inputtext.value.match(alphaExp)){
			return true;
			}else{
			document.getElementById('p1').innerText = "Please enter the valid text";
			inputtext.focus();
			return false;
			}
			}
		</script>
		<script type="text/javascript">
function loadXMLDoc()
{
var xmlhttp;
var emailValue=document.getElementById("email").value;
var urls="emailConnection.jsp?ver="+emailValue;

if (window.XMLHttpRequest)
� {
� xmlhttp=new XMLHttpRequest();
� }
else
� {
� xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
� }
xmlhttp.onreadystatechange=function()
� {
� if (xmlhttp.readyState==4)
��� {
�� ��� �//document.getElementById("err").style.color="red";
�� ��� �document.getElementById("err").innerHTML=xmlhttp.responseText;

��� }
� }
xmlhttp.open("GET",urls,true);
xmlhttp.send();
}
</script>
<!----details-product-slider--->
</head>
<body>
   <div class="single">
	<div class="container">
		<div class="header-top">
      		 <div class="logo">
				<a href="index.html"><img src="images/logo.png" alt=""/></a>
			 </div>
		   <div class="header_right">
			 <ul class="social">
			 </ul>
		    <div class="lang_list">
   			</div>
			<div class="clearfix"></div>
          </div>
          <div class="clearfix"></div>
		 </div>  
		 <div class="apparel_box">
			<ul class="login">
				<li class="login_text"><a href="login.html">Login</a></li>
				<li class="wish"><a href="checkout.html">Wish List</a></li>
				<div class='clearfix'></div>
		    </ul>
		    <div class="cart_bg">
			  <ul class="cart">
				<i class="cart_icon"></i><p class="cart_desc">$1459.50<br><span class="yellow">2 items</span></p>
			    <div class='clearfix'></div>
			  </ul>
			  <ul class="product_control_buttons">
				 <li><a href="#"><img src="images/close.png" alt=""/></a></li>
				 <li><a href="#">Edit</a></li>
			  </ul>
		      <div class='clearfix'></div>
			 </div>
			 <ul class="quick_access">
				<li class="view_cart"><a href="checkout.html">View Cart</a></li>
				<li class="check"><a href="checkout.html">Checkout</a></li>
				<div class='clearfix'></div>
		     </ul>
			<div class="search">
			   <input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
			   <input type="submit" value="">
			</div>
		  </div>
		</div>
    </div>
    <div class="main">
	   <div class="container">
		  <div class="register">
		  	<form action="MainController" method="post"> 
				 <div class="register-top-grid">
					<h3>Personal Information</h3>
					 <div>
						<span>Name<label>*</label></span>
						<input type="text" name="name" id="name">
						<p id="p1"></p>
					 </div>
					 <div>
						 <span>Email Address<label>*</label></span>
						 <input type="text" name="email" id="email" onkeyup="loadXMLDoc()"><span id="err"> </span>
					 </div>
					  <div>
						<span>Phone<label>*</label></span>
						<input type="text" name="phone"> 
					 </div>
					 <div>
						<span>City<label>*</label></span>
						<input type="text" name="city" > 
					 </div>
					 <div>
						<span>State<label>*</label></span>
						<input type="text" name="state"> 
					 </div>
					 <div>
						<span>Zip<label>*</label></span>
						<input type="text" name="zip" > 
					 </div>
					 <div class="clearfix"> </div>
					   <a class="news-letter" href="#">
						 <input type="hidden" name="key" value="register"/>
					   </a>
					 </div>
				     <div class="register-bottom-grid">
							 <div>
								<span>Password<label>*</label></span>
								<input type="text" name="password">
							 </div>
							 <div>
								
							 </div>
					 </div>
				<div class="clearfix"> </div>
				<div class="register-but">
					   <input type="submit" value="Register" onclick='return submit()'>
					   <div class="clearfix"> </div>
				   </form>
				</div>
		   </div>
	     </div>
	    </div>
</body>
</html>		