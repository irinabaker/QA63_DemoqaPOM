package com.demoqa.core;

import com.demoqa.utils.MyTestWatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MyTestWatcher.class)
public class TestBase {

    protected WebDriver driver;
    public  static Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser","chrome"));

    @BeforeEach
    public void init(TestInfo testInfo) {
        driver = app.startTest();
        logger.info("Start test {}",testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown() {
        app.stopTest();
        logger.info("Stop test");
        logger.info("****************************************");
    }

}
