package br.com.bo;

import java.sql.SQLException;

import br.com.bean.UserBean;
import br.com.dao.UserDao;

public class UserBo {

	//Conferindo se o login está correto com o Banco de dados
	public Boolean isLogado(String login, String password) throws SQLException {
		UserDao dao = new UserDao();
		UserBean pessoa = dao.getPessoa(login);
		
		//Verificando se o login está vazio
		if(pessoa.getLogin() == null) {
			return false;
		}
		
		return (pessoa.getPassword().equalsIgnoreCase(password));
	}
}
