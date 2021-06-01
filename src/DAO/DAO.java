package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import JDBC.JDBC;
import VO.KVO;

public class DAO {
	Connection conn =  null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	
	public ArrayList<KVO> K(){
		ArrayList<KVO> KO = null;
		
		try {
			
			conn = JDBC.getConnection();
			String sql = "select name, h, o, k from a order by k desc ";
			stmt = conn.prepareStatement(sql);
			rs=  stmt.executeQuery();
			
			KO = new ArrayList<KVO>();
			
			while(rs.next()) {
				KVO ko = new KVO();
				
				ko.setH(rs.getInt("h"));
				ko.setK(rs.getInt("k"));
				ko.setName(rs.getString("name"));
				ko.setO(rs.getInt("o"));
				
				KO.add(ko);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(rs, stmt, conn);
		}
		return KO;
	}
	
	public ArrayList<KVO> O(){
		ArrayList<KVO> KO = null;
		
		try {
			conn = JDBC.getConnection();
			String sql = "select name, h, o, k from a order by o desc ";
			stmt = conn.prepareStatement(sql);
			rs=  stmt.executeQuery();
			
			KO = new ArrayList<KVO>();
			
			while(rs.next()) {
				KVO ko = new KVO();
				
				ko.setH(rs.getInt("h"));
				ko.setK(rs.getInt("k"));
				ko.setName(rs.getString("name"));
				ko.setO(rs.getInt("o"));
				
				KO.add(ko);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(rs, stmt, conn);
		}
		return KO;
	}
	
	public ArrayList<KVO> H(){
		ArrayList<KVO> KO = null;
		
		try {
			conn = JDBC.getConnection();
			String sql = "select name, h, o, k from a order by h desc ";
			stmt = conn.prepareStatement(sql);
			rs=  stmt.executeQuery();
			
			KO = new ArrayList<KVO>();
			
			while(rs.next()) {
				KVO ko = new KVO();
				
				ko.setH(rs.getInt("h"));
				ko.setK(rs.getInt("k"));
				ko.setName(rs.getString("name"));
				ko.setO(rs.getInt("o"));
				
				KO.add(ko);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(rs, stmt, conn);
		}
		return KO;
	}

	public int add(KVO vo) {
		int cnt = 0;
		
		try {
			conn = JDBC.getConnection();
			String sql = "insert into a values(?,?,?,?) ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getName());
			stmt.setInt(2, vo.getH());
			stmt.setInt(3, vo.getO());
			stmt.setInt(4, vo.getK());
			
			cnt = stmt.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
			}
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBC.close(stmt, conn);
		}
		return cnt;
	}

	public KVO getM(String no) {
			KVO k = null;
		
		try {
			conn = JDBC.getConnection();
			String sql = "select * from a where name = ? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, no);
			
			rs = stmt.executeQuery();
			
			k = new KVO();
			
			if(rs.next()) {
				k.setName(rs.getString("name"));
				k.setH(rs.getInt("h"));
				k.setK(rs.getInt("k"));
				k.setO(rs.getInt("o"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBC.close(rs, stmt, conn);
		}
		return k;
	}

	public int update(KVO vo, String no) {
		int cnt = 0;
		
		try {
			conn = JDBC.getConnection();
			String sql  = "update a set name=?, h=?, k=?, o=? where name = ? ";
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, vo.getName());
			stmt.setInt(2, vo.getH());
			stmt.setInt(3, vo.getK());
			stmt.setInt(4, vo.getO());
			stmt.setString(5, no);
			
			cnt = stmt.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBC.close(stmt, conn);
		}
		return cnt;
	}

	public int getS(String no) {
		int cnt = 0;
		
		KVO k = null;
		
		try {
			conn = JDBC.getConnection();
			String sql = "select * from a where name = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, no);
			rs= stmt.executeQuery();
			
			k =new KVO();
			
			if(rs.next()) {
				k.setH(rs.getInt("h"));
				k.setK(rs.getInt("k"));
				k.setName(rs.getString("name"));
				k.setO(rs.getInt("o"));
			}
			
			cnt = stmt.executeUpdate();
			
			if(cnt > 0) {
				conn.commit();
			}
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			JDBC.close(rs, stmt, conn);
		}
		return cnt;
	}

}

