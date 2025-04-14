/** Example of reading a file.
 * This program reads a file and lists each line.
 * It also puts each line into a hashtable.
 */

import java.io.DataInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Hashtable;
import java.util.Enumeration;


class ReadIntoHash {
    public static void main (String args[]) {
	String   dictFileName  ="dict.dat";

	Hashtable dictHT	= new Hashtable(50);

	try {
	    FileReader     fr = new FileReader(dictFileName);
	    BufferedReader br = new BufferedReader(fr);
//					    read the file
	    boolean eof        = false;
	    while(!eof) {
	        String dictLine = br.readLine();
	        if (dictLine != null) {
		    System.out.println("read dict=" + dictLine);
	    	    dictHT.put(dictLine,dictLine);
	        }
	        else {
		    eof = true;
	        }
	    }
//						close the file
	    br.close();
	} catch (IOException e) {
	    System.out.println("Error -- " + e.toString() );
	  }

// 			Now list the hashtable
	System.out.println("Listing words in Dictionary Hashtable...");

	for (Enumeration wordsEnum = dictHT.keys(); wordsEnum.hasMoreElements();) {
	    System.out.println("Current word=" + wordsEnum.nextElement());
	}
    }
}
////////////////////////////////////////////////////////////////////////