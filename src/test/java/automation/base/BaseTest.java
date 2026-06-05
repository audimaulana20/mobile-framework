package automation.base;

import automation.driver.AppManager;
import automation.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        System.out.println(
                "===== START TEST SUITE ====="
        );
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        DriverManager.createDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        AppManager.launchApp();
        initInstance();
    }

    protected void initInstance() {
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        AppManager.terminateApp();
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        DriverManager.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println(
                "===== FINISH TEST SUITE ====="
        );
    }
}