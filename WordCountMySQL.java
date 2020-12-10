import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * This class implment a Word Count of a file
 * @author Mariadelly Esparza
 * @version 1.0
 *
 */

public class WordCountMySQL {
	
/**
 * @param args expression used when calling the method.
 * Creating the HashMap Class objects 
 * keys are String, values are Integer
 */
	
		 
	public static void main(String[] args) throws Exception { 
        HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
        
        // connect to Database
        String url = "jdbc:mysql://localhost:3306/wordoccurrences";
        String user = "root";
        String password = "Md1979";
        
        try {
        	Connection connection = DriverManager.getConnection(url, user, password);
        	
        	String sql = "SELECT * FROM wordoccurrences.word";
        	Statement statement = connection.createStatement();
        	statement.executeQuery(sql);
        	ResultSet result = statement.executeQuery(sql);
        	
        	int count = 0;
        	
        	while (result.next()) {
        		String idword =result.getString(1);
        		String word = result.getString("word");
        		count++;
        		System.out.println("Word " + count + ": " + word);
        		
        	}
            
            connection.close();
        	
        	
            //System.out.println("Connected to the database test1");
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
        	
            
        	// This code sorts outputs HashMap sorting it by values    
            // First we're getting values array */ 
            ArrayList<Integer> values = new ArrayList<Integer>();
            values.addAll(wordcount.values());
            // and sorting it (in reverse order) 
            Collections.sort(values, Collections.reverseOrder());
     
            int last_i = -1;
            // Now, for each value  
            for (Integer i : values) { 
                if (last_i == i) // without dublicates  
                    continue;
                last_i = i;
                // we print all hash keys            
                for (String s : wordcount.keySet()) { 
                    if (wordcount.get(s) == i) /* which have this value  */
                    System.out.println(s + "=" + i);
               
                            
                }
            }
	}
}


	

 
        
        
         
            	
