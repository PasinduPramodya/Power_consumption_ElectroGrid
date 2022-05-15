package model;
import java.sql.*;
public class powerconsumptionj {
	//A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
		 Class.forName("com.mysql.jdbc.Driver");

		
		 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/electro","root", "");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 }
		public String insertcustomerdetails(String password, String name, String customerPhone, String email)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 // create a prepared statement
		 String query = " insert into powerconsumption (`id`,`unit`,`datefrom`,`dateto`,`cusid`)" + " values (?, ?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setString(2, password);
		 preparedStmt.setString(3, name);
		 preparedStmt.setString(4, customerPhone);
		 preparedStmt.setString(5, email);
		// execute the statement
		
		 preparedStmt.execute();
		 con.close();
		 output = "Inserted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while inserting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		public String readItems()
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for reading."; }
		 // Prepare the html table to be displayed
		 output = "<table border='1'><tr><th>Units</th>" +
		 "<th>Date From</th>" +
		 "<th>Date To</th>" +
		 "<th>Customer ID</th>"+
		 "<th>Update</th><th>Remove</th></tr>";

		 String query = "select * from powerconsumption";
		 Statement stmt = con.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 // iterate through the rows in the result set
		 while (rs.next())
		 {
		 String customerID = Integer.toString(rs.getInt("id"));
		 String customerPassword = rs.getString("unit");
		 String customerName = rs.getString("datefrom");
		 String customerPhone =rs.getString("dateto");
		 String customerEmail = rs.getString("cusid");
		 
		 
		 output += "<tr><td>" + customerName + "</td>";
		 output += "<td>" + customerPhone + "</td>";
		 output += "<td>" + customerEmail + "</td>";
		 output += "<td>" + customerPassword + "</td>";
		 // buttons
		 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
				 + "<td><form method='post' action='powerconsumption.jsp'>"
				 + "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
				 + "<input name='customerID' type='hidden' value='" + customerID
				 + "'>" + "</form></td></tr>";
				 }
				 con.close();
				
				 output += "</table>";
				 } 
		 catch (Exception e)
		 {
		 output = "Error while reading the items.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		public String updatecustomerdetails(String ID, String password, String name, String phone, String email)
		
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for updating."; }
		 // create a prepared statement
		 String query = "UPDATE powerconsumption SET unit=?,datefrom=?,dateto=?,cusid=? WHERE id=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setString(1, password);
		 preparedStmt.setString(2, name);
		 preparedStmt.setString(3, phone);
		 preparedStmt.setString(4, email);
		 preparedStmt.setInt(5, Integer.parseInt(ID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Updated successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while updating the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		public String deleteItem(String customerID)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for deleting."; }
		 // create a prepared statement
		 String query = "delete from powerconsumption where id=?";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, Integer.parseInt(customerID));
		 // execute the statement
		 preparedStmt.execute();
		 con.close();
		 output = "Deleted successfully";
		 }
		 catch (Exception e)
		 {
		 output = "Error while deleting the item.";
		 System.err.println(e.getMessage());
		 }
		 return output;
		 }
		} 

