package study;
/*영화 리뷰 객체들을 저장하고 싶습니다.
영화 리뷰란, 닉네임과 별점, 내용으로 구성되어있습니다.
별점은 1부터 5까지입니다.
만약 내용이 없는 영화 리뷰라면 영화 리뷰의 내용을 빈칸(" ")으로 해주세요.
출력 예시-
닉네임 : 자바만JAVA
별점 : 3
리뷰 내용 : 킬링타임으로 적절하다.
*/
class MovieReivew{
    String nickname;
    int star;
    String content;
    MovieReivew(String nickname, int star, String content){
        this.nickname = nickname;
        this.star = star;
        this.content = content;
        System.out.println("닉네임 : " + nickname);
        System.out.println("별점 : " + star);
        System.out.println("리뷰 내용 : " + content);
    }
    MovieReivew(String nickname, int star){
        this.nickname = nickname;
        this.star = star;
        this.content = " ";
        System.out.println("닉네임 : " + nickname);
        System.out.println("별점 : " + star);
        System.out.println("리뷰 내용 : " + content);
    }
}
public class Test02 {
    public static void main(String[] args) {
        MovieReivew movieReivew = new MovieReivew("피카츄", 5, "낫밷");
        MovieReivew movieReivew1 = new MovieReivew("꼬북이", 3);
    }
}
