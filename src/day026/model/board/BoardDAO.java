package day026.model.board;

import day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

// 목록출력
// 검색
public class BoardDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private ArrayList<BoardDTO> selectAll(BoardDTO dto){
        final String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
        ArrayList<BoardDTO> datas = new ArrayList<>();
        try {
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardDTO boardDTO = new BoardDTO();
                // BoardDTO의 실제 필드에 맞게 데이터 설정
                boardDTO.setNum(rs.getInt("NUM"));
                boardDTO.setTitle(rs.getString("TITLE"));
                boardDTO.setContent(rs.getString("CONTENT"));
                boardDTO.setWriter(rs.getString("WRITER"));
                boardDTO.setCnt(rs.getInt("CNT"));
                boardDTO.setRegdate(rs.getTimestamp("REGDATE"));
                datas.add(boardDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. DB 연결 해제
            JDBCUtil.disconnect(conn, pstmt);
        }
        return null;
    }
    // 선택
    public BoardDAO selectOne(BoardDTO dto){
        return null;
    }
    // 작성
    public boolean insert(BoardDTO dto){
        final String sql = "insert into board (title, content, writer) values (?, ?, ?)";
        try{
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getWriter());
            int result = pstmt.executeUpdate();
            if(result <= 0){
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 4. DB 연결 해제
            JDBCUtil.disconnect(conn, pstmt);
        }


        return false;
    }
    public boolean update(BoardDAO dto){
        // 내용변경
        return false;
    }
    public boolean delete(BoardDAO dto){
        // 삭제
        return false;
    }
}
