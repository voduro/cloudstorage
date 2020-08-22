package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static java.lang.Thread.sleep;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CloudStorageApplicationTests {
	@LocalServerPort
	private int port;
	private String baseURL = "http://localhost:";

	private WebDriver driver;

	String username = "onepunchman83";
	String password = "onepunch";

	@BeforeAll
	static void beforeAll() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public void beforeEach() {
		this.driver = new ChromeDriver();
	}

	@AfterEach
	public void afterEach() {
		if (this.driver != null) {
			driver.quit();
		}
	}

	@Test
	@Order(1)
	public void getLoginPage() {
		driver.get(baseURL + port + "/login");

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		WebElement loginMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		Assertions.assertEquals("Login", driver.getTitle());
	}

	@Test
	@Order(2)
	public void testHomePageNotAccessible() {
		driver.get(baseURL + port + "/Home");
		Assertions.assertEquals("Login", driver.getTitle());
	}
	@Test
	@Order(3)
	public void testUserSignupLoginAndSubmit() {

		WebDriverWait wait = new WebDriverWait(driver, 1000);

		driver.get(baseURL + port + "/signup");

		WebElement signupMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup("Saitama", "Hero", username, password);

		driver.get(baseURL + port + "/login");

		WebElement loginMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

//		assertEquals(username, sentMessage.getUsername());
//		assertEquals(messageText, sentMessage.getMessageText());
	}

	@Test
	@Order(4)
	public void testUserLoginAndLogout() {

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		driver.get(baseURL + port + "/login");

		WebElement loginMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		loginMarker = null;
		WebElement homeMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		HomePage homePage = new HomePage(driver);

		WebElement logoutBtn = wait.until(webDriver -> webDriver.findElement(By.name("logoutBtn")));
		homePage.logout();
		loginMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));
		Assertions.assertEquals("Login", driver.getTitle());

		testHomePageNotAccessible();
	}

	@Test
	@Order(5)
	public void testAddEditDelNote() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		driver.get(baseURL + port + "/login");

		WebElement loginMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		WebElement homeMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		HomePage homePage = new HomePage(driver);
		homePage.navNotes();
		sleep(3000);

		NotesTabPage notesTabPage = new NotesTabPage(driver);
//		 homePage = notesTabPage.navNotes(driver);

		sleep(3000);
		notesTabPage.createNote("Test Note", "Test Description");
//
		homePage.navNotes();
		sleep(3000);
		notesTabPage.editNote("Editied Test Note", "Edited Test Description");

		homePage.navNotes();
		sleep(3000);
		notesTabPage.deleteNote();


	}

	@Test
	@Order(6)
	public void testAddEditDelCredentials() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 1000);
		driver.get(baseURL + port + "/login");

		WebElement loginMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		Assertions.assertEquals("Home", driver.getTitle());

		WebElement homeMarker = wait.until(webDriver -> webDriver.findElement(By.tagName("title")));

		HomePage homePage = new HomePage(driver);
		homePage.navCredentials();

		CredTabPage credTabPage = new CredTabPage(driver);

		sleep(3000);
		credTabPage.createCredential("credential", "opm", "Zcity");

		homePage.navCredentials();
		sleep(3000);
		credTabPage.editCrednetial("credential-edit", "opm-edit", "Zcity-edit");


		homePage.navCredentials();
		sleep(3000);
		credTabPage.deleteCredntial();


	}
//
//	@Test
//	@Order(1)
//	public void testSignUpLoginFlow() throws InterruptedException {
//		// Write a Selenium test that verifies that the home page is not accessible without logging in.
//		driver.get("http://localhost:" + this.port + "/home");
//		Assertions.assertEquals("Login", driver.getTitle());
//
//		//Write a Selenium test that signs up a new user
//		driver.get("http://localhost:" + this.port + "/signup");
//		SignUpPage signUpPage = new SignUpPage(driver);
//		signUpPage.SignUpUser("Saitama", "Man", "onePunchMan", "onePunch");
//		Assertions.assertEquals("Login", driver.getTitle());
//
//		//  logs that user in, verifies that they can access the home page
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.loginValidUser("onePunchMan", "onePunch");
//		Assertions.assertEquals("Home", driver.getTitle());
//
//		//then logs out...
//		HomePage homePage = new HomePage(driver);
//		homePage.getLogout();
//		Assertions.assertEquals("Login", driver.getTitle());
//
//		//  ...and verifies that the home page is no longer accessible.
//		driver.get("http://localhost:" + this.port + "/home");
//		Assertions.assertEquals("Login", driver.getTitle());
//	}
//
//	@Test
//	@Order(2)
//	public void testAddEditDelNotes() throws InterruptedException {
//		// Write a Selenium test that logs in an existing use
//		driver.get("http://localhost:" + this.port + "/login");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.loginValidUser("onePunchMan", "onePunch");
//		Assertions.assertEquals("Home", driver.getTitle());
//
//		HomePage homePage = new HomePage(driver);
//		homePage.navNotes();
//		homePage.createNote("Test Note.", "This is the test description.");
//		driver.get("http://localhost:" + this.port + "/home");
//
//
//
//	}
//
//	@Test
//	@Order(3)
//	public void testAddEditDelCred() throws InterruptedException {
//		// Write a Selenium test that logs in an existing use
//		driver.get("http://localhost:" + this.port + "/login");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.loginValidUser("onePunchMan", "onePunch");
//		Assertions.assertEquals("Home", driver.getTitle());
//
//		HomePage homePage = new HomePage(driver);
//		homePage.navCredentials();
//		homePage.createCredentials("www.opm.com", "onepunchman", "onePUUUUUUUNCH");
//		driver.get("http://localhost:" + this.port + "/home");
//
//
//
//	}



//	@Test
//	public void loginValidUser() {
//		driver.get("http://localhost:" + this.port + "/login");
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.loginValidUser( "onePunchMan", "onePunch"  );
//		Assertions.assertEquals("Home", driver.getTitle());
//	}



//	@Test
//	public void testLogin() {
//		SignUpPage signUnPage = new SignUpPage(driver);
////        HomePage homePage = signInPage.loginValidUser("userName", "password");
////        assertThat(homePage.getMessageText(), is("Hello userName"));
//	}

}
