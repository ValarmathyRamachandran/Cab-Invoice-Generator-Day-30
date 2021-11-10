package bridgelab.CabInvoiceGenerator;

public class CabInvoiceGenerator {

	private static final double COST_PER_KM = 10;
    private static final double COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    
    public double calculateFare(double distance, int time) {
    	double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }
    
    public double calculateFare(Ride[] rides) {
    	double totalFare = 0;
        for (Ride ride : rides) {
            totalFare = calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}
