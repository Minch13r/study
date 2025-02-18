package java.day014.class06;

import java.util.HashMap;
import java.util.Map;

// 맵 Map
// key : value
// Key 값은 중복을 허용하지 않는다 --->> 유일한 값.
// value는 중복이 허용된다. 동명이인이 있을 수 있다는 느낌
// python으로 따지면 dictionary와 같은 느낌
// index 개념 xxx ---> key 값으로 검색
public class Test03 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(101, "사과");
        map.put(102, "바나나");
        map.put(103, "키위");

        System.out.println(map.get(101));
        map.replace(101, "파인애플");
        System.out.println(map.get(101));

        System.out.println(map);
    }
}
