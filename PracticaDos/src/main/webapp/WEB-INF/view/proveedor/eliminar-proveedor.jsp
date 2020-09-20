
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Proveedor</title>
    </head>
    <body>
        <h1>Eliminar Proveedor</h1>

        <span>${mensaje}</span>

        
        
        <form:form method="post"  
                   action="${pageContext.servletContext.contextPath}/proveedor/eliminar"
                   modelAttribute="proveedor">
            
            <form:label path="codigo">Código:</form:label> 
            <form:input path="codigo" readonly="true"  />
            <br/>

            <form:label path="nombreComercial">Nombre Comercial:</form:label> 
            <form:input path="nombreComercial" readonly="true" />
            <br/>

            <form:label path="contacto">Contacto:</form:label> 
            <form:input path="contacto" readonly="true" />
            <br/>
            
            <form:label path="direccion">Dirección:</form:label> 
            <form:textarea path="direccion" readonly="true" />
            <br/>


            <form:label path="email">Correo Electrónico:</form:label> 
            <form:input path="email" readonly="true" />
            <br/>

            <form:label path="pais">Pais:</form:label> 
            <form:input path="pais" readonly="true" />
            <br/>
            
            <p>¿Esta seguro que quiere eliminar a este usuario?</p>            
            <form:button class="">Sí, eliminar</form:button>           
            
        </form:form>
    <br/>
    <a href="${pageContext.servletContext.contextPath}">Ver el listado de proveedores</a>
    </body>
</html>
