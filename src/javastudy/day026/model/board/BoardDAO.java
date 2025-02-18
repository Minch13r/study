package javastudy.day026.model.board;

import javastudy.day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

// 목록출력
// 검색
public class BoardDAO {
    final String SELECTALL = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD";

    final String SELECTALL_SEARCH_TITLE = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD WHERE TITLE LIKE CONCAT('%',?,'%')";
    final String SELECTALL_SEARCH_WRITER = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD WHERE WRITER=?";

    //final String SELECTONE = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD WHERE NUM=?";
    final String SELECTONE = "SELECT BOARD.NUM,BOARD.TITLE,BOARD.CONTENT,BOARD.WRITER,MEMBER.MEMBER_NAME AS NAME,BOARD.CNT,BOARD.REGDATE FROM BOARD LEFT JOIN MEMBER ON BOARD.WRITER=MEMBER.MEMBER_ID WHERE BOARD.NUM=?";

    final String INSERT = "INSERT INTO BOARD (TITLE,CONTENT,WRITER) VALUES(?,?,?)";
    final String UPDATE = "UPDATE BOARD SET CONTENT=? WHERE NUM=?";
    final String UPDATE_DELETEMEMBER = "UPDATE BOARD SET WRITER='' WHERE WRITER=?";
    final String DELETE = "DELETE FROM BOARD WHERE NUM=?";
    final String UPDATE_CNT = "UPDATE BOARD SET CNT=CNT+1 WHERE NUM=?";


    public ArrayList<BoardDTO> selectAll(BoardDTO dto){
        ArrayList<BoardDTO> datas=new ArrayList<BoardDTO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            if(dto.getCondition().equals("SELECTALL")) {
                pstmt = conn.prepareStatement(SELECTALL);
            }
            else if(dto.getCondition().equals("SEARCH_TITLE")) {
                pstmt = conn.prepareStatement(SELECTALL_SEARCH_TITLE);
                pstmt.setString(1, dto.getSearchKeyword());
            }
            else if(dto.getCondition().equals("SEARCH_WRITER")) {
                pstmt = conn.prepareStatement(SELECTALL_SEARCH_WRITER);
                pstmt.setString(1, dto.getSearchKeyword());
            }
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                BoardDTO data = new BoardDTO();
                data.setNum(rs.getInt("NUM"));
                data.setTitle(rs.getString("TITLE"));
                data.setContent(rs.getString("CONTENT"));
                data.setWriter(rs.getString("WRITER"));
                data.setCnt(rs.getInt("CNT"));
                data.setRegdate(rs.getDate("REGDATE"));
                datas.add(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return datas;
    }
    public BoardDTO selectOne(BoardDTO dto){
        BoardDTO data = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 데이터 read, write
            pstmt = conn.prepareStatement(SELECTONE);
            pstmt.setInt(1, dto.getNum());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                data = new BoardDTO();
                data.setNum(rs.getInt("NUM"));
                data.setTitle(rs.getString("TITLE"));
                data.setContent(rs.getString("CONTENT"));
                data.setWriter(rs.getString("WRITER"));
                data.setName(rs.getString("NAME"));
                data.setCnt(rs.getInt("CNT"));
                data.setRegdate(rs.getDate("REGDATE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return data;
    }
    public boolean insert(BoardDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 데이터 read, write
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setString(3, dto.getWriter());
            int result = pstmt.executeUpdate();
            if(result <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }
    public boolean update(BoardDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();

            // 조회수 증가
            pstmt = conn.prepareStatement(UPDATE_CNT);
            pstmt.setInt(1, dto.getNum());
            pstmt.executeUpdate();

            if(dto.getCondition().equals("UPDATE")) {
                pstmt = conn.prepareStatement(UPDATE);
                pstmt.setString(1, dto.getContent());
                pstmt.setInt(2, dto.getNum());
            }
            else if(dto.getCondition().equals("UPDATE_DELETEMEMBER")) {
                pstmt = conn.prepareStatement(UPDATE_DELETEMEMBER);
                pstmt.setString(1, dto.getWriter());
            }
            int result = pstmt.executeUpdate();
            if(result <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }
    public boolean delete(BoardDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 데이터 read, write
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, dto.getNum());
            int result = pstmt.executeUpdate();
            if(result <= 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }
}

