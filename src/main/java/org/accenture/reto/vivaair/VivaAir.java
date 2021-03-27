package org.accenture.reto.vivaair;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class VivaAir {
    public static WebDriver driver;
    private static String masEconomico;
    private static String vueloSeleccionado;

    public String getMasEconomico() {
        return masEconomico;
    }

    public String getVueloSeleccionado() {
        return vueloSeleccionado;
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        System.out.println("Web driver inicializado");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vivaair.com/co/es");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement closeAdds;
        //closeAdds=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[3]/div[6]/div/div/div[2]/div/div[1]/i")));
        //closeAdds.click();
        closeAdds=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"onesignal-slidedown-cancel-button\"]")));
        closeAdds.click();


        WebElement soloIda;
        soloIda = driver.findElement(By.xpath("//*[@id=\"criteria\"]/div/div[1]/label/span[1]"));
        soloIda.click();

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");

        WebElement origen;
        origen = driver.findElement(By.xpath("//*[@id=\"criteria-airport-select-departure-input\"]"));
        origen.click();
        origen.sendKeys("Medellin");
        origen = driver.findElement(By.xpath("//*[@id=\"criteria-airport-select-departure-station-MDE\"]"));
        origen.click();

        WebElement destino;
        destino = driver.findElement(By.xpath("//*[@id=\"criteria-airport-select-destination-input\"]"));
        destino.click();
        destino.sendKeys("Bogota");
        destino = driver.findElement(By.xpath("//*[@id=\"criteria-airport-select-destination-station-BOG\"]"));
        destino.click();

        WebElement fechaIda;
        LocalDate currentDate = LocalDate.now();
        String currentDayBefore= currentDate.toString();
        String currentDaySplited [] = currentDayBefore.split("-");
        int currentDay = currentDate.getDayOfMonth();
        int nextDay = currentDay+1;
        String currendDayMerged=currentDaySplited[0]+"-"+currentDaySplited[1]+"-"+nextDay;
        System.out.println(currendDayMerged);
        fechaIda = driver.findElement(By.xpath("//*[@id=\"criteria-dates-from\"]"));
        fechaIda.click();
        fechaIda=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@date=\""+currendDayMerged+"\"]")));
        fechaIda.click();

        WebElement buscar;
        buscar=driver.findElement(By.xpath("//*[@id=\"criteria-search-button-desktop\"]"));
        buscar.click();

        jse.executeScript("window.scrollBy(0,350)");
        WebElement vueloMaseconomico;
        vueloMaseconomico = driver.findElement(By.xpath("//*[@id=\"days-0\"]/button[4]/div[3]"));
        System.out.println(vueloMaseconomico.getText());
        masEconomico=vueloMaseconomico.getText();

        jse.executeScript("window.scrollBy(0,350)");
        WebElement seleccionarVueloMasBarato;
        seleccionarVueloMasBarato = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[@class=\"from-price\"][ text() = \""+vueloMaseconomico.getText()+"\"]")));
        seleccionarVueloMasBarato.click();
        vueloSeleccionado=seleccionarVueloMasBarato.getText();

        jse.executeScript("window.scrollBy(350,700)");
        WebElement masBarato;
        masBarato = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"Vkh_NTU4Nn4gfn5NREV_MDMvMjQvMjAyMSAxNjo0NX5CT0d_MDMvMjQvMjAyMSAxNzo0Mn5_\"]/div[2]/div/div/div[2]/div[1]/div/div[5]")));
        masBarato.click();
        masBarato.click();

        WebElement continuar;
        continuar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=\"Continuar\"]")));
        continuar.click();
    }
}
