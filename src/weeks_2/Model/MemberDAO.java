package weeks_2.Model;

import java.util.ArrayList;

public class MemberDAO {
    ArrayList<MemberDTO> datas; // 사용자 데이터 객체
    ArrayList<MovieDTO> isPremium; // 즐겨찾기 목록객체

    public MemberDAO() {
        this.datas = new ArrayList<>();
        this.isPremium = new ArrayList<>();
    }


    private ArrayList<MemberDTO> selectAll(MemberDTO dto) {
        return new ArrayList<>(datas); // 전체 회원 목록 반환
        //아직 개발이 안되었지만 외부에서 불러올수있기때문에 메서드를 만들어놓고 private으로 가려놓기
    }



    public MemberDTO selectOne(MemberDTO dto) {
        // 입력값 검증
        if (dto == null || dto.getId() == null || dto.getPw() == null) {
            return null;
        }
        if (datas.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return null;
        }
        for (MemberDTO member : datas) {
            // 로그인 검사
            if (dto.getId().equals(member.getId()) && dto.getPw().equals(member.getPw())) {
                //사용자 배열에 아이디,비번과 입력값 아이디,비번이 같은지 확인
                MemberDTO result = new MemberDTO();
                result.setId(member.getId());
                result.setPw(member.getPw());
                result.setIsPremium(member.getIsPremium());
                //새로운 객체 생성 후
                //아이디,비밀번호,즐겨찾기 목록 복사
                return result;
                //복사값 반환
            }
        }
        System.out.println("로그 : 일치하는 회원이 없습니다");//유효성 검사
        return null;
    }
 /*객체를 새로 생성하여 데이터를 복사하고 복사한 값을 반환한 이유
 	1.데이터값을 그대로 반환하면 반환된 객체가 수정되면 원본데이터가 변경됨
 	2.로그아웃후 데이터가 남아있을수있음
 */



    // id, pw 만드는 것
    public boolean insert(MemberDTO dto) {
        try {
            // 중복 ID 체크
            for (MemberDTO member : datas) {
                if (member.getId().equals(dto.getId())) {
                    //기존 아이디 배열과 입력한 아이디 비교
                    System.out.println("로그 : 이미 존재하는 아이디입니다.");
                    return false;//유효성 검사
                }
            }
            MemberDTO data = new MemberDTO();
            data.setId(dto.getId());
            data.setPw(dto.getPw());
            data.setIsPremium(new ArrayList<>());
            this.datas.add(data);
            //새로운 data 객체 생성후
            //입력한 아이디와 비밀번호를 새로 생성한 data에 저장
            //새로운 회원이므로 즐겨찾기 빈 리스트로 초기화
            //새로운 객체(회원) 기존 회원들 데이터스에 추가
            System.out.println("로그 : MemberDTO insert()에서 true값을 반환.입력한 아이디와 비밀번호를 사용자 리스트에 저장");
            return true;
        }
        catch(Exception e) {
            System.out.println("로그 : 회원가입 중 오류가 발생했습니다: " + e.getMessage());
            return false;//유효성 검사
        }
    }



    // 즐겨찾기 배열에 영화 추가
    public boolean update(String id, MovieDTO dto) {//회원 아이디와 영화 DTO 인자받아오기
        for (MemberDTO memberDTO : this.datas) {
            //데이터를 돌면서 모든 회원들 정보 확인
            if (memberDTO.getId().equals(id)) {//입력아이디와 기존아이디가 일치할때
                if (memberDTO.getIsPremium() == null) {//유효성 검사 : 즐겨찾기 목록이 null인 경우 초기화
                    memberDTO.setIsPremium(new ArrayList<>());
                }
                // 이미 즐겨찾기에 있는지 확인
                for (MovieDTO movie : memberDTO.getIsPremium()) {
                    //즐겨찾기 목록을 돌면서 모든 영화확인
                    if (movie.getMovieId() == dto.getMovieId()) {
                        System.out.println("로그 : 이미 즐겨찾기에 존재하는 영화입니다.");
                        return false;//유효성 검사
                    }
                }

                // 즐겨찾기에 추가
                memberDTO.getIsPremium().add(dto);//기존 사용자의 즐겨찾기에 추가
                System.out.println("로그 : 즐겨찾기에 영화가 추가되었습니다.");
                return true;
            }
        }
        System.out.println("로그 : 사용자를 찾을 수 없습니다.");
        return false;//유효성 검사
    }



    // 즐겨찾기에서 영화 삭제
    public boolean delete(MemberDTO memberDto, MovieDTO movieDto) {//사용자정보와 영화 정보인자로 받아오기
        if (datas.isEmpty()) {
            System.out.println("로그 :등록된 회원이 없습니다.");
            return false;
        }
        if (memberDto == null) {
            //만약 사용자가 없다면
            //관리자가 영화를 삭제하는 경우 (memberDto가 null일 때)
            boolean removed = false;
            //removed 변수를 만들고 false 저장
            for (MemberDTO member : datas) {
                ArrayList<MovieDTO> favorites = member.getIsPremium();
                if (favorites != null) {
                    for (int i = favorites.size() - 1; i >= 0; i--) {
                        //for문으로 배열을 돌때 배열의 값을 삭제할시 끝값부터 검사하며 삭제해야함
                        if (favorites.get(i).getMovieId() == movieDto.getMovieId()) {
                            favorites.remove(i);
                            removed = true;
                        }
                    }
                }
            }
            return removed;
        }
        // 일반 사용자가 자신의 즐겨찾기에서 삭제하는 경우
        else {
            for (MemberDTO member : datas) {
                if (member.getId().equals(memberDto.getId())) {
                    ArrayList<MovieDTO> favorites = member.getIsPremium();
                    if (favorites != null) {
                        for (int i = 0; i < favorites.size(); i++) {
                            if (favorites.get(i).getMovieId() == movieDto.getMovieId()) {
                                favorites.remove(i);
                                System.out.println("로그 : 즐겨찾기에서 삭제됨");
                                return true;
                            }
                        }
                    }
                }
            }
            System.out.println("로그 : 해당영화가 존재하지않음");
            return false;
        }
    }
}
/* 관리자와 사용자의 즐겨찾기 목록의 삭제가 다른이유
 * (관리자만 removed변수를 만들고 false를 저장하여 반환하는 이유)
 *
 * 사용자는 자신의 배열만없애면 되지만
 * 관리자는 모든 즐겨찾기 목록을 확인하기때문
 */