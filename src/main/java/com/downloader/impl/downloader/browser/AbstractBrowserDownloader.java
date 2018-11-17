package com.downloader.impl.downloader.browser;

import com.downloader.base.downloader.AbstractDownloader;
import com.downloader.base.model.DownloaderRequest;
import com.downloader.base.model.DownloaderResponse;
import com.downloader.utils.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author: liukai
 * @time: 2018/11/17
 */
public class AbstractBrowserDownloader extends AbstractDownloader {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractBrowserDownloader.class);

    private ThreadLocal<WebDriver> webDriverThreadLocal;

    private static final String MAC = "mac";

    private static final String LINUX = "linux";

    public AbstractBrowserDownloader() {
        initWebDriver();
    }

    /**
     * 初始化webDrive
     */
    private void initWebDriver() {
        setDriverPath();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments("--allow-file-access-from-files");
        chromeOptions.addArguments("--disable-web-security");
        WebDriver webDriver = new ChromeDriver(chromeOptions);
        webDriverThreadLocal.set(webDriver);
    }

    private void setDriverPath() {
        String os = SystemUtils.system();
        String name = "";
        String path = this.getClass().getClassLoader().getResource("").getPath();
        if (os.contains(MAC)) {
            name = "chromedriver_mac";
        } else if (os.contains(LINUX)) {
            name = "chromedriver_linux";
        }
        path = path + name;
        System.setProperty("webdriver.chrome.drive", path);
    }

    public void close() {
        WebDriver webDriver = webDriverThreadLocal.get();
        webDriver.close();
        webDriver.quit();
    }

    @Override
    public DownloaderResponse downloadAsync(DownloaderRequest downloaderRequest) {
        return null;
    }

    @Override
    public DownloaderResponse downloadSync(DownloaderRequest downloaderRequest) {
        String url = downloaderRequest.getUrl();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        System.out.println(webDriver.getTitle());
        webDriver.close();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.quit();
        return null;
    }


    public static void main(String[] args) {
//        DownloaderRequest downloaderRequest = new DownloaderRequest();
//        downloaderRequest.setUrl("https://www.baidu.com");
//        SimpleDownloader simpleDownloader = new AbstractBrowserDownloader();
//        simpleDownloader.downloadSync(downloaderRequest);

        System.out.println(AbstractBrowserDownloader.class.getClassLoader().getResource("").getPath());
    }
}
