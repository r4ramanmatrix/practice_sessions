package selenium_training;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.lse.qa.base.TestBase;

public class Using_TestBase extends TestBase {

	public Using_TestBase() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
	}

	@Test
	public void test_01() {

	}

	@AfterClass
	public void tearDown() {

	}

}
