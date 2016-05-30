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
public class InsertGet {

    private int assetGetID;
    private String assetGet;

    private static final String SQL_LIST_GET = "select * from asset_get ";

    public InsertGet() {
    }

    public InsertGet(ResultSet rs) throws SQLException {
        this.assetGetID = rs.getInt("get_id");
        this.assetGet = rs.getString("get_name");
    }
    
    public static List<InsertGet> searchAllGet() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<InsertGet> matchingGets = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_LIST_GET);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingGets == null) {
                    matchingGets = new ArrayList<>();
                }
                matchingGets.add(new InsertGet(rs));
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
        return matchingGets;
    }

    public int getAssetGetID() {
        return assetGetID;
    }

    public void setAssetGetID(int assetGetID) {
        this.assetGetID = assetGetID;
    }

    public String getAssetGet() {
        return assetGet;
    }

    public void setAssetGet(String assetGet) {
        this.assetGet = assetGet;
    }

}
