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
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    private ArrayList<BoardDTO> selectAll(BoardDTO dto){
        final String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
        ArrayList<BoardDTO> datas = new ArrayList<>();
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
    // 선택
    public BoardDAO selectOne(BoardDTO dto){
        return null;
    }
    // 작성
    public boolean insert(BoardDTO dto){
        final String sql = "insert into board (title, content, writer) values (?, ?, ?)";
        try{
            // 1. 드라이버 연결
            Class.forName(driverName);
            // 2. conn 연결
            conn = DriverManager.getConnection(url, userName, password);
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
            try {
                // 4. conn 연결 해제
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
