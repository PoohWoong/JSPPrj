package net.answeris.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.answeris.web.model.Notice;

public class JdbcNoticeDao implements NoticeDao{

	public List<Notice> getList(String field, String query, int page) {
		
		int pageSize=10;
		int start = (page-1)*pageSize +1;
		int end = pageSize*page;
		
		String sql="SELECT * FROM (SELECT ROWNUM NUM, NOTICE_VIEW.* FROM NOTICE_VIEW "
				+"WHERE "+field+" LIKE ? ) WHERE NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		
		List<Notice> list = new ArrayList<Notice>();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
			Statement st = con.createStatement();
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+query+"%");
			pst.setInt(2, start);
			pst.setInt(3, end);			
			
			ResultSet rs = pst.executeQuery();

			while (rs.next()) { // 서버에서 레코드 하나 가져옴
				Notice n = new Notice();

				n.setCode(rs.getString("CODE"));
				n.setTitle(rs.getString("TITLE"));
				n.setRegdate(rs.getDate("REGDATE"));
				n.setHit(rs.getInt("HIT"));
				n.setWriter(rs.getString("WRITER"));
				n.setContent(rs.getString("CONTENT"));
				n.setCmtCnt(rs.getInt("CMT_CNT"));
				n.setWriterName(rs.getString("WRITER_NAME"));

				list.add(n);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<Notice> getList(int page) {
		// TODO Auto-generated method stub
		return getList("TITLE", "", page);
	}
	
	public List<Notice> getList() {
		return getList("TITLE","",1);
	}

	public List<Notice> getLIst(String field, String query, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice get(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice getNext(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public Notice getPrev(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	public int add(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
