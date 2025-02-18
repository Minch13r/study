package day026.model.board;

import day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

// 목록출력
// 검색
public class BoardDAO {
    final String SELECTALL = "SELECT * FROM board";
    final String SELECTONE = "SELECT * FROM board WHERE num = ?";
    final String SELECT_TITLE = "SELECT * FROM board WHERE title LIKE ?";
    final String SELECT_WRITER = "SELECT * FROM board WHERE WRITER = ?";
    final String INSERT = "insert into board (title, content, writer) values (?, ?, ?)";
    final String UPDATE = "update board set content = ? where num = ?";
    final String DELETE = "delete from board where num = ?";

    // 공유자원
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public ArrayList<BoardDTO> selectAll(BoardDTO dto) {
        ArrayList<BoardDTO> datas = new ArrayList<BoardDTO>();

        try {
            conn = JDBCUtil.connect();

            if (dto.getCondition().equals("SELECTALL")) {
                pstmt = conn.prepareStatement(SELECTALL);
            }
            else if (dto.getCondition().equals("SEARCH_TITLE")) {
                pstmt = conn.prepareStatement(SELECTONE);
                pstmt.setString(1, dto.getTitle());
            }
            else if (dto.getCondition().equals("SEARCH_WRITER")) {
                pstmt = conn.prepareStatement(SELECTONE);
                pstmt.setString(1, dto.getWriter());
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardDTO data = new BoardDTO();
                data.setNum(rs.getInt("num"));
                data.setTitle(rs.getString("title"));
                data.setContent(rs.getString("content"));
                data.setWriter(rs.getString("writer"));
                data.setCnt(rs.getInt("CNT"));
                data.setRegdate(rs.getDate("regdate"));
                datas.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return datas;
    }

    // 선택
    public BoardDTO selectOne(BoardDTO dto) {  // 반환 타입을 BoardDTO로 변경
        BoardDTO data = null;  // 단일 게시글 정보를 저장할 변수
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(SELECTONE);
            pstmt.setInt(1, dto.getNum());  // 게시글 번호로 검색
            rs = pstmt.executeQuery();

            if (rs.next()) {  // while이 아닌 if 사용 (단일 결과)
                data = new BoardDTO();
                data.setNum(rs.getInt("NUM"));
                data.setTitle(rs.getString("TITLE"));
                data.setContent(rs.getString("CONTENT"));
                data.setWriter(rs.getString("WRITER"));
                data.setCnt(rs.getInt("CNT"));
                data.setRegdate(rs.getTimestamp("REGDATE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return data;
    }

    // 작성
    public boolean insert(BoardDTO dto){
        try{
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(INSERT);
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
    public boolean update(BoardDTO dto){
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, dto.getContent());
            pstmt.setInt(2, dto.getNum());
            int result = pstmt.executeUpdate();
            if(result <= 0){
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return false;
    }
    public boolean delete(BoardDTO dto){
        try {
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, dto.getNum());
            int result = pstmt.executeUpdate();
            if(result <= 0){
                return false;
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return false;
    }
}
