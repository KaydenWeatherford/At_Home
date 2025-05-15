package com.kiki.ChatGPT;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ChatGPTChromeScraper {

    private static final String COOKIES_FILE_PATH = "cookies.data";

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        // Add user data dir and profile directory if needed
        options.addArguments("user-data-dir=C:/Users/KiKiTheProto/AppData/Local/Google/Chrome/User Data");
        options.addArguments("profile-directory=Default");

        WebDriver driver = new ChromeDriver(options);  // This line launches the browser window
        System.out.println("Browser started");
        try {
            driver.get("https://chat.openai.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Try to load cookies if exists to skip login
            File cookieFile = new File(COOKIES_FILE_PATH);
            if (cookieFile.exists()) {
                Set<Cookie> cookies = loadCookiesFromFile(COOKIES_FILE_PATH);
                for (Cookie cookie : cookies) {
                    driver.manage().addCookie(cookie);
                }
                driver.navigate().refresh();
                System.out.println("Loaded cookies and refreshed the page.");
            } else {
                // No cookies saved, do manual login

                // Wait for email input to appear and enter email
                WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
                // You might need to adjust selector here, check actual element name or id
                emailInput.sendKeys(System.getenv("CHATGPT_EMAIL")); // set this env variable

                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
                nextButton.click();

                // Wait for password input and enter password
                WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
                passwordInput.sendKeys(System.getenv("CHATGPT_PASSWORD")); // set this env variable

                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
                loginButton.click();

                // Wait for the main chat page to load - this selector is for chat container
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.markdown.prose")));

                // Save cookies to reuse next time
                saveCookiesToFile(driver.manage().getCookies(), COOKIES_FILE_PATH);
                System.out.println("Logged in and saved cookies.");
            }

            // Now scrape the latest response
            List<WebElement> responses = driver.findElements(By.cssSelector("div.markdown.prose"));
            if (responses.size() > 0) {
                System.out.println("Latest GPT response:\n" + responses.get(responses.size() - 1).getText());
            } else {
                System.out.println("No responses found.");
            }

        } finally {
            driver.quit();
        }
    }

    private static void saveCookiesToFile(Set<Cookie> cookies, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(cookies);
        }
    }

    @SuppressWarnings("unchecked")
    private static Set<Cookie> loadCookiesFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Set<Cookie>) ois.readObject();
        }
    }
}