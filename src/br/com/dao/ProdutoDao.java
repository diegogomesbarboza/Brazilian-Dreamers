package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.ProdutoBean;

public class ProdutoDao {
	
	public ProdutoBean getProdutoPorId(int idProduto) throws SQLException {

		ProdutoBean produto = new ProdutoBean();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM produto WHERE id_produto=?");
		ps.setInt(1, idProduto);

		ResultSet rs = ps.executeQuery();

		if (rs.first()) {
			produto.setId_produto(rs.getInt("id_produto"));
			produto.setNome_produto(rs.getString("nome_produto"));
			produto.setValor_produto(rs.getFloat("valor_produto"));
			produto.setImagem_produto(rs.getString("imagem_produto"));
		}

		return produto;

	}

	public List<ProdutoBean> getListaProdutos() throws SQLException {

		List<ProdutoBean> lista = new ArrayList<ProdutoBean>();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM produto");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			ProdutoBean produto = new ProdutoBean();
			produto.setId_produto(rs.getInt("id_produto"));
			produto.setNome_produto(rs.getString("nome_produto"));
			produto.setValor_produto(rs.getFloat("valor_produto"));
			produto.setImagem_produto(rs.getString("imagem_produto"));
			lista.add(produto);
		}
		return lista;
	}

	public void insert(ProdutoBean produto) throws SQLException {

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection
				.prepareStatement("INSERT INTO produto SET nome_produto=?, valor_produto=?, imagem_produto=?;");
		ps.setString(1, produto.getNome_produto());
		ps.setDouble(2, produto.getValor_produto());
		ps.setString(3, produto.getImagem_produto());
		ps.execute();
	}

	public void update(ProdutoBean produto) throws SQLException {

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement(
				"UPDATE produto SET nome_produto=?, valor_produto=?, imagem_produto=? WHERE id_produto=?;");
		ps.setString(1, produto.getNome_produto());
		ps.setFloat(2, produto.getValor_produto());
		ps.setString(3, produto.getImagem_produto());
		ps.setInt(4, produto.getId_produto());

		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM produto WHERE id_produto=?;");
		ps.setInt(1, id);

		ps.execute();

	}
}
