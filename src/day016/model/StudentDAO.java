package day016.model;

import java.util.ArrayList;

// DAO(Data Access Object)
// CRUD 메서드만 가짐
// DAO는 이와 같이 5개의 메서드만 가질 수 있음(고정)
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

    public ArrayList<StudentDTO> selectAll() {
        return null;
    }

    public StudentDTO selectOne() {
        return null;
    }

    public boolean insert(){
        return false;
    }

    public boolean update(){
        return false;
    }

    public boolean delete(){
        return false;
    }
}
