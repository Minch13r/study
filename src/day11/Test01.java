package day11;

// 캡슐화
class Student {
    private String name; // 접근자, 접근제한자
    private int score;
    Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    // 캡슐화된 멤버변수의 값을 가져오고 싶을 때 == getter
    public String getName(){ // getXxx()
        return this.name;
    }

    public int getScore(){
        return this.score;
    }
    // 캡슐화된 멤버변수에게 새로운 값을 부여하고 싶을 때 == setter
    public void setName(String name){
        this.name = name;
    }
    public void setScore(int score){
        this.score = score;
    }
}
public class Test01 {
    public static void main(String[] args) {
        Student s1 = new Student("티모", 50);
        Student s2 = new Student("모르가나", 80);

        //System.out.println(s2.score);
        System.out.println(s2.getScore());

        //s1.score=81;
        s1.setScore(81);
    }
}
