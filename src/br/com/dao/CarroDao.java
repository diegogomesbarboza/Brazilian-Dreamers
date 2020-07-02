package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bean.CarroBean;

public class CarroDao {
	
	public CarroBean getCarroPorId(int idCarro) throws SQLException {

		CarroBean carro = new CarroBean();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM carro WHERE id_carro=?");
		ps.setInt(1, idCarro);

		ResultSet rs = ps.executeQuery();

		if (rs.first()) {
			carro.setIdCarro(rs.getInt("id_carro"));
			carro.setFabricante(rs.getString("fabricante"));
			carro.setModelo(rs.getString("modelo"));
			carro.setAno(rs.getString("ano"));
			carro.setPotencia(rs.getString("potencia"));
			carro.setPeso(rs.getString("peso"));
			carro.setUppgrade_interno(rs.getString("uppgrade_interno"));
			carro.setEstetica_externo(rs.getString("estetica_externo"));
			carro.setImagem(rs.getString("imagem"));
		}

		return carro;
	}

	public List<CarroBean> getListaCarros() throws SQLException {

		List<CarroBean> lista = new ArrayList<CarroBean>();

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("SELECT * FROM carro");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			CarroBean carro = new CarroBean();
			carro.setIdCarro(rs.getInt("id_carro"));
			carro.setFabricante(rs.getString("fabricante"));
			carro.setModelo(rs.getString("modelo"));
			carro.setAno(rs.getString("ano"));
			carro.setPotencia(rs.getString("potencia"));
			carro.setPeso(rs.getString("peso"));
			carro.setUppgrade_interno(rs.getString("uppgrade_interno"));
			carro.setEstetica_externo(rs.getString("estetica_externo"));
			carro.setImagem(rs.getString("imagem"));
			lista.add(carro);
		}
		
		return lista;
	}


	public void insert(CarroBean carro) throws SQLException {

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection
				.prepareStatement("INSERT INTO carro SET fabricante=?, modelo=?, ano=?, potencia=?, peso=?, uppgrade_interno=?, estetica_externo=?, imagem=?");
		ps.setString(1, carro.getFabricante());
		ps.setString(2, carro.getModelo());
		ps.setString(3, carro.getAno());
		ps.setString(4, carro.getPotencia());
		ps.setString(5, carro.getPeso());
		ps.setString(6, carro.getUppgrade_interno());
		ps.setString(7, carro.getEstetica_externo());
		ps.setString(8, carro.getImagem());
		ps.execute();
	}

	public void update(CarroBean carro) throws SQLException {

		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement(
				"UPDATE carro SET fabricante=?, modelo=?, ano=?, potencia=?, peso=?, uppgrade_interno=?, estetica_externo=?, imagem=? WHERE id_carro=?");
		ps.setString(1, carro.getFabricante());
		ps.setString(2, carro.getModelo());
		ps.setString(3, carro.getAno());
		ps.setString(4, carro.getPotencia());
		ps.setString(5, carro.getPeso());
		ps.setString(6, carro.getUppgrade_interno());
		ps.setString(7, carro.getEstetica_externo());
		ps.setString(8, carro.getImagem());
		ps.setInt(9, carro.getIdCarro());

		ps.executeUpdate();
	}

	public void delete(int id) throws SQLException {
		Connection connection = new ConnectionFactory().getConection();
		PreparedStatement ps = connection.prepareStatement("DELETE FROM carro WHERE id_carro=?");
		ps.setInt(1, id);

		ps.execute();

	}
}
