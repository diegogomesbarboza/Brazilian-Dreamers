package br.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bean.ProdutoBean;
import br.com.bo.ProdutoBO;
import br.com.bo.exception.BusinessException;
import br.com.bo.utils.TextUtils;

@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProdutoBO bo = new ProdutoBO();

	public servlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = (String) req.getParameter("acao");

		// Utilizando a ação para chamar o metodo no servidor
		if (acao == null) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);

		} else if (acao.equalsIgnoreCase("produtos")) {
			listarProdutos(req, resp);

		} else if (acao.equalsIgnoreCase("editar")) {
			String id_produto = (String) req.getParameter("id_produto");
			editarProduto(req, resp, id_produto);

		} else if (acao.equalsIgnoreCase("excluir")) {
			String id_produto = (String) req.getParameter("id_produto");
			excluirProduto(req, resp, id_produto);

		} else if (acao.equalsIgnoreCase("salvar")) {
			salvarProduto(req, resp);

		} else if (acao.equalsIgnoreCase("listar")) {
			listarProdutos(req, resp);

		} else if (acao.equalsIgnoreCase("listar_login")) {
			listarProdutosLogin(req, resp);

		} else {
			req.getRequestDispatcher("erro404.html").forward(req, resp);
		}

	}

	// Inserindo ou Atualizando produto com os dados vindo da JSP no banco de dados
	// Chamando a acão listar
	private void salvarProduto(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id_produto = (String) req.getParameter("id_produto");
		String nome_produto = (String) req.getParameter("nome_produto");
		String valor_produto = (String) req.getParameter("valor_produto");
		String imagem_produto = (String) req.getParameter("imagem_produto");

		ProdutoBean produto = new ProdutoBean();

		if (!TextUtils.isBlank(id_produto)) {
			produto.setId_produto(Integer.parseInt(id_produto));
		}

		produto.setNome_produto(nome_produto);
		produto.setValor_produto(Float.parseFloat(valor_produto));
		produto.setImagem_produto(imagem_produto);

		try {

			bo.salvarProduto(produto);

		} catch (BusinessException e) {
			req.setAttribute("mensagem", e.getMessage());
			req.setAttribute("produto", produto);
			req.getRequestDispatcher("/servlet?acao=listar_login").forward(req, resp);

		} catch (Exception e) {
			req.setAttribute("mensagem", "Valor incorreto!");
			req.setAttribute("produto", produto);

		}
		req.getRequestDispatcher("/servlet?acao=listar_login").forward(req, resp);
		listarProdutos(req, resp);
	}

	//Listagem de carros do banco de dados
	private void listarProdutos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<ProdutoBean> lista;

		try {
			lista = bo.getListaProdutos();

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("produtos.jsp").forward(req, resp);
	}

	//Listagem de carros do banco de dados para o usuario logado
	private void listarProdutosLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<ProdutoBean> lista;

		try {
			lista = bo.getListaProdutos();

		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("lista", lista);
		req.getRequestDispatcher("produtosLogin.jsp").forward(req, resp);
	}
	
	//Edita os produtos inseridos pelo o ID
	private void editarProduto(HttpServletRequest req, HttpServletResponse resp, String id_produto)
			throws ServletException, IOException {
		ProdutoBean produto = new ProdutoBean();

		try {
			if (id_produto != null) {
				produto = bo.getProdutosPorId(id_produto);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

		req.setAttribute("produto", produto);
		req.getRequestDispatcher("adicionarProduto.jsp").forward(req, resp);
	}

	//Excluir os produtos pelo o ID
	private void excluirProduto(HttpServletRequest req, HttpServletResponse resp, String id_produto)
			throws ServletException, IOException {
		try {
			if (id_produto != null) {
				bo.excluirProdutoPorId(id_produto);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		req.getRequestDispatcher("/servlet?acao=listar_login").forward(req, resp);
		listarProdutos(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
