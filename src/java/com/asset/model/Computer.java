/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Seraght
 */
public class Computer {

    private String assetYear;
    private int assetGet;
    private String assetNumber;
    private int typeID;
    private String serial;
    private double price;
    private ComputerSpec spec;
    private String assetStatus;
    private String typeName;
    private String assetBuyDate;
    private String donateDate;

    public Computer(String assetYear, int assetGet, String assetNumber, int typeID, String serial, double price, ComputerSpec spec, String assetBuyDate) {
        this.assetYear = assetYear;
        this.assetGet = assetGet;
        this.assetNumber = assetNumber;
        this.typeID = typeID;
        this.serial = serial;
        this.price = price;
        this.spec = spec;
        this.assetBuyDate = assetBuyDate;
    }

    public Computer(String assetYear, int assetGet, int typeID, String serial, ComputerSpec spec) {
        this.assetYear = assetYear;
        this.assetGet = assetGet;
        this.typeID = typeID;
        this.serial = serial;
        this.spec = spec;
    }

    public Computer() {

    }

    public Computer(ResultSet rs) throws SQLException {
        this.assetYear = rs.getString("asset_year");
        this.assetGet = rs.getInt("asset_get");
        this.assetNumber = rs.getString("asset_number");
        this.typeID = rs.getInt("TYPE_ID");
        this.serial = rs.getString("serial");
        this.price = rs.getDouble("PRICE");
        Map properties = new HashMap();
        properties.put("model", rs.getString("MODEL"));
        properties.put("brand", rs.getString("BRAND"));
        properties.put("description", rs.getString("DESCRIPTION"));
        this.spec = new ComputerSpec(properties);
        this.assetStatus = rs.getString("asset_status");
        this.typeName = rs.getString("type_name");
        this.assetBuyDate = rs.getString("buy_date");
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public ComputerSpec getSpec() {
        return spec;
    }

    public void setSpec(ComputerSpec spec) {
        this.spec = spec;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getAssetNumber() {
        return assetNumber;
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

    public String getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(String donateDate) {
        this.donateDate = donateDate;
    }
    
    

}
