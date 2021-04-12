


public interface AirportInterface {
    
    public String getName();

    public String getCity();

    public double getLongitude();

    public double getLatitude();

    public int findDistance(AirportInterface otherAirport);

    public int findCost(AirportInterface otherAirport);
    
}







