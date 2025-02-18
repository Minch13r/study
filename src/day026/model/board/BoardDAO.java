package day026.model.board;

import day026.model.common.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;

// 목록출력
// 검색
public class BoardDAO {
    final String SELECTALL = "SELECT * FROM board";
    final String SELECTONE = "SELECT * FROM board WHERE num = ?";
    final String INSERT = "insert into board (title, content, writer) values (?, ?, ?)";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;


    public ArrayList<BoardDTO> selectAll(){
        ArrayList<BoardDTO> datas = new ArrayList<>();
        try {
            // 1. 드라이버 로드
            // 2. DB 연결
            conn = JDBCUtil.connect();
            pstmt = conn.prepareStatement(SELECTALL);
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
            // 4. DB 연결 해제
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
    public boolean update(BoardDAO dto){
        // 내용변경
        return false;
    }
    public boolean delete(BoardDAO dto){
        // 삭제
        return false;
    }
}
