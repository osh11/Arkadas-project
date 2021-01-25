package com.kh.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberNutrition;

public class MemberDao {
	private Properties prop=new Properties();
	
	public MemberDao() {
		String fileName=MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		Member loginUser = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("loginMember");
		
		//loginMember=SELECT * FROM MEMBER3 WHERE USERID=? AND PASSWORD=? AND STATUS='Y'
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser=new Member(rset.getInt("USERNO"),
									rset.getString("USERID"),
									rset.getString("PASSWORD"),
									rset.getString("USERNAME"),
									rset.getString("GENDER").charAt(0),
									rset.getDate("AGE"),
									rset.getString("EMAIL"),
									rset.getString("STATUS"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
		
	}

	public int insertMember(Connection conn, Member m) {
		int result=0;
		
		PreparedStatement pstmt = null;
		String sql=prop.getProperty("insertMember");
		
		//insertMember=INSERT INTO MEMBER3 VALUES(SEQ_UNO.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT)
				
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, Character.toString(m.getGender()));
			pstmt.setDate(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member mem = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql=prop.getProperty("selectMember");
		
		//selectMember=SELECT * FROM MEMBER3 WHERE USER_ID=? AND STATUS='Y'
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset=pstmt.executeQuery();
			if(rset.next()) {
				mem = new Member(rset.getInt("USERNO"),
						rset.getString("USERID"),
						rset.getString("PASSWORD"),
						rset.getString("USERNAME"),
						rset.getString("GENDER").charAt(0),
						rset.getDate("AGE"),
						rset.getString("EMAIL"),
						rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return mem;
		
	}

	public int updateMember(Connection conn, Member m) {
		int result=0;
		
		PreparedStatement pstmt=null;
		
		String sql=prop.getProperty("updateMember");
		// updateMember=UPDATE MEMBER4 SET USERNAME=?, GENDER=?, AGE=?, EMAIL=? WHERE USERID=?
		System.out.println(m.getUserName());
		System.out.println(Character.toString(m.getGender()));
		System.out.println(m.getAge());
		System.out.println(m.getEmail());
		System.out.println(m.getUserId());
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, Character.toString(m.getGender()));
			pstmt.setDate(3, m.getAge());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getUserId());
			
			result=pstmt.executeUpdate();
			System.out.println("update:"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int updatePwd(Connection conn, String userId, String userPwd, String newPwd) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updatePwd");
		 
		// updatePwd=UPDATE MEMBER3 SET PASSWORD=?, WHERE USERID=? AND PASSWORD=?
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newPwd);
			pstmt.setString(2,userId);
			pstmt.setString(3, userPwd);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
	public int deleteMember(Connection conn, String userId) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int idCheck(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		
		String sql=prop.getProperty("idCheck");
		
		//idCheck=SELECT COUNT(*) FROM MEMBER3 WHERE USERID=?
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}

	public int insertNutrition(Connection conn, ArrayList<MemberNutrition> memberNutrition) {
		int result=0;
		
		PreparedStatement pstmt = null;
		String sql=prop.getProperty("insertNutrition");
		
		//insertMember=INSERT INTO MEMBER3 VALUES(SEQ_UNO.NEXTVAL, ?, ?, ?, ?, ?, ?, DEFAULT)
		//insertNutrition=INSERT INTO NUTRITION VALUES(?,?)		
				
		try {
			pstmt = conn.prepareStatement(sql);
			
			for(MemberNutrition m : memberNutrition) {
				
				pstmt.setString(1, m.getUserId());
				pstmt.setString(2, m.getNutrition());
				
				result=pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;	
	}

	public int deleteNutrition(Connection conn, String userId) {
		int result=0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteNutrition");
		
		//deleteNutrition=UPDATE MEMBER3 SET STATUS='N' WHERE USERID=?
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<MemberNutrition> selectNutrition(Connection conn, String userId) {
		ArrayList<MemberNutrition> memberNutrition = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql=prop.getProperty("selectNutrition");
		
		//selectNutrition=SELECT MEMBER_NUTRITION FROM MEMBER_NUTRITION WHERE USERID=? AND STATUS='Y'
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset=pstmt.executeQuery();
			while(rset.next()) {
				memberNutrition.add(
						new MemberNutrition(
						userId,
						rset.getString("NUTRITION")
						));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return memberNutrition;
	}
}
