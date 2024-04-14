package hooks;

import utils.UrlsConfig;
import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class WebHooks {

    UrlsConfig cfg = ConfigFactory.create(UrlsConfig.class);

    @BeforeAll
    public static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @BeforeEach
    @Step("Переход на сайт")
    public void authenticationProcess() {
//        System.setProperty("webdriver.chrome.driver", "/home/ubereak/IdeaProjects/CollectionOfVacancies/chromedriver");
//        Configuration.browser = Browsers.CHROME;
        open(cfg.baseUrl());
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    public void afterTest() {
        closeWebDriver();
    }
}

