package com.kh.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberNutrition;

import static com.kh.common.JDBCTemplate.*;

public class MemberService {
	
	public Member loginMember(String userId, String userPwd) {
		Connection conn=getConnection();
		
		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		return loginUser;
	}

	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result=new MemberDao().insertMember(conn,m);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Member selectMember(String userId) {
		Connection conn = getConnection();
		
		Member mem=new MemberDao().selectMember(conn, userId);
		
		close(conn);
		return mem;
	}

	public Member updateMember(Member m) {
		Connection conn = getConnection();
		Member updateMem = null;
		
		int result = new MemberDao().updateMember(conn,m);
		
		System.out.println("result:"+result);
		if(result>0) {
			commit(conn);
			updateMem=new MemberDao().selectMember(conn, m.getUserId());
		}else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}
	public Member updatePwd(String userId, String userPwd, String newPwd) {
		Connection conn = getConnection();
		Member updateMem = null;
		
		int result = new MemberDao().updatePwd(conn,userId,userPwd,newPwd);
		
		if(result>0) {
			commit(conn);
			updateMem=new MemberDao().selectMember(conn,userId);
		}else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}

	public int deleteMember(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn,userId);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int result=new MemberDao().idCheck(conn,userId);
		System.out.println(result);
		
		close(conn);
		return result;
	}

	public void insertNutrition(ArrayList<MemberNutrition> memberNutrition) {
		Connection conn = getConnection();
		
		int result=new MemberDao().insertNutrition(conn, memberNutrition);
		
		close(conn);
		
	}

	public void deleteNutrition(String userId) {
		Connection conn = getConnection();
		
		int result=new MemberDao().deleteNutrition(conn, userId);
		
		close(conn);
	}

	public ArrayList<MemberNutrition> selectNutrition(String userId) {
		Connection conn = getConnection();
		
		ArrayList<MemberNutrition> memberNutrition=new MemberDao().selectNutrition(conn, userId);
		
		close(conn);
		return memberNutrition;
	}
	
}
