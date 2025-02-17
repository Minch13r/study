package day026.model;

import java.sql.*;
import java.util.ArrayList;

// 목록출력
// 검색
public class BoardDAO {
    final String driverName = "com.mysql.cj.jdbc.Driver";
    final String url = "jdbc:mysql://localhost:3306/test";
    final String userName = "root";
    final String password = "12345678";

    private ArrayList<BoardDAO> selectAll(BoardDAO dto){
        final String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
        ArrayList<BoardDTO> datas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. 드라이버 로드
            Class.forName(driverName);

            // 2. DB 연결
            conn = DriverManager.getConnection(url, userName, password);
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
            // 5. 리소스 해제
            try {
                if(rs != null) rs.close();
                if(pstmt != null) pstmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public BoardDAO selectOne(BoardDAO dto){
        // 선택
        return null;
    }
    public boolean insert(BoardDAO dto){
        // 작성
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
