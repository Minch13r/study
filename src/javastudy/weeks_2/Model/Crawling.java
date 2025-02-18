package javastudy.weeks_2.Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Crawling {
    public static ArrayList<MovieDTO> makeDatas() {
        ArrayList<MovieDTO> datas = new ArrayList<>();
        WebDriver driver = null;

        try {
            String driverPath = "D:\\new\\minch13r\\workspace\\KOREA\\src\\weeks_2\\chromedriver.exe";

            if(!Files.exists(Paths.get(driverPath))) {
                System.out.println("[로그]크롤링 실패: ChromeDriver 경로를 다시 확인해주세요");
                return datas;
            }

            System.setProperty("webdriver.chrome.driver", driverPath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);

            try {
                driver.get("https://m.kinolights.com/ranking/netflix");

                Thread.sleep(5000);

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

                // 원래의 CSS 선택자 유지
                List<WebElement> titleElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector(".info__title")));
                List<WebElement> scoreElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.cssSelector("span.score__number")));

                if (titleElements.isEmpty() || scoreElements.isEmpty()) {
                    System.out.println("[로그]데이터를 찾을 수 없습니다.");
                    return datas;
                }

                System.out.println("\n===== 넷플릭스 TOP 20 =====");
                int count = 0;

                for (int i = 0; i < titleElements.size() && count < 20; i++) {
                    try {
                        String title = titleElements.get(i).getText().trim();
                        String ratingText = scoreElements.get(i).getText().trim();
                        double rating = 0.0;

                        if(!ratingText.isEmpty()) {
                            try {
                                rating = Double.parseDouble(ratingText);
                            } catch (NumberFormatException e) {
                                System.out.println("[로그]평점 변환 실패: " + ratingText);
                                continue;
                            }
                        }

                        if (!title.isEmpty()) {
                            MovieDTO data = new MovieDTO();
                            data.setMovieId(count + 1);
                            data.setTitle(title);
                            data.setRating(rating);
                            data.setViewCount(0);
                            datas.add(data);
                            count++;

                            System.out.println("[로그] " + count + ". " + title + " (평점: " + rating + ")");
                        }
                    } catch (Exception e) {
                        System.out.println("[로그]개별 영화 처리 중 오류: " + e.getMessage());
                    }
                }

                System.out.println("[로그]총 " + count + "개의 영화 데이터 수집 완료");

            } finally {
                if (driver != null) {
                    driver.quit();
                    System.out.println("[로그]브라우저 종료 완료");
                }
            }

        } catch (Exception e) {
            System.out.println("[로그]크롤링 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }

        return datas;
    }
}