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
public class Asset {

    private static final String SQL_INSERT_COMPUTER = "INSERT INTO ASSET"
            + "(asset_year,asset_get,asset_number,type_id,serial,model,brand,price,description,buy_date) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE_COMPUTER = "update asset set model=?,"
            + "brand=?,price=?,description=?,type_id=?,serial=? where asset_year = ? and asset_get = ? and "
            + "asset_number = ? and type_id = ?";
    private static final String SQL_SEARCH_COMPUTER = "select * from asset a left join "
            + "asset_type t on a.type_id = t.type_id where a.asset_status <> 'Delete' "
            + "and exists (select * from asset a left join asset_type t on a.type_id = t.type_id "
            + "where a.asset_year like ? or a.asset_get = ? or a.type_id = ? or a.model like ? "
            + "or a.brand like ? or a.serial like ?) order by a.asset_year,a.asset_get,"
            + "a.asset_number,a.type_id";

    private static final String SQL_SEARCH_BY_NUMBER = "SELECT * FROM asset WHERE "
            + "asset_number = ?";
    private static final String SQL_SEARCH_BY_ID = "SELECT * FROM asset a left join asset_type t on a.type_id = t.type_id WHERE "
            + "a.asset_year = ? and a.asset_get = ? and a.asset_number = ? and a.type_id = ?";
    private static final String SQL_SEARCH_BY_STATUS = "SELECT * FROM asset a left join asset_type t on a.type_id = t.type_id WHERE "
            + "a.asset_status = ?";
    private static final String SQL_SEARCH_ALL = "SELECT * FROM asset where has_owner = 0";
    private static final String SQL_LIST_ID = "SELECT * FROM asset a left join "
            + "asset_type t on a.type_id = t.type_id WHERE "
            + "(a.asset_year, a.asset_get,a.type_id) = (?, ?, ?);";
    private static final String SQL_UPDATE_OWNER = "update asset set "
            + "has_owner=? where asset_id=?";
    private static final String SQL_COUNT_ASSET = "select * from asset ";
    private static final String SQL_DELETE_ASSET = "update asset a set a.asset_status = 'Delete' "
            + "where a.asset_year = ? and a.asset_get = ? and a.asset_number = ? and a.type_id = ?";
    private static final String SQL_RESTORE_ASSET = "update asset a set a.asset_status = 'Stock' "
            + "where a.asset_year = ? and a.asset_get = ? and a.asset_number = ? and a.type_id = ?";

//    public void addComputer(String assetID, double price, ComputerSpec spec, int typeID) {
//        Computer computer = new Computer(assetID, price, spec, typeID);
//        insertComputer(computer);
//    }
    public boolean insertComputer(Computer addComputer) {
        Connection conn = null;
        PreparedStatement stm = null;
        Computer computer = addComputer;
        ComputerSpec spec = computer.getSpec();
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_INSERT_COMPUTER);
            stm.setString(1, computer.getAssetYear());
            stm.setInt(2, computer.getAssetGet());
            stm.setString(3, computer.getAssetNumber());
            stm.setInt(4, computer.getTypeID());
            stm.setString(5, computer.getSerial());
            stm.setString(6, (String) spec.getProperty("model"));
            stm.setString(7, (String) spec.getProperty("brand"));
            stm.setDouble(8, computer.getPrice());
            stm.setString(9, (String) spec.getProperty("description"));
            stm.setString(10, computer.getAssetBuyDate());
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

    public boolean updateComputer(Computer updateComputer, int typeIDOld) {
        Connection conn = null;
        PreparedStatement stm = null;
        Computer computer = updateComputer;
        ComputerSpec spec = computer.getSpec();
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_COMPUTER);
            stm.setString(1, (String) spec.getProperty("model"));
            stm.setString(2, (String) spec.getProperty("brand"));
            stm.setDouble(3, computer.getPrice());
            stm.setString(4, (String) spec.getProperty("description"));
            stm.setInt(5, computer.getTypeID());
            stm.setString(6, computer.getSerial());
            stm.setString(7, computer.getAssetYear());
            stm.setInt(8, computer.getAssetGet());
            stm.setString(9, computer.getAssetNumber());
            stm.setInt(10, typeIDOld);
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

