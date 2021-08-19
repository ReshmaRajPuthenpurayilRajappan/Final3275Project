package com.example.Final3275Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface {

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
        query = con.prepareStatement("Update loan set clientno=?, clientname=?, loanamount=?, " +
                "years=?,loantype=? where clientno = ?");
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
    public void delete(String clientno) throws SQLException {
        String quer1 = "Delete from loan where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        query.executeUpdate();
    }
    public Loan search(String clientno) throws SQLException,ClassNotFoundException {
        String quer1 = "Select * from loan where clientno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, clientno);
        ResultSet rs = query.executeQuery();
        if(!rs.first()){
            System.out.print("Record not existing");
            return null;
        }
        Loan obj1=null;
        obj1 = new Loan(rs.getString("clientno"), rs.getString("clientname"),
                rs.getDouble("loanamount"), rs.getInt("years"),
                rs.getString("loantype"));
        return obj1;
    }
    @Override
    public List<Loan> display() throws ClassNotFoundException, SQLException {

        List<Loan> Loanlist = new ArrayList<Loan>();
        String quer1 = "Select * from loan";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        Loan obj1;
        //display records if there is data;
        while (rs.next()) {
            obj1 = new Loan(rs.getString("clientno"), rs.getString("clientname"),
                    rs.getDouble("loanamount"), rs.getInt("years"),
                    rs.getString("loantype"));
            Loanlist.add(obj1);
        }
        return Loanlist;
    }


}
