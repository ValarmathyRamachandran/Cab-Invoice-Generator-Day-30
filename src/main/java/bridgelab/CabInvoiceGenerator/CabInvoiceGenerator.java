package bridgelab.CabInvoiceGenerator;

public class CabInvoiceGenerator {

	private static final double NORMAL_RIDE_COST_PER_KM = 10;
    private static final double NORMAL_RIDE_COST_PER_MINUTE = 1;
    private static final double NORMAL_RIDE_MINIMUM_FARE = 5;
    private static final double PREMIUM_RIDE_COST_PER_KM = 15;
    private static final double PREMIUM_RIDE_COST_PER_MINUTE = 2;
    private static final double PREMIUM_RIDE_MINIMUM_FARE = 20;
    
    
    
    public double calculateFare(double distance, int time) {
    	double totalFare = distance * NORMAL_RIDE_COST_PER_KM + time * NORMAL_RIDE_COST_PER_MINUTE;
        return Math.max(totalFare, NORMAL_RIDE_MINIMUM_FARE);
    }
    
    public double calculateFareForPremiumRide(double distance, int time) {
    	double totalFare = distance * PREMIUM_RIDE_COST_PER_KM + time * PREMIUM_RIDE_COST_PER_MINUTE;
        return Math.max(totalFare, PREMIUM_RIDE_MINIMUM_FARE);
    }
    
    public InvoiceSummary calculateFare(Ride[] rides) {
    	double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
}
