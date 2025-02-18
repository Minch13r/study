package java.study;


/*학생부 클래스를 선언해주세요.
학생부 객체들은 이름과 나이, 성별을 가집니다.
성별은 1과 2를 입력받습니다.
학생의 정보를 출력해주세요.
1이라면 남자, 2라면 여자로 출력합니다.
출력 예시-
JAVA의 나이는 30살이며 성별은 남자입니다.
*/
class Student{
    String name;
    int age;
    int gender;
    Student(String name, int age, int gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    void printInfo(){
        String gender = this.gender == 1 ? "남자" : "여자";
        System.out.println(this.name + "의 나이는 " + this.age + "살이며 성별은 " + gender + "입니다.");
    }
}
public class number03 {

    public static void main(String[] args) {
        Student student = new Student("JAVA", 30, 2);
        student.printInfo();
    }
}
