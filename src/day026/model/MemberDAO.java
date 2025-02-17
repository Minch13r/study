package day026.model;

import com.mysql.cj.xdevapi.Result;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private ArrayList<MemberDTO> selectAll(MemberDTO dto) {
        return null;
    }

    // 로그인
    public MemberDTO selectOne(MemberDTO dto){
        MemberDTO data = null;
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/test";
        final String userName = "root";
        final String password = "12345678";
        final String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PASSWORD=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. 드라이버 로드
            Class.forName(driverName);
            // 2. DB 연결
            conn = DriverManager.getConnection(url,userName,password);
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(sql);
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
            // 4. DB 연결 해제
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 회원가입
    public boolean insert(MemberDTO dto){
        /*
        * 내 DB에 dto 값을 저장
        * 저장 잘되면 T
        * 저장 안되면 F
        * */
        // [ JDBC ], Java DataBase Connection
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // 1. 드라이버 로드(메모리에 데이터 적재)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. DB 연결
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "12345678");
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement("INSERT INTO MEMBER VALUES (?, ?, ?)"); // parsing
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
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    // 이름변경
    public boolean update(MemberDTO dto) {
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/test";
        final String userName = "root";
        final String password = "12345678";
        final String sql = "UPDATE MEMBER SET MEMBER_NAME = ? WHERE MEMBER_ID = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. 드라이버 로드
            Class.forName(driverName);

            // 2. DB 연결
            conn = DriverManager.getConnection(url, userName, password);

            // 3. SQL 준비 및 실행
            pstmt = conn.prepareStatement(sql);
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
            // 4. 리소스 해제
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean delete(MemberDTO dto){
        // 회원탈퇴
        return false;
    }
}
