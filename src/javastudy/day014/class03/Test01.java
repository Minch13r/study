package javastudy.day014.class03;

import java.util.ArrayList;
import java.util.Iterator;

// iterator 복사체
public class Test01 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        System.out.println(al);

        // forEach로도 구현가능
        Iterator<Integer> itr = al.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            // 포인터(↑)가 이동
        }
    }
}
