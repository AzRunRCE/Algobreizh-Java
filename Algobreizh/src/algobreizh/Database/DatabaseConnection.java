package algobreizh.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    
    public static ResultSet execute(String requete) {
	Connection connexion;
	Statement stmt = null;
	ResultSet res = null;
	try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/Algobreizh_1.1?user=root&password=");
            //Class.forName("com.mysql.jdbc.Driver");
            stmt = connexion.createStatement();
            if(stmt.execute(requete)) {
		res = stmt.getResultSet();
            }
	} catch (Exception e) {
            System.out.println(e);
	}
	return res;
    }
    
}