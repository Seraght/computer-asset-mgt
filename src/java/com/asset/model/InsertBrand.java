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
public class InsertBrand {

    private int assetBrandID;
    private String assetBrand;

    private static final String SQL_ADD_BRAND = "insert into brand(brand_name) values (?)";
    private static final String SQL_LIST_BRAND = "select * from brand order by brand_name";

    public InsertBrand() {
    }

    public InsertBrand(ResultSet rs) throws SQLException {
        this.assetBrandID = rs.getInt("brand_id");
        this.assetBrand = rs.getString("brand_name");
    }

    public int getAssetBrandID() {
        return assetBrandID;
    }

    public void setAssetBrandID(int assetBrandID) {
        this.assetBrandID = assetBrandID;
    }

    public String getAssetBrand() {
        return assetBrand;
    }

    public void setAssetBrand(String assetBrand) {
        this.assetBrand = assetBrand;
    }

    public boolean insertAssetBrand(String insertBrand) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_ADD_BRAND);
            stm.setString(1, insertBrand);
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

    public static List<InsertBrand> searchAllBrand() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<InsertBrand> matchingBrands = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_LIST_BRAND);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingBrands == null) {
                    matchingBrands = new ArrayList<>();
                }
                matchingBrands.add(new InsertBrand(rs));
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
        return matchingBrands;
    }

}
