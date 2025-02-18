package java.weeks_2.Model;

import java.util.ArrayList;

public class MovieDAO {
    private ArrayList<MovieDTO> datas;
    private int NUM;	//영화 추가할 때 넣을 영화 번호

    public MovieDAO() {
        this.datas=new ArrayList<>();
        this.NUM=1;
    }

    public ArrayList<MovieDTO> selectAll(MovieDTO dto){
        try {
            if(dto==null) {	//입력받은 dto가 null이면
                System.out.println("[로그]입력된 데이터가 null 입니다");
                return null;
            }
            else if(dto.getCondition()==null) {	//condition이 null이면
                System.out.println("[로그]condition이 null 입니다");
                return null;
            }

            if(dto.getCondition().equals("CRAWLING")) {	//크롤링 할 때
                ArrayList<MovieDTO> datas=Crawling.makeDatas();	//크롤링해서 반환한 데이터 저장
                for(int i=0;i<this.datas.size();i++) {
                    this.datas.add(datas.get(i));
                }
                return datas;
            }
            else if(dto.getCondition().equals("PRINTALL")) {	//전체출력 할 때
                ArrayList<MovieDTO> datas=new ArrayList<>();
                for(int i=0;i<this.datas.size();i++) {
                    MovieDTO data=new MovieDTO();
                    data.setMovieId(this.datas.get(i).getMovieId());
                    data.setTitle(this.datas.get(i).getTitle());
                    data.setRating(this.datas.get(i).getRating());
                    data.setViewCount(this.datas.get(i).getViewCount());
                    datas.add(data);
                }
                return datas;
            }
            else if(dto.getCondition().equals("SEARCH")) {	//영화 검색
                ArrayList<MovieDTO> datas=new ArrayList<>();
                for(int i=0;i<this.datas.size();i++) {
                    MovieDTO data=new MovieDTO();
                    if(this.datas.get(i).getTitle().contains(dto.getTitle())) {
                        data.setMovieId(this.datas.get(i).getMovieId());
                        data.setTitle(this.datas.get(i).getTitle());
                        data.setViewCount(this.datas.get(i).getViewCount());
                        data.setRating(this.datas.get(i).getRating());
                        datas.add(data);
                    }
                }
                return datas;
            }
            else {
                System.out.println("[로그]condition이 잘못 입력되었습니다");
            }
        }catch(Exception e) {
            System.out.println("[로그]selectAll에서 오류 발생"+e.getMessage());
            return null;
        }
        //		return new ArrayList<>();
        return null;
    }
    public MovieDTO selectOne(MovieDTO dto) {	//영화 하나 출력할 때
        try {
            if(dto==null) {	//dto가 null이면
                System.out.println("[로그]입력된 데이터가 null 입니다");
                return null;
            }

            for(int i=0;i<datas.size();i++) {
                if(datas.get(i).getMovieId() == dto.getMovieId()) {
                    MovieDTO data=null;
                    data=new MovieDTO();
                    data.setMovieId(datas.get(i).getMovieId());
                    data.setTitle(datas.get(i).getTitle());
                    data.setRating(datas.get(i).getRating());
                    data.setViewCount(datas.get(i).getViewCount());
                    return data;
                }
            }
        }catch(Exception e) {
            System.out.println("[로그]selectOne에서 오류 발생"+e.getMessage());
            return null;
        }
        return null;
    }
    public boolean insert(MovieDTO dto) {	//영화 추가
        try {
            if(dto==null) {	//dto가 null이면
                System.out.println("[로그]입력된 데이터가 null 입니다");
                return false;
            }
            else if(dto.getTitle()==null) {	//입력받은 제목이 null이면
                System.out.println("영화 제목은 필수입니다");
                return false;
            }
            else if(dto.getRating()<0 || 100<dto.getRating()) {	//입력받은 평점이 0~100 아니면
                System.out.println("영화 평점은 0~100 사이여야 합니다");
                return false;
            }
            MovieDTO data=new MovieDTO();
            data.setMovieId(NUM++);	//추가할 때 영화 번호 1씩 증가
            data.setTitle(dto.getTitle());
            data.setRating(dto.getRating());
            data.setViewCount(0);	//처음 시청수는 0
            this.datas.add(data);
        }catch(Exception e) {
            System.out.println("insert에서 오류 발생"+e.getMessage());
            return false;
        }
        return true;
    }
    public boolean update(MovieDTO dto) {	//영화 시청할 때 update 메서드로 시청수 +1
        try {
            if(dto==null) {	//인자로 받은 dto가 null
                System.out.println("입력된 데이터가 null 입니다");
                return false;
            }
            else if(dto.getMovieId()<=0) {//입력받은 숫자가 0보다 작거나 같으면
                System.out.println("영화 번호는 1부터 시작합니다");
                return false;
            }
            for(int i=0;i<this.datas.size();i++) {
                if(this.datas.get(i).getMovieId()==dto.getMovieId()) {
                    this.datas.get(i).setViewCount((this.datas.get(i).getViewCount())+1);
                    return true;
                }
            }
        }catch(Exception e) {
            System.out.println("update에서 오류 발생"+e.getMessage());
        }
        return false;	//영화가 리스트에 없으면
    }
    public boolean delete(MovieDTO dto) {	//영화 번호로 입력받아서 삭제
        try {
            if(dto==null) {	//인자로 받은 dto가 null이면
                System.out.println("입력된 데이터가 null 입니다");
                return false;	//질문
            }
            else if(dto.getMovieId()<=0) {	//입력받은 번호가 0 이하이면
                System.out.println("영화 번호는 1부터 시작합니다");
                return false;
            }
            for(int i=0;i<this.datas.size();i++) {
                if(this.datas.get(i).getMovieId()==dto.getMovieId()) {
                    this.datas.remove(i);
                    return true;
                }
            }
            System.out.println("삭제할 영화가 존재하지 않습니다");
        }catch(Exception e) {
            System.out.println("delete에서 오류 발생"+e.getMessage());
        }
        return false;
    }
}