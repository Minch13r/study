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
    }

    public MemberDTO selectOne(MemberDTO dto) {
        // 입력값 검증
        if (dto == null || dto.getId() == null || dto.getPw() == null) {
            return null;
        }

        for (MemberDTO member : datas) {
            // 로그인 검사
            if (dto.getId().equals(member.getId()) && dto.getPw().equals(member.getPw())) {
                MemberDTO result = new MemberDTO();
                result.setId(member.getId());
                result.setPw(member.getPw());
                result.setIsPremium(member.getIsPremium()); // 즐겨찾기 목록도 복사
                return result;
            }
        }
        return null; // 일치하는 회원이 없는 경우
    }

    // id, pw 만드는 것
    public boolean insert(MemberDTO dto) {
        try {
            // 중복 ID 체크
            for (MemberDTO member : datas) {
                if (member.getId().equals(dto.getId())) {
                    System.out.println("이미 존재하는 아이디입니다.");
                    return false;
                }
            }

            MemberDTO data = new MemberDTO();
            data.setId(dto.getId());
            data.setPw(dto.getPw());
            data.setIsPremium(new ArrayList<>()); // 즐겨찾기 목록 초기화
            this.datas.add(data);

            System.out.println("MemberDTO insert()에서 true값을 반환.입력한 아이디와 비밀번호를 사용자 리스트에 저장");
            return true;
        }
        catch(Exception e) {
            System.out.println("회원가입 중 오류가 발생했습니다: " + e.getMessage());
            return false;
        }
    }

    // 즐겨찾기 배열에 영화 추가
    public boolean update(String id, MovieDTO dto) {
        for (MemberDTO memberDTO : datas) {
            if (memberDTO.getId().equals(id)) {
                // 즐겨찾기 목록이 null인 경우 초기화
                if (memberDTO.getIsPremium() == null) {
                    memberDTO.setIsPremium(new ArrayList<>());
                }

                // 이미 즐겨찾기에 있는지 확인
                for (MovieDTO movie : memberDTO.getIsPremium()) {
                    if (movie.getMovieId() == dto.getMovieId()) {
                        System.out.println("이미 즐겨찾기에 존재하는 영화입니다.");
                        return false;
                    }
                }

                // 즐겨찾기에 추가
                memberDTO.getIsPremium().add(dto);
                System.out.println("즐겨찾기에 영화가 추가되었습니다.");
                return true;
            }
        }
        System.out.println("사용자를 찾을 수 없습니다.");
        return false;
    }

    // 즐겨찾기에서 영화 삭제
    public boolean delete(MemberDTO memberDto, MovieDTO movieDto) {
        // 관리자가 영화를 삭제하는 경우 (memberDto가 null일 때)
        if (memberDto == null) {
            boolean removed = false;
            for (MemberDTO member : datas) {
                ArrayList<MovieDTO> favorites = member.getIsPremium();
                if (favorites != null) {
                    for (int i = favorites.size() - 1; i >= 0; i--) {
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
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

}
