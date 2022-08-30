<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Distributeur Spring mvc v2</title>
    </head>
    <body>
        <h1>Crédit : ${balance}</h1>
        <table>
            <caption>Liste des produits</caption>
            <tr>
                <th>Numéro de produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>

            <c:forEach var="product" items="${products }">
                <tr>
                    <td>${product.id }</td>
                    <td>${product.name }</td>
                    <td>${product.price }</td>
                    <td>${product.quantity }</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>
