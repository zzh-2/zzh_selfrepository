package xonecms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.BrowserUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RetrieveCell {
    public static WebDriver driver;

    @DataProvider(name = "cells")
    public static Object[][] word() throws IOException {
        //return  new Object[][]{{"2223","18219112223"}}
        return getTestData("C:\\test\\cellNum.csv");
    }

    @Test(dataProvider="cells")
    public void login(String cell , String result) throws InterruptedException {
        //打开浏览器
        driver.manage().window().maximize();
        driver.get("http://192.168.7.91:9529/#/login");

        //登录后台管理系统
        driver.findElement(By.xpath("/html/body/div/div/div[1]/form/div[2]/div/div[1]/input")).sendKeys("17612018006");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/form/div[3]/div/div[1]/input")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/form/div[4]/div/div[2]/button")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[1]/form/div[4]/div/div[1]/div/input")).sendKeys("666666");
        driver.findElement(By.xpath("/html/body/div/div/div[1]/form/button")).click();

        Thread.sleep(3000);

        //根据手机号搜索
        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div")).click();
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[1]/a/li")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/section/div/div[1]/div/div[3]/div/input")).sendKeys(cell);
        driver.findElement(By.className("el-icon-search")).click();
        Thread.sleep(2000);

        //是否查出来了对应手机号的订单
        String cellNum = driver
                .findElement(By.xpath("/html/body/div/div/div[2]/section/div/div[2]/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div"))
                .getText();
        //Assert.assertEquals(cellNum,result);
        Assert.assertTrue(driver.getPageSource().contains(result));
        Thread.sleep(60000);
    }

    public static Object[][] getTestData(String filePath) throws IOException {
        List<Object[]> tempData = new ArrayList<Object[]>();
        String cell;

        //将CSV文件的内容放入ArrayList中
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));

        //循环读取CSV文件里每一行的值并放入集合中
        while((cell = file.readLine()) != null){
            String fields[] = cell.split(",");
            tempData.add(fields);
        }


        Object[][] testData = new Object[tempData.size()][];

        for(int i=0; i<tempData.size(); i++){
            testData[i] = tempData.get(i);
        }
        return testData;
    }

    @BeforeMethod
    public void startDriver(){
        BrowserUtils bu = new BrowserUtils();
        driver = bu.openBrowser("Chrome");
    }

    @AfterMethod
    public void closeDriver(){
        driver.close();
    }
}
