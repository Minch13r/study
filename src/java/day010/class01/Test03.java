package java.day010.class01;

class Pokemon {
	int num;
	String name;
	String type;
	int level;
	int exp;
	Pokemon(int num,String name,String type) {
		this(num,name,type,5);
	}
	Pokemon(int num,String name,String type,int level) {
		this(num,name,type,level,0); // 이미 만들어둔 생성자 호출
	}
	Pokemon(int num,String name,String type,int level,int exp) {
		this.num=num;
		this.name=name;
		this.type=type;
		this.level=level;
		this.exp=exp;
	}
}

public class Test03 {
	public static void main(String[] args) {
		Pokemon p=new Pokemon(1,"이상해씨","풀");
	}
}
