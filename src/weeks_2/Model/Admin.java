package weeks_2.Model;

import weeks_2.View.AdminView;
import weeks_2.View.ClientView;
import weeks_2.View.View;

public class Admin {
    private MovieDAO movieDao;
    private MemberDAO memberDao;
    private MemberDTO memberDTO;
    private MovieDTO movieDTO;
    private AdminView adminView;
    private ClientView clientView;
    private View baseView;
    private Crawling crawling;
    private MemberDTO admin; // admin 객체를 필드로 선언


    public Admin() {
        this.movieDao = new MovieDAO();
        this.memberDao = new MemberDAO();
        this.adminView = new AdminView();
        this.clientView = new ClientView();
        this.baseView = new View();
        this.memberDTO = new MemberDTO();
        this.movieDTO = new MovieDTO();
        this.admin = new MemberDTO();
        this.admin.setId("윤지팀");
        this.admin.setPw("9999");
    }

    // 관리자 로그인 확인 메소드
    public boolean isAdminLogin(String id, String password) {
        return id.equals(admin.getId()) && password.equals(admin.getPw());
    }

    // admin 객체의 getter
    public MemberDTO getAdmin() {
        return this.admin;
    }
}
