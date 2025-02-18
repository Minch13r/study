package javastudy.day014.class05;

import java.util.ArrayList;
import java.util.Scanner;

class Circle {
	private String name;
	private int radius;
	private double area;
	static final double PI=3.14;
	Circle(String name,int radius){
		this.name=name;
		this.radius=radius;
		this.area=this.radius*this.radius*Circle.PI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Circle)) {
			return false;
		}
		Circle circle=(Circle)obj; // 형변환(캐스팅), 다운캐스팅(강제형변환)
		return this.name.equals(circle.name);
	}
	@Override
	public String toString() {
		return "Circle [name=" + name + ", radius=" + radius + ", area=" + area + "]";
	}
}
public class Test01 {
	public static void main(String[] args) {		
		ArrayList<Circle> al=new ArrayList<>();
		al.add(new Circle("도넛",1));
		al.add(new Circle("피자",10));
		al.add(new Circle("도넛",10)); // 무명 객체
		
		double max=al.get(0).getArea();
		int maxIndex=0;
		for(int i=1;i<al.size();i++) {
			if(max <= al.get(i).getArea()) {
				max=al.get(i).getArea();
				maxIndex=i;
			}
		}
		System.out.println(al.get(maxIndex));
		
		
		
		Scanner sc=new Scanner(System.in);
		System.out.print("이름 입력 >> ");
		String name=sc.next();
			
		Circle circle=new Circle(name,0);
		
		int cnt=0;
		for(Circle v:al) {
			if(v.equals(circle)) { // 비교대상은 "원 객체"!!!!!
				System.out.println(v);
				cnt++;
			}
		}
		System.out.println("cnt = "+cnt);
		
		
		
		
		
		
		
		
		
		
		
	}
}
