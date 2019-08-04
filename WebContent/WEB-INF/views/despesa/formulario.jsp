<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

<head>
 <link type="text/css" href="resources/css/imovel.css" rel="stylesheet" />
 <script type="text/javascript" src="resources/js/jquery.js"></script>
</head>

 <h3>Adiciona despesas</h3>
 <form:errors path="despesa.descricao" cssStyle="color:red"/>
 <br />
 <br />
 <form action="adicionaDespesa" method="post">
 Descrição: <br />
 <textarea rows="5" cols="100" name="descricao"></textarea><br />
 <input type="submit" value="Adicionar" />
 </form>
</body>
</html>