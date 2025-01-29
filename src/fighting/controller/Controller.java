package fighting.controller;

import java.util.ArrayList;

import fighting.crawling.Crawling;
import fighting.model.CoffeeDAO;
import fighting.model.CoffeeDTO;
import fighting.model.MemberDAO;
import fighting.model.MemberDTO;
import fighting.view.View;

public class Controller {
	private CoffeeDAO coffeeDAO;
	private MemberDAO memberDAO;
	private View view;
	private String member; // 로그인 여부(장바구니 정보와 같은 존재)
	public Controller() {
		this.coffeeDAO=new CoffeeDAO();
		this.memberDAO=new MemberDAO();
		this.view=new View();
		this.member=null; // 처음에는 비로그인 상태
	}

	public void start() {
		String mid=this.view.inputMid();
		String mpw=this.view.inputMpw();
		MemberDTO dto=new MemberDTO();
		dto.setMid(mid);
		dto.setMpw(mpw);
		memberDAO.insert(dto);
		while(true) {
			if(this.member==null) {
				this.view.printMenu01();	
			}
			else {
				System.out.println("CTRL 로그 : "+this.member+"님 로그인 중");
				this.view.printMenu02();	
			}

			int menu=this.view.inputMenu();
			if(menu==0) {
				break;
			}
			else if(menu==1) {
				ArrayList<CoffeeDTO> samples=Crawling.makeSample();

				for(int i=0;i<samples.size();i++) {
					this.coffeeDAO.insert(samples.get(i));
				}
			}
			else if(menu==2) {
				this.view.printDatas(this.coffeeDAO.selectAll(null));
			}
			else if(menu==3) {
				int num=this.view.inputNum();
				String detail=this.view.inputDetail();

				CoffeeDTO cdto=new CoffeeDTO();
				cdto.setNum(num);
				cdto.setDetail(detail);
				coffeeDAO.update(cdto);
			}
			else if(menu==4) {
				if(this.member == null) {
					continue;
				}

				this.member=null;
			}
			else if(menu==5) {
				if(this.member != null) {
					continue;
				}

				mid=this.view.inputMid();
				mpw=this.view.inputMpw();

				MemberDTO mdto=new MemberDTO();
				mdto.setCondition("LOGIN");
				mdto.setMid(mid);
				mdto.setMpw(mpw);
				mdto=this.memberDAO.selectOne(mdto);
				if(mdto != null) {
					this.member=mdto.getMid(); // 비로그인 → 로그인 상태
				}
			}
			else if(menu==6) {
				while(true) {
					mid=this.view.inputMid();
					
					MemberDTO mdto=new MemberDTO();
					mdto.setCondition("CHECK");
					mdto.setMid(mid);
					mdto=this.memberDAO.selectOne(mdto);
					// dto에 데이터가 존재 ===>> 해당 아이디 사용중
					// dto에 데이터가 없음 ===>> 해당 아이디 사용가능
					if(mdto==null) { 
						// 장바구니에 제품추가 ===>> DB 사용 x CRUD x
						// 중복검사 ===>> DB 사용 o CRUD o
						break;
					}
				}

				mpw=this.view.inputMpw();
				MemberDTO mdto=new MemberDTO();
				mdto.setMid(mid);
				mdto.setMpw(mpw);
				memberDAO.insert(mdto);
				// PK값을 사용자가 지정하는 경우, "중복검사"
			}
		}
	}
}
