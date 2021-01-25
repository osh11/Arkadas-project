package com.kh.nutrient.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.nutrient.model.dao.NutrientBoardDao;
import com.kh.nutrient.model.vo.Attachment;
import com.kh.nutrient.model.vo.Board;
import com.kh.nutrient.model.vo.nutrientBoard;

public class nutrientBoardService {

	public ArrayList<Board> selectNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThList(conn);
		close(conn);
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		// TODO Auto-generated method stub
				Connection conn = getConnection();
				NutrientBoardDao nbdao = new NutrientBoardDao();
				int result1 = nbdao.insertThBoard(conn,b);
				int result2 = nbdao.insertAttachment(conn, fileList);
				if(result1>0) {
					commit(conn);
				}else {
					rollback(conn);
				}
						
				return result1 * result2;
	}

	public nutrientBoard selectBoard(int bno) {
		Connection conn = getConnection();
		
		int result = new NutrientBoardDao().increaseCount(conn,bno);
		
		nutrientBoard nb = null;
		if(result>0) {
			commit(conn);
			nb = new NutrientBoardDao().selectBoard(conn,bno);
		}else {
			rollback(conn);
		}
		
		close(conn);
		return nb;
	}

	public ArrayList<Attachment> nutrientselectThumbnail(int bid) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new NutrientBoardDao().selectThumbnail(conn,bid);
		close(conn);
		return list;
	}



	public ArrayList<Board> selectDiNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectDiThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectSkNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectSkThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectEyNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectEyThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectBrNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectBrThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectLiNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectLiThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectBoNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectBoThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectToNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectToThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectImNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectImThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectHaNuList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectHaThList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectDiLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectDiThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectDiHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectDiThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectSkLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectSkThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectSkHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectSkThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectEyLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectEyThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectEyHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectEyThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectBrHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectBrThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectBrLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectBrThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectLiLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectLiThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectLiHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectLiThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectBoHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectBoThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectBoLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectBoThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectToLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectToThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectToHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectToThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectImLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectImThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectImHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectImThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectHaHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectHaThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectHaLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectHaThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuHighPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectNuThHighPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuLowPrice() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectNuThLowPrice(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuDiTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThDiTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuSkTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThSkTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuEyTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThEyTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuBrTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThBrTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuLiTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThLiTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuBoTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThBoTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuToTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThToTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuImTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThImTopList(conn);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectNuHaTopList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new NutrientBoardDao().selectThHaTopList(conn);
		close(conn);
		return list;
	}

	public int searchBoard(Board b) {
		Connection conn = getConnection();
		int result = new NutrientBoardDao().searchBoard(conn, b);
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Board selectDetailBoard(int bno) {
		// TODO Auto-generated method stub
				Connection conn = getConnection();
				
				int result = new NutrientBoardDao().increaseCount(conn,bno);
				
				Board b = null;
				if(result>0) {
					commit(conn);
					b = new NutrientBoardDao().selectDetailBoard(conn,bno);
				}else {
					rollback(conn);
				}
				
				close(conn);
				return b;
				
				
	}

	public ArrayList<Attachment> selectDetailThumbnail(int bid) {
		// TODO Auto-generated method stub
				Connection conn = getConnection();
				ArrayList<Attachment> list = new NutrientBoardDao().selectDetailThumbnail(conn,bid);
				close(conn);
				return list;
				
	}



	public ArrayList<Board> searchBoard(String search) {
		// TODO Auto-generated method stub
				Connection conn = getConnection();
				ArrayList<Board> list = new NutrientBoardDao().selectRlist(conn,search);
				close(conn);
				return list;
	}

	public int deleteBoard(int bid) {
		Connection conn = getConnection();
		
		int result1 = new NutrientBoardDao().deleteBoard(conn, bid);
		int result2 = new NutrientBoardDao().deleteAttachment(conn, bid);
		
		if(result1 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1;
	}
	
}
