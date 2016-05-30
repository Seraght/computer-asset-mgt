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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Seraght
 */
public class DeliverAsset {

    public static Map countAsset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int deliverID;
    private String deliverDate;
    private String deliverStatus;
    private String acceptDate;
    private int personID;
    private int computerID;
    private static final String SQL_CREATE_DELIVER = "insert into "
            + "deliver_asset(deliver_date, person_id, "
            + "computer_id) values (?,?,?)";
    private static final String SQL_UPDATE_STATUS = "update deliver_asset set "
            + "deliver_status=?, accept_date =? where deliver_id=?";
    private static final String SQL_SEARCH_ASSET_ID = "select * from "
            + "deliver_asset where deliver_id = ?";
    private static final String SQL_SEARCH_PERSON_ID = "select * from "
            + "deliver_asset where person_id = ?";
    private static final String SQL_COUNT_DELIVER = "select * from deliver_asset";

    public DeliverAsset() {

    }

    public DeliverAsset(int personID, int computerID) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.deliverDate = timeStamp;
        this.personID = personID;
        this.computerID = computerID;
    }

    public DeliverAsset(ResultSet rs) throws SQLException {
        this.deliverID = rs.getInt("DELIVER_ID");
        this.deliverDate = rs.getString("DELIVER_DATE");
        this.deliverStatus = rs.getString("DELIVER_STATUS");
        this.personID = rs.getInt("PERSON_ID");
        this.computerID = rs.getInt("COMPUTER_ID");
        this.acceptDate = rs.getString("ACCEPT_DATE");
    }

    public Boolean insertDeliverAsset(DeliverAsset deliverAsset) {
        Connection conn = null;
        PreparedStatement stm = null;
        DeliverAsset d = deliverAsset;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_CREATE_DELIVER);
            stm.setString(1, d.getDeliverDate());
            stm.setInt(2, d.getPersonID());
            stm.setInt(3, d.getComputerID());
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

    public Boolean updateDeliverStatus(int deliverID, String updateStatus, String acceptDate) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_STATUS);
            stm.setString(1, updateStatus);
            stm.setString(2, acceptDate);            
            stm.setInt(3, deliverID);
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


    public static DeliverAsset searchByComputer(int assetID) {
        DeliverAsset d = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_ASSET_ID);
            stm.setInt(1, assetID);
            rs = stm.executeQuery();
            if (rs.next()) {
                d = new DeliverAsset(rs);
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
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return d;
    }

    public static DeliverAsset searchByPerson(int personID) {
        DeliverAsset d = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_PERSON_ID);
            stm.setInt(1, personID);
            rs = stm.executeQuery();
            if (rs.next()) {
                d = new DeliverAsset(rs);
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
            try {
                rs.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return d;
    }
    
    public static Map countDeliver() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map m = new HashMap();
        int count_sum = 0;
        int count_deliver = 0;
        int count_accept = 0;
        String status = "WAITING";
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_COUNT_DELIVER);
            rs = stm.executeQuery();
            while (rs.next()) {
                count_sum++;
                if (rs.getString("ACCEPT_DATE") == null) {
                    count_deliver++;
                } else {
                    count_accept++;
                }
            }
            m.put("count_sum", count_sum);
            m.put("count_deliver", count_deliver);
            m.put("count_accept", count_accept);
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
        return m;
    }

    public int getDeliverID() {
        return deliverID;
    }

    public void setDeliverID(int deliverID) {
        this.deliverID = deliverID;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getComputerID() {
        return computerID;
    }

    public void setComputerID(int computerID) {
        this.computerID = computerID;
    }

}
