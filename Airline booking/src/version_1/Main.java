package version_1;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
@SuppressWarnings("static-access")
public static void main(String[] args) throws SQLException, ClassNotFoundException {
	Mainmenu  mm = new Mainmenu();
	mm.mainmenu();
	@SuppressWarnings("resource")
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	switch(n) {
	case 1: 
	Registration reg = new Registration();
	reg.userreg(null, null, null, n, null);
	break;
	case 2:SearchFlight sf = new SearchFlight();
	sf.searchflight(null, null);
	break;
	case 3:  Bookflight bf = new Bookflight();
	bf.bookflight(null, null, null, null, null);
	break;
	case 4:Cancel_flight cf = new Cancel_flight();
	cf.cancelflight(null, null, null);
	break;
	case 5 : 
	mm.mainmenu();
	case 6: Admin ad = new Admin();
	ad.newflight(null, null, null, null, null, null, null);
	break;
	case 7: 
	break;
	default : System.out.println("Give valid selection");
	}
}
}

