package exam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exam.dto.BoardVO;
import exam.dto.MemberVO;
import exam.util.DBManager;

public class BoardDAO {
	private static BoardDAO boardDao = new BoardDAO();
	
	private BoardDAO(){}
	
	public static BoardDAO getInstance(){
		return boardDao;
	}	
	
	// 글쓰기
	public int insertBoard(String id, String title, String content) throws SQLException {
		int result = 0;		
		
		String sql = "insert into board values("
				+ "board_seq.nextval, ?, ?, ?, default, null, default, default)";
		
		Connection con = null;		
		PreparedStatement pstmt = null;
		try{
			con = DBManager.getConnection();		
			pstmt = con.prepareStatement(sql);
	
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);		
	
			result = pstmt.executeUpdate();
			
		}finally{	// 정상 종료든지 비정상 종료든지 수행(throws로 예외처리를 넘겼지만 끝나면 이 부분이 수행됨)
			DBManager.close(con, pstmt);
		}
		return result;
	}
	
	// 글목록확인
	public List<BoardVO> selectAll() throws SQLException {
		List<BoardVO> list = new ArrayList();
		ResultSet rs = null;		
		
		String sql = "select num, m.id id, m.name name, title, content, write_date, file_name, read_count, down_count"
				+ " from board b, member m where m.id=b.id";
		
		Connection con = null;		
		PreparedStatement pstmt = null;
		try{
			con = DBManager.getConnection();		
			pstmt = con.prepareStatement(sql);
	
			rs = pstmt.executeQuery();
			while(rs.next()){
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("write_date");
				String fileName = rs.getString("file_name");
				int readCount = rs.getInt("read_count");
				int downCount = rs.getInt("down_count");
				
				BoardVO vo = new BoardVO(num, id, name, title, content, writeDate, fileName, readCount, downCount);
				list.add(vo);
			}
			
		}finally{	// 정상 종료든지 비정상 종료든지 수행(throws로 예외처리를 넘겼지만 끝나면 이 부분이 수행됨)
			DBManager.close(con, pstmt);
		}
		return list;
	}
	
	// 상세정보확인
	public BoardVO selectByNum(int selectNum) throws SQLException {
		BoardVO vo = null;
		ResultSet rs = null;		
		
		String sql = "select num, m.id id, m.name name, title, content, write_date, file_name, read_count, down_count"
				+ " from board b, member m where m.id=b.id and b.num=?";
		
		Connection con = null;		
		PreparedStatement pstmt = null;
		try{
			con = DBManager.getConnection();		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, selectNum);
	
			rs = pstmt.executeQuery();
			if(rs.next()){
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Date writeDate = rs.getDate("write_date");
				String fileName = rs.getString("file_name");
				int readCount = rs.getInt("read_count");
				int downCount = rs.getInt("down_count");
				
				vo = new BoardVO(num, id, name, title, content, writeDate, fileName, readCount, downCount);
			}
			
		}finally{	// 정상 종료든지 비정상 종료든지 수행(throws로 예외처리를 넘겼지만 끝나면 이 부분이 수행됨)
			DBManager.close(con, pstmt);
		}
		return vo;
	}
	
	// 조회수 증가
	public int updateByNum(int selectNum) throws SQLException {
		int result = 0;		
		
		String sql = "update board set read_count = read_count+1 where num = ?";
		
		Connection con = null;		
		PreparedStatement pstmt = null;
		try{
			con = DBManager.getConnection();		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, selectNum);
	
			result = pstmt.executeUpdate();			
			
		}finally{	// 정상 종료든지 비정상 종료든지 수행(throws로 예외처리를 넘겼지만 끝나면 이 부분이 수행됨)
			DBManager.close(con, pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
