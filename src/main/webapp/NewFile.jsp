<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
@import 'assets/base.scss';

.form-label-group {
	position: relative;
	margin-bottom: 35px;
}

.form-label-group input, .form-label-group label {
	padding: 0 20px;
	border: 1px solid #dde5eb;
	height: 48px; @ include radius(5px);
	font-size: 16px;
	line-height: 1.31;
	color: #465166;
}

.form-label-group input:focus {
	border: 2px solid #ed6c0d;
	box-shadow: none;
}

.form-label-group label {
	position: absolute;
	top: 0;
	left: 0;
	display: block;
	width: 100%;
	margin-bottom: 0;
	line-height: 46px;
	color: rgba(0, 0, 0, 0.2);
	font-size: 14px;
	transition: all .1s ease-in-out;
	border: 1px solid transparent;
}

.form-label-group input:not (:focus ):valid {
	border: 1px solid #dde5eb;
}

.form-label-group input:not (:focus ):valid+label {
	color: rgba(70, 81, 102, 0.7);
}

.form-label-group input::-webkit-input-placeholder {
	color: transparent;
}

.form-label-group input:-ms-input-placeholder {
	color: transparent;
}

.form-label-group input::-ms-input-placeholder {
	color: transparent;
}

.form-label-group input::-moz-placeholder {
	color: transparent;
}

.form-label-group input::placeholder {
	color: transparent;
}

.form-label-group input:not (:placeholder-shown ) {
	border: 2px solid #ed6c0d;
}

.form-label-group input:focus ~label{
	padding: 0 20px;
	font-size: 10px;
	color: #ed6c0d;
	top: -7px;
	line-height: 13px;
	height: 14px;
	width: auto; @ include radius(0);
	z-index: 1;
	border: 1px solid transparent;
}

.form-label-group input:focus ~label::after {
	height: 4px;
	content: '';
	width: 70%;
	position: absolute;
	left: 15%;
	background: #ffffff;
	top: 5px;
	z-index: -1;
}

.form-label-group input:not (:placeholder-shown ) ~ label {
	padding: 0 20px;
	font-size: 10px;
	color: #ed6c0d;
	top: -7px;
	line-height: 13px;
	height: 14px;
	width: auto; @ include radius(0);
	z-index: 1;
}

.form-label-group input:not (:placeholder-shown ) ~ label:after {
	height: 4px;
	content: '';
	width: 70%;
	position: absolute;
	left: 15%;
	border: 1px solid #ffffff;
	background: #fff;
	top: 5px;
	z-index: -1;
}
/* CSS for +91*/
.form-label-group .user-mobile {
	padding-left: 49px;
}

.error-text {
	position: absolute;
	bottom: -16px;
	line-height: 10px;
	font-size: 12px;
	color: #c80039;
}

.code {
	position: absolute;
	top: 1px;
	height: 48px;
	line-height: 48px;
	vertical-align: baseline;
	display: inline-block;
	left: 20px;
	font-size: 16px;
	opacity: 0.5;
	color: #465166;
}

.verify {
	position: absolute;
	right: 20px;
	height: 48px;
	line-height: 48px;
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	color: rgba(70, 81, 102, 0.3);
	top: 0;
	cursor: default;
}

.orange {
	color: #ed6c0d;
	cursor: pointer !important;
}

.error-border {
	border: 2px solid #c80039 !important;
}

.error-border+label {
	color: #c80039 !important;
}

.otp-field.form-label-group input {
	letter-spacing: 6px;
}

.otp-field.form-label-group input:focus::placeholder {
	color: rgba(70, 81, 102, 0.7);
	font-weight: normal;
}

.timer {
	position: absolute;
	bottom: -20px;
	right: 3px;
	z-index: 9;
	font-size: 12px;
	color: #465166;
}

@media screen and (max-width:767px) {
	.form-label-group input:not (:placeholder-shown ) ~ label:after {
		border: 2px solid #ffffff;
		top: 5px;
	}
	.form-label-group input:focus ~ label::after {
		height: 4px;
		top: 5px;
	}
}

@import 'assets/base.scss';

.modal-dialog {
	width: 100%;
}

