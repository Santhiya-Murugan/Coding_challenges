package mainmod;

import dao.InsuranceServiceImpl;
import entity.Policy;
import myexceptions.PolicyNotFoundException;

public class MainModule {
	
	
	 public static void main(String[] args) {
	        InsuranceServiceImpl insuranceService = new InsuranceServiceImpl();

	        // Trigger all the methods in the InsuranceServiceImpl class
	        try {
	            // Example 1: Create a new policy
	            Policy newPolicy = new Policy(1, "Policy A");
	            boolean created = insuranceService.createPolicy(newPolicy);
	            System.out.println("Policy created: " + created);

	            // Example 2: Get a policy by ID
	            Policy policyById = insuranceService.getPolicy(1);
	            if (policyById != null) {
	                System.out.println("Policy by ID: " + policyById);
	            } else {
	                System.out.println("Policy not found by ID.");
	            }

	            // Example 3: Update a policy
	            Policy updatedPolicy = new Policy(1, "Updated Policy A");
	            boolean updated = insuranceService.updatePolicy(updatedPolicy);
	            System.out.println("Policy updated: " + updated);

	            // Example 4: Delete a policy
	            boolean deleted = insuranceService.deletePolicy(1);
	            System.out.println("Policy deleted: " + deleted);

	            // Example 5: Triggering PolicyNotFoundException
	            Policy notFoundPolicy = insuranceService.getPolicy(1000);
	            if (notFoundPolicy == null) {
	                throw new PolicyNotFoundException("Policy with ID 1000 not found.");
	            }
	        } catch (PolicyNotFoundException e) {
	            System.out.println("PolicyNotFoundException caught: " + e.getMessage());
	        } catch (Exception ex) {
	            System.out.println("Other exception caught: " + ex.getMessage());
	        }
	    }
	}


