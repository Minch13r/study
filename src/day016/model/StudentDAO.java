package day016.model;

import java.util.ArrayList;

// DAO(Data Access Object)
// CRUD 메서드만 가짐
// DAO는 이와 같이 5개의 메서드만 가질 수 있음(고정)
// selectAll(list), selectOne(DTO), insert(boolean), update(boolean), delete(boolean)
// 자신한테 없는거는 외부에서 받아와야 함
public class StudentDAO {
    // DB의 역할
    private ArrayList<StudentDTO> datas;

    // 생성자
    public StudentDAO(){
        this.datas = new ArrayList<>();
        // 샘플 데이터 추가
        this.datas.add(new StudentDTO(1001, "티모", 98));
        this.datas.add(new StudentDTO(1002, "모르가나", 64));
        this.datas.add(new StudentDTO(1003, "오리아나", 40));
    }

    // 전체 다 받아오는 것
    public ArrayList<StudentDTO> selectAll() {
        // Controller에서 전체출력하겠다. 라고 하면
        // 내가 가지고 있던 DB의 내용을 모두
        // Controller로 전달
        ArrayList<StudentDTO> datas = new ArrayList<>();
        // selectAll 하면 리스트 형태를 모두 전달할거고
        // 리스트 안에는 DB 안에 있는 내용이 모두 들어가 있어야 한다.
        // datas 리스트의 크기만큼 반복해서 모든 내용 출력
        for(int i=0; i<this.datas.size(); i++){
            int num = this.datas.get(i).getNum();
            String name=this.datas.get(i).getName();
            int score=this.datas.get(i).getScore();
            datas.add(new StudentDTO(num, name, score));
        }
        // datas 값 반환(모든 내용 출력해야 하니까)
        return datas;
    }

    // 한가지만 받아오는 거
    public StudentDTO selectOne(int num) {
        // 검색할게 없으면 안 나와야 하니까 null 맞음
        StudentDTO data = null;
        // 처음부터 끝까지 돌면서
        for(int i=0; i<this.datas.size(); i++){
            // 같은 번호 발견하면
            if(num == this.datas.get(i).getNum()){
                String name=this.datas.get(i).getName();
                int score=this.datas.get(i).getScore();
                data = new StudentDTO(num, name, score);
            }
        }
        // 반환(한개만)
        return data;
    }
    /*
    selectAll이랑 selectOne 차이점이 뭐냐면 All은 반복문을 다 돌면서
    모든 내용을 다 출력하는거임. 하지만 One은 반복문을 다 돌면서 들어온 값에
    해당되는 번호를 선택해서 그 번호 안에 있는 정보'만' 출력하는거임
    */

    // 학생 생성 메서드
    public boolean insert(String name, int score, int num){
        // 이름이랑 정수를 받아서
        // 그것에 해당하는 학생을 생성
        // 배열(db)에 추가
        this.datas.add(new StudentDTO(num, name, score));
        return true;
    }

    // 학생 수정 메서드
    public boolean update(int num, String name){
        for(int i=0; i<this.datas.size(); i++){
            if(num == this.datas.get(i).getNum()){
                this.datas.get(i).setName(name);
                return true;
            }
        }
        return false;
    }

    // 학생 삭제 메서드
    public boolean delete(int num){
        for(int i=0; i<this.datas.size(); i++){
            if(num == this.datas.get(i).getNum()){
                this.datas.remove(i);
                return true;
            }
        }
        return false;
    }
}
