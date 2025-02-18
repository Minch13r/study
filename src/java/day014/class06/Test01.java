package java.day014.class06;

// set 집합

import java.util.HashSet;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        // Set은 추상 클래스여서 객체화 불가능
        Set set = new HashSet();

        set.add(10);
        set.add(11);
        set.add(12);
        set.add(123);
        set.add(1234);
        set.add(0);
        System.out.println(set);
        // 집합의 특징 1. 중복 허용 XXX
        // 집합의 특징 2. 순서 존재 X
    }
}
