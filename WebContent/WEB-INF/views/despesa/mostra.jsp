<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<body>
<head>
 <link type="text/css" href="resources/css/imovel.css" rel="stylesheet" />
 <script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
 <h3>Alterar despesa - ${despesa.id}</h3>
 <form action="alteraDespesa" method="post">
 <input type="hidden" name="id" value="${despesa.id}" />
 Descri&ccedil;&atilde;o:<br />
 <textarea name="descricao" cols="100" rows="5">${despesa.descricao}</textarea>
 <br /> Pago?
 <input type="checkbox" name="pago" value="true" ${despesa.pago ? 'checked' : ''} />
 <br /> Data de pagamento:<br />
 <input type="text" name="dataPagamento"
 value="<fmt:formatDate value="${despesa.dataPagamento.time}" pattern="dd/MM/yyyy" /> " />
 <br />
 <br />
 <input type="submit" value="Alterar" />
 </form>
</body>
</html>