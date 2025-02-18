package javastudy.study;
/*
당일치기 근무 클래스를 구현해주세요.
당일치기 근무는 근무 시간을 보여줄 수 있고,
모든 당일치기 근무는 최대 근무 시간이 8시간을 넘을 수 없습니다.
출력 예시-
당일 노동 시간 : 8시간
*/
class Work {
    int workTime;
    int maxWorkTime;
    Work(){
        this.maxWorkTime = 8;
    }
    public void setWorkTime(int workTime) {
        if(workTime > maxWorkTime) {
            System.out.println("당일치기 근무는 최대 8시간을 넘을 수 없습니다.");
            return;
        }
        this.workTime = workTime;
        System.out.println("당일 노동 시간 : " + workTime + "시간");
    }
}
public class number04 {
    public static void main(String[] args) {
        Work work = new Work();
        work.setWorkTime(5);
    }
}
