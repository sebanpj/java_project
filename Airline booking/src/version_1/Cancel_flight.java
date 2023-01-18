package version_1;
import java.util.Scanner;
import java.sql.*;

public class Cancel_flight {
	
	public void cancelflight(String flightno, String ticketno, String cardno) {
    	
    	Scanner sc = new Scanner(System.in);
    
		System.out.println("            "+"CANCEL FLIGHTS"+"         ");
		System.out.println("\n"+"Enter flight number: "); 
		 flightno = sc.next();// inputing flight  number
		System.out.println("Enter ticket number: ");
		 ticketno = sc.next();// input ticket number
		System.out.println("\n"+"Choose refund method:"); //choose between payment option
		System.out.println("1.Card "+"\n"+"2. UPI");
		int n = sc.nextInt();
		
		if(n==1) {
			System.out.println("            "+"Enter card details:"+"            ");
			System.out.println("Enter the card number");
			 cardno= sc.next();
			System.out.println("Enter the OTP code: ");
			int otp = sc.nextInt();
			System.out.println("the rufund will be done to"+ cardno+ "with in 3 banking days");
		}else {
			System.out.println("            "+"Enter upi details"+"            ");
			System.out.println("Enter upi id:");
			 cardno = sc.next();
			System.out.println("Enter the OTP code:");
			int otp = sc.nextInt();
			System.out.println("the rufund will be done to "+ cardno+ "with in 3 banking days"+"\n\n");
			
		}
// printing the admin confirmation
		
		System.out.println("                  "+"RECIPT"+"\n"+"\n"+"your flight number: "+ flightno +"\n"+ "ticket number: "+ ticketno +"\n"+
				"cacellation request has been sent to the admin the further procedures will de done by Admin");

//code for connection with jdbc
	
	
	 try{
		 
         Class.forName("com.mysql.jdbc.Driver");      //used to get instance of the class with specified class name
         String user="root";                          //user name of my sql
         String pass="Seb@43021";                   //password of my sql
         String url = "jdbc:mysql://localhost:3306/airbooking?autoReconnect=true&useSSL=false";
     Connection    con= DriverManager.getConnection(url,user,pass);  //Driver manager class attempts to establish a connection to the database

         String sql = "INSERT INTO cancel_tickets_request(flightno, ticketnumber, card_number) VALUES (?,?,?)";
 		PreparedStatement ps = con.prepareStatement(sql);
 		con.setAutoCommit(false);
 		ps.setString(1,  flightno  );
 		ps.setString(2,ticketno);//code for inputing details to database
 		ps.setString(3, cardno);
 		ps.execute();
 		con.commit();
 		con.close();

        
     }
     catch(Exception ex){
         ex.printStackTrace();
     }
	}}



 
 
	
	

	


