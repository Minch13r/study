package fighting.view;

import java.util.ArrayList;
import java.util.Scanner;

import fighting.model.CoffeeDTO;

public class View {
	private static final int MAX=6;
	private static final Scanner sc=new Scanner(System.in);
	public void printMenu01() { // 비로그인 상태
		System.out.println("5. 로그인");
		System.out.println("6. 회원가입");
		System.out.println("0. 종료");
	}
	public void printMenu02() { // 로그인 상태
		System.out.println("1. 샘플데이터생성");
		System.out.println("2. 샘플데이터출력");
		System.out.println("3. 상세설명변경");
		System.out.println("4. 로그아웃");
	}
	public String inputMid() {
		System.out.print("아이디입력 >> ");
		String mid=sc.next();
		return mid;
	}
	public String inputMpw() {
		System.out.print("비밀번호입력 >> ");
		String mpw=sc.next();
		return mpw;
	}
	public void printDatas(ArrayList<CoffeeDTO> datas) {
		if(datas.size()<=0) {
			System.out.println("샘플데이터없음!");
			return;
		}
		for(CoffeeDTO data:datas) {
			System.out.println(data);
		}
	}
	public int inputNum() {
		System.out.print(">> ");
		int num=sc.nextInt();
		return num;
	}
	public String inputDetail() {
		System.out.print(">> ");
		String detail=sc.next();
		return detail;
	}
	public int inputMenu() {
		int num;
		while(true) {
			try {
				System.out.print(">> ");
				num=sc.nextInt();
				if(0<=num && num<=MAX) { // 하드코딩 제거
					break;
				}
				System.out.println("범위확인!");
			}
			catch(Exception e) {
				sc.nextLine();
				System.out.println("자료형확인!");
				continue;
			}
		}
		return num;
	}
}
