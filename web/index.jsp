

<%@page import="logica.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Inicio</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">TP Final</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                
            </form>
            
            <!-- Navbar-->
            
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        
                        
                        <li><a class="dropdown-item" href="views/vistaEmpleado/login.jsp">Salir</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            
            <!-- Verificar si existe una sesion -->
            
            <% HttpSession misession = request.getSession(); 
                //Verificamos si existe usuario que haya iniciado sesion
                String usu = (String)request.getSession().getAttribute("usuario");
                if(usu == null){
                    response.sendRedirect("views/vistaEmpleado/sinLogin.jsp");
                }else{
                    Controlador control = new Controlador();
                    misession.setAttribute("control", control);
                }
            
            
            %>
            
            
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Principal</div>
                            <a class="nav-link" href="index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-home"></i></div>
                                Inicio
                            </a>
                            <div class="sb-sidenav-menu-heading">Menu</div>
                            <!-- Empleados-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEmpleados" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-user"></i></div>
                                Empleados
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseEmpleados" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="views/vistaEmpleado/altaEmpleado.jsp">Nuevo Empleado</a>
                                    
                                    <form  action="SvListarEmpleados" method="GET">
                                        <a class="SUBMIT nav-link" href="SvListarEmpleados">Lista de Empleados</a>
                                    </form>
                                </nav>
                            </div>
                            <!-- Clientes-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseClientes" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="far fa-user"></i></div>
                                Clientes
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseClientes" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="views/vistaCliente/altaCliente.jsp">Nuevo Cliente</a>
                                    
                                    <form  action="SvListarClientes" method="GET">
                                        <a class="SUBMIT nav-link" href="SvListarClientes">Lista de Clientes</a>
                                    </form>
                                </nav>
                            </div>
                            <!-- Servicios-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseServicios" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-concierge-bell"></i></div>
                                Servicios
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseServicios" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="views/vistaServicio/altaServicio.jsp">Nuevo Servicio</a>
                                    
                                    <form  action="SvListarServicios" method="GET">
                                        <a class="SUBMIT nav-link" href="SvListarServicios">Lista de Servicios</a>
                                    </form>
                                </nav>
                            </div>
                            <!-- Paquetes-->
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePaquetes" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-box"></i></div>
                                Paquetes
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePaquetes" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="views/vistaPaquete/altaPaquete.jsp">Nuevo Paquete</a>
                                    <a class="nav-link" href="views/vistaPaquete/listarPaquete.jsp">Lista de Paquetes</a>
                                    
                                </nav>
                            </div>
                            <!-- Ventas-->
                            
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVentas" aria-expanded="false" aria-controls="collapseVentas">
                                <div class="sb-nav-link-icon"><i class="fas fa-hand-holding-usd"></i></div>
                                Ventas
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseVentas" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    
                                    <a class="nav-link" href="views/vistaVenta/altaVenta.jsp">Nueva Venta</a>

                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Lista de Ventas
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="views/vistaVenta/altaVenta.jsp">Venta de Servicios</a>
                                            <a class="nav-link" href="views/vistaVenta/altaVenta.jsp">Venta de Paquetes</a>
                                            
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Usuario</div>
                            
                            
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logueado como: </div>
                        <%=request.getSession().getAttribute("usuario")%>
                    </div>
                </nav>
            </div>
            
            <!-- Main-->
            
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4 text-center">
                        <h1 class="mt-4">Agencia de viajes Nube Voladora</h1>
                        
                            <p class="breadcrumb-item active text-center">Bienvenido a la mejor Agencia de Viajes</p>
                        
                        
                        
                        <div>
                            
                            <img src="img/img1.png" class="img-fluid w-100 " alt="...">
                            
                        </div>
                        
                        
                        
                        
                    </div>
                </main>
                
                <!-- Footer-->
                
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; TP Final Curso Desarrollo FullStack con Java - Silicom Misiones 2021</div>
                            <div>
                                <span>Privacy Policy</span>
                                &middot;
                                <span>Terms &amp; Conditions</span>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
