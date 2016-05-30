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
    private int personReportID;
    private String firstName;
    private String lastName;
    private int assetReportID;
    private String assetNumber;

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
        this.ticketSolveDetail = rs.getString("TICKET_SOLVE");
        this.ticketSolveDate = rs.getString("TICKET_SOLVE_DATE");
        this.personReportID = rs.getInt("PERSON_REPORT_ID");
        this.assetReportID = rs.getInt("ASSET_REPORT_ID");
        Person p = Person.searchPerson(personReportID);
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        Computer c = Asset.searchByID(assetReportID);
        this.assetNumber = c.getAssetNumber();
        this.ticketStatusName = rs.getString("STATUS_NAME");
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


    public int getPersonReportID() {
        Person p = Person.searchPerson(this.personReportID);
        
        return personReportID;
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

    public int getAssetReportID() {
        return assetReportID;
    }

    public void setAssetReportID(int assetReportID) {
        this.assetReportID = assetReportID;
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
    
    
    

}
