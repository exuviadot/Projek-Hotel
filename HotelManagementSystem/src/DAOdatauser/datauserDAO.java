/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatauser;
import java.sql.*;
import java.util.*;
import pj.connector;
import model.*;
import DAOImplement.datauserimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Bagaskara
 */
public class datauserDAO implements datauserimplement{
    Connection connection;
    
    final String login = "SELECT * FROM user WHERE username = ? AND password_user = ?";
    final String signup = "INSERT INTO user (username, email_user, password_user) VALUES (?, ?, ?);";
    
    private static final Logger LOGGER = Logger.getLogger(datauserDAO.class.getName());
    
    public datauserDAO(){
        connection = connector.connection();
    }
    
    @Override
    public void signup(dataUser user) {
        PreparedStatement statement = null;
        try{
                statement = connection.prepareStatement(signup, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail_user());
                statement.setString(3, user.getPassword_user());
                statement.executeUpdate();
                ResultSet rs = statement.getGeneratedKeys();
                while (rs.next()) {
                    user.setId_user(rs.getInt(1));

                }
            }catch(SQLException ex){
                ex.printStackTrace();
            }finally{
                try{
                    statement.close();
                }catch(SQLException ex){
                    ex.printStackTrace();
                }
            }
    }
    
    @Override
    public boolean login(dataUser user) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(login);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword_user());
            
            ResultSet rs = statement.executeQuery();
            return rs.next();
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void update(dataUser user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id_user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<dataUser> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
