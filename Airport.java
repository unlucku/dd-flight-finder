public class Airport implements AirportInterface {
    private String name; // the name of the Airport
    private String city; // the city the Airport is located in
    private double longitude; // the longitude of the Airport
    private double latitude; // the latitude of the airport

    public Airport(String name, String city, double longitude, double latitude) {
        this.name = name;
        this.city= city;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public int findDistance(AirportInterface otherAirport) {
        double lon1 = longitude;
        double lat1 = latitude;
        double lon2 = otherAirport.getLongitude();
        double lat2 = otherAirport.getLatitude();

        if (lon1 == lon2 && lat1 == lat2) return 0;

        double lonDiff = lon1 = lon2;

        double dist = 
            Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1))
            * Math.cos(Math.toRadians(lat2))
            * Math.cos(Math.toRadians(lonDiff));

        dist = Math.toDegrees(Math.acos(dist)) ;
        
        return (int) Math.round(dist * 60 * 1.1515);

    }

    @Override
    public int findCost(AirportInterface otherAirport) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}