package javastudy.day005.class07;

import java.util.Random;
import java.util.Scanner;

// 데이터 검색하기
// 이진 탐색(이분 검색) ===>> 데이터가 "정렬"되어있어야함!
public class Test03 {
	public static void main(String[] args) {

		int[] datas=new int[10];
		Random rand=new Random();
		for(int i=0;i<datas.length;i++) {
			datas[i]=rand.nextInt(100)+1;
		}

		// 버블 정렬
		for(int i=0;i<datas.length-1;i++) {
			for(int j=0;j<datas.length-1;j++) {
				if(datas[j] > datas[j+1]){
					int tmp=datas[j];
					datas[j]=datas[j+1];
					datas[j+1]=tmp;
				}
			}
		}

		for(int v:datas) {
			System.out.print(v+" ");
		}
		System.out.println();

		Scanner sc=new Scanner(System.in);
		System.out.print("찾고싶은 정수 입력 >> ");
		int num=sc.nextInt();

		int START=0;
		int END=9;
		// 이진 탐색
		int pivot;
		while(true) {
			pivot=(START+END)/2; // 피벗(기준)
			if(datas[pivot] < num) { // 가운데 숫자보다 내가 찾으려는게 크니?
				// 업! 상황
				START=pivot+1;
			}
			else if(datas[pivot] > num) { // 가운데 숫자보다 내가 찾으려는게 작니?
				// 다운! 상황
				END=pivot-1;
			}
			else { // 종료조건 : 찾았다면
				break;
			}	

			if(START > END) { // 종료조건 : 못찾았다면
				// CROSS(교차) 발생
				break;
			}
		}

		if(START<=END) {
			System.out.println(num+"은 ["+pivot+"]에 있습니다.");
		}
		else {
			System.out.println(num+"은 없습니다.");
		}












	}
}
