package jUnitWordOccurrences;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Test;


public class JUnitTEST {
	

	@Test (expected = FileNotFoundException.class) 
    public void testFileReader() throws IOException { 
        FileReader BufferedReader = new FileReader("Words.txt");
        BufferedReader.read();
        BufferedReader.close();
	
	}
  }

	
	
