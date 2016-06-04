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
 * @author nuttapong.j
 */
public class Donate {

    private int donateID;
    private String donateDate;
    private String donateStatus;
    private String assetYear;
    private int assetGet;
    private String assetNumber;
    private int typeID;
    private String brand;
    private String model;
    private String typeName;
    private String assetStatus;
    private String assetBuyDate;

    private static final String SQL_SEARCH_DONATE = "select * from asset a, "
            + "asset_donate ad, asset_type at where a.asset_year = ad.asset_year "
            + "and a.asset_get = ad.asset_get and a.asset_number = ad.asset_number "
            + "and a.type_id = ad.asset_type and a.type_id = at.type_id";

    public Donate() {

    }

    public Donate(ResultSet rs) throws SQLException {
        this.donateID = rs.getInt("donate_id");
        this.donateDate = rs.getString("donate_date");
        this.donateStatus = rs.getString("donate_status");
        this.assetYear = rs.getString("asset_year");
        this.assetGet = rs.getInt("asset_get");
        this.assetNumber = rs.getString("asset_number");
        this.typeID = rs.getInt("type_id");
        this.brand = rs.getString("brand");
        this.model = rs.getString("model");
        this.typeName = rs.getString("type_name");
        this.assetStatus = rs.getString("asset_status");
        this.assetBuyDate = rs.getString("buy_date");
    }

    public int getDonateID() {
        return donateID;
    }

    public void setDonateID(int donateID) {
        this.donateID = donateID;
    }

    public String getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(String donateDate) {
        this.donateDate = donateDate;
    }

    public String getDonateStatus() {
        return donateStatus;
    }

    public void setDonateStatus(String donateStatus) {
        this.donateStatus = donateStatus;
    }

    public String getAssetYear() {
        return assetYear;
    }

    public void setAssetYear(String assetYear) {
        this.assetYear = assetYear;
    }

    public int getAssetGet() {
        return assetGet;
    }

    public void setAssetGet(int assetGet) {
        this.assetGet = assetGet;
    }

    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getAssetBuyDate() {
        return assetBuyDate;
    }

    public void setAssetBuyDate(String assetBuyDate) {
        this.assetBuyDate = assetBuyDate;
    }
    
    

    public static List<Donate> searchAllDonate() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Donate> matchingComputers = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_DONATE);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingComputers == null) {
                    matchingComputers = new ArrayList<>();
                }
                matchingComputers.add(new Donate(rs));
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
        return matchingComputers;
    }

}
