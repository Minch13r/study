package day018.class02.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class Crawling {
    private KyoChonDAO dao;
    final String URL = "https://www.kyochon.com/menu/chicken.asp";
    final String DRIVER_PATH = "C:\\Users\\3333c\\Desktop\\school\\ACADEMY\\study\\src\\day018\\class01\\driver\\chromedriver.exe";

    public Crawling(KyoChonDAO dao) {
        this.dao = dao;
    }

    public boolean crawlMenuData() {
        WebDriver driver = null;
        try {
            // 드라이버 설정
            System.setProperty("webdriver.chrome.driver", DRIVER_PATH);

            // 크롬 옵션 설정
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");            // 브라우저 창 숨기기
            options.addArguments("--disable-gpu");         // GPU 사용 안함
            options.addArguments("--no-sandbox");          // 샌드박스 모드 해제
            options.addArguments("--disable-dev-shm-usage");

            // WebDriver 생성
            driver = new ChromeDriver(options);

            // 명시적 대기 설정
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 페이지 접속
            driver.get(URL);

            // 메뉴 요소들이 로드될 때까지 대기
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("dl.txt")));

            // 메뉴 정보 추출
            List<WebElement> menuItems = driver.findElements(By.cssSelector("dl.txt"));

            for (WebElement item : menuItems) {
                // 메뉴명 추출
                String menuName = item.findElement(By.cssSelector("dt")).getText();

                // 설명 추출
                String description = item.findElement(By.cssSelector("dd")).getText();

                // 가격 추출 (상위 요소로 이동 후 가격 정보 찾기)
                String price = item.findElement(By.xpath("../p[@class='money']/strong")).getText();

                // DTO 생성 및 DB 저장
                KyochonDTO menuDTO = new KyochonDTO(menuName, description, price);
                dao.insert(menuDTO);
            }

            return true;

        } catch (Exception e) {
            System.out.println("[로그] 크롤링 중 오류 발생: " + e.getMessage());
            return false;

        } finally {
            // WebDriver 종료
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
