package com.jikisan.vstech.DAO;

import javax.swing.*;
import java.sql.Connection;

public class DbConn {

    public static Connection ConnectDb() {
        try {
//            Class.forName("org.sqlite.JDBC");
            String userDir = System.getProperty("user.dir");
            Connection con = java.sql.DriverManager.getConnection("jdbc:sqlite:" + userDir + "/vstechdb.sqlite");
            System.out.println("Connection Successful");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Connection Failed");
            return null;
        }
    }
}
