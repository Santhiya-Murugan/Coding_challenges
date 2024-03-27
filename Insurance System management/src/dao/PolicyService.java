package dao;

import entity.Policy;
import util.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class PolicyService implements IPolicyService {
    private static final String CREATE_POLICY_QUERY = "INSERT INTO policies (policy_id, policy_name) VALUES (?, ?)";
    private static final String GET_POLICY_QUERY = "SELECT * FROM policies WHERE policy_id = ?";
    private static final String GET_ALL_POLICIES_QUERY = "SELECT * FROM policies";
    private static final String UPDATE_POLICY_QUERY = "UPDATE policies SET policy_name = ? WHERE policy_id = ?";
    private static final String DELETE_POLICY_QUERY = "DELETE FROM policies WHERE policy_id = ?";

    @Override
    public boolean createPolicy(Policy policy) {
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_POLICY_QUERY)) {
            preparedStatement.setInt(1, policy.getPolicyId());
            preparedStatement.setString(2, policy.getPolicyName());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Policy getPolicy(int policyId) {
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_POLICY_QUERY)) {
            preparedStatement.setInt(1, policyId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Policy(resultSet.getInt("policy_id"), resultSet.getString("policy_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<Policy> getAllPolicies() {
        Collection<Policy> policies = new ArrayList<>();
        try (Connection connection = DBConnUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_POLICIES_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Policy policy = new Policy(resultSet.getInt("policy_id"), resultSet.getString("policy_name"));
                policies.add(policy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) {
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POLICY_QUERY)) {
            preparedStatement.setString(1, policy.getPolicyName());
            preparedStatement.setInt(2, policy.getPolicyId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePolicy(int policyId) {
        try (Connection connection = Dbconnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_POLICY_QUERY)) {
            preparedStatement.setInt(1, policyId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
