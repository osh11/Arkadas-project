package com.kh.nutrient.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.kh.nutrient.model.vo.Attachment;
import com.kh.nutrient.model.vo.Board;
import com.kh.nutrient.model.vo.nutrientBoard;

public class NutrientBoardDao {
	private Properties prop = new Properties();
	//생성자
	public NutrientBoardDao() {
		String fileName = NutrientBoardDao.class.getResource("/sql/nutrientBoard/board-query.properties").getPath();
		
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

	public ArrayList<Board> selectThList(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertThBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertThBoard");
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getsCategory());
			pstmt.setString(2, b.getsCode());
			pstmt.setString(3, b.getsName());
			pstmt.setString(4, b.getsBrand());
			pstmt.setString(5, b.getsBno());
			pstmt.setString(6, b.getsSize());
			pstmt.setString(7, b.getsTerm());
			pstmt.setInt(8, b.getsPrice());
			pstmt.setString(9, b.getsUrl());
			pstmt.setString(10, b.getsContent1());
			pstmt.setString(11, b.getsContent2());
			pstmt.setString(12, b.getsContent3());
			pstmt.setString(13, b.getGuide1());
			pstmt.setString(14, b.getGuide2());
			pstmt.setString(15, b.getGuide3());
			pstmt.setString(16, b.getEfContentMain1());
			pstmt.setString(17, b.getEfContentSub1());
			pstmt.setString(18, b.getEfContentMain2());
			pstmt.setString(19, b.getEfContentSub2());
			pstmt.setString(20, b.getEfContentMain3());
			pstmt.setString(21, b.getEfContentSub3());
			pstmt.setString(22, b.getsEle1());
			pstmt.setString(23, b.getsEleSize1());
			pstmt.setString(24, b.getsEleContent1());
			pstmt.setString(25, b.getsEle2());
			pstmt.setString(26, b.getsEleSize2());
			pstmt.setString(27, b.getsEleContent2());
	
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		int result = 0;	
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			for(int i=0;i<fileList.size();i++) {
				Attachment at = fileList.get(i);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String sql = prop.getProperty("selectAttachment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rset = pstmt.executeQuery();
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				
				list.add(at);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}	

		return list;
	}

	public nutrientBoard selectBoard(Connection conn, int bno) {
		// TODO Auto-generated method stub
				nutrientBoard nb = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectBoard");
				try {
					
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, bno);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						nb = new nutrientBoard(rset.getInt("BOARD_NO"),
											rset.getString("CATEGORY_NAME")
											,rset.getString("BOARD_TITLE")
											,rset.getNString("BOARD_CONTENT")
											,rset.getString("USER_ID")
											,rset.getInt("COUNT")
											,rset.getDate("CREATE_DATE")
								);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					close(rset);
					close(pstmt);
				}
				
				return nb;
	}

	public int increaseCount(Connection conn, int bno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		
		//increaseCount=UPDATE SBOARD SET COUNT=COUNT+1 WHERE BOARD_NO=?
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,bno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



	public ArrayList<Board> selectDiThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDiThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectSkThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSkThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectEyThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEyThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectBrThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBrThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectLiThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLiThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectBoThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectImThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectImThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectToThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectToThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectHaThList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHaThList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectDiThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDiThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectDiThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectDiThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectSkThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSkThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectSkThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSkThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectEyThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEyThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectEyThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEyThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectBrThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBrThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectBrThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBrThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectLiThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLiThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectLiThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLiThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectBoThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectBoThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectToThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectToThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectToThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectToThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectImThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectImThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectImThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectImThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectHaThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHaThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectHaThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectHaThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectNuThHighPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNuThHighPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectNuThLowPrice(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNuThLowPrice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThDiTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThDiTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThSkTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThSkTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThEyTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThEyTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThBrTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThBrTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThLiTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThLiTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThBoTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThBoTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThToTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThToTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThImTopList(Connection conn) {
ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThImTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Board> selectThHaTopList(Connection conn) {
		ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectThHaTopList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*			
					SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
					FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
					WHERE FILE_NO IN( \
					SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
					WHERE BOARD.STATUS='Y' AND FILE_LEVEL=2 ORDER BY BOARD_NO DESC
			*/
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int searchBoard(Connection conn, Board b) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectThSearchList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, b.getSearch());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		} 
		
		return result;
	}

	public Board selectDetailBoard(Connection conn, int bno) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectBoard");
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				b = new Board(rset.getInt("BOARD_NO"),
						rset.getString("SUPPLEMENTS_CATEGORY"),
						rset.getString("SUPPLEMENTS_CODE"),
						rset.getString("SUPPLEMENTS_NAME"),
						rset.getString("SUPPLEMENTS_BRAND"),
						rset.getString("SUPPLEMENTS_BRANDNO"),
						rset.getString("SUPPLEMENTS_SIZE"),
						rset.getString("SUPPLEMENTS_TERM"),
						rset.getInt("SUPPLEMENTS_PRICE"),
						rset.getString("SUPPLEMENTS_URL"),
						
						rset.getString("SUPPLEMENTS_CONTENT1"),
						rset.getString("SUPPLEMENTS_CONTENT2"),
						rset.getString("SUPPLEMENTS_CONTENT3"),
						rset.getString("SUPPLEMENTS_GUIDE1"),
						rset.getString("SUPPLEMENTS_GUIDE2"),
						rset.getString("SUPPLEMENTS_GUIDE3"),
						rset.getString("SUPPLEMENTS_EFCONTENTMAIN1"),
						rset.getString("SUPPLEMENTS_EFCONTENTSUB1"),
						rset.getString("SUPPLEMENTS_EFCONTENTMAIN2"),
						rset.getString("SUPPLEMENTS_EFCONTENTSUB2"),
						rset.getString("SUPPLEMENTS_EFCONTENTMAIN3"),
						rset.getString("SUPPLEMENTS_EFCONTENTSUB3"),
						rset.getString("SUPPLEMENTS_ELEMENT1"),
						rset.getString("SUPPLEMENTS_ELEMENTSIZE1"),
						rset.getString("SUPPLEMENTS_ELEMENTCONTENT1"),
						rset.getString("SUPPLEMENTS_ELEMENT2"),
						rset.getString("SUPPLEMENTS_ELEMENTSIZE2"),
						rset.getString("SUPPLEMENTS_ELEMENTCONTENT2"),
						rset.getInt("COUNT")
					
									
						);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return b;
	}

	public ArrayList<Attachment> selectDetailThumbnail(Connection conn, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String sql = prop.getProperty("selectAttachment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rset = pstmt.executeQuery();
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				
				list.add(at);
			}
			
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}	

		return list;
	}

	public ArrayList<Board> selectRlist(Connection conn, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = prop.getProperty("selectThSearchList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setsName(rset.getString("SUPPLEMENTS_NAME"));
				b.setsPrice(rset.getInt("SUPPLEMENTS_PRICE"));
				b.setCount(rset.getInt("COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int deleteBoard(Connection conn, int bid) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteBoard");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bid);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteAttachment(Connection conn, int bid) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteAttachment");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, bid);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	

	
}
