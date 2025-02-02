package weeks_2.Model;

import java.util.ArrayList;

public class MovieDAO {
    private ArrayList<MovieDTO> datas;
    private int NUM;	//영화 추가할 때 넣을 영화 번호

    public MovieDAO() {
        this.datas=new ArrayList<>();
        this.NUM=21;	//영화 20개만 가져오니까 21로 초기화
    }

    public ArrayList<MovieDTO> selectAll(MovieDTO dto){
        if(dto.getCondition().equals("CRAWLING")) {	//크롤링 할 때
            ArrayList<MovieDTO> datas=Crawling.makeDatas();	//크롤링해서 반환한 데이터 저장
            return datas;
        }
        else if(dto.getCondition().equals("PRINTALL")) {	//전체출력 할 때
            ArrayList<MovieDTO> datas=new ArrayList<>();
            for(int i=0;i<datas.size();i++) {
                MovieDTO data=new MovieDTO();
                data.setMovieId(this.datas.get(i).getMovieId());
                data.setTitle(this.datas.get(i).getTitle());
                data.setRating(this.datas.get(i).getRating());
                data.setViewCount(this.datas.get(i).getViewCount());
                datas.add(data);
            }
        }
        return datas;
    }
    public MovieDTO selectOne(MovieDTO dto) {	//영화 하나 출력할 때
        MovieDTO data=null;
        for(int i=0;i<datas.size();i++) {
            if(datas.get(i).getMovieId() == dto.getMovieId()) {
                data=new MovieDTO();
                data.setMovieId(datas.get(i).getMovieId());
                data.setTitle(datas.get(i).getTitle());
                data.setRating(datas.get(i).getRating());
                data.setViewCount(datas.get(i).getViewCount());
                break;
            }
        }
        return data;
    }
    public boolean insert(MovieDTO dto) {	//영화 추가
        try {
            MovieDTO data=new MovieDTO();
            data.setMovieId(NUM++);	//추가할 때 영화 번호 21로 넣고 1증가
            data.setTitle(dto.getTitle());
            data.setRating(dto.getRating());
            data.setViewCount(0);	//처음 시청수는 0
            this.datas.add(data);
        }catch(Exception e) {
            return false;
        }
        return true;
    }


    public boolean update(MovieDTO dto) {	//영화 시청할 때 update 메서드로 시청수 +1
        for(int i=0;i<this.datas.size();i++) {
            if(this.datas.get(i).getMovieId()==dto.getMovieId()) {
                this.datas.get(i).setViewCount((this.datas.get(i).getViewCount())+1);
                return true;
            }
        }
        return false;	//영화가 리스트에 없으면
    }
    public boolean delete(MovieDTO dto) {	//영화 번호로 입력받아서 삭제
        for(int i=0;i<this.datas.size();i++) {
            if(this.datas.get(i).getMovieId()==dto.getMovieId()) {
                this.datas.remove(i);
                return true;
            }
        }
        return false;	//영화가 리스트에 없으면
    }
}
