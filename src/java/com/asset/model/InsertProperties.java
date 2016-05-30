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
public class InsertProperties {

    private int assetTypeID;
    private String assetType;

    private static final String SQL_ADD_TYPE = "insert into asset_type(type_name) values (?)";
    private static final String SQL_LIST_TYPE = "select * from asset_type order by type_name";

    public InsertProperties() {
    }

    public InsertProperties(ResultSet rs) throws SQLException {
        this.assetTypeID = rs.getInt("type_id");
        this.assetType = rs.getString("type_name");
    }

    public int getAssetTypeID() {
        return assetTypeID;
    }

    public void setAssetTypeID(int assetTypeID) {
        this.assetTypeID = assetTypeID;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public boolean insertAssetType(String insertType) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_ADD_TYPE);
            stm.setString(1, insertType);
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

    public static List<InsertProperties> searchAllType() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<InsertProperties> matchingTypes = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_LIST_TYPE);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingTypes == null) {
                    matchingTypes = new ArrayList<>();
                }
                matchingTypes.add(new InsertProperties(rs));
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
        return matchingTypes;
    }

}
