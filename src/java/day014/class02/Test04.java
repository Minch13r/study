package java.day014.class02;

import java.util.ArrayList;

// [ 컬렉션 프레임워크 : list ]
public class Test04 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        // 배열 3요소 중에 관련이 있는지만 해당하면 넣을 수 있음
        // 자료형 상관없이 다 가능
        al.add(10);
        al.add(0,11);
        al.add(20);
        al.add(30);
        // al.clear();
        System.out.println(al.contains(31));
        System.out.println(al.get(1));
        System.out.println(al.isEmpty());
        System.out.println(al.size());
        al.set(0, 123);
        al.remove(0);
        System.out.println(al);


        ArrayList<Integer> datas = new ArrayList<>();
        // <> 제네릭
        // : 저장할 데이터의 타입을 '강제'
        datas.add(10);
        // Pokemon 이런것도 들어갈 수 있음 <Pokemon> 이런식으로
    }
}
