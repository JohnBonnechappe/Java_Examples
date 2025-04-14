/** Example of reading a file.
 * This program reads a file and lists each line.
 */
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

class FileRead1 {
    public static void main (String args[]) {
	String   dictFileName  ="dict.dat";

	try {
	    FileReader     fr = new FileReader(dictFileName);
	    BufferedReader br = new BufferedReader(fr);
//					    read the file
	    boolean eof        = false;
	    while(!eof) {
	        String dictLine = br.readLine();
	        if (dictLine != null) {
		    System.out.println("read dict=" + dictLine);
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
    }
}
////////////////////////////////////////////////////////////////////////