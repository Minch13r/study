package java.day026.model.board;

import java.day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

// 목록출력
// 검색
public class BoardDAO {
    final String SELECTALL = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD";

    final String SELECTALL_SEARCH_TITLE = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD WHERE TITLE LIKE CONCAT('%',?,'%')";
    final String SELECTALL_SEARCH_WRITER = "SELECT NUM,TITLE,CONTENT,WRITER,CNT,REGDATE FROM BOARD WHERE WRITER=?";

    final String SELECTONE = "SELECT b.NUM,b.TITLE,b.CONTENT,m.member_name as WRITER, b.CNT,b.REGDATE FROM BOARD b inner join member m on m.member_id = b.writer WHERE NUM=?";

    final String INSERT = "INSERT INTO BOARD (TITLE,CONTENT,WRITER) VALUES(?,?,?)";
    final String UPDATE = "UPDATE BOARD SET CONTENT=? WHERE NUM=?";
    final String UPDATECANCLE = "UPDATE BOARD SET member_name=? WHERE NUM=?";
    final String DELETE = "DELETE FROM BOARD WHERE NUM=?";

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
                pstmt.setString(1, dto.getTitle());
            }
            else if(dto.getCondition().equals("SEARCH_WRITER")) {
                pstmt = conn.prepareStatement(SELECTALL_SEARCH_WRITER);
                pstmt.setString(1, dto.getWriter());
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
            if(dto.getCondition().equals("UPDATE")) {
                pstmt = conn.prepareStatement(UPDATE);
                pstmt.setString(1, dto.getContent());
                pstmt.setInt(2, dto.getNum());
            }
            else if(dto.getCondition().equals("UPDATECANCLE")){
                pstmt = conn.prepareStatement(UPDATECANCLE);
                pstmt.setString(1, dto.getWriter());
                pstmt.setInt(2, dto.getNum());
            }
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                pstmt.setString(1, dto.getContent());
                pstmt.setInt(2, dto.getNum());
                pstmt.setString(3, dto.getWriter());

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
        return true;
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
