package br.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.CarroBean;
import br.com.bo.CarroBO;
import br.com.bo.utils.TextUtils;

@WebServlet("/CarroServlet")
public class CarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CarroBO bo = new CarroBO();

	public CarroServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = (String) req.getParameter("acao");
		
		//Utilizando a ação para chamar o metodo no servidor
		if (acao == null) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);

		} else if (acao.equalsIgnoreCase("listar")) {
			listarCarros(req, resp);

		} else if (acao.equalsIgnoreCase("listar_login")) {
			listarCarrosLogin(req, resp);

		} else if (acao.equalsIgnoreCase("excluir")) {
			String idCarro = (String) req.getParameter("id_carro");
			excluirCarro(req, resp, idCarro);

		} else if (acao.equalsIgnoreCase("editar")) {
			String idCarro = (String) req.getParameter("id_carro");
			editarRedirecionar(req, resp, idCarro);

		} else if (acao.equalsIgnoreCase("salvar")) {
			salvarCarro(req, resp);

		} else if (acao.equalsIgnoreCase("cancelar")) {
			listarCarros(req, resp);

		} else {
			req.getRequestDispatcher("erro404.html").forward(req, resp);
		}

	}

	//Inserindo ou Atualizando carro com os dados vindo da JSP no banco de dados
	//Chamando a acão listar
	private void salvarCarro(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idCarro = (String) req.getParameter("id_carro");
		String fabricante = (String) req.getParameter("fabricante");
		String modelo = (String) req.getParameter("modelo");
		String ano = (String) req.getParameter("ano");
		String potencia = req.getParameter("potencia");
		String peso = (String) req.getParameter("peso");
		String uppgrade_interno = (String) req.getParameter("uppgrade_interno");
		String estetica_externo = (String) req.getParameter("estetica_externo");
		String imagem = (String) req.getParameter("imagem");

		CarroBean carro = new CarroBean();

		if (!TextUtils.isBlank(idCarro)) {
			carro.setIdCarro(Integer.parseInt(idCarro));
		}

		carro.setFabricante(fabricante);
		carro.setModelo(modelo);
		carro.setAno(ano);
		carro.setPotencia(potencia);
		carro.setPeso(peso);
		carro.setUppgrade_interno(uppgrade_interno);
		carro.setEstetica_externo(estetica_externo);
		carro.setImagem(imagem);

		try {

			bo.salvarCarro(carro);

		} catch (Exception e) {
			req.setAttribute("mensagem", e.getMessage());
			req.setAttribute("carro", carro);
		}

		req.getRequestDispatcher("/CarroServlet?acao=listar_login").forward(req, resp);
		listarCarros(req, resp);
	}
	
	//Edita os carros inseridos pelo o ID
	private void editarRedirecionar(HttpServletRequest req, HttpServletResponse resp, String idCarro) throws ServletException, IOException {
		
		CarroBean carro = new CarroBean();
		
		try {
			
			carro = bo.getCarroPorId(idCarro);

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("carro", carro);
		req.getRequestDispatcher("adicionarCarro.jsp").forward(req, resp);

	}

	//Listagem de carros do banco de dados
	private void listarCarros(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CarroBean> lista;
		System.out.println("alou to aqui listar");
		try {
			lista = bo.getListaCarros();

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("sobreEquipe.jsp").forward(req, resp);

	}
	
	//Listagem de carros do banco de dados para o usuario logado
	private void listarCarrosLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CarroBean> lista;
		System.out.println("alou to aqui listar");
		try {
			lista = bo.getListaCarros();

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("sobreEquipeLogin.jsp").forward(req, resp);

	}

	//Excluir carros do banco de dados pelo o ID
	private void excluirCarro(HttpServletRequest req, HttpServletResponse resp, String idCarro)
			throws ServletException, IOException {
		try {
			if (idCarro != null) {
				bo.excluirCarroPorId(idCarro);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		req.getRequestDispatcher("/CarroServlet?acao=listar_login").forward(req, resp);
		listarCarros(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
