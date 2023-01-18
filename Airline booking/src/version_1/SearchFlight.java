package version_1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

public class SearchFlight {
	
	public void searchflight(String FromLocation,String ToLocation ){
	   Scanner sc =new Scanner(System.in);
      System.out.println("      Search flights    ");
       System.out.println("Enter From location :");
        FromLocation =sc.nextLine(); 
       System.out.println("Enter To  :");
      ToLocation =sc.nextLine();
   
     
       try{
  		 
           Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
           String user="root";                          //user name of my sql
           String pass="Seb@43021";                   //password of my sql
           String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
       Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database
    String sql = "";
       if(FromLocation.equalsIgnoreCase("kerala") && ToLocation.equalsIgnoreCase("goa")){ //to select according to user entry 
    	  sql = "select * from flights where From_ = 'kerala' && To_ = 'goa' " ;
    }else if(FromLocation.equalsIgnoreCase("kerala")&& ToLocation.equalsIgnoreCase("mumbai")) {
    	sql = "select * from flights where From_ = 'kerala' && To_ = 'mumbai'";
    }else if(FromLocation.equalsIgnoreCase("tamilnadu")&&ToLocation.equalsIgnoreCase("hydrebad")){
    	sql = "select * from flights where From_ ='tamilnadu' && To_ = 'hydrebad' ";
    }else if (FromLocation.equalsIgnoreCase("delhi")&& ToLocation.equalsIgnoreCase("banglore")){
    	sql = "select * from flights where From_ ='delhi' && To_ = 'banglore' ";
    }else if (FromLocation.equalsIgnoreCase("kerala")&& ToLocation.equalsIgnoreCase("jharkhand")){
    	sql = "select * from flights where From_ ='kerala' && To_ = 'jharkhand' ";
    }else if (FromLocation.equalsIgnoreCase("mumbai")&& ToLocation.equalsIgnoreCase("banglore")){
    	sql = "select * from flights where From_ ='mumbai' && To_ = 'banglore' ";
    }else if (FromLocation.equalsIgnoreCase("delhi")&& ToLocation.equalsIgnoreCase("mumbai")){
    	sql = "select * from flights where From_ ='delhi' && To_ = 'mumbai' ";
    }else if (FromLocation.equalsIgnoreCase("chennai")&& ToLocation.equalsIgnoreCase("kerala")){
    	sql = "select * from flights where From_ ='delhi' && To_ = 'banglore' ";
    }
       
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
    		
    		while(rs.next()) {
    			String flightno = rs.getString("flightno");
    			String fromloc = rs.getString("From_");
    			String toloc = rs.getString("To_");    			
    			String depdate = rs.getString("depdate");    			
    			String ardate =rs.getString("arrdate");    			
    			String ra =  rs.getString("rate");
    			String classf = rs.getString("class");
    			System.out.println("Flight number: "+ flightno);
    		System.out.println("From location: " +fromloc);
    		System.out.println("To location: "+toloc);
    		System.out.println("Departure Date:"+ depdate );
    		System.out.println("Arrival Date: "+ ardate);
    		System.out.println("Rate: " +ra);
    		System.out.println("Class of flight avilable: "+ classf );
    		}
       }
       catch(Exception ex){
           ex.printStackTrace();
           System.out.println("The flights to the given location is not availiable ");
       }
       
       
	}

}
