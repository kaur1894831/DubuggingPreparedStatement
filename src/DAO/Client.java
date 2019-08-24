/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import oracle.jdbc.driver.OracleDriver;

/**
 *
 * @author 1897564
 */
public class Client {
    private Connection conn;
    private PreparedStatement statement;
    private String sql;

    public Client() {
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "sales", "anypw");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addClient(int clientID, String clientName, String clientPhone) {
        try {
            sql = "INSERT INTO CLIENT VALUES (?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, clientID);
            statement.setString(2, clientName);
            statement.setString(3, clientPhone);
            
            int i = statement.executeUpdate();
            if (i > 0)
                System.out.println("The records were successfully added to the system.");
            else
                System.out.println("There was some issue adding the records. Please try again.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void updateClient(int clientNum, String clientName) {
        try {
            String sql = "UPDATE CLIENT SET NAMECLIENT = ? "
                    + "WHERE NOCLIENT = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, clientName);
            statement.setInt(2, clientNum);
            
            int i = statement.executeUpdate();
            if (i > 0)
                System.out.println("The records were successfully updated to the system.");
            else
                System.out.println("There was some issue updating the records. Please try again.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deleteClient(int clientID) {
        try {
            sql = "DELETE FROM CLIENT "
                    + "WHERE NOCLIENT = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, clientID);
            
            int i = statement.executeUpdate();
            if (i > 0)
                System.out.println("The records were successfully deleted from the system.");
            else
                System.out.println("There was some issue deleting the records. Please try again.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void listClients() {
        try {
            sql = "SELECT * FROM CLIENT";
            statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int cID = rs.getInt(1);
                String clientName = rs.getString(2);
                String clientPhone = rs.getString(3);
                
                System.out.println("Client ID: " + cID + 
                        "\nClient Name: " + clientName + 
                        "\nClient Phone: " + clientPhone + 
                        "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void singleClients(int clientID) {
        try {
            sql = "SELECT * FROM CLIENT WHERE NOCLIENT = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, clientID);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int cID = rs.getInt(1);
                String clientName = rs.getString(2);
                String clientPhone = rs.getString(3);
                
                System.out.println("Client ID: " + cID + 
                        "\nClient Name: " + clientName + 
                        "\nClient Phone: " + clientPhone + 
                        "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
