<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
  <body>
    <em>Struts Hello World Example Results Page</em>
    <p>Hello <s:property value="nmCliente"/> ! </p>
    
    <p>nmExame é <s:property value="nmExame"/> ! </p>
    
    <p>observação do exame: <s:property value="observacaoExame"/> ! </p>
  </body>
</html>