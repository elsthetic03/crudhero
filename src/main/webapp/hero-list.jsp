List

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Manajemen Hero Mobile Legend</title>
    <style>
        body { font-family: sans-serif; }
        table { border-collapse: collapse; width: 80%; margin: 20px auto; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        a { text-decoration: none; color: #007bff; }
        .container { width: 80%; margin: auto; }
    </style>
</head>
<body>
<div class="container">
    <h1>Daftar Hero Mobile Legend</h1>
    <h3><a href="new">Tambah Hero Baru</a></h3>
    <table>
        <tr>
            <th>ID</th>
            <th>Nama Hero</th>
            <th>Kategori</th>
            <th>Gender</th>
            <th>Aksi</th>
        </tr>
        <c:forEach var="hero" items="${listHero}">
            <tr>
                <td><c:out value="${hero.idHero}" /></td>
                <td><c:out value="${hero.namaHero}" /></td>
                <td><c:out value="${hero.kategori}" /></td>
                <td><c:out value="${hero.gender}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${hero.idHero}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${hero.idHero}' />"
                       onclick="return confirm('Yakin ingin menghapus hero ini?')">Hapus</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>