package br.com.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.bean.ProdutoBean;
import br.com.dao.ProdutoDao;

public class ProdutoBO {
	
	ProdutoDao dao = new ProdutoDao();
	
	//Buscar a lista de produtos da DAO
	public List<ProdutoBean> getListaProdutos() throws SQLException{
		return dao.getListaProdutos();
	}
	
	//Buscar a lista de produtos por meio do ID na DAO
	public ProdutoBean getProdutosPorId(String id) throws SQLException {
		int id_produto = Integer.parseInt(id);
		
		return dao.getProdutoPorId(id_produto);
	}

	//Inserir ou atualizar as lista de produtos no banco de dados
	public void salvarProduto(ProdutoBean produto) throws SQLException {
		if(produto.getId_produto()!= null) {
			dao.update(produto);
		}else {
			dao.insert(produto);
		}
	}

	//Excluir produtos pelo o ID no banco de dados
	public void excluirProdutoPorId(String id_produto) throws SQLException {
		dao.delete(Integer.parseInt(id_produto));
	}

}