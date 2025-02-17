package day026.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
    private ArrayList<MemberDTO> selectAll(MemberDTO dto){
        return null;
    }
    public MemberDTO selectOne(MemberDTO dto){
        // 로그인
        return null;
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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "12345678");
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
