/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seraght
 */
public class Person {

    private int officerID;
    private String officerNumber;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int roleID;
    private int hasAsset;

    private static final String SQL_SEARCH_ID = "SELECT * FROM PERSON WHERE "
            + "PERSON_ID = ?";
    private static final String SQL_SEARCH_AUTHEN = "SELECT * FROM PERSON WHERE "
            + "USERNAME = ? AND PASSWORD = ?";
    private static final String SQL_SEARCH_BY_STATUS = "SELECT * FROM person WHERE "
            + "has_asset like ? and role_id = 1";
    private static final String SQL_SEARCH_ALL = "SELECT * FROM PERSON where has_asset = 0 and role_id = 1";
    private static final String SQL_UPDATE_ASSET = "update person set "
            + "has_asset=? where person_id=?";

    public static Person searchPerson(int id) {
        Person p = null;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_ID);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p = new Person(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return p;
    }

    public static Person authenLogin(String username, String password) {
        Person p = null;
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_AUTHEN);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p = new Person(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return p;

    }
    
    public Person() {
        
    }

    public Person(ResultSet rs) throws SQLException {
        this.officerID = rs.getInt("PERSON_ID");
        this.officerNumber = rs.getString("PERSON_NUMBER");
        this.firstName = rs.getString("FIRSTNAME");
        this.lastName = rs.getString("LASTNAME");
        this.username = rs.getString("USERNAME");
        this.password = rs.getString("PASSWORD");
        this.roleID = rs.getInt("ROLE_ID");
        this.hasAsset = rs.getInt("HAS_ASSET");
    }

    public int getOfficerID() {
        return officerID;
    }

    public String getOfficerNumber() {
        return officerNumber;
    }

    public void setOfficerNumber(String officerNumber) {
        this.officerNumber = officerNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHasAsset() {
        return hasAsset;
    }

    public void setHasAsset(int hasAsset) {
        this.hasAsset = hasAsset;
    }

    public static List<Person> searchByStatus(int status) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        int search = status;
        List<Person> matchingPersons = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_BY_STATUS);
            if (search == 1 || search == 0) {
                stm.setInt(1, search);
            } else {
                stm.setString(1, "%");
            }
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingPersons == null) {
                    matchingPersons = new ArrayList<>();
                }
                matchingPersons.add(new Person(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                stm.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return matchingPersons;
    }

    public static List<Person> searchAllPerson() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Person> matchingPersons = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingPersons == null) {
                    matchingPersons = new ArrayList<>();
                }
                matchingPersons.add(new Person(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                stm.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return matchingPersons;
    }

    public boolean updateAsset(int status, int assetID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_ASSET);
            stm.setInt(1, status);
            stm.setInt(2, assetID);
            stm.executeUpdate();
            result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                stm.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                conn.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return result;
    }

}
