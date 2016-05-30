package com.asset.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author int676
 */
public class ConnectionBuilder {

    private static boolean load = false;
    private final static String URL = "jdbc:mysql://localhost:3307/asset?zeroDateTimeBehavior=convertToNull";
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String USER = "root";
    private final static String PASS = "P@ssw0rd";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            if (!load) {
                Class.forName(DRIVER);
                load = true;
            }
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println(ex);
        }
        return conn;
    }
//    public static Connection getConnection() {
//
//        Connection con = null;
//        try {
//            Context ctx = null;
//            ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("jdbc:derby://localhost:1527/asset");
//            con = ds.getConnection(USER, PASS);
//        } catch (NamingException | SQLException ex) {
//            System.out.println(ex);
//        }
//        return con;
//    }
}
