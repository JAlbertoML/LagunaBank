<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="message" value="${requestScope['message']}"></c:set>
<c:set var="person" value="${requestScope['person']}"></c:set>
<head>

<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>registro</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Crea tu cuenta</h1>
							</div>
							<p>* Secciones obligatorias: todos los campos de la sección
								deberán ser llenados.</p>
							<p style="color: red" class="text-center">${message}</p>
							<form class="user" action="Register" method="post">
								<h3 class="h5 text-gray-900 mb-4">Datos personales *</h3>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control " id="nameTxt"
											name="nameTxt" placeholder="Nombre" value="${person.name}">
									</div>
									<div class="col-sm-6 mb-3 mt-sm-3">
										<input type="text" class="form-control " id="surnameTxt"
											name="surnameTxt" placeholder="Primer apellido"
											value="${person.surname}">
									</div>
									<div class="col-sm-6 mb-3 mt-sm-3">
										<input type="text" class="form-control " id="lastnameTxt	"
											name="lastnameTxt" placeholder="Segundo apellido"
											value="${person.lastname}">
									</div>
									<div class="col-sm-6 mb-3 mt-sm-0">
										<input type="text" class="form-control " id="curpTxt"
											name="curpTxt" placeholder="CURP" value="${person.curp}"
											pattern="^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0\d|1[0-2])(?:[0-2]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$">
									</div>
									<div class="col-sm-6 mb-3 mt-sm-0">
										<input type="text" class="form-control " id="birthdayDate"
											name="birthdayDate" placeholder="Fecha de nacimiento"
											onfocus="(this.type='date')">
									</div>
									<div class="col-sm-12 mb-3 mt-sm-0">
										<select name=genderTxt id="genderTxt"
											class="form-control form-control-select">
											<option selected value="">Género</option>
											<option value="Masculino">Masculino</option>
											<option value="Femenino">Femenino</option>
											<option value="Otro">Otro</option>
										</select>
									</div>
								</div>
								<h3 class="h5 text-gray-900 mb-4">Define tu usuario y
									contraseña *</h3>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="text" class="form-control " id="usernameTxt"
											name="usernameTxt" placeholder="Nombre de usuaro">
									</div>
									<div class="col-sm-6 mb-3 mt-sm-3">
										<input type="password" class="form-control " id="passwordTxt"
											name="passwordTxt" placeholder="Contraseña">
									</div>
									<div class="col-sm-6 mb-3 mt-sm-3">
										<input type="password" class="form-control "
											id="repeatPasswordTxt" name="repeatPasswordTxt"
											placeholder="Repite tu contraseña">
									</div>
								</div>
								<h3 class="h5 text-gray-900 mb-4">Contacto *</h3>
								<div class="form-group row">

									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="email" class="form-control " id="emailTxt"
											name="emailTxt" placeholder="Correo Electrónico"
											value="${person.contact.email}">
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="tel" class="form-control " id="phoneTxt"
											name="phoneTxt" placeholder="Teléfono a 10 dígitos"
											value="${person.contact.phone}" pattern="^[2-9]{2}[0-9]{8}$">
									</div>
								</div>
								<h3 class="h5 text-gray-900 mb-4">Dirección *</h3>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control " id="streetTxt"
											name="streetTxt" placeholder="Calle"
											value="${person.direction.street}">
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="number" class="form-control " id="numberTxt"
											name="numberTxt" placeholder="Número"
											value="${person.direction.number}">
									</div>
									<div class="col-sm-6  mb-3 mt-sm-3">
										<input type="text" class="form-control " id="suburbTxt"
											name="suburbTxt" placeholder="Colonia o poblado"
											value="${person.direction.suburb}">
									</div>
									<div class="col-sm-6  mb-3 mt-sm-3">
										<select name="townhallTxt" id="townhallTxt"
											class="form-control">
											<option selected value="">Alcaldía o municipio</option>
											<option value="Benito Juárez">Benito Juárez</option>
											<option value="Iztacalco">Iztacalco</option>
											<option value="Miguel Hidalgo">Miguel Hidalgo</option>
										</select>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<select name="stateTxt" id="stateTxt" class="form-control">
											<option selected value="">Estado</option>
											<option value="Ciudad de México">Ciudad de México</option>
										</select>
									</div>
									<div class="col-sm-6 mb-3 mb-sm-0">
										<select name="countryTxt" id="countryTxt" class="form-control">
											<option selected value="">País</option>
											<option value="México">México</option>
										</select>
									</div>
								</div>
								<h3 class="h5 text-gray-900 mb-4">Saldo inicial</h3>
								<div class="form-group row">
									<div class="col-sm-12 mb-3 mb-sm-0">
										<input type="number" class="form-control " id="balanceTxt"
											name="balanceTxt" placeholder="Cantidad de apertura">
									</div>
								</div>
								<button class="btn btn-primary btn-user btn-block" type="submit">
									Registrarme</button>
							</form>
							<hr>
							<div class="text-center">
								<a class="small" href="forgot-password.html">Olvidé mi
									contraseña</a>
							</div>
							<div class="text-center">
								<a class="small" href="Login">Ya tengo una cuenta</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

</body>

</html>