/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author rlarg
 */
public class Cliente {

    private int id;
    private String name;
    private String lastName;
    private String company;

    public static ArrayList<Cliente> getCount() throws Exception {
        ArrayList<Cliente> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
//O caminho do arquivo deve ser diferente se executado do seu PC
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from artists");
        int count = 0;
        while (rs.next()) {
            int id = rs.getInt("CostumerId");
            String name = rs.getString("Firstname");
            String lastName = rs.getString("lastName");
            String company = rs.getString("company");
            Cliente a = new Cliente(id, name, lastName, company);
            list.add(a);
            count = rs.getInt("count");
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    public Cliente(int id, String name, String lastName, String company) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.company = company;
    }

    private Cliente(int id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
