<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Distributeur Spring mvc v2</title>
    </head>
    <body>
        <h2>Crédit : ${balance}</h2>
        <table>
            <caption>Liste des produits</caption>
            <tr>
                <th>Numéro de produit</th>
                <th>Nom</th>
                <th>Quantité</th>
                <th>Prix</th>
            </tr>

            <c:forEach var="p" items="${products }">
                <tr>
                    <td>${p.id }</td>
                    <td>${p.name }</td>
                    <td>${p.quantity }</td>
                    <td>${p.price }</td>
                </tr>
            </c:forEach>


        </table>

        <form:form method="POST" action="/addBalance" modelAttribute="userForm">
            <fieldset>
                <legend>Crédit à ajouter : </legend>
                <p>
                    <form:label path="balance">Montant</form:label>
                    <form:input path="balance" type="number" step="0.01" />
                    <form:errors style="color:red" path="balance" />
                </p>
                <input type="submit" value="Ajouter" />

            </fieldset>
        </form:form>


        <form:form method="POST" action="/buyProduct" modelAttribute="buyForm">
            <fieldset>
                <legend>Acheter un produit : </legend>
                <p>
                    <form:label path="id">Numéro du produit</form:label>
                    <form:input path="id" type="number" />
                    <form:errors style="color:red" path="id" />
                </p>
                <input type="submit" value="Acheter" />

            </fieldset>
        </form:form>
    </body>
</html>