.login-pop {
	max-width: 869px !important;
	margin: 0 auto;
	display: flex; . modal-content { border : none; @ include radius(10px);
	box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.1);
	display: flex;
	max-height: 533px;
	flex-direction: row; . modal-left { width : 100%;
	max-width: 545px; h4 { &.modal-title{ font-size : 20px;
	color: #465166;
	margin-bottom: 48px;
	font-weight: 500;
	line-height: 1.3;
	max-width: 194px;
}

}
.modal-login {
	max-width: 290px;
	margin: 100px auto 0;
	h3
	{
	display
	:
	none;
}

.login-left {
	padding: 0; . login-buton { width : 100%;
	height: 48px; @ include radius(5px);
	background-image: linear-gradient(261deg, #f69b00, #ed6a00);
	color: #fff;
	font-size: 1rem;
	font-weight: 500;
	text-transform: uppercase;
	opacity: 1;
}

.login-go-back {
	font-size: 0.875rem;
	margin-top: 20px;
	display: inline-block;
	width: 100%;
	max-width: 290px;
	text-align: center; span { color : #465166;
	cursor: pointer;
}

}
.error {
	color: #c80039;
	font-size: 12px;
	display: block;
	position: absolute;
	margin-top: 8px;
	line-height: 14px;
}

}
}
p {
	font-size: .75rem;
	color: rgba(70, 81, 102, 0.5);
	text-align: center;
	margin-top: 70px; a { color : rgba( 70, 81, 102, 0.5);
	text-decoration: underline;
}

}
}
.modal-right {
	width: calc(100% - 545px);
	max-width: 324px;
	background-image: linear-gradient(147deg, #0059a3, #003057);
	height: 100%;
	padding: 88px 65px 0 65px; @ include radius(0 10px 10px 0); p { color :
	#fff;
	font-size: 0.875rem;
	margin-bottom: 0;
	line-height: 1.36;
}

h4 { &.modal-title { font-size:2.25rem;
	font-weight: 500;
	line-height: 1.33;
	margin-bottom: 25px;
	color: #fff;
	span
	{
	&.orange{
	color
	:
	#ed6c0d;
}

}
}
}
ul {
	margin: 25px 0 23px;
	padding: 0; li { font-size : 1rem;
	font-weight: 500;
	color: #dde5eb;
	list-style: none;
	margin-bottom: 18px;
	line-height: 1.44;
	padding: 3px 0;
	background-position: left center; &. track-appointment {
	background-image : url('/assets/images/group-87.svg');
	background-repeat: no-repeat;
	padding-left: 40px;
}

&
.used-car-bid {
	background-image: url('/assets/images/group-88.svg');
	background-repeat: no-repeat;
	padding-left: 40px;
}

}
}
.happy-customer {
	margin-top: 75px;
	padding-left: 53px;
	background-image: url('/assets/images/group-92.svg');
	background-repeat: no-repeat; p { font-size : 1rem;
	line-height: 1.31;
}

}
}
}
}
.cross-icon {
	position: absolute;
	right: 28px;
	top: 28px;
}

@media screen and (max-width:767px) {
	.login-pop {
		padding: 0 15px;
	}
	.modal-left {
		padding: 40px 25px;
	}
	.login-pop .modal-content .modal-left .modal-login .login-left .login-buton
		{
		width: 100%;
	}
	.login-pop .modal-content .modal-left .modal-login {
		margin: 0;
		max-width: 100%;
	}
	.login-pop .modal-content .modal-left p {
		margin: 19px 0 0;
		a
		{
		color
		:
		#465166;
	}
}

.login-pop .modal-content .modal-left h4.modal-title {
	margin: 0;
}

.login-pop .modal-content .modal-left .modal-login h3 {
	font-size: 14px;
	line-height: 1.36;
	color: #465166;
	margin: 16px 0 30px;
	display: block;
	font-weight: normal;
}

.cross-icon {
	right: 21px;
	top: 21px;
}

}
	.login-pop {
		padding: 0 20px; . modal-content .modal-left{ width : 55%;
		max-width: 100%;
	}
	.modal-content .modal-right {
		width: 45%;
		max-width: 100%;
	}
}


.login {
	background: url('assets/images/login-bg.png') no-repeat top center;
	background-size: cover;
	height: 100vh;
	position: relative;
}
</style>
<body>
	<div>
		<main>
		<div id="login"
			class="login d-flex align-items-center justify-content-center">
			<div class="modal-dialog login-pop">
				<div class="modal-content">
					<span class="cross-icon"><img
						src="/assets/images/cross-mobile.953fcce5.svg"
						alt="Login popup close button" class="d-md-none"></span>
					<div class="modal-left">
						<div class="modal-login">
							<h4 class="modal-title">Log In/Sign Up</h4>
							<h3>Join us to track your appointments and find all your
								recently viewed cars in one place!</h3>
							<div class="col-md-12 login-left">
								<form>
									<div class="form-label-group">
										<input type="tel" id="phone" class="form-control user-mobile"
											placeholder="Enter Name" maxlength="10" required="" value=""><label
											for="phone">Mobile Number*</label><span disabled=""
											class="verify">Get OTP</span>
									</div>
									<div class="form-label-group otp-field">
										<input type="tel" id="otp" name="otp" class="form-control"
											placeholder="_ _ _ _" maxlength="4" autocomplete="off"
											required="" value=""><label for="otp">OTP</label>
									</div>
									<button type="submit"
										class="btn btn-default login-buton btn-disabled" disabled="">Login</button>
									<br>
								</form>
								<div class="login-go-back d-md-block d-none">
									<span>Go Back</span>
								</div>
							</div>
						</div>
						<p>
							By clicking Login button, you agree to our <a
								href="https://www.cars24.com/terms-and-conditions/">Terms
								&amp; Conditions </a>&amp; <a
								href="https://www.cars24.com/privacy-policy/">Privacy Policy</a>
						</p>
					</div>
					<div class="modal-right login-right d-md-block d-none">
						<h4 class="modal-title">
							Welcome to<span class="orange"> CARS24</span>
						</h4>
						<p>India’s most preferred place for selling and buying used
							cars.</p>
						<p>Login to :</p>
						<ul>
							<li class="track-appointment">Track Appointment</li>
							<li class="used-car-bid">Used Car Bids</li>
						</ul>
						<div class="happy-customer">
							<p>1.1 lakhs+</p>
							<p>Happy customers</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		</main>
	</div>
</body>
</html>