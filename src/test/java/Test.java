import io.github.bonigarcia.wdm.ChromeDriverManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test extends TestCase {

    private WebDriver drive;

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @Before
    public void setUp() throws Exception  {
        drive = new ChromeDriver();

        drive.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @org.junit.Test

    public void testOpenPage() throws Exception {
        this.drive.get("http://ngx42.mybluemix.net/app/orders");
        assertEquals("Home Page - Order Product", this.drive.getTitle());
    }

    @After
    public void tearDown() throws Exception {
        this.drive.quit();
    }
}
