<%-- 
    Document   : modificarFuncionario
    Created on : 15/11/2013, 08:06:28 AM
    Author     : 202
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
      <script src="js/libs/jquery-1.9.0/jquery.min.js"></script>
       <script src="js/libs/jquery-validate-1.10.0/jquery.validate.min.js"></script>
        <style>
            .error
            {
                color:red
                    
            }
            input.error
            {
                background-color: #cccccc
            }
           
            li
            {
                
                color:red
                
            }
           
            
        </style> 
    </head>
    <body>
        
          <form  method="post" id="form1" name="inicioSesion" action="CFuncionario?a=modificar" >
                    
                    <br>Numero de documento: <input type="text" name="numeroDocumento" value=""/><br>
         
                    <% Boolean error= (Boolean)request.getAttribute("error"); %>
           
                <%if(error==false){ %> 
            
<li>El documento digitado no existe</li>
                    
<% } %>
                   
            
            <br><input type="submit" name="aceptar" value="aceptar"/> 
       
            
            <script>
             $("#form1").validate(                
        
        {
    errorLabelContainer:"#messagebox",
    wrapper:"li",
         rules:
                 {
             
             numeroDocumento:
                     {
                 required: true,
                 digits:true               
                 },
              },
        
                 messages:
                         {
                     
                     numeroDocumento:
                     {
                 required: "por favor digite el numero de su documento",
                 digits:"digite solo numeros"
            },                     
                 }                         
                         }
           );
                          </script>
    </body>
</html>
