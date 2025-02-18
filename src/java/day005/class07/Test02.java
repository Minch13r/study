package java.day005.class07;

import java.util.Random;
import java.util.Scanner;

// 데이터 검색하기
public class Test02 {
	public static void main(String[] args) {

		int[] datas=new int[10];
		Random rand=new Random();
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(100)+1;
		}
		for(int v:datas) {
			System.out.print(v+" ");
		}
		System.out.println();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("찾고싶은 정수 입력 >> ");
		int num=sc.nextInt();
		int index=0;
		
		boolean flag=false; // 못찾은상태
		
		for(int i=0;i<datas.length;i++) {
			if(num == datas[i]) {
				index=i;
				flag=true; // 플래그 ON
			}
		}
		
		if(flag) {
			System.out.println(num+"은 ["+index+"]에 있습니다.");
		}
		else {
			System.out.println(num+"은 없습니다.");
		}
		
		
		
		
		
	}
}
