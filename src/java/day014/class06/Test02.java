package java.day014.class06;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test02 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();

        Random rand = new Random();
        while(true){
            int randNum =rand.nextInt(10);
            set.add(randNum);
            if(set.size()>=5){
                break;
            }
        }
        System.out.println(set);
    }
}
