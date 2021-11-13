package model;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import DAO.connectMySql;

public class getAllContent {
	public List<beanContent> getContent() throws NamingException, SQLException{
		connectMySql conn = new connectMySql();
		int id = 3;
		String sort = "Title", sortType = "asc";

		List<beanContent> listContent = conn.viewContentWithId(id, sort, sortType);
		return listContent;
	}
}
