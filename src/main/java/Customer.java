package com.temitopeolanrewaju81;

import java.sql.*;

public class Customer {
    public String customer_id;
    public String first_name;
    public String last_name;
    public String account_number;
    public String phone_number;
    public String account_Balance;

    public static void main(String[] args) {

        String url = "jdbc:mysql://3.21.167.100:3306/topman";
        String username = "root";
        String password = "abcde12345";
        String queue = "SELECT * FROM customer";
        String sql = "INSERT INTO customer(customer_id,first_name,last_name,phone_number,account_number,account_Balance) " +
                       "VALUES(?,?,?,?,?,?)";
        String del= "DELETE FROM customer WHERE customer_id=8";
        String update="UPDATE customer SET account_Balance='9000' WHERE customer_id='1'";


        //making a connection with sql in docker container sql select all from customer

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement rs1 = conn.prepareStatement(sql);
            PreparedStatement rs2 = conn.prepareStatement(queue);
            PreparedStatement rs3 = conn.prepareStatement(update);
            PreparedStatement rs4 = conn.prepareStatement(del);


            //insert into table
            rs1.setString(1, "9");
            rs1.setString(2, "Hammed");
            rs1.setString(3, "Awonuga");
            rs1.setString(4, "3469365");
            rs1.setString(5,"1256787");
            rs1.setString(6,"6500");

            int rows = rs1.executeUpdate();

            if (rows > 0) {
                System.out.println("A new customer was inserted successfully");

            }

            //select all from customer
            ResultSet rf= rs2.executeQuery(queue);
            while (rf.next()) {
               String customer_id= rf.getString(1);
               String first_name=rf.getString(2);
               String last_name=rf.getString(3);
               String phone_number=rf.getString(4);
               String account_number=rf.getString(5);
               String account_Balance=rf.getString(6);
                System.out.println(customer_id + ':'  + first_name + ','+ last_name +',' + phone_number + ','+account_number
                       + ',' + account_Balance);

            }

            //update account balance

            int row =rs3.executeUpdate();
            if (row > 0) {
                System.out.println("customers information is updated.");
            }

            //Method to delete customer information
            int rowss =rs4.executeUpdate();
            if (rowss > 0) {
                System.out.println("Customer information is deleted." );
            }



            } catch(SQLException e) {
                System.out.println("Oops, error!");
                e.printStackTrace();

        }


    }

}



