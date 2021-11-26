package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Account;
import model.beanContent;

public class connectMySql {

	static String url = "jdbc:mysql://localhost:3306/cms";
	static String user = "root";
	static String password = "nam123";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(url, user, password);
			System.out.print("connect Suscessfully");
		} catch (ClassNotFoundException e) {
			System.out.print("connect failed!");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public boolean role(int id) throws SQLException {
		String query = "select Role from Member where id = ?";
		boolean role = false;
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				role = rs.getBoolean("Role");
			}
		} catch (Exception e) {

			System.out.print("role failed !");
		}
		return role;
	}

	public List<beanContent> viewContentWithId(int id, String sort, String sortType, int page) {
		String query = "";
		boolean rl = false;
		try {
			rl = role(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		switch (sort) {
			case "Title":
				if (sortType.equals("asc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where Draft = false order by Title limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where Draft = false and AuthorId = ? order by Title limit ? , 10";
					}
				} else if (sortType.equals("desc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where Draft = false order by Title desc limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where Draft = false and AuthorId = ? order by Title desc limit ? , 10";
					}
				}
				break;
			case "Brief":
				if (sortType.equals("asc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where Draft = false order by Brief limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where Draft = false and AuthorId = ? order by Brief limit ? , 10";
					}
				} else if (sortType.equals("desc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where Draft = false order by Brief desc limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where Draft = false and AuthorId = ? order by Brief desc limit ? , 10";
					}
				}
				break;
			case "CreateDate":
				if (sortType.equals("asc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where Draft = false order by CreateDate limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where Draft = false and AuthorId = ?  order by CreateDate limit ? , 10";
					}
				} else if (sortType.equals("desc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where Draft = false order by CreateDate desc limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where Draft = false and AuthorId = ? order by CreateDate desc limit ? , 10";
					}
				}
			default:

		}
		List<beanContent> listContent = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			if (rl == false) {
				pstmt.setInt(1, id);
				pstmt.setInt(2, page);
			}
			else {
				pstmt.setInt(1, page);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int getId = rs.getInt("id");
				String getTitle = rs.getString("Title");
				String getBrief = rs.getString("Brief");
				String getCreatedate = rs.getString("CreateDate");
				listContent.add(new beanContent(getId, getTitle, getBrief, getCreatedate));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listContent;
	}
	
	public List<beanContent> Search(String txtsearch, int id, String sort, String sortType, int page) {
		String query = "";
		boolean rl = false;
		try {
			rl = role(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
			
		switch (sort) {
			case "Title":
				if (sortType.equals("asc")) {
					if (rl) {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false  order by Title limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false and AuthorId = ? order by Title limit ? , 10";
					}
				} else if (sortType.equals("desc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false order by Title desc limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false and AuthorId = ? order by Title desc limit ? , 10";
					}
				}
				break;
			case "Brief":
				if (sortType.equals("asc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false order by Brief limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false and AuthorId = ? order by Brief limit ? , 10";
					}
				} else if (sortType.equals("desc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false order by Brief desc limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false and AuthorId = ? order by Brief desc limit ? , 10";
					}
				}
				break;
			case "CreateDate":
				if (sortType.equals("asc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false order by CreateDate limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false and AuthorId = ?  order by CreateDate limit ? , 10";
					} 
				} else if (sortType.equals("desc")) {
					if (rl) {
						query = "select  id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false order by CreateDate desc limit ? , 10";
					} else {
						query = "select id, Title, Brief, CreateDate from Content where (id like ? or Title like ? or Brief like ? or Content like ?) and Draft = false and AuthorId = ? order by CreateDate desc limit ? , 10";
					}
				}
			default:

		}	
		
		List<beanContent> listContent = new ArrayList<>();
		Connection conn = getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			if (rl) {
				pstmt.setInt(5, page);
			}
			else {
				pstmt.setInt(5, id);
				pstmt.setInt(6, page);
			}
			pstmt.setString(1, "%" + txtsearch + "%");
			pstmt.setString(2, "%" + txtsearch + "%");
			pstmt.setString(3, "%" + txtsearch + "%");
			pstmt.setString(4, "%" + txtsearch + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				listContent.add(new beanContent(rs.getInt("id"), rs.getString("Title"), rs.getString("Brief"),
						rs.getString("CreateDate")));
			}

		} catch (Exception e) {

			System.out.print("search fails !");
		}
		return listContent;
	}

	private static final String INSERT_CONTENT_SQL = "INSERT INTO content (title, brief, content, AuthorId) VALUES (?, ?, ?, ?);";
	public void insertContent(beanContent bCt) throws SQLException {
      
        // try-with-resource statement will auto close the connection.
        try (Connection conn = getConnection(); 
            PreparedStatement pstmt = conn.prepareStatement(INSERT_CONTENT_SQL);) {
            pstmt.setString(1, bCt.getTitle());
            pstmt.setString(2, bCt.getBrief());
            pstmt.setString(3, bCt.getContent());
            pstmt.setInt(4, bCt.getAuthorid());
       
            pstmt.executeUpdate();
        } catch (SQLException e) {
        	System.out.print("add content that bai");
        }
    }
	

	public boolean deleteContent(int id) throws SQLException {
		boolean deleteContent = false;
		String query = "delete from Content where id = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			deleteContent = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.print("failed to delete!");
		}
		return deleteContent;
	}

	public boolean checkDraft(int id) throws SQLException {
		String query = "select Draft from Content where id = ?";
		boolean dr = false;
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				dr = rs.getBoolean("Draft");
			}
		} catch (Exception e) {

			System.out.print("role failed !");
		}
		return dr;
	}

	public boolean trashOrRestore(int id, boolean draft) throws SQLException {
		boolean moveToTrash = false;
		String query = "update Content set Draft = ? where id = ?";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setBoolean(1, draft);
			pstmt.setInt(2, id);
			moveToTrash = pstmt.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.print("trash Or Restore failed !");
		}
		return moveToTrash;
	}

	public beanContent editContent(int id) throws SQLException {
		String query = "select id, Title, Brief, Content from Content where id = ?";
		LocalDateTime today = LocalDateTime.now();
		beanContent bCt = new beanContent();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int getId = rs.getInt("id");
				String getTitle = rs.getString("Title");
				String getBrief = rs.getString("Brief");
				String getContent = rs.getString("Content");
				bCt = new beanContent(getId, getTitle, getBrief, getContent, today.toString());
			}
			// editContent =pstmt.executeUpdate(); > 0;
		} catch (Exception e) {
			System.out.print("failed to edit!");
		}
		return bCt;
	}

	public void updateContent(beanContent bCt) throws SQLException {
		// boolean updateContent = false;

		String query = "update Content set Title = ?, Brief = ?, Content = ?, UpdateTime= ? where id = ?	";
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			pstmt.setString(1, bCt.getTitle());
			pstmt.setString(2, bCt.getBrief());
			pstmt.setString(3, bCt.getContent());
			pstmt.setString(4, bCt.getUpdatetime());
			pstmt.setInt(5, bCt.getId());
			pstmt.executeUpdate();
			// updateContent = > 0;
		} catch (Exception e) {
			System.out.print("failed to edit!");
		}
		// return updateContent;
	}

	public List<beanContent> trashBinContentWithId(int id, String sort, String sortType) {
		String query = "";
		boolean rl = false;
		try {
			rl = role(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		switch (sort) {
		case "Title":
			if (sortType.equals("asc")) {
				if (rl) {
					query = "select  id, Title, Brief, CreateDate from Content where Draft = true order by Title";
				} else {
					query = "select id, Title, Brief, CreateDate from Content where Draft = true and AuthorId = ? order by Title";
				}
			} else if (sortType.equals("desc")) {
				if (rl) {
					query = "select  id, Title, Brief, CreateDate from Content where Draft = true order by Title desc";
				} else {
					query = "select id, Title, Brief, CreateDate from Content where Draft = true and AuthorId = ? order by Title desc";
				}
			}
			break;
		case "Brief":
			if (sortType.equals("asc")) {
				if (rl) {
					query = "select  id, Title, Brief, CreateDate from Content where Draft = true order by Brief";
				} else {
					query = "select id, Title, Brief, CreateDate from Content where Draft = true and AuthorId = ? order by Brief";
				}
			} else if (sortType.equals("desc")) {
				if (rl) {
					query = "select  id, Title, Brief, CreateDate from Content where Draft = true order by Brief desc";
				} else {
					query = "select id, Title, Brief, CreateDate from Content where Draft = true and AuthorId = ? order by Brief desc";
				}
			}
			break;
		case "CreateDate":
			if (sortType.equals("asc")) {
				if (rl) {
					query = "select  id, Title, Brief, CreateDate from Content where Draft = true order by CreateDate";
				} else {
					query = "select id, Title, Brief, CreateDate from Content where Draft = true and AuthorId = ?  order by CreateDate";
				}
			} else if (sortType.equals("desc")) {
				if (rl) {
					query = "select  id, Title, Brief, CreateDate from Content where Draft = true order by CreateDate desc";
				} else {
					query = "select id, Title, Brief, CreateDate from Content where Draft = true and AuthorId = ? order by CreateDate desc";
				}
			}
		default:

		}
		List<beanContent> listContent = new ArrayList<>();
		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
			if (rl == false) {
				pstmt.setInt(1, id);
			}
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int getId = rs.getInt("id");
				String getTitle = rs.getString("Title");
				String getBrief = rs.getString("Brief");
				String getCreatedate = rs.getString("CreateDate");
				listContent.add(new beanContent(getId, getTitle, getBrief, getCreatedate));
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listContent;
	}

	public boolean checkLogin(String email, String password) {
		String query = "select Email,Password from Member where Email='" + email + "'";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				if (email.equals(rs.getString("Email")) && password.equals(rs.getString("Password")))
					return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * public boolean checkRegister(String email, String username){ String query =
	 * "SELECT COUNT(*) from account where Username=" + username + "or Email=" +
	 * email + ""; try { Connection conn = getConnection(); Statement stmt =
	 * conn.createStatement(); ResultSet rs = stmt.executeQuery(query); int n = 2;
	 * if ( rs.next() ) { n = rs.getInt("COUNT");
	 * 
	 * } if ( n > 0 ) { return true; } } catch (Exception e) { e.printStackTrace();
	 * } return false; }
	 */
	public void insertUser(Account acc) {
		String query = "insert into Member(Username, Email, Password) values (?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, acc.getUsername());
			pstmt.setString(2, acc.getEmail());
			pstmt.setString(3, acc.getPassword());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.print("insert failed");
		}
	}
	
	
	public int getTotal(int id, boolean draft, boolean search, String txtsearch ) {
		boolean rl = false;
		String query = "";
		try {
			rl = role(id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(search) {
		
			if (rl) {
				query = "select count(*) from Content where Draft = ? and (id like ? or Title like ? or Brief like ? or Content like ?)";
			} else {
				query = "select count(*) from Content where Draft = ? and (id like ? or Title like ? or Brief like ? or Content like ?) and AuthorId = ?";
			}
		} else {
			if(rl) {
				query = "select count(*) from Content where Draft = ?";
			} else {
				query = "select count(*) from Content where Draft = ? and AuthorId = ?";
			}
		}
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(query);) {
        	if(search) {
        		if(!rl) {
            		pstmt.setInt(6, id);	
            	}    
        		pstmt.setBoolean(1, draft);
	        	pstmt.setString(2, "%" + txtsearch + "%");
				pstmt.setString(3, "%" + txtsearch + "%");
				pstmt.setString(4, "%" + txtsearch + "%");
				pstmt.setString(5, "%" + txtsearch + "%");           
        	} else {
        		if(!rl) {
            		pstmt.setInt(2, id);	
            	} 
        		pstmt.setBoolean(1, draft);
        	}
        	
        	ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

            System.out.print("get total failed !");
        }
        return 0;
    }
	
	

}
