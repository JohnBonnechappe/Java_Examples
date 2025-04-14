/** Example of reading a file.
 * This program reads a file and lists each line.
 * It also puts each line into a vector.
 */

import java.io.DataInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Vector;
import java.util.StringTokenizer;

class ReadIntoVect {
    Vector wordVect	= new Vector(100,10);

    public static void main (String args[]) {
	ReadIntoVect riv = new ReadIntoVect();

	riv.readFile();
    }

    public void ReadIntoVect() {
    }

    public void readFile() {
	String	 wordFileName  = "words.dat";

	try {
	    FileReader     fr = new FileReader(wordFileName);
	    BufferedReader br = new BufferedReader(fr);
//					    read the file
	    boolean eof        = false;
	    while(!eof) {
	        String wordLine = br.readLine();
	        if (wordLine != null) {
		    parseLine(wordLine);
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

	System.out.println("Listing words in Wordlist Vector...");

	for (int i = 0; i < wordVect.size(); i++) {
	    System.out.println("Word at position " + i +" = " + wordVect.elementAt(i) );
	}
    }

    private void parseLine(String wordLine) {
	StringTokenizer aST = new StringTokenizer(wordLine, " ");

	System.out.println("parsing wordline=" + wordLine);

	while (aST.hasMoreTokens() ) {
	    String aWord = aST.nextToken();
	    System.out.println("word=" + aWord );

	    boolean existsFlag = false;
	    int imax = wordVect.size();
	    System.out.println("wordvectsize=" + imax );
	    for (int i=0; i < imax; i++) {
		System.out.println("wordvect=" + wordVect.elementAt(i) );
		if (wordVect.elementAt(i).equals(aWord) ) {
		    System.out.println("equality");
		    existsFlag = true;
		}
	    }
	    if (existsFlag == false) {
		wordVect.addElement(aWord);
	    }
	}

    }

}
////////////////////////////////////////////////////////////////////////