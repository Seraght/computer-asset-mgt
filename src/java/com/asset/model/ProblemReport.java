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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Seraght
 */
public class ProblemReport {

    private static final String SQL_LIST_TICKET = "select * from ticket t, "
            + "person p,ticket_status ts where t.person_report_id = p.person_id and "
            + "t.ticket_status = ts.status_id and t.ticket_status = 1 "
            + "order by ticket_date ASC";
    private static final String SQL_LIST_ALL = "select * from ticket t, "
            + "person p, ticket_status ts where t.person_report_id = p.person_id and "
            + "t.ticket_status = ts.status_id order by ticket_status ASC,ticket_date DESC";
    private static final String SQL_SEARCH_TICKET = "select * from ticket t, "
            + "person p, ticket_status ts where t.person_report_id = p.person_id and "
            + "t.ticket_id = ? and t.ticket_status = ts.status_id";
    private static final String SQL_CREATE_TICKET = "INSERT INTO TICKET("
            + "TICKET_TITLE,TICKET_DATE,TICKET_DESCRIPTION, TICKET_STATUS,"
            + "PERSON_REPORT_ID,ASSET_REPORT_ID) VALUES(?,?,?,?,?,?)";
    private static final String SQL_UPDATE_TICKET = "update ticket set "
            + "ticket_title=?,ticket_description=?,asset_report_id=? "
            + "where ticket_id=?;";
    private static final String SQL_UPDATE_TICKET_STATUS = "update ticket set "
            + "ticket_status=?,ticket_solve=?,ticket_solve_date=? "
            + "where ticket_id=?;";
    private static final String SQL_COUNT_TICKET = "select * "
            + "from ticket t, ticket_status ts where t.ticket_status = ts.status_id";

    public Boolean createTicket(Ticket requestTicket, Person requestPerson, Computer requestComputer) {
        Connection conn = null;
        PreparedStatement stm = null;
        Ticket t = requestTicket;
        Person p = requestPerson;
        Computer c = requestComputer;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_CREATE_TICKET);
            stm.setString(1, t.getTicketTitle());
            stm.setString(2, t.getTicketDate());
            stm.setString(3, t.getTicketDescription());
            stm.setInt(4, t.getTicketStatus());
            stm.setInt(5, (Integer) p.getOfficerID());
            stm.setInt(6, (Integer) c.getAssetID());
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

    public Boolean updateTicket(Ticket updateTicket) {
        Ticket t = updateTicket;
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_TICKET);
            stm.setString(1, t.getTicketTitle());
            stm.setString(2, t.getTicketDescription());
            stm.setInt(3, t.getAssetReportID());
            stm.setInt(4, t.getTicketID());
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

    public Boolean updateTicketAdmin(Ticket updateTicket) {
        Ticket t = updateTicket;
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_TICKET_STATUS);
            stm.setInt(1, t.getTicketStatus());
            stm.setString(2, t.getTicketSolveDetail());
            stm.setString(3, t.getTicketSolveDate());
            stm.setInt(4, t.getTicketID());
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

    public static Ticket searchByID(int id) {
        Ticket t = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_TICKET);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                t = new Ticket(rs);
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
        return t;
    }

    public static List<Ticket> viewAllTicket() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Ticket> matchingTickets = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_LIST_TICKET);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingTickets == null) {
                    matchingTickets = new ArrayList<>();
                }
                matchingTickets.add(new Ticket(rs));
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
        return matchingTickets;
    }

    public static List<Ticket> viewAllTicketAdmin() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Ticket> matchingTickets = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_LIST_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingTickets == null) {
                    matchingTickets = new ArrayList<>();
                }
                matchingTickets.add(new Ticket(rs));
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
        return matchingTickets;
    }

    public static Map countTicket() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map m = new HashMap();
        int count_sum = 0;
        int count_new = 0;
        int count_solve = 0;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_COUNT_TICKET);
            rs = stm.executeQuery();
            while (rs.next()) {
                count_sum++;
                if (rs.getInt("TICKET_STATUS") == 1) {
                    count_new++;
                } else {
                    count_solve++;
                }
            }
            m.put("count_sum", count_sum);
            m.put("count_new", count_new);
            m.put("count_solve", count_solve);
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
}
