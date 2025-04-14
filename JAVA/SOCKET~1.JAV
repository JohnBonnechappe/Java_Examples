/**
 * Part 4 of Assignment 2 of the Java Course.
 *
 * Description:
 * This program checks the spelling of each word in a file against
 * a main dictionary which is accessed through a server on the net.
 * Optionally, a personal dictionary can be used for checking. Any
 * words that fail checking can optionally be written to the
 * personal dictionary.
 *
 
 */
import java.io.*;

import java.util.Hashtable;
import java.util.Enumeration;

import java.util.Vector;
import java.util.StringTokenizer;

import java.net.*;

class SocketTest {

    public static void main (String args[]) {
	boolean  sts           = true;
	String	 wordFileName  = " ";

        System.out.println("John & Sofiya's Spelling Checker Version 1.02");

	if (args.length == 0) {
	    System.out.println("No file name supplied, using words.dat");
	    wordFileName = "words.dat";
	}
	else {
	    System.out.println("Checking " + args[0]);
	    wordFileName = args[0];
	}

	new SocketTest(wordFileName);
    }

    public SocketTest(String wordFileName) {

	readFiles(wordFileName);

    }

    public void readFiles(String wordFileName) {

	String   persDictFileName  ="pers.dat";

	MainDictionary		  mainDictObj    = new MainDictionary();

	PersonalDictionary	  persDictObj    = new PersonalDictionary();

	WordCls		 	  wordObj	 = new WordCls();

        mainDictObj.dictClsDo();

	persDictFileName = getPersName();

	if (persDictFileName.equals("") ) {
//	    no action
	}
	else {
            persDictObj.dictClsDo(persDictFileName);
	}

        wordObj.wordClsDo(wordFileName);

/**
 * Now we check each word from the Vector against the main Dictionary on the net,
 * and if required, also checks against the personal dictionary Hashtable.
 *
 */
	boolean mStat		= true;
	boolean pStat		= true;
	String aaWord		= " ";
	int addWordIndic	= 0;

	System.out.println("These are the incorrect words:");
	
	aaWord = wordObj.getWord();

	while (aaWord != null) {
	
	    mStat = mainDictObj.isValidWord(aaWord);

	    if (mStat != true) {

		if (persDictFileName.equals("") ) {
		    System.out.println(aaWord + " <<<< is NOT in the main dictionary");
		}
		else {
		    pStat = persDictObj.isValidWord(aaWord);
	            if (pStat != true) {
		        System.out.println(aaWord + " <<<< is NOT in either dictionary");
		        addWordIndic=addWordPrompt();
		        if (addWordIndic == 1) {
			    persDictObj.addThisWord(aaWord, persDictFileName);
		        }
		    }
		}
	    }
	    aaWord = wordObj.getWord();
	}
    }

    public String getPersName() {
	byte inByte[] = new byte[12];
	String tmpString = " ";
	String retString = " ";
	int tstInt	= 0;

	try {
	    System.out.println("Enter the name of the Personal Dictionary");
	    System.out.println("Leave blank to not use a Personal Dictionary");

	    DataInputStream stdin = new DataInputStream(System.in);

	    int ii = 0;
	    do {
	        inByte[ii] = stdin.readByte();
		tstInt = (int) inByte[ii];
		ii++;
	    } while ( ii < 12 &&  tstInt != 13);
	    tmpString		= new String( inByte);
	    retString		= tmpString.trim();
	    stdin.close();
	  } catch (IOException e) {System.out.println("Error on scrn input");
	}

	if (retString.equals("") ) {
	    System.out.println("No personal Dictionary is being used");
	}
	else {
	    System.out.println("Entered personal Dictionary name=" + retString);
	}
	return retString;
    }

