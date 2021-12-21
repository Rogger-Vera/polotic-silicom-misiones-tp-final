<%@page import="logica.ServicioTuristico"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Lista Servicios Turisticos</title>
        <link href="../../css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-12">
                                <div class="card shadow-lg border-0 rounded-lg mt-3 mb-3">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Servicios Turisticos</h3></div>
                                    <div class="card-body">
                                        
                                        
                                        
                                        <div class="card mb-4">
                                            <div class="card-header">
                                                <i class="fas fa-table me-1"></i>
                                                Lista de Servicios Turisticos
                                            </div>
                                            <div class="card-body">
                                                <table id="datatablesSimple">
                                                    <thead>
                                                        <tr>
                                                            <th>Codigo de Servicio</th>
                                                            <th>Nombre</th>
                                                            <th>Descripcion</th>
                                                            <th>Destino</th>
                                                            <th>Costo</th>
                                                            <th>Fecha</th>
                                                        </tr>
                                                    </thead>
                                                    <tfoot>
                                                        <tr>
                                                            <th>Codigo de Servicio</th>
                                                            <th>Nombre</th>
                                                            <th>Descripcion</th>
                                                            <th>Destino</th>
                                                            <th>Costo</th>
                                                            <th>Fecha</th>
                                                        </tr>
                                                    </tfoot>
                                                    <tbody>
                                                        
                                                        <% HttpSession miSesion = request.getSession();
                                                        Controlador control = new Controlador();
                                                    List <ServicioTuristico> listaServicios = (List) request.getSession().getAttribute("listaServicios");
                                                    for ( ServicioTuristico servi : listaServicios) {      
                                                %>  
                                                        
                                                        
                                                        
                                                        <tr>
                                                            <td><%=servi.getCodigoServicio()%></td>
                                                            <td><%=servi.getNombre()%></td>
                                                            <td><%=servi.getDescripcion()%></td>
                                                            <td><%=servi.getDestinoServicio()%></td>
                                                            <td><%=servi.getCostoServicio()%></td>
                                                            
                                                            <td><%=control.deDateAString(servi.getFecha())%></td>
                                                            
                                                            
                                                            <td>
                                                                <form name="formModificarPersona" action="../../SvModificarServicio" method="POST">
                                                                    <input type="hidden" name="id" value="<%=servi.getCodigoServicio()%>">
                                                                    <button type="SUMBIT" class="btn btn-primary">Modificar</button>
                                                                </form>
                                                                
                                                                
                                                            </td>
                                                            <td>
                                                                <form name="formBorrarPersona" action="../../SvEliminarServicio" method="POST">
                                                                    <input type="hidden" name="id" value="<%=servi.getCodigoServicio()%>">
                                                                    <button type="SUMBIT" class="btn btn-danger">Eliminar</button>
                                                                </form>
                                                            </td>
                                                            
                                                            
                                                        </tr>
                                                        
                                                        <%}%>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="d-flex align-items-center justify-content-center mt-4 mb-0">
                                                
                                            <div class="d-grid""><a class="btn btn-primary btn-block" href="../../index.jsp">Volver a Inicio</a></div>
                                        </div>
                                        
                                        
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2021</div>
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
        
        
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="../../js/datatables-simple-demo.js"></script>
    </body>
</html>
