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

public class Seleniumrating {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // ChromeDriver 경로 설정
            String driverPath = "C:\\Users\\3333c\\Desktop\\school\\ACADEMY\\study\\src\\day018\\class01\\driver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);

            // Chrome 옵션 설정
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");

            driver = new ChromeDriver(options);
            driver.get("https://m.kinolights.com/ranking/netflix");
            System.out.println("페이지 로딩 중...");

            // 명시적 대기 설정
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // 제목과 점수 요소들이 로드될 때까지 대기
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".info__title")));
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".score__number")));

            // 제목과 점수 요소 찾기
            List<WebElement> titleElements = driver.findElements(By.cssSelector(".info__title"));
            List<WebElement> scoreElements = driver.findElements(By.cssSelector(".score__number"));

            System.out.println("\n===== 넷플릭스 TOP 20 =====");

            int count = 0;
            for (int i = 0; i < scoreElements.size() && count < 20; i++) {
                String title = titleElements.get(i).getText().trim();
                String score = scoreElements.get(i).getText().trim();

                if (!score.isEmpty() && !score.equals("%")) {
                    count++;
                    System.out.printf("%d。 %s %s%%\n", count, title, score);
                }
            }

        } catch (Exception e) {
            System.out.println("크롤링 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("\n브라우저 종료 완료");
            }
        }
    }
}