    public static Computer searchByNumber(String assetNumber) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String searchAsset = assetNumber;
        Computer matchingComputer = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_BY_NUMBER);
            stm.setString(1, searchAsset);
            rs = stm.executeQuery();
            if (rs.next()) {
                matchingComputer = new Computer(rs);
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
        return matchingComputer;
    }

    public static Computer searchByID(String assetYear, int assetGet, String assetNumber, int typeID) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Computer matchingComputer = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_BY_ID);
            stm.setString(1, assetYear);
            stm.setInt(2, assetGet);
            stm.setString(3, assetNumber);
            stm.setInt(4, typeID);
            
            rs = stm.executeQuery();
            if (rs.next()) {
                matchingComputer = new Computer(rs);
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
        return matchingComputer;
    }

    public static List<Computer> searchComputer(Computer searchComputer) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Computer computer = searchComputer;
        ComputerSpec spec = computer.getSpec();
        List<Computer> matchingComputers = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_COMPUTER);
            stm.setString(1, "%" + computer.getAssetYear() + "%");
            stm.setInt(2, computer.getAssetGet());
            stm.setInt(3, computer.getTypeID());
            stm.setString(4, "%" + (String) spec.getProperty("model") + "%");
            stm.setString(5, "%" + (String) spec.getProperty("brand") + "%");
            stm.setString(6, "%" + computer.getSerial());
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingComputers == null) {
                    matchingComputers = new ArrayList<>();
                }
                matchingComputers.add(new Computer(rs));
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

    public static List<Computer> searchByStatus(String status) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Computer> matchingComputers = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_BY_STATUS);
            stm.setString(1, status);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingComputers == null) {
                    matchingComputers = new ArrayList<>();
                }
                matchingComputers.add(new Computer(rs));
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

    public static List<Computer> searchAllComputer() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Computer> matchingComputers = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_SEARCH_ALL);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingComputers == null) {
                    matchingComputers = new ArrayList<>();
                }
                matchingComputers.add(new Computer(rs));
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

    public static List<Computer> primaryKeyFilter(String year, int get, int type) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Computer> matchingComputers = null;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_LIST_ID);
            stm.setString(1, year);
            stm.setInt(2, get);
            stm.setInt(3, type);
            rs = stm.executeQuery();
            while (rs.next()) {
                if (matchingComputers == null) {
                    matchingComputers = new ArrayList<>();
                }
                matchingComputers.add(new Computer(rs));
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

    public boolean updateOwner(int status, int computerID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE_OWNER);
            stm.setInt(1, status);
            stm.setInt(2, computerID);
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

    public static Map countAsset() {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Map m = new HashMap();
        int count_sum = 0;
        int count_pc = 0;
        int count_notebook = 0;
        int count_tablet = 0;
        int count_printer = 0;
        int count_scanner = 0;
        int count_network = 0;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_COUNT_ASSET);
            rs = stm.executeQuery();
            while (rs.next()) {
                count_sum++;
                switch (rs.getInt("type_id")) {
                    case 1:
                        count_pc++;
                        break;
                    case 2:
                        count_notebook++;
                        break;
                    case 3:
                        count_tablet++;
                        break;
                    case 4:
                        count_printer++;
                        break;
                    case 5:
                        count_scanner++;
                        break;
                    case 6:
                        count_network++;
                        break;
                }
            }
            m.put("count_sum", count_sum);
            m.put("count_pc", count_pc);
            m.put("count_notebook", count_notebook);
            m.put("count_tablet", count_tablet);
            m.put("count_printer", count_printer);
            m.put("count_scanner", count_scanner);
            m.put("count_network", count_network);
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
    
    public boolean deleteComputer(String assetYear, int assetGet, String assetNumber, int typeID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_DELETE_ASSET);
            stm.setString(1, assetYear);
            stm.setInt(2, assetGet);
            stm.setString(3, assetNumber);
            stm.setInt(4, typeID);
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
    
    public boolean restoreComputer(String assetYear, int assetGet, String assetNumber, int typeID) {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean result = false;
        try {
            conn = ConnectionBuilder.getConnection();
            stm = conn.prepareStatement(SQL_RESTORE_ASSET);
            stm.setString(1, assetYear);
            stm.setInt(2, assetGet);
            stm.setString(3, assetNumber);
            stm.setInt(4, typeID);
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
}
