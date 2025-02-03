package weeks_2.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Crawling {public static ArrayList<MovieDTO> makeDatas() {

    ArrayList<MovieDTO> datas=new ArrayList<>();
    try {
        // ChromeDriver 경로 지정
        String driverPath = "C:\\Users\\3333c\\Desktop\\school\\ACADEMY\\study\\src\\day018\\class01\\driver\\chromedriver.exe";


        // setProperty()로 ChromeDriver의 위치를 시스템에 넘김
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Chrome 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");           // 브라우저 창을 띄우지 않고 백그라운드에서 실행
        options.addArguments("--disable-gpu");        // GPU 하드웨어 가속 비활성화
        options.addArguments("--no-sandbox");         // 샌드박스 모드 비활성화
        options.addArguments("--disable-dev-shm-usage"); // 공유 메모리 사용 비활성화

        // WebDriver 생성
        WebDriver driver = new ChromeDriver(options);

        try {
            // 웹페이지 로드
            driver.get("https://m.kinolights.com/ranking/netflix");

            // 페이지가 완전히 로드될 때까지 충분히 기다림
            Thread.sleep(3000); // 3초 대기


            // 명시적 대기 설정
            // 최대 대기 10초 설정
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            // .info__title이 나타날 때까지 대기
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector(".info__title")));
            // span.score__number 나타날 때까지 대기
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.cssSelector("span.score__number")));


            // .info__title 클래스를 가진 모든 요소를 찾아 리스트로 저장
            List<WebElement> titleElements = driver.findElements(
                    By.cssSelector(".info__title"));
            // span.score__number 클래스를 가진 모든 요소를 찾아 리스트로 저장
            List<WebElement> scoreElements = driver.findElements(
                    By.cssSelector("span.score__number"));




            // 결과 출력 (상위 20개만)
            System.out.println("\n===== 넷플릭스 TOP 20 =====");
            int count = 0;   //영화 번호
            for (int i=0;i<titleElements.size() && count<20;i++) {   //20개까지
                String title = titleElements.get(i).getText().trim(); // 요소의 텍스트를 가져와서 공백 제거
                String ratingText=scoreElements.get(i).getText().trim(); // 요소의 텍스트를 가져와서 공백 제거
                double rating=0.0;   //초기화

                if(!ratingText.isEmpty()) {   //평점 텍스트로 받은거 double로 형변환
                    rating=Double.parseDouble(ratingText);
                }
                if (!title.isEmpty()) { //공백이 아니면
                    MovieDTO data=new MovieDTO();
                    data.setMovieId(count+1);   //영화 번호
                    data.setTitle(title);   //영화 제목
                    data.setRating(rating);   //영화 평점
                    data.setViewCount(0);   //영화 시청수 0으로 초기화
                    datas.add(data);
                    count++;
                }
            }

        } finally {
            driver.quit();
//            System.out.println("브라우저 종료 완료");
        }

    } catch (Exception e) {
        System.out.println("오류 발생: " + e.getMessage());
        e.printStackTrace();
    }
    return datas;   //리스트 반환

}

}
