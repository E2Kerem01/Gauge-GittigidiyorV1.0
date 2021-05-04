import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;


public class BaseStep extends BaseTest {

    WebElement webElement = null;

    @Step("<i> saniye  bekle")
    public void waitForsecond(int i) throws InterruptedException {
        Thread.sleep(i * 1000);
    }

    @Step("<key> tipinde olan <value> değerindeki elemana <sendingvalue> kelimesini gir.")
    public void search(String key, String value, String sendingvalue) {
        webElement = webElementiBul(key, value);
        webElement.sendKeys(sendingvalue);
        webElement.submit();
    }

    @Step("<key> tipinde olan <value> değerindeki elemana tıkla.")
    public WebElement webElementiBul(String key, String value) {

        switch (key) {
            case "id":
                webElement = driver.findElement(By.id(value));
                webElement.click();
                break;
            case "css":
                webElement = driver.findElement(By.cssSelector(value));
                webElement.click();
                break;
            case "xpath":
                webElement = driver.findElement(By.xpath(value));
                webElement.click();
                break;
            case "classname":
                webElement = driver.findElement(By.className(value));
                webElement.click();
                break;
            case "name":
                webElement = driver.findElement(By.name(value));
                webElement.click();
                break;
            case "linkText":
                webElement = driver.findElement(By.linkText(value));
                webElement.click();
                break;
            default:
                System.out.println("TestClass içerisinde Web Elementi Bul fonksiyonu düzgün çalışmadı...");
                break;
        }
        return webElement;
    }

    @Step("<key> tipinde olan <value> değerindeki elemanın üzerinde dur.")
    public void search(String key, String value) {
        Actions actions = new Actions(driver);
        webElement = webElementiBul(key, value);
        actions.moveToElement(webElement).build().perform();
    }

    @Step("<key>,<value> texti ile <actual> değerini karşılaştır.")
    public void kontrol(String key, String value, String actual) {
        String expected = webText(key, value);
        Assert.assertEquals(expected, actual);
    }

    @Step("<key> tipinde olan <value> değerindeki elemanın textini al.")
    public String webText(String key, String value) {

        String text = null;

        switch (key) {
            case "id":
                text = driver.findElement(By.id(value)).getText();
                break;
            case "css":
                text = driver.findElement(By.cssSelector(value)).getText();
                break;
            case "xpath":
                text = driver.findElement(By.xpath(value)).getText();
                break;
            case "classname":
                text = driver.findElement(By.className(value)).getText();
                break;
            case "name":
                text = driver.findElement(By.name(value)).getText();
                break;
            case "linkText":
                text = driver.findElement(By.linkText(value)).getText();
                break;
            default:
                System.out.println("TestClass içerisinde Web Elementi Bul fonksiyonu düzgün çalışmadı...");
                break;
        }
        return text;
    }

    @Step("<by> değerinde olan elemanlardan birisine random olarak tıkla")
    public void randomTıklama(String by) {
        driver.findElements(By.cssSelector(by)).get(random(48)).click();
    }

    @Step("<key> tipinde olan <value> değerindeki elemanın içinden random bir değere tıkla. ")
    public void ürünkontrol(String key, String value) {
        String basketSize = driver.findElement(By.cssSelector("select[data-maxamount]")).getText();
        System.out.println("basketSize : " + basketSize);
        Select sepet = new Select(webElementleriBul(key, value, random(Integer.parseInt(basketSize))));
        sepet.selectByIndex(random(Integer.parseInt(basketSize)));
    }

    @Step("Bu <url> e git")
    public void navigateTo(String url){
        driver.navigate().to(url);
    }

    @Step("<key> tipinde olan <value> değerindeki <i>.elemanı bul.")
    public WebElement webElementleriBul(String key, String value, int i) {

        switch (key) {
            case "id":
                webElement = driver.findElements(By.id(value)).get(i);
                webElement.click();
                break;
            case "css":
                webElement = driver.findElements(By.cssSelector(value)).get(i);
                webElement.click();
                break;
            case "xpath":
                webElement = driver.findElements(By.xpath(value)).get(i);
                webElement.click();
                break;
            case "classname":
                webElement = driver.findElements(By.className(value)).get(i);
                webElement.click();
                break;
            case "name":
                webElement = driver.findElements(By.name(value)).get(i);
                webElement.click();
                break;
            case "linkText":
                webElement = driver.findElements(By.linkText(value)).get(i);
                webElement.click();
                break;
            default:
                System.out.println("Kerem LG ekran alamaz. :D");
                break;
        }
        return webElement;
    }

    public int random(int x) {
        Random rand = new Random();
        int num = rand.nextInt(x);

        if (num == 0) {
            return 1;
        } else {
            return num;
        }
    }
}
