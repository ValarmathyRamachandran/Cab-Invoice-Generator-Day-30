package bridgelab.CabInvoiceGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CabInvoiceGeneratorTest {
	CabInvoiceGenerator cabInvoiceGenerator = null;
	
	@Before
		public void setUp() throws Exception {
		cabInvoiceGenerator = new CabInvoiceGenerator();
	}

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        
        double distance = 2.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare,0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinimumFare() {
        
        double distance = 0.1;
        int time = 1;
        double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5.0, totalFare,0);
    }
 
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary()  {
        Ride[] rides = {
        		new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary summary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
    
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFareFor_PremiumRide() {
        
        double distance = 2.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.calculateFareForPremiumRide(distance, time);
        Assert.assertEquals(40, totalFare,0);
    }
}
