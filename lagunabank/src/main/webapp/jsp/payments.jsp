<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<c:set var="client" value="${requestScope['client']}"></c:set>
<c:set var="typeMov" value="${requestScope['type']}"></c:set>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Pagos a cuenta</title>

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="Client">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-piggy-bank"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					LagunaBank
				</div>
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
							data-target="#withdrawalModal" href="">Retiro de dinero</a> <a
							class="collapse-item" data-toggle="modal"
							data-target="#transferModal" href="">Transferencia</a> <a
							class="collapse-item" data-toggle="modal"
							data-target="#topUpModal" href="">Recarga de saldo</a>
					</div>
				</div></li>

			<!-- Nav Item - Utilities Collapse Menu -->
			<li class="nav-item active"><a class="nav-link" href="#"
				data-toggle="collapse" data-target="#collapseUtilities"
				aria-expanded="true" aria-controls="collapseUtilities"> <i
					class="fas fa-fw fa-wrench"></i> <span>Consultar movimientos</span>
			</a>
				<div id="collapseUtilities" class="collapse show"
					aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<h6 class="collapse-header">Movimientos:</h6>
						<a class="collapse-item" href="CheckWithdrawals">Retiros</a>
						<a class="collapse-item" href="CheckTransfers">Transferencias</a>
						<a class="collapse-item active" href="CheckPayments">Pagos a cuenta</a> <a
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
					<h1 class="h3 mb-0 text-gray-800">Pagos a cuenta</h1>
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
								<a class="dropdown-item" href="Profile"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
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



					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Tabla de
								transferencias de dinero a tu cuenta</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th width="15%">Cantidad</th>
											<th width="25%">Fecha</th>
											<th width="15%">Tipo</th>
											<th>Descripción</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Cantidad</th>
											<th>Fecha</th>
											<th>Tipo</th>
											<th>Descripción</th>
										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${client.movements}" var="mov">
											<c:if test="${mov.type == \"Pago a cuenta\"}">
												<tr>
													<td>$${mov.amount}</td>
													<td>${mov.movDate}</td>
													<td>${mov.type}</td>
													<td>${mov.description}</td>
												</tr>
											</c:if>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Alberto Laguna 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

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
						<span aria-hidden="true">&times;</span>
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
							<select id="idReceiverTxt" name="idReceiverTxt"
								class="form-control ">
								<option value="" selected="selected" disabled="disabled">Destinatario</option>
								<c:forEach items="${client.savedAccounts}" var="account">
									<option value="${account.idAccout}">${account.alias}-
										${account.idAccout}</option>
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
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>

</body>

</html>
