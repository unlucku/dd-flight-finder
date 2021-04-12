import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class AirportReader implements AirportReaderInterface {

    /**
     * Takes data from either a StringReader or CSV file path and turns it into Airport objects
     * 
     * @param r the StringReader or CSV file path
     * @throws IOException if there is an error importing the data
     * @throws DataFormatException if the data format is invalid
     * @return a List of Airport objects
     */
    @Override
    public List<Airport> readDataSet(Reader r) throws IOException, DataFormatException {
        // String buffer to store later read String data
        StringBuffer data = new StringBuffer();

        // Reads data from Reader and appends it to StringBuffer
        int c = 0;
        while ((c = r.read()) != -1) {
            data.append((char) c);
        }

        // Array of Strings, with each index being a different row in the data
        String[] stringData = data.toString().split("\n");

        // Number of columns in the data
        int columnNums = stringData[0].split(",").length; 

        // List of Airport objects
        List<Airport> airports = new ArrayList<Airport>();

        // Creates a new Airport object for every row in the data
        for (int i = 1; i < stringData.length; i++) {
            // List of Strings, with each index being a different column in the data
            List<String> currentRow = parseAirportData(stringData[i]);

            // Throws a DataFormatException if there are too many or not enough columns
            if (currentRow.size() != columnNums) 
                throw new DataFormatException("Invalid number of columns.");
            
            // Otherwise, add a new Airport to the List of Airport objects
            airports.add(new Airport(
                currentRow.get(1), 
                currentRow.get(2), 
                Double.parseDouble(currentRow.get(5)),
                Double.parseDouble(currentRow.get(6)) 
            ));
        }

        
        return airports;
        
    }

    /**
     * Take a row from the data and turns it into a list where each index represents one column
     * 
     * @param row the row from the dataset to be parsed
     * @return a list where each index represents one column
     */
    @Override
    public List<String> parseAirportData(String row) {
        String[] stringData = row.split(",");
        List<String> stringDataToList = new ArrayList<String>();
        for(int i = 0; i < stringData.length; i++) {
			stringDataToList.add(String.valueOf(stringData[i]));
		}
		return stringDataToList;
    }

    public static void main(String[] args) {
        File pokemonData = new File(System.getProperty("user.dir") + "\\airports.csv");
        
		try {
            FileReader f = new FileReader(pokemonData);
            List<Airport> allAirports = new AirportReader().readDataSet(f);
            
            System.out.println(allAirports.get(0).findDistance(allAirports.get(1)));

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        catch (DataFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
