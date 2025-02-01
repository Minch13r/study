package day018.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Selenium {
    public static void main(String[] args) {
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
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                // .info__title이 나타날 때까지 대기
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".info__title")));

                // .info__title 클래스를 가진 모든 요소를 찾아 리스트로 저장합
                List<WebElement> titleElements = driver.findElements(
                        By.cssSelector(".info__title"));

                // 결과 출력 (상위 20개만)
                System.out.println("\n=== 넷플릭스 TOP 20 ===");
                int count = 0;
                for (WebElement element : titleElements) {
                    String title = element.getText().trim(); // 요소의 텍스트를 가져와서 공백 제거
                    if (!title.isEmpty() && count < 20) { // 빈 문자열이 아니고 20개 미만일 때만
                        System.out.println((count + 1) + ". " + title);
                        count++;
                    }
                }

            } finally {
                driver.quit();
                System.out.println("브라우저 종료 완료");
            }

        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}