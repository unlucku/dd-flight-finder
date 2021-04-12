import java.util.List;
import java.util.NoSuchElementException;

public interface AirportInterface {
    
    public String getName();

    public String getCity();

    public double getLongitude();

    public double getLatitude();

    public int findDistance(AirportInterface otherAirport);

    public void setAirports(List<Airport> airports);

    public List<Airport> getAirports() throws NoSuchElementException;
    
}







