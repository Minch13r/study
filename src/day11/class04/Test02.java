package day11.class04;

class Point {
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
}

public class Test02 {
    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(10, 20);

        System.out.println(p1);
        System.out.println(p2);
    }
}
