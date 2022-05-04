package com.eurotech.day22_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.time.Duration;
import java.util.List;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.findElement(By.xpath("//button[@id='ez-accept-all']")).click();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement demoTable = driver.findElement(By.xpath("//h3[text()='Demo Table 2']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", demoTable);

    }



    @Test
    public void printTable() throws InterruptedException {

        WebElement table1 = driver.findElement(By.xpath("//table[@border='1']"));
        System.out.println(table1.getText());

    }

    @Test
    public void getAllHeaders() {

        //getAll Headers
        List<WebElement> allHeaders = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        System.out.println("allHeaders.size() = " + allHeaders.size());
        for (WebElement header : allHeaders) {
            System.out.println("header.getText() = " + header.getText());
        }
        System.out.println("****************************************");
        //getRow size
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("rows.size() = " + rows.size());
        for (WebElement row : rows) {
            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getRows() {
        //get second row which is starting clock tower hotel
        WebElement clockTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]"));
        System.out.println("clockTower.getText() = " + clockTower.getText());

        //get all rows
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        System.out.println("numRows.size() = " + numRows.size());

        for (int i = 1; i <=numRows.size() ; i++) {
               WebElement row= driver.findElement(By.xpath("//table[@border='1']/tbody/tr["+i+"]"));
               System.out.println(i+"-" + row.getText());
        }
    }

    @Test
    public void gelAllCellInOneRow() {

        //get Burj Khalifa's info
        List<WebElement> burj = driver.findElements(By.xpath("//table[@border='1']/tbody/tr[1]/td"));
        //expected size =6
        System.out.println("burj.size() = " + burj.size());

        for (WebElement element : burj) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void getSingleCell() {
        //get Height of Clock Tower Hotel (601)

        WebElement heightOfTower = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[3]"));
        System.out.println("heightOfTower.getText() = " + heightOfTower.getText());

    }

    @Test
    public void printAllCellByIndex() {

        int rowNumber =getNumberOfRows();
        int colNumber =getNumberOfColumns()-2;

        //her bir row u al
        for (int i = 1; i <=rowNumber ; i++) {
            //her bir column al
            for (int j = 1; j <=colNumber ; j++) {
                String cellXpath = "//table[@border='1']/tbody/tr["+i+"]/td["+j+"]";
                WebElement cell = driver.findElement(By.xpath(cellXpath));
                System.out.print(" "+cell.getText());

            }
            System.out.println();
        }
    }

    private int getNumberOfColumns() {
        List<WebElement> columns = driver.findElements(By.xpath("//table[@border='1']/thead/tr/th"));
        return columns.size();
    }

    private int getNumberOfRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@border='1']/tbody/tr"));
        return rows.size();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

