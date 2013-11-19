<%-- 
    Document   : modificarFormulario
    Created on : 15/11/2013, 08:31:35 AM
    Author     : 202
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/libs/jquery-1.9.0/jquery.min.js"></script>
        <script src="js/libs/jquery-validate-1.10.0/jquery.validate.min.js"></script>
        <title>validacion nuevo funcionario</title>
    <style>
            .error
            {
                color:red
                    
            }
            input.error
            {
                background-color: #cccccc
            }
           
           
            
        </style> 
    </head>
    <body>
             <%@ page import="datos.entidades.Funcionario" %>        
           <%  Funcionario f1=(Funcionario)request.getAttribute("funcionario"); %> 
             <% String nombre=f1.getNombres(); %>
             <% String apellido1=f1.getApellido1(); %>
             <% String apellido2=f1.getApellido2(); %>
             <% String clave=f1.getClave(); %>
             <% String nDocumento=f1.getNumeroDocumento(); %>              
               
               
                   
        <form  method="post" id="form1" name="funcionario" action="CFuncionario?a=guardarM" >
            <br>Nombre:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="nombre" value="<%=nombre%>" /><br>
            <br>Primer Apellido:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="apellidoU" value="<%=apellido1%>" /><br>
            <br>Segundo Apellido:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="apellidoD" value="<%=apellido2%>" /><br>
            <br>Clave:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="clave" value="<%=clave%>" /><br>
            <input type="hidden" name="numeroDocumento" value="<%=nDocumento%>">
            <br><input type="submit" name="aceptar" value="aceptar"/> 
         </form>
        
        
        
        
    </body>
</html>
