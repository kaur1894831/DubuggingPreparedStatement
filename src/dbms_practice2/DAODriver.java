package dbms_practice2;

import DAO.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAODriver {
    public static void main(String[] args) {
        //new Client().deleteClient(500);
        new Client().singleClients(20);
    }
}
