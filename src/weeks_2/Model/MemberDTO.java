package weeks_2.Model;

import java.util.ArrayList;

public class MemberDTO {
//    public String getIsAdminID() {
//        return isAdminID;
//    }
//
//    public String getIsAdminPW() {
//        return isAdminPW;
//    }
//
//    private final String isAdminID = "윤지팀";//관리자 아이디,비번
//    private final String isAdminPW = "9999";

    private String id;
    private String pw;
    private String searchCondition;
    private ArrayList<MovieDTO> isPremium; // 각자의 즐겨찾기 목록

    public MemberDTO() {
        this.isPremium = new ArrayList<>();  // 생성자에서 초기화
    }


    public ArrayList<MovieDTO> getIsPremium() {
        return isPremium;
    }
    public void setIsPremium(ArrayList<MovieDTO> isPremium) {
        this.isPremium = isPremium;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getSearchCondition() {
        return searchCondition;
    }
    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }
}
