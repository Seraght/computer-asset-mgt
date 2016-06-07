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
            + "person p,ticket_status ts where t.person_id = p.person_id and "
            + "t.ticket_status = ts.status_id and t.ticket_status < 4 "
            + "order by ticket_status, ticket_date ASC";
    private static final String SQL_LIST_ALL = "select * from ticket t, "
            + "person p, ticket_status ts where t.person_id = p.person_id and "
            + "t.ticket_status = ts.status_id order by ticket_status ASC,ticket_date DESC";
    private static final String SQL_SEARCH_TICKET = "select * from ticket t, "
            + "person p, ticket_status ts where t.person_id = p.person_id and "
            + "t.ticket_id = ? and t.ticket_status = ts.status_id";
    private static final String SQL_SEARCH_REVIEW = "select * from ticket t, "
            + "person p, ticket_status ts where t.person_id = p.person_id and "
            + "t.person_id = ? and t.ticket_status = ts.status_id and ticket_status = 4";
    private static final String SQL_CREATE_TICKET = "INSERT INTO TICKET("
            + "TICKET_TITLE,TICKET_DATE,TICKET_DESCRIPTION, TICKET_STATUS,"
            + "person_id,asset_year,asset_get,asset_number, asset_type) VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_TICKET = "update ticket set "
            + "ticket_title=?,ticket_description=?,asset_year=?,asset_get=?,asset_number=?,asset_type=? "
            + "where ticket_id=?;";
    private static final String SQL_UPDATE_TICKET_SOLVE_STATUS = "update ticket set "
            + "ticket_status=?,ticket_solve_description=?,ticket_solve_date=? "
            + "where ticket_id=?";
    private static final String SQL_UPDATE_TICKET_ONGOING_STATUS = "update ticket set "
            + "ticket_status=?,ticket_solve_description=?,ticket_ongoing_date=? "
            + "where ticket_id=?";
    private static final String SQL_UPDATE_REVIEW = "update ticket set "
            + "ticket_status=?,review=? where ticket_id = ?";
    private static final String SQL_COUNT_TICKET = "select * "
            + "from ticket t, ticket_status ts where t.ticket_status = ts.status_id";
    private static final String SQL_COUNT_TIME = "select  ticket_id, "
            + "TIMESTAMPDIFF(minute,ticket_date, ticket_solve_date) minute from ticket";

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
            stm.setString(6, c.getAssetYear());
            stm.setInt(7, c.getAssetGet());
            stm.setString(8, c.getAssetNumber());
            stm.setInt(9, c.getTypeID());
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
            stm.setString(3, t.getAssetYear());
            stm.setInt(4, t.getAssetGet());
            stm.setString(5, t.getAssetNumber());
            stm.setInt(6, t.getAssetType());
            stm.setInt(7, t.getTicketID());
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

    public Boolean updateTicketSolveAdmin(Ticket updateTicket) {
        Ticket t = updateTicket;
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_TICKET_SOLVE_STATUS);
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

    public Boolean updateTicketOngoingAdmin(Ticket updateTicket) {
        Ticket t = updateTicket;
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_TICKET_ONGOING_STATUS);
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

    public Boolean review(int review, int status, int ticketID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_REVIEW);
            stm.setInt(1, review);
            stm.setInt(2, status);
            stm.setInt(3, ticketID);

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

    public static Ticket searchByPersonID(int id) {
        Ticket t = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_REVIEW);
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
        int count_resolve = 0;
        int count_ongoing = 0;
        int count_pending = 0;
        int count_close = 0;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_COUNT_TICKET);
            rs = stm.executeQuery();
            while (rs.next()) {
                count_sum++;
                switch (rs.getInt("ticket_status")) {
                    case 1:
                        count_new++;
                        break;
                    case 2:
                        count_ongoing++;
                        break;
                    case 3:
                        count_pending++;
                        break;
                    case 4:
                        count_resolve++;
                        break;
                    case 5:
                        count_close++;
                        break;
                }
            }
            m.put("count_sum", count_sum);
            m.put("count_new", count_new);
            m.put("count_ongoing", count_ongoing);
            m.put("count_pending", count_pending);
            m.put("count_resolve", count_resolve);
            m.put("count_close", count_close);
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
    
    public static Map countTime() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map m = new HashMap();
        int count_sum = 0;
        int count_0 = 0;
        int count_15 = 0;
        int count_30 = 0;
        int count_60 = 0;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_COUNT_TIME);
            rs = stm.executeQuery();
            while (rs.next()) {
                count_sum++;
                if (rs.getInt("minute") > 60) {
                    count_60++;
                } else if (rs.getInt("minute") > 30) {
                    count_30++;
                } else if (rs.getInt("minute") > 15) {
                    count_15++;
                } else {
                    count_0++;
                }
            }
            m.put("count_sum", count_sum);
            m.put("count_0", count_0);
            m.put("count_15", count_15);
            m.put("count_30", count_30);
            m.put("count_60", count_60);
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
