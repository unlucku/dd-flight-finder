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
	public boolean tryInvalidOptionSelection() {
		try {
			Frontend.s = new Scanner(new ByteArrayInputStream("6".getBytes()));
			assertEquals(Frontend.getInput(), "invalid");
		}
		catch(Exception e) {
			assertEquals(false);
		}
	}

}
