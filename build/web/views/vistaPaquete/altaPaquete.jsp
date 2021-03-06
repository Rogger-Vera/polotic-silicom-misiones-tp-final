<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Registro</title>
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
                                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Alta Paquete</h3></div>
                                    <div class="card-body">
                                        <form action="../../SvServicioTuristico" method="POST">
                                            
                                            <div class="card-header"><h5 class="text-center font-weight-light my-4">Seleccione los servicios</h5></div>
                                            
                                            
                                            <div class="form-floating mb-3 md-0">
                                                <select class="form-select" name="nombre" aria-label="Selecione el servicio">
                                                    <option selected>Seleccione el servicio</option>
                                                    <option value="Pasajes de colectivo">Pasajes de colectivo</option>
                                                    <option value="Pasajes de avi??n">Pasajes de avion</option>
                                                    <option value="Pasajes de tren">Pasajes de tren</option>
                                                </select>
                                            </div>
                                            
                                            <div class="form-floating mb-3 md-0">
                                                <select class="form-select" name="nombre" aria-label="Selecione el servicio">
                                                    <option selected>Seleccione el servicio</option>
                                                    <option value="Hotel por noche/s">Hotel por noche/s</option>
                                                    <option value="Alquiler de auto">Alquiler de auto</option>
                                                    <option value="Excursiones">Excursiones</option>
                                                    <option value="Entradas a Eventos">Entradas a Eventos</option>
                                                </select>
                                            </div>
                                            
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputDescripcion" type="text" name="descripcion" placeholder="Ingrese su apellido" />
                                                        <label for="inputDescripcion">Descripcion breve</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputDestino" type="text" name="destino" placeholder="Ingrese su direccion" />
                                                        <label for="inputDestino">Destino</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row mb-3">
                                                <div class="col-md-6">
                                                    <div class="form-floating mb-3 mb-md-0">
                                                        <input class="form-control" id="inputFecha" type="date" name="fecha" placeholder="Ingrese su direccion" />
                                                        <label for="inputFecha">Fecha</label>
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <div class="form-floating">
                                                        <input class="form-control" id="inputCosto" type="text" name="costo" placeholder="Ingrese su numero de documento" />
                                                        <label for="inputCosto">Costo</label>
                                                    </div>
                                                </div>
                                            </div>
                                            
                                            
                                            
                                            
                                            <div class="mt-4 mb-0">
                                                <div class="d-grid"><button class="btn btn-primary btn-block" type="submit">Crear Servicio</button></div>
                                            </div>
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
