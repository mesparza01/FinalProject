import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * This class implment a Word Count of a file
 * @author Mariadelly Esparza
 * @version 1.0
 *
 */

public class WordCount {
	
/**
 * @param args expression used when calling the method.
 * Creating the HashMap Class objects 
 * keys are String, values are Integer
 */
		 
	public static void main(String[] args) { 
        HashMap<String, Integer> wordcount = new HashMap<String, Integer>();
        
       
        try { 
            // Opening file 
             BufferedReader in = new BufferedReader(new FileReader( 
            "C:\\Users\\TEMP\\eclipse-workspace\\TextAnalyzer\\Words.txt"));
            // string buffer for file reading   
            String str;
 
            /* reading line by line from file */
            while ((str = in.readLine()) != null) { 
 
             // starting index, we'll use this to copy words from string 
                int idx1 = -1;
              // process each characters  
                for (int i = 0; i < str.length(); i++) { 
                    // trigger condition if current character is not letter 
                    // or it is the end of line  
                    if ((!Character.isLetter(str.charAt(i))) || (i + 1 == str.length())) { 
                        // do nothing if previous character was also non-letter 
                        if (i - idx1 > 1) { 
                            //copy word from input string buffer to new variable  
                            if (Character.isLetter(str.charAt(i))) 
                                i++;  
                            String word = str.substring(idx1 + 1, i);
   
                            // Check if word is in HashMap 
                                if (wordcount.containsKey(word)) { 
                                /* get number of occurrences for this word increment it  
                                 and put back again  */
                                wordcount.put(word, wordcount.get(word) + 1);
                                 } else { 
                                // this is first time we see this word, set value '1' 
                                wordcount.put(word, 1);
                            } 
                        } 
 
                        /* remember current position as last non-letter symbol */                     
                        idx1 = i;
                    } 
                } 
            } 
            
            // Close buffered reader 
            in.close();   
            // If something unexpected happened 
            // print exception information and quit  
        } catch (Exception e) { 
            e.printStackTrace();
            System.exit(1);
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
                //JOptionPane.showInputDialog(s + "=" + i) ;
                //JOptionPane.showMessageDialog(null, (s + "=" + i));
        		//System.exit(0);
                
          }           
        }
     }
  }
        
        
         
            	
