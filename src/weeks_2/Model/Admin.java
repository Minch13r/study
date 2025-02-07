package weeks_2.Model;

import weeks_2.View.AdminView;
import weeks_2.View.ClientView;
import weeks_2.View.View;

public class Admin {

    private MemberDTO admin; // admin 객체를 필드로 선언


    public Admin() {
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
