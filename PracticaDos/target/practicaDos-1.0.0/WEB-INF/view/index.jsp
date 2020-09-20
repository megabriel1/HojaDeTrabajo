<%@page import="javax.swing.text.html.CSS"%>
<link href="css/style.css" rel="stylesheet">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Proveedores</title>
        <link href="../../css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Listado de Proveedores</h1>

        <a href="proveedor">Crear Proveedor</a>


        <table>
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre Comercial</th>
                    <th>Contacto</th>                    
                    <th>Dirección</th>
                    <th>Pais</th>
                    <th colspan="2">Opciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${proveedorList}" var="proveedor">
                    <tr>
                        <td>${proveedor.codigo}</td> 
                        <td>${proveedor.nombreComercial}</td> 
                        <td>${proveedor.contacto}</td>                        
                        <td>${proveedor.direccion}</td> 
                        <td>${proveedor.pais}</td>
                        <td><a href="proveedor/codigo/${proveedor.codigo}">Modificar</a></td> 
                        <td><a href="proveedor/eliminar/${proveedor.codigo}">Eliminar</a></td> 
                    </tr>

                </c:forEach>

            
            </tbody>
        </table>
    </body>
    
</html>
