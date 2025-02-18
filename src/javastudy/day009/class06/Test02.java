package javastudy.day009.class06;
/*     2) 책 객체들을 저장하고 싶습니다.
	   책이란, 제목과 작가로 구성되어있습니다.
	   만약, 작가를 알 수 없는 책이라면 작가의 이름을 작자미상으로 설정해주세요
*/
class Book { // 클래스
    String title; // 제목
    String writer; // 작가
    Book(String title){ // 작자미상 오버로딩
        this.title = title;
        this.writer = "작자미상";
    }

    Book(String title, String writer){ // 기본 생성자
        this.title = title;
        this.writer = writer;
    }

    void printBookInfo(){
        System.out.println(this.title + " " + this.writer); // this 쓰는게 내꺼 보여달라고 하는거
        // 여기에  book01이나 book02 들어갔을 때 자기꺼 보여줌
    }
}

public class Test02 {
    public static void main(String[] args) {
        Book book01 = new Book("해리포터", "JK톨링");
        Book book02 = new Book("춘향전");

        book01.printBookInfo();
        book02.printBookInfo();
//        System.out.println(book01.title+" "+book01.writer);
//        System.out.println(book02.title+" "+book02.writer);
    }
}
