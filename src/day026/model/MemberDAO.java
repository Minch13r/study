package day026.model;

import com.mysql.cj.xdevapi.Result;

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private ArrayList<MemberDTO> selectAll(MemberDTO dto) {
        return null;
    }

    // 로그인
    public MemberDTO selectOne(MemberDTO dto) {
        MemberDTO data = null;
        final String driverName = "com.mysql.cj.jdbc.Driver";
        final String url = "jdbc:mysql://localhost:3306/test";
        final String userName = "root";
        final String password = "12345678";
        final String sql = "select * from member where member_id = ? and member_password = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1. 드라이버 로드
            Class.forName(driverName);
            // 2. DB 연결
            conn = DriverManager.getConnection(url, userName, password);
            // 3. 데이터 read, write
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getMember_id());
            pstmt.setString(2, dto.getMember_password());
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                MemberDTO memberDTO = new MemberDTO();
                data.setMember_id(rs.getString("MEMBER_ID"));
                data.setMember_password(rs.getString("MEMBER_PASSWORD"));
                data.setMember_name(rs.getString("MEMBER_NAME"));
            }
            else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
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
        return data;
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
    public boolean update(MemberDTO dto){
        // 이름변경
        return false;
    }
    public boolean delete(MemberDTO dto){
        // 회원탈퇴
        return false;
    }
}
