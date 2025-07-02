package com.hero.dao;

import com.hero.model.Hero;
import com.hero.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HeroDAO {

    public void insertHero(Hero hero) throws SQLException {
        String sql = "INSERT INTO tm_hero (nama_hero, kategori, gender) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hero.getNamaHero());
            stmt.setString(2, hero.getKategori());
            stmt.setString(3, hero.getGender());
            stmt.executeUpdate();
        }
    }

    public List<Hero> selectAllHeroes() throws SQLException {
        List<Hero> heroes = new ArrayList<>();
        String sql = "SELECT * FROM tm_hero ORDER BY id_hero";
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                heroes.add(new Hero(
                        rs.getInt("id_hero"),
                        rs.getString("nama_hero"),
                        rs.getString("kategori"),
                        rs.getString("gender")
                ));
            }
        }
        return heroes;
    }

    public Optional<Hero> selectHero(int id) throws SQLException {
        String sql = "SELECT * FROM tm_hero WHERE id_hero = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Hero(
                        rs.getInt("id_hero"),
                        rs.getString("nama_hero"),
                        rs.getString("kategori"),
                        rs.getString("gender")
                ));
            }
        }
        return Optional.empty();
    }

    public void updateHero(Hero hero) throws SQLException {
        String sql = "UPDATE tm_hero SET nama_hero = ?, kategori = ?, gender = ? WHERE id_hero = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hero.getNamaHero());
            stmt.setString(2, hero.getKategori());
            stmt.setString(3, hero.getGender());
            stmt.setInt(4, hero.getIdHero());
            stmt.executeUpdate();
        }
    }

    public void deleteHero(int id) throws SQLException {
        String sql = "DELETE FROM tm_hero WHERE id_hero = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