    public int addWordPrompt() {
	byte inByte[] = new byte[2];
	String tmpString = " ";
	String retString = " ";

	int addIndic=0;
	retString	=" ";

	try {
	    System.out.println("Do you want to add to the Personal Dictionary Y=yes");

	    DataInputStream stdin = new DataInputStream(System.in);
	    System.out.flush();

	    inByte[0] = stdin.readByte();	
            System.out.println("byte0=" + " " + inByte[0]);
	    inByte[1] = stdin.readByte();
	    System.out.println("byte1=" + " " + inByte[1]);   
	    tmpString		= new String( inByte);
	    retString		= tmpString.trim();

	    System.out.println("Entered option=" + retString);
	    stdin.close();
	  } catch (IOException e) {System.out.println("Error on scrn input" + e.toString() );
	}
	if (retString.equals("Y") ) {
	    addIndic=1;
	}
	else {
	    addIndic=0;
	}

	return addIndic;
    }

/**
 * This abstract class forms the basis
 * for the personal dictionary.
 */
abstract class DictCls {
    Hashtable dictHT	= new Hashtable(50);
    String dictword	= " ";

    public void DictCls() {
    }

    public void dictClsDo(String aDictFileName) {
//					    set up the file character stream 
	try {
	    FileReader     fr = new FileReader(aDictFileName);
	    BufferedReader br = new BufferedReader(fr);
//					    read the file
	    boolean eof        = false;
	    while(!eof) {
	        String dictLine = br.readLine();
 	        if (dictLine != null) {
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
    }

    public void listDict() {
	System.out.println("Listing words in Dictionary Hashtable...");

	for (Enumeration wordsEnum = dictHT.keys(); wordsEnum.hasMoreElements();) {
	    System.out.println("Current word=" + wordsEnum.nextElement());
	}
    }

    public boolean isValidWord(String aWord) {
	return (dictHT.get(aWord) != null);
    }

}

class MainDictionary  {
    boolean aMDStat		= true;

    public void dictClsDo() {
    }

    public boolean isValidWord(String aWord) {
	String incoming = "";
	String info	= "";

	try {
	    Socket socket = new Socket("161.100.4.45",13);
	    BufferedReader br = new BufferedReader (
		new InputStreamReader(socket.getInputStream() ) );
	    PrintWriter ps = new PrintWriter(socket.getOutputStream(), true);
	    while ( (incoming = br.readLine() ) != null) {
	        info = info + incoming;
	    }
	    System.out.println("Received text=" + info);
	} catch (IOException e) {System.out.println("Error on socket create" + e.toString() );
	}
	aMDStat = false;
	return (aMDStat);
    }
}

class PersonalDictionary extends DictCls {
    public void addThisWord(String aaWord , String persDictFileName) {
/**
 * This is where we write a new version of the personal dictionary.
 * First write add the new word to the Hashtable, then write the entire hashtable to the file.
 *
 */
	System.out.println("Adding word=" + aaWord);
	dictHT.put(aaWord,aaWord);
	try {
	    FileOutputStream fos = new FileOutputStream(persDictFileName);
	    PrintWriter pw = new PrintWriter(fos,true);

	    for (Enumeration wordsEnum = dictHT.keys(); wordsEnum.hasMoreElements();) {
		pw.println(wordsEnum.nextElement());
	    }

	    fos.close();
	    pw.close();
          } catch (IOException e) {System.out.println("Error on file write" + e.toString() );
	}
    }
    }

class WordCls {
    Vector wordVect	= new Vector(100,10);
    int ii = 0;

    public void WordCls() {
	ii = 0;
    }

    public void wordClsDo(String wordFileName) {

//					    set up the file character stream
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
    }

    private void parseLine(String wordLine) {
	StringTokenizer aST = new StringTokenizer(wordLine, " !-,.:;-\"");

	while (aST.hasMoreTokens() ) {
	    String aWord = aST.nextToken();

	    boolean existsFlag = false;
	    for (int i=0; i < wordVect.size(); i++) {
		if (wordVect.elementAt(i).equals(aWord) ) {
		    existsFlag = true;
		}
	    }
	    if (existsFlag == false) {
		wordVect.addElement(aWord);
	    }
	}
    }

    public void listWord() {
	System.out.println("Listing words in Wordlist Vector...");

	for (int i = 0; i < wordVect.size(); i++) {
	    System.out.println("Word at position " + i +" = " + wordVect.elementAt(i) );
	}
    }

    public String getWord() {
	String aaaWord;
/**
 *
 * vector starts at zero!
 */
	if (ii < wordVect.size() ) {
	    aaaWord = (String) wordVect.elementAt(ii);
	    ii++;
	    return aaaWord;
	}
	else {
	    return null;
	}
    }
}
}
////////////////////////////////////////////////////////////////////////