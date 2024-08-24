package Delphi.Assignment;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class product {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        login(driver);
        addToCart(driver);
        placeOrder(driver);
        driver.quit();
    }

    public static void login(WebDriver driver) {
        driver.findElement(By.id("login2")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("Delphitest");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys("Delphi@123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Log in')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
    }

    public static void addToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Laptops')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'MacBook air')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Add to cart')]"))).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text is: " + alert.getText());
        alert.accept();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Cart')]"))).click();
    }

    public static void placeOrder(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Place Order')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Delphitest");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))).sendKeys("India");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("Tirunelveli");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("card"))).sendKeys("4444 4444 4444");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month"))).sendKeys("01");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year"))).sendKeys("26");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Purchase')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'OK')]"))).click();
    }
}
