/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asset.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Seraght
 */
public class Ticket {

    private int ticketID;
    private String ticketTitle;
    private String ticketDate;
    private String ticketDescription;
    private int ticketStatus;
    private String ticketStatusName;
    private String ticketSolveDetail;
    private String ticketSolveDate;
    private int personID;
    private String firstName;
    private String lastName;
    private String assetYear;
    private int assetGet;
    private String assetNumber;
    private int assetType;
    private String ticketOngoingDate;
    private int review;
    private Computer c;
    private Person p;

    public Ticket() {
    }

    public Ticket(String ticketTitle, String ticketDescription) {
        this.ticketTitle = ticketTitle;
        this.ticketDescription = ticketDescription;
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.ticketDate = timeStamp;
        this.ticketStatus = 1;
    }

    public Ticket(ResultSet rs) throws SQLException {
        this.ticketID = rs.getInt("TICKET_ID");
        this.ticketTitle = rs.getString("TICKET_TITLE");
        this.ticketDate = rs.getString("TICKET_DATE");
        this.ticketDescription = rs.getString("TICKET_DESCRIPTION");
        this.ticketStatus = rs.getInt("TICKET_STATUS");
        this.ticketSolveDetail = rs.getString("ticket_solve_description");
        this.ticketSolveDate = rs.getString("TICKET_SOLVE_DATE");
        this.personID = rs.getInt("person_id");
        this.assetYear = rs.getString("asset_year");
        this.assetGet = rs.getInt("asset_get");
        this.assetNumber = rs.getString("asset_number");
        this.assetType = rs.getInt("asset_type");
        this.ticketStatusName = rs.getString("STATUS_NAME");
        this.ticketOngoingDate = rs.getString("ticket_ongoing_date");
        this.review = rs.getInt("review");
        p = new Person();
        p.setFirstName(rs.getString("firstname"));
        p.setLastName(rs.getString("lastname"));
    }

    public int getTicketID() {
        return ticketID;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketDate() {
        return ticketDate;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public int getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(int ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketSolveDetail() {
        return ticketSolveDetail;
    }

    public void setTicketSolveDetail(String ticketSolveDetail) {
        this.ticketSolveDetail = ticketSolveDetail;
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        this.ticketSolveDate = timeStamp;
    }

    public String getTicketSolveDate() {
        return ticketSolveDate;
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


    public String getAssetNumber() {
        return assetNumber;
    }

    public void setAssetNumber(String assetNumber) {
        this.assetNumber = assetNumber;
    }

    public String getTicketStatusName() {
        return ticketStatusName;
    }

    public void setTicketStatusName(String ticketStatusName) {
        this.ticketStatusName = ticketStatusName;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
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

    public int getAssetType() {
        return assetType;
    }

    public void setAssetType(int assetType) {
        this.assetType = assetType;
    }

    public Computer getC() {
        return c;
    }

    public void setC(Computer c) {
        this.c = c;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }

    public String getTicketOngoingDate() {
        return ticketOngoingDate;
    }

    public void setTicketOngoingDate(String ticketOngoingDate) {
        this.ticketOngoingDate = ticketOngoingDate;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }
    
    
    

}
