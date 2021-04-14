import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

//--== CS400 File Header Information ==--
//Name: Maaz Amin
//Email: mamin6@wisc.edu
//Team: DD Red
//Role: Frontend Developer
//TA: Dan
//Lecturer: Gary
//Notes to Grader: N/A

/**
 * Frontend tests class to use for junit tests
 */
public class FrontendTests {

	/**
	 * This test makes sure that invalid input validation is handled
	 * properly when selecting an option
	 *
	 */
	public void tryInvalidOptionSelection() {
		try {
			Frontend.s = new Scanner(new ByteArrayInputStream("6".getBytes()));
			assertEquals(Frontend.getInput(), "invalid");

			Frontend.s = new Scanner(new ByteArrayInputStream("0".getBytes()));
			assertEquals(Frontend.getInput(), "valid");
		}
		catch(Exception e) {
			fail("Exception occurred");
		}

	}

	/**
	 * This test makes the user enter an airport
	 * and checks to see if the right one is returned, and also checks to see
	 * if that the input validation is handled properly
	 */
	public void testProcessCityEntry() {
		try {
			Frontend.s = new Scanner(new ByteArrayInputStream("ATL".getBytes()));
			asserEquals(Frontend.processCityEntry().getName(), "ATL");

			Frontend.s = new Scanner(new ByteArrayInputStream("0\nANC".getBytes()));
			asserEquals(Frontend.getInput(), "ANC");
		}
		catch(Exception e) {
			fail("Exception occurred");
		}

	}

	/**
	 * This test makes the user enter two airports
	 * and then calls the backend method to see
	 * if the flight between them is available
	 */
	public void testProcessCityEntry() {
		try {
			Frontend.s = new Scanner(new ByteArrayInputStream("ATL\nBNA".getBytes()));
			asserEquals(Frontend.processInStock(), true);

			Frontend.s = new Scanner(new ByteArrayInputStream("DEN\nANC".getBytes()));
			asserEquals(Frontend.processInStock(), true);
		}
		catch(Exception e) {
			fail("Exception occurred");
		}

	}
}
