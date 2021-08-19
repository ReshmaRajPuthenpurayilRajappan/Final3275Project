package com.example.Final3275Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{

    Connection con;
    public DatabaseService(Connection con) {

        this.con = con;
    }
    @Override
    public void add(Loan loan) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO loan VALUES ( ?, ?, ?, ?, ? )";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, loan.getClientno());
        query.setString(2, loan.getClientname());
        query.setDouble(3, loan.getLoanamount());
        query.setInt(4, loan.getYears());
        query.setString(5, loan.getLoantype());
        query.executeUpdate();
    }
    @Override
    public Loan edit(Loan loan, String clientno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update loan set clientno=?, clientname=?, loanamount=?, years=?,loantype=? where clientno = ?");
        query.setString(1, loan.getClientno());
        query.setString(2, loan.getClientname());
        query.setDouble(3, loan.getLoanamount());
        query.setInt(4, loan.getYears());
        query.setString(5, loan.getLoantype());
        query.setString(6, clientno);
        query.executeUpdate();
        return loan;
    }
    @Override
    public void delete(String catcode) throws SQLException {
        String quer1 = "Delete from Category where catcode = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, catcode);
        query.executeUpdate();
    }
    public Category search(String catcode) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from category where catcode = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, catcode);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Category obj1=null;
        obj1 = new Category(rs.getString("catcode"), rs.getString("catdesc"));
        return obj1;
    }
    @Override
    public List<Category> display() throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Category> Catlist = new ArrayList<Category>();
        String quer1 = "Select * from category";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Category obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Category(rs.getString("catcode"), rs.getString("catdesc"));
            Catlist.add(obj1); } return Catlist;
    }
    public List<Items> display2(String catcode) throws ClassNotFoundException, SQLException {
        //create an array list that will contain the data recovered
        List<Items> Itemlist = new ArrayList<Items>();
        String quer1 = "Select itemcode,itemdesc from items where catcode=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, catcode); ResultSet rs = query.executeQuery();
        Items obj2;
        //display records if there is data;
        while (rs.next()) {
            obj2 = new Items(rs.getString("itemcode"),rs.getString("itemdesc"));
            Itemlist.add(obj2);
        }
        return Itemlist;
    }


}
