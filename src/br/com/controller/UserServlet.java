package br.com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bo.UserBo;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UserServlet() {
    	
    }
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		
		String acao = (String) req.getParameter("acao");
		
		if (acao == null) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);

		} else if (acao.equalsIgnoreCase("logar")) {
			logar(req, resp);

		}
	}
	
	private void logar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = (String) req.getParameter("login");
		String password = (String) req.getParameter("password");
		
		UserBo bo = new UserBo();
		
		try {
			if(bo.isLogado(login, password)) {
				req.getRequestDispatcher("homeLogin.jsp").forward(req, resp);
			}else {
				req.setAttribute("mensagem", "Usuário ou senha incorreta.");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
