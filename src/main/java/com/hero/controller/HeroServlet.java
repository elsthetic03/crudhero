package com.hero.controller;

import com.hero.dao.HeroDAO;
import com.hero.model.Hero;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class HeroServlet extends HttpServlet {
    private HeroDAO heroDAO;

    public void init() {
        heroDAO = new HeroDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new" -> showNewForm(request, response);
                case "/insert" -> insertHero(request, response);
                case "/delete" -> deleteHero(request, response);
                case "/edit" -> showEditForm(request, response);
                case "/update" -> updateHero(request, response);
                default -> listHero(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listHero(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Hero> listHero = heroDAO.selectAllHeroes();
        request.setAttribute("listHero", listHero);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hero-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("hero-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Hero existingHero = heroDAO.selectHero(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Hero ID: " + id));
        request.setAttribute("hero", existingHero);
        RequestDispatcher dispatcher = request.getRequestDispatcher("hero-form.jsp");
        dispatcher.forward(request, response);
    }

    private void insertHero(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Hero newHero = new Hero(
                request.getParameter("nama_hero"),
                request.getParameter("kategori"),
                request.getParameter("gender")
        );
        heroDAO.insertHero(newHero);
        response.sendRedirect("list");
    }

    private void updateHero(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Hero hero = new Hero(
                id,
                request.getParameter("nama_hero"),
                request.getParameter("kategori"),
                request.getParameter("gender")
        );
        heroDAO.updateHero(hero);
        response.sendRedirect("list");
    }

    private void deleteHero(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        heroDAO.deleteHero(id);
        response.sendRedirect("list");
    }
}