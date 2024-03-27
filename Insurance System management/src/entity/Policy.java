package entity;

public class Policy {
	
	
	private int policyId;
    private String policyName;

    public Policy() {
        // Default constructor
    }

    public Policy(int policyId, String policyName) {
        this.policyId = policyId;
        this.policyName = policyName;
    }

    // Getters and setters
    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyName='" + policyName + '\'' +
                '}';
        
        
        
    }
    public void printDetails() {
        System.out.println("Policy Details:");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Policy Name: " + policyName);
    }
}



