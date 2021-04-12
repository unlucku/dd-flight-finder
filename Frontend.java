// --== CS400 File Header Information ==--
// Name: Maaz Amin
// Email: mamin6@wisc.edu
// Team: DD Red
// Role: Frontend Developer
// TA: Dan
// Lecturer: Gary
// Notes to Grader: N/A

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;



public class Frontend {
	public static Backend backendObject;
	public static Scanner s;
	public static String[] validOptions = {
			"Get the shortest path from your city to another",
			"Get the cheapest path from your city to another",
			"Get the availibility to see which flights are available between an origin and a destination",
			"Get a multi stop vacation",
			"Exit the program"
	};
	public static void main(String[] args) {
		try {
			System.out.println("<===> Welcome To The Flight Finder Application <===>");
			System.out.println("Please wait while we fetch different flights and related information...");
			backendObject = new Backend();
			s = new Scanner(System.in);
			System.out.println("Successfully loaded flights into the program... Starting input loop");
			System.out.println();
			System.out.println("We will now print a list of airports that are supported. Please note you will need this list to enter your airport. (It is not case sensitive)");
			sleep(1000);
			//backend.getListOfCities();
			System.out.println();
			programLoop();
		}
		catch(Exception e) {

			System.out.println();
			logError(e);
		}
	}
	public static void programLoop() {
		while(true) {
			getInput();
			System.out.println();
		}
	}
	public static String getInput() {
		System.out.println("Please choose one of the following options (Enter the number corresponding to your selection): ");
		for (int i = 0; i < validOptions.length; i++) {
			System.out.println((i+1) + ". " + validOptions[i]);
		}
		String response = s.nextLine();
		if (response.equals("0")) {
			processShortest();
		}
		else if (response.equals("1")) {
			processCheapest();
		}
		else if (response.equals("2")) {
			processInStock();
		}
		else if (response.equals("3")) {
			processMultiStop();
		}
		else if (response.equals("4")) {
			processExit();
		}
		else {
			System.out.println("Invalid input! Please try again.");
			return "invalid";
		}
		return "good";
	}


	public static void processExit() {
		System.out.println("Thank you for using flight finder. Good bye!");
		System.exit(0);
	}

	public static void processInStock() {
		Airport starting = processCityEntry(true);
		Airport ending = processCityEntry(false);
		//System.out.println(backend.);
	}

	public static void processCheapest() {
		Airport starting = processCityEntry(true);
		Airport ending = processCityEntry(false);
		//System.out.println(backend.);
	}

	public static void processShortest() {
		Airport starting = processCityEntry(true);
		Airport ending = processCityEntry(false);
		//System.out.println(backend.);
	}
	public static void processMultiStop() {
		Airport starting = processCityEntry(true);
		Airport ending = processCityEntry(false);
		//System.out.println(backend.);
	}

	public static Airport processCityEntry(boolean start)  {
		System.out.println("Please enter your " + (start ? "Starting " : "Ending ") + "destination below.");
		String response = s.nextLine();
		/**	Airport airport = backend.getCityByName(response);
		if (airport == null) {
			System.out.println("Invalid input! Please try again.");
			return processCityEntry(start);
		}

		 *

		return airport*/
		return null;
	}
	public static void logError(Exception e) {
		if (e.getLocalizedMessage() != null) {
			System.out.println("The application encountered an error: " + e.getLocalizedMessage());
		}
		else {
			System.out.println("The application encountered a null pointer exception...");
		}
		System.out.println();
		System.out.println("Type 1 if you would like to view the error stack trace, type anything else to exit!");
		String response = s.nextLine();
		try {
			int value = Integer.parseInt(response);
			if (value == 1) {
				System.out.println("Stack trace is below: ");
				System.out.println(errorToLog(e));
			}
		}
		catch(Exception e1) {
		}
		System.out.println("Program now exiting due to errored state...");
		s.close();
		System.exit(0);
	}
	public static String errorToLog(Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
	public static class Backend {

	}
	public static void sleep(long t) {
		try {
			Thread.sleep(t);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
