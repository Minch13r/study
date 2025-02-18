package day026.model.member;

import day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    final String SELECTONE = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PASSWORD=?";

    final String INSERT = "INSERT INTO MEMBER VALUES(?,?,?)";
    final String UPDATE = "UPDATE MEMBER SET MEMBER_NAME=? WHERE MEMBER_ID=?";
    final String DELETE = "DELETE FROM MEMBER WHERE MEMBER_ID=?";

    private ArrayList<MemberDTO> selectAll(MemberDTO dto){
        return null;
    }
    public MemberDTO selectOne(MemberDTO dto){
        MemberDTO data = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(SELECTONE);
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_password());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                data=new MemberDTO();
                data.setMember_id(rs.getString("MEMBER_ID"));
                data.setMember_password(rs.getString("MEMBER_PASSWORD"));
                data.setMember_name(rs.getString("MEMBER_NAME"));
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        } finally {
            JDBCUtil.disconnect(conn, pstmt);
        }
    }
    public boolean insert(MemberDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_password());
            pstmt.setString(3, dto.getMember_name());
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
    public boolean update(MemberDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(UPDATE);
            pstmt.setString(1, dto.getMember_name());
            pstmt.setString(2, dto.getMember_id());
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
    public boolean delete(MemberDTO dto){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setString(1, dto.getMember_id());
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
