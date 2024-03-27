package dao;

import entity.Policy;
import java.util.ArrayList;
import java.util.Collection;


public class InsuranceServiceImpl implements IPolicyService {
	
	private Collection<Policy> policies;

    public InsuranceServiceImpl() {
        this.policies = new ArrayList<>();
    }

    @Override
    public boolean createPolicy(Policy policy) {
        return policies.add(policy);
    }

    @Override
    public Policy getPolicy(int policyId) {
        for (Policy policy : policies) {
            if (policy.getPolicyId() == policyId) {
                return policy;
            }
        }
        return null; // Policy not found
    }

    @Override
    public Collection<Policy> getAllPolicies() {
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        for (Policy p : policies) {
            if (p.getPolicyId() == policy.getPolicyId()) {
                p.setPolicyName(policy.getPolicyName());
                // Update other fields as needed
                return true;
            }
        }
        return false; // Policy not found
    }

    @Override
    public boolean deletePolicy(int policyId) {
        Policy policyToRemove = null;
        for (Policy policy : policies) {
            if (policy.getPolicyId() == policyId) {
                policyToRemove = policy;
                break;
            }
        }
        if (policyToRemove != null) {
            policies.remove(policyToRemove);
            return true;
        }
        return false; // Policy not found
    }
}
	
	
	


