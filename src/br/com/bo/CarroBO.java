package br.com.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.bean.CarroBean;
import br.com.dao.CarroDao;

public class CarroBO {
	
	CarroDao dao = new CarroDao();
	
	//Buscar a lista de carros da DAO
	public List<CarroBean> getListaCarros() throws SQLException{
		return dao.getListaCarros();
	}
	
	//Buscar a lista de carros por meio do ID na DAO
	public CarroBean getCarroPorId(String id) throws SQLException {
		int idCarro = Integer.parseInt(id);
		
		return dao.getCarroPorId(idCarro);
	}

	//Inserir ou atualizar as lista de carros no banco de dados
	public void salvarCarro(CarroBean carro) throws SQLException {
		
		if(carro.getIdCarro()!= null) {
			dao.update(carro);
		}else {
			dao.insert(carro);
		}
	}

	//Excluir carro pelo o ID no banco de dados
	public void excluirCarroPorId(String idCarro) throws SQLException {
		dao.delete(Integer.parseInt(idCarro));
	}
	

}
