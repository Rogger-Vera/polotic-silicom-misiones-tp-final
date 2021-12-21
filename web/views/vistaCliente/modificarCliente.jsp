
<%@page import="logica.Controlador"%>
<%@page import="logica.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Modificar Cliente</title>
        <link href="../../css/styles.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-7">
                                <div class="card shadow-lg border-0 rounded-lg mt-3 mb-3">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Modificar Cliente</h3></div>
                                    <div class="card-body">
                                        <form action="../../SvModDatosCliente" method="POST">
                                            
                                            <%
                                                HttpSession misesion = request.getSession();
                                                Controlador control = new Controlador();
                                                Cliente cli = (Cliente)misesion.getAttribute("cliente");
                                                {
                                            %>
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" value="<%=cli.getNombre()%>" id="inputNombre" type="text" name="nombre" placeholder="Ingrese su nombre" required/>
                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" value="<%=cli.getApellido()%>" id="inputApellido" type="text" name="apellido" placeholder="Ingrese su apellido" required/>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" value="<%=cli.getDireccion()%>" id="inputDireccion" type="text" name="direccion" placeholder="Ingrese su direccion" required/>
                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" value="<%=cli.getDni()%>" id="inputDocumento" type="text" name="documento" placeholder="Ingrese su numero de documento" required/>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" value="<%=control.deDateAString(cli.getFechaNac())%>" id="inputFechaNac" type="date" name="fechaNac" placeholder="Ingrese su fecha de nacimiento" required/>
                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" value="<%=cli.getNacionalidad()%>" id="inputNacionalidad" type="text" name="nacionalidad" placeholder="Ingrese su nacionalidad" required/>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" value="<%=cli.getCelular()%>" id="inputCelular" type="text" name="celular" placeholder="Ingrese su numero de celular" required/>
                                                        
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3">
                                                        <input class="form-control" value="<%=cli.getEmail()%>" id="inputEmail" type="email" name="email" placeholder="name@example.com" required/>
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            
                                                        <input class="form-control" value="<%=cli.getId()%>" id="inputId" type="hidden" name="id"/>
                                                        
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Modificar Cliente</button></div>
                                            </div>
                                            
                                                <%}%>
                                            
                                        </form>
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
        <script src="js/scripts.js"></script>
    </body>
</html>
