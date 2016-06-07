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
    private Person p;
    private Computer c;
    private ComputerSpec cp;

    private static final String SQL_CREATE_DELIVER = "insert into "
            + "deliver_asset(deliver_date, person_id, "
            + "asset_year,asset_get,asset_number,asset_type) values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE_DELIVER_STATUS = "update deliver_asset set "
            + "deliver_status=?, accept_date =? where deliver_id=?";
    private static final String SQL_UPDATE_STATUS = "update deliver_asset "
            + "set deliver_status = ? where deliver_id = ?";
    private static final String SQL_SEARCH_ASSET_ID = "select * from deliver_asset da, "
            + "person p, asset a where p.person_id = da.person_id and "
            + "a.asset_year = da.asset_year and a.asset_get = da.asset_get and "
            + "a.asset_number = da.asset_number and a.type_id = da.asset_type and "
            + "deliver_status <> 'Cancel' and da.asset_year = ? and da.asset_get = ? "
            + "and da.asset_number = ? and da.asset_type = ?";
    private static final String SQL_SEARCH_PERSON_ID = "select * from deliver_asset da, "
            + "person p, asset a where p.person_id = da.person_id and "
            + "a.asset_year = da.asset_year and a.asset_get = da.asset_get and "
            + "a.asset_number = da.asset_number and a.type_id = da.asset_type and "
            + "deliver_status <> 'Cancel' and da.person_id = ? order by "
            + "a.type_id, a.type_id, a.asset_get,a.asset_number";
    private static final String SQL_SEARCH_RECIEVE = "select * from deliver_asset da, "
            + "person p, asset a where p.person_id = da.person_id and "
            + "a.asset_year = da.asset_year and a.asset_get = da.asset_get and "
            + "a.asset_number = da.asset_number and a.type_id = da.asset_type and "
            + "deliver_status = 'Deliver' and da.person_id = ? order by "
            + "a.type_id, a.type_id, a.asset_get,a.asset_number";
    private static final String SQL_SEARCH_BY_FOREIGN_KEY = "select * from "
            + "deliver_asset where person_id = ? and asset_year = ? and asset_get = ? "
            + "and asset_number = ? and asset_type = ?";
    private static final String SQL_COUNT_DELIVER = "select * from deliver_asset";

    public DeliverAsset() {

    }

    public DeliverAsset(int personID, String assetYear, int assetGet, String assetNumber, int assetType) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.deliverDate = timeStamp;
        p = new Person();
        p.setOfficerID(personID);
        c = new Computer();
        c.setAssetYear(assetYear);
        c.setAssetGet(assetGet);
        c.setAssetNumber(assetNumber);
        c.setTypeID(assetType);
    }

    public DeliverAsset(ResultSet rs) throws SQLException {
        this.deliverID = rs.getInt("DELIVER_ID");
        this.deliverDate = rs.getString("DELIVER_DATE");
        this.deliverStatus = rs.getString("DELIVER_STATUS");
        this.acceptDate = rs.getString("ACCEPT_DATE");
        p = new Person();
        p.setOfficerID(rs.getInt("person_id"));
        p.setFirstName(rs.getString("firstname"));
        p.setLastName(rs.getString("lastname"));
        c = new Computer();
        c.setAssetYear(rs.getString("asset_year"));
        c.setAssetGet(rs.getInt("asset_get"));
        c.setAssetNumber(rs.getString("asset_number"));
        c.setTypeID(rs.getInt("asset_type"));
        Map properties = new HashMap();
        properties.put("model", rs.getString("model"));
        properties.put("brand", rs.getString("brand"));
        cp = new ComputerSpec(properties);
        c.setSpec(cp);
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
            stm.setInt(2, d.getP().getOfficerID());
            stm.setString(3, d.getC().getAssetYear());
            stm.setInt(4, d.getC().getAssetGet());
            stm.setString(5, d.getC().getAssetNumber());
            stm.setInt(6, d.getC().getTypeID());
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
            stm = conn.prepareStatement(SQL_UPDATE_DELIVER_STATUS);
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
    
    public Boolean updateStatus(String updateStatus, int deliverID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_STATUS);
            stm.setString(1, updateStatus);
            stm.setInt(2, deliverID);
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
    
    public Boolean receiveDeliver(String updateStatus, int deliverID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_STATUS);
            stm.setString(1, updateStatus);
            stm.setInt(2, deliverID);
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

    public static DeliverAsset searchByComputer(String assetYear, int assetGet, String assetNumber, int assetType) {
        DeliverAsset d = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_ASSET_ID);
            stm.setString(1, assetYear);
            stm.setInt(2, assetGet);
            stm.setString(3, assetNumber);
            stm.setInt(4, assetType);
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
    
    public static DeliverAsset searchByReceiveStatus(int personID) {
        DeliverAsset d = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_RECIEVE);
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
    
    public static DeliverAsset searchByForeignKey(DeliverAsset searchAsset) {
        DeliverAsset d = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        DeliverAsset cd = searchAsset;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_BY_FOREIGN_KEY);
            stm.setInt(1, cd.getP().getOfficerID());
            stm.setString(2, cd.getC().getAssetYear());
            stm.setInt(3, cd.getC().getAssetGet());
            stm.setString(4, cd.getC().getAssetNumber());
            stm.setInt(5, cd.getC().getTypeID());
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

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public Computer getC() {
        return c;
    }

    public void setC(Computer c) {
        this.c = c;
    }

}
