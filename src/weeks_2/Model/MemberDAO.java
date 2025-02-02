package weeks_2.Model;

import java.util.ArrayList;

public class MemberDAO {
    ArrayList<MemberDTO> datas;//사용자 데이터 객체
    ArrayList<MovieDTO> isPremium;//즐겨찾기 목록객체
    public MemberDAO(){
        this.datas=new ArrayList<>();
        this.isPremium=new ArrayList<>();
    }



    private ArrayList<MemberDTO> selectAll(MemberDTO dto) {
        return null;
    }
    //메서드를 미리 만들어놓고 추후에 개발되었을때 사용할수있도록 private으로 가려놓기




    public MemberDTO selectOne(MemberDTO dto) {
        MemberDTO data=null;
        if(dto.getSearchCondition().equals("LOGIN")) {
            for(int i=0;i<this.datas.size();i++) {
                if(dto.getId().equals(this.datas.get(i).getId()) && dto.getPw().equals(this.datas.get(i).getPw())) { // mid,mpw 둘다 같다면
                    data=new MemberDTO();
                    data.setId(dto.getId());
                    data.setPw(dto.getPw());
                    break;
                }
            }
        }
        else if(dto.getSearchCondition().equals("CHECK")) {
            for(int i=0;i<this.datas.size();i++) {
                if(dto.getId().equals(this.datas.get(i).getId())) {
                    data=new MemberDTO();
                    break;
                }
            }
        }
        return data;
    }

    // id, pw 만드는 것
    public boolean insert(MemberDTO dto) {
        try {
            MemberDTO data=new MemberDTO();//새로운 멤버DTO를 생성한것을 멤버DTO배열에 넣을 준비
            data.setId(dto.getId());//dto의 멤버 아이디와 비밀번호 받아와서 데이터에 저장
            data.setPw(dto.getPw());
            this.datas.add(data);//위에서 받은 데이터를 배열에 추가
        }
        catch(Exception e) {
            return false;
        }
        System.out.println("MemberDTO insert()에서 true값을 반환.입력한 아이디와 비밀번호를 사용자 리스트에 저장");
        return true;
    }

    // 즐겨찾기 배열에 영화 추가
    // 각자의 속성으로 갖는 즐겨찾기 배열
    private boolean update(String id, MovieDTO dto) {
        for(MemberDTO memberDTO : datas){
            if(memberDTO.getId().equals(id)){
                for(int i=0; i<memberDTO.getIsPremium().size();i++) {
                    // 즐겨찾기에 추가할 내용이 있는지 없는지 확인하고
                    if(memberDTO.getIsPremium().get(i).getMovieId() == dto.getMovieId()){
                        memberDTO.getIsPremium().set(i, dto);
                        // 있으면 false 반환
                        return false;
                    }
                    memberDTO.getIsPremium().add(dto);

                }
            }
        }
        // 없으면 true 반환
        return true;
    }

    // 즐겨찾기에 있는배열중 원하는 영화 번호 입력후 삭제
    private boolean delete(MovieDTO dto) {
        for(int i=0;i<this.isPremium.size();i++) {
            if(this.isPremium.get(i).getMovieId()==dto.getMovieId()) {
                this.isPremium.remove(i);
                System.out.println("로그 : MemberDAO delete()에서 발생한 true반환.즐겨찾기 리스트에 입력영화 제거");
                return true;
            }
        }
        System.out.println("로그 : MemberDAO delete()에서 발생한 false반환.해당 영화는 즐겨찾기에 없습니다");
        return false;
    }
}
