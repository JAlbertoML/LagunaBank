<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<c:set var="client" value="${requestScope['client']}"></c:set>
<c:set var="user" value="${requestScope['user']}"></c:set>
<c:if test="${client.photo == \"img/profileMan.png\"}">
	<c:set var="remove" value="disabled"></c:set>
</c:if>
<c:if test="${client.photo == \"img/profileWoman.png\"}">
	<c:set var="remove" value="disabled"></c:set>
</c:if>
<c:if test="${client.photo == \"img/profileNeutral.png\"}">
	<c:set var="remove" value="disabled"></c:set>
</c:if>
<c:set var="alert" value="${requestScope['alert']}"></c:set>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Client</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.css" rel="stylesheet">

</head>

<body id="page-top" onload="${alert}">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="Client"> <img alt="Laguna Bank" src="img/logo.png"
				width="100%">
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" href="Client"> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Resumen
						bancario</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Movimientos</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-cog"></i> <span>Realizar movimiento</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Movimientos</h6>
						<a class="collapse-item" data-toggle="modal"
							data-target="#withdrawalModal" href="">Retiro de
							dinero</a> <a class="collapse-item" data-toggle="modal"
							data-target="#transferModal" href="">Transferencia</a>
						<a class="collapse-item" data-toggle="modal"
							data-target="#topUpModal" href="">Recarga de
							saldo</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Consultar movimientos</span>
			</a>
				<div id="collapseUtilities" class="collapse"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Movimientos:</h6>
						<a class="collapse-item" href="CheckWithdrawals">Retiros</a> <a
							class="collapse-item" href="CheckTransfers">Transferencias</a> <a
							class="collapse-item" href="CheckPayments">Pagos a cuenta</a> <a
							class="collapse-item" href="CheckTopUpBalances">Recargas</a> <a
							class="collapse-item" href="CheckMovements">Todos</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">Cuentas</div>

			<!-- Nav Item - Charts -->
			<li class="nav-item"><a class="nav-link" href="SavedAccounts">
					<i class="fas fa-fw fa-folder"></i> <span>Cuentas guardadas</span>
			</a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block">

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>

		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>
					<h1 class="h3 mb-0 text-gray-800">Perfil</h1>
					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small">${client.name}
									${client.surname} ${client.lastname}</span> <img
								class="img-profile rounded-circle" src="${client.photo}">
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="Client"> <i
									class="fas fa-tachometer-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Página principal
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<div class="row my-2">
						<div class="col-lg-12 order-lg-2">
							<div class="tab-content py-4">
								<div class="tab-pane active" id="profile">
									<div class="col-lg-12 order-lg-1 text-center">
										<div class="row d-flex align-items-center">
											<div class="col-md-4"></div>
											<div class="col-md-2">
												<img src="${client.photo}"
													class="mx-auto img-fluid img-circle d-block" width="150px"
													style="border-radius: 50%" alt="avatar">
											</div>
											<div class="col-md-2 mt-3">
												<a class="btn btn-primary btn-user btn-block"
													style="color: white;" data-toggle="modal"
													data-target="#changePhoto">Cambiar foto</a> <a
													href="DeleteAccount"
													class="btn btn-danger btn-icon-split col-md-12 mt-3 ${remove} "><span
													class="text">Eliminar foto</span> </a>
											</div>
											<div class="col-md-4"></div>
										</div>
									</div>
									<br>
									<h5 class="mb-3 text-center">${client.name}
										${client.surname} ${client.lastname} (<b>${user.username}</b>)
									</h5>
									<p class="text-center">
										<b>N° de Cliente: </b>${client.idClient}</p>
									<div class="row">

										<div class="col-lg-6">

											<div class="card shadow mb-4">
												<div class="card-header py-3">
													<h6 class="m-0 font-weight-bold text-primary">Datos
														personales</h6>
												</div>
												<div class="card-body">
													<p>
														<b>Fecha de nacimiento: </b>${client.birthday}</p>
													<p>
														<b>CURP: </b>${client.curp}</p>
													<p>
														<b>Genero: </b>${client.gender}</p>
												</div>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="card shadow mb-4">
												<div class="card-header py-3">
													<h6 class="m-0 font-weight-bold text-primary">Contacto</h6>
												</div>
												<div class="card-body">
													<p>
														<b>Correo electrónico: </b>${client.contact.email}</p>
													<p>
														<b>Teléfono: </b>${client.contact.phone	}</p>
												</div>
											</div>
										</div>
										<div class="col-lg-12">
											<div class="card shadow mb-4">
												<div class="card-header py-3">
													<h6 class="m-0 font-weight-bold text-primary">Dirección</h6>
												</div>
												<div class="card-body">
													<div class="row">
														<div class="col-lg-4">
															<p>
																<b>Calle: </b>${client.direction.street}</p>
															<p>
																<b>Número: </b>${client.direction.number}</p>
														</div>
														<div class="col-lg-4">
															<p>
																<b>Colonia o poblado: </b>${client.direction.suburb}</p>
															<p>
																<b>Alcaldía o municipio: </b>${client.direction.townhall}</p>
														</div>
														<div class="col-lg-4">
															<p>
																<b>Estado: </b>${client.direction.state}</p>
															<p>
																<b>País: </b>${client.direction.country}</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
								<a class="btn btn-primary btn-user btn-block" href="EditProfile">Editar
									perfil</a>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">¿Estás seguro?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Da clic en cerrar sesión para salir.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancelar</button>
					<a class="btn btn-primary" href="Logout">Cerrar sesión</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Change PHoto modal -->
	<div class="modal fade" id="changePhoto" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<form action="ChangePhoto" method="post" enctype="multipart/form-data">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Cambiar
							foto de perfil</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>Debes subir imagenes en formato png, jpg, o jpeg</p>
						<input type="file" name="photoInput" accept="image/png, image/jpeg, image/jpg" />
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<input type="submit" class="btn btn-primary" value="Guardar foto">
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<!-- Make Withdrawal Modal -->
	<div class="modal fade" id="withdrawalModal" tabindex="-1"
		role="dialog" aria-labelledby="withdrawalModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Retirar dinero</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form class="user" action="MakeWithdrawal" method="post">
					<div class="modal-body">
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="amountTxt" name="amountTxt" placeholder="Monto del retiro">
						</div>
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="descTxt" name="descTxt"
								placeholder="Descripción del movimiento (opcional)">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Realizar
							retiro</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Make Top Up Modal -->
	<div class="modal fade" id="topUpModal" tabindex="-1" role="dialog"
		aria-labelledby="topUpModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Recargar saldo</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form class="user" action="MakeTopUpBalance" method="post">
					<div class="modal-body">
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="amountTxt" name="amountTxt"
								placeholder="Monto de la recarga">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Recargar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Transfer Modal -->
	<div class="modal fade" id="transferModal" tabindex="-1" role="dialog"
		aria-labelledby="transferModal" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Realizar
						transferencia</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form class="user" action="MakeTransfer" method="post">
					<div class="modal-body">
					<div class="form-group">
							<select id="idReceiverTxt" name="idReceiverTxt" class="form-control ">
							<option value="" selected="selected" disabled="disabled">Destinatario</option>
								<c:forEach items="${client.savedAccounts}" var="account">
									<option value="${account.idAccout}">${account.alias} - ${account.idAccout}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="amountTxt" name="amountTxt"
								placeholder="Monto de la transferencia">
						</div>
						<div class="form-group">
							<input type="text" class="form-control form-control-user"
								id="descTxt" name="descTxt" placeholder="Descripción (opcional)">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cancelar</button>
						<button type="submit" class="btn btn-primary">Tranferir</button>
					</div>
				</form>
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

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>
</body>

</html>