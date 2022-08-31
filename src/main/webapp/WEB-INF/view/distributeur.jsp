<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
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

        <form:form method="POST" action="/addBalance" modelAttribute="userForm">
            <table>
                <tr>
                    <td><form:label path="balance">Crédit à ajouter : </form:label></td>
                        <td>
                        <form:input path="balance" type="number" />
                        <form:errors style="color:red" path="balance" />
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>


        <form:form method="POST" action="" modelAttribute="buyForm">
            <table>
                <tr>
                    <td><form:label path="id">Produit à acheter : </form:label></td>
                        <td>
                        <form:input path="id" />
                        <form:errors style="color:red" path="id" />
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" /></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
