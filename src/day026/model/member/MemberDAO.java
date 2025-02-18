package day026.model.member;

import day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    final String SELECTONE = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PASSWORD=?";
    final String INSERT = "INSERT INTO MEMBER VALUES (?, ?, ?)";
    final String UPDATAE = "UPDATE MEMBER SET MEMBER_NAME = ? WHERE MEMBER_ID = ?";
    final String DELETE = "DELETE FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    private ArrayList<MemberDTO> selectAll(MemberDTO dto) {
        return null;
    }

    // 로그인
    public MemberDTO selectOne(MemberDTO dto) {
        MemberDTO data = null;

        try {
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(SELECTONE);
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_password());

            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new MemberDTO();
                data.setMember_id(rs.getString("MEMBER_ID"));
                data.setMember_password(rs.getString("MEMBER_PASSWORD"));
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return data;
        } finally {
            // 4. DB 연결 해제
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    // 회원가입
    public boolean insert(MemberDTO dto) {
        /*
         * 내 DB에 dto 값을 저장
         * 저장 잘되면 T
         * 저장 안되면 F
         * */
        // [ JDBC ], Java DataBase Connection
        try {
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(INSERT); // parsing
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_password());
            pstmt.setString(3, dto.getMember_name());
            int result = pstmt.executeUpdate();

            if (result <= 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 4. DB 연결 해제
            JDBCUtil.disconnect(conn, pstmt);
        }

    }

    // 이름변경
    public boolean update(MemberDTO dto) {

        try {
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();

            // 3. SQL 준비 및 실행
            pstmt = conn.prepareStatement(UPDATAE);
            System.out.println("[로그]" + dto);
            pstmt.setString(1, dto.getMember_name());     // 새로운 이름
            pstmt.setString(2, dto.getMember_id());       // 아이디

            int result = pstmt.executeUpdate();

            // 업데이트 성공 여부 반환
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 4. DB 연결 해제
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

    public boolean delete(MemberDTO dto) {

        try {
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();

            // 3. SQL 준비 및 실행
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_password());

            int result = pstmt.executeUpdate();

            // 삭제 성공 여부 반환
            return result > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // 4. DB 연결 해제
            JDBCUtil.disconnect(conn, pstmt);
        }
    }

}
