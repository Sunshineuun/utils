package com.qiusm.utils.selenium;

import cn.hutool.core.thread.ThreadUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ResourceType;

import java.util.HashMap;
import java.util.Map;

/**
 * chrome 驱动地址下载 <a href="https://chromedriver.storage.googleapis.com/index.html">refernce</a> <br>
 *
 * @author qiushengming
 */
@Data
@Slf4j
public class ChromeWebDriverClient {
    final static String WEBDRIVER_CHROME_DRIVER = "/Users/qiushengming/Documents/tool/chromedriver/99.0.4844.51/chromedriver";
    private ChromeDriver driver;
    private boolean lock = false;
    private Integer clientId;
    private String webdriver;

    public ChromeWebDriverClient(Integer clientId) {
        this.clientId = clientId;
        this.webdriver = WEBDRIVER_CHROME_DRIVER;
        init();

    }

    public ChromeWebDriverClient(Integer clientId, String webdriver) {
        this.clientId = clientId;
        this.webdriver = webdriver;
        init();
    }

    public void getUrl(String url) {
        driver.get(url);
        lock = true;
        long timeout = 10000;
        while (lock) {
            timeout -= 500;
            ThreadUtil.sleep(500);
            if (timeout <= 0) {
                log.info("失败的请求：url:{}", url);
                lock = false;
            }
        }
    }

    public boolean isLock() {
        return lock;
    }

/*    public void interceptResponse4Xhr(DevTools devTools, String pattern, InterceptCallback<String> callback) {
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (ResourceType.XHR != responseReceived.getType()) {
                return;
            }
            String body = devTools.send((Network.getResponseBody(responseReceived.getRequestId()))).getBody();
            callback.emit(body);
        });
    }*/

    public Integer getClientId() {
        return this.clientId;
    }

    public void quit() {
        this.driver.quit();
    }

    private void init() {
        //配置浏览器驱动地址
        System.setProperty("webdriver.chrome.driver", this.webdriver);
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--user-agent=iPhone XR");
        Map<String, String> mobileEmulation = new HashMap<>();
        // iPhone 6 / iPhone X
        mobileEmulation.put("deviceName", "iPhone X");
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.addArguments("-headless");
        driver = new ChromeDriver(options);
        Dimension dimension = new Dimension(414, 896);
        driver.manage().window().setSize(dimension);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
        // 请求拦截监听设置，主要是为了监听是否将富文本数据发送到【community/review/push】接口上了
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            if (ResourceType.XHR != responseReceived.getType()) {
                return;
            }
            log.info("{}", responseReceived.getResponse().getUrl());
            if (StringUtils.contains(responseReceived.getResponse().getUrl(), "community/review/push")) {
                lock = false;
            }
        });
    }
}
