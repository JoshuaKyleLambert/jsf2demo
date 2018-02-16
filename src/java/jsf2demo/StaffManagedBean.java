/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf2demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Joshu
 */
@Named(value = "staffManagedBeanx")
@ApplicationScoped
public class StaffManagedBean {

    private String idNumber;
    private String lastName;
    private String firstName;
    private String mi;
    private String address;
    private String city;
    private String state;
    private String telephone;
    private String email;
    //private String go;
    private String error;

    private ResultSet rset;

    private PreparedStatement selectStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;

    /**
     * Creates a new instance of StaffManagedBean
     */
    public StaffManagedBean() {
        initializeDB();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public String getGo() {
//        return go;
//    }
//    public void setGo(String go) {
//        this.go = go;
//        switch (go) {
//            case "View":
//                viewRecord();
//                break;
//            case "Update":
//                updateRecord();
//                break;
//            case "Clear":
//                clear();
//                break;
//            case "Insert":
//                insertRecord();
//                break;
//            default:
//                break;
//        }
//    }
    public void clear() {
        idNumber = lastName = firstName = mi = address = city = state = telephone = email = error = "";
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private void initializeDB() {

        try {
            //Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");

            //Establish a connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
            System.out.println("Database connected");

            String selectString = "SELECT  lastName, mi, firstName, address, city, "
                    + " state, telephone, email, id FROM Staff WHERE Staff.id = ?";

            String insertString = "INSERT INTO Staff (id, lastName, firstName, mi,"
                    + " address, city, state, telephone, email)"
                    + " VALUES (?,?,?,?,?,?,?,?,?)";

            String updateString = "UPDATE Staff SET "
                    + "id=?, lastName=?, mi=?, firstName=?, address=?, city=?, state=?,"
                    + "telephone=?, email=? WHERE id=?";

            selectStatement = connection.prepareStatement(selectString);
            insertStatement = connection.prepareStatement(insertString);
            updateStatement = connection.prepareStatement(updateString);

        } catch (ClassNotFoundException | SQLException ex) {
            setError(ex.getMessage());
        }

    }

    public void insert() {

        try {

            if (idNumber.contains(" ") || idNumber.equals("")) {
                throw new SQLException("ID must not be left blank or contain spaces!");
            }

            insertStatement.setString(1, idNumber);
            insertStatement.setString(2, lastName);
            insertStatement.setString(3, firstName);
            insertStatement.setString(4, mi);
            insertStatement.setString(5, address);
            insertStatement.setString(6, city);
            insertStatement.setString(7, state);
            insertStatement.setString(8, telephone);
            insertStatement.setString(9, email);
            insertStatement.execute();

            setError("Record ID: " + idNumber + " insert success!");

        } catch (SQLException ex) {

            setError(ex.getMessage());
        }

    }

    public void update() {

        try {
            if (idNumber.contains(" ") || idNumber.equals("")) {
                throw new SQLException("ID must not be left blank or contain spaces!");
            }

            updateStatement.setString(1, idNumber);
            //ResultSet rset = updateStatement.executeQuery();

            //if (rset.next()) {
            updateStatement.setString(1, idNumber);
            updateStatement.setString(2, lastName);
            updateStatement.setString(3, mi);
            updateStatement.setString(4, firstName);
            updateStatement.setString(5, address);
            updateStatement.setString(6, city);
            updateStatement.setString(7, state);
            updateStatement.setString(8, telephone);
            updateStatement.setString(9, email);
            updateStatement.setString(10, idNumber);
            updateStatement.execute();

            setError("ID: " + idNumber + " update success.");
            // } else {
        } catch (SQLException ex) {
            setError(ex.getMessage());
            //}
        }
    }

    public void view() {
        String id = idNumber;
        try {
            if (id.contains(" ") || id.equals("")) {
                setError("ID must not be blank or contain spaces.");

            }

            selectStatement.setString(1, id);
            rset = selectStatement.executeQuery();

            if (rset.next()) {
                lastName = rset.getString(1);
                mi = rset.getString(2);
                firstName = rset.getString(3);
                address = rset.getString(4);
                city = rset.getString(5);
                state = rset.getString(6);
                telephone = rset.getString(7);
                email = rset.getString(8);

            }

        } catch (SQLException ex) {
            setError(ex.getMessage());
        }

    }

}
