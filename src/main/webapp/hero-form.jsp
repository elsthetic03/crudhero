Form
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Form Hero</title>
    <style>
        body { font-family: sans-serif; }
        .container { width: 50%; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
        input[type=text], select {
            width: 100%; padding: 12px 20px; margin: 8px 0;
            border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;
        }
        input[type=submit] {
            width: 100%; background-color: #4CAF50; color: white;
            padding: 14px 20px; margin: 8px 0; border: none; border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>
        <c:if test="${hero != null}">Edit Hero</c:if>
        <c:if test="${hero == null}">Tambah Hero Baru</c:if>
    </h1>

    <form action="${hero != null ? 'update' : 'insert'}" method="post">
        <c:if test="${hero != null}">
            <input type="hidden" name="id" value="<c:out value='${hero.idHero}' />" />
        </c:if>

        <label for="nama_hero">Nama Hero</label>
        <input type="text" id="nama_hero" name="nama_hero" value="<c:out value='${hero.namaHero}' />" required>

        <label for="kategori">Kategori</label>
        <select id="kategori" name="kategori" required>
            <option value="">-- Pilih Kategori --</option>
            <option value="MAGE" <c:if test="${hero.kategori == 'MAGE'}">selected</c:if>>MAGE</option>
            <option value="ASSASSIN" <c:if test="${hero.kategori == 'ASSASSIN'}">selected</c:if>>ASSASSIN</option>
            <option value="FIGHTER" <c:if test="${hero.kategori == 'FIGHTER'}">selected</c:if>>FIGHTER</option>
            <option value="TANK" <c:if test="${hero.kategori == 'TANK'}">selected</c:if>>TANK</option>
            <option value="MARKSMAN" <c:if test="${hero.kategori == 'MARKSMAN'}">selected</c:if>>MARKSMAN</option>
            <option value="SUPPORT" <c:if test="${hero.kategori == 'SUPPORT'}">selected</c:if>>SUPPORT</option>
        </select>

        <label for="gender">Gender</label>
        <select id="gender" name="gender" required>
            <option value="">-- Pilih Gender --</option>
            <option value="MALE" <c:if test="${hero.gender == 'MALE'}">selected</c:if>>MALE</option>
            <option value="FEMALE" <c:if test="${hero.gender == 'FEMALE'}">selected</c:if>>FEMALE</option>
        </select>

        <input type="submit" value="Simpan">
    </form>
</div>
</body>
</html>