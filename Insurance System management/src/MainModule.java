import dao.InsuranceServiceImpl;
import entity.Policy;
import myexceptions.PolicyNotFoundException;

public class MainModule {
	
	public static void main(String[] args) {
        InsuranceServiceImpl insuranceService = new InsuranceServiceImpl();

        try {
            // Example usage: Attempt to get a policy with an invalid ID
            Policy policy = insuranceService.getPolicy(1000);
            if (policy == null) {
                throw new PolicyNotFoundException("Policy with ID 1000 not found.");
            }
        } catch (PolicyNotFoundException e) {
            System.out.println("PolicyNotFoundException caught: " + e.getMessage());
            // Handle the exception appropriately, e.g., display an error message to the user
        } catch (Exception ex) {
            System.out.println("Other exception caught: " + ex.getMessage());
            // Handle other exceptions if needed
        }
    }
}


