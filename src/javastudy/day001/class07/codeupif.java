package javastudy.day001.class07;

public class codeupif {
        public static void main(String[] args){
            int a = 3;
            int b = 5;
            int c = 2;

            int min = a;
            if(b < min){
                min = b;
            }
            if(c < min){
                min = c;
            }

            System.out.println("답 : " + min);
        }
    }
