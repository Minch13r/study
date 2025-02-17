package day026.model;

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
        return false;
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
