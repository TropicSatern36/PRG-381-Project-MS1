/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author tropicsatern36
 */

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {
    Connection connect() throws SQLException;
    public void disconnect() throws SQLException;
    boolean isConnected() throws SQLException;
    
}
