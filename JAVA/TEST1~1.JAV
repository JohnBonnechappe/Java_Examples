/**
 
 
 */
import java.io.*;

import java.util.Hashtable;
import java.util.Enumeration;

import java.util.Vector;
import java.util.StringTokenizer;

import java.net.*;

class Test1 {

    public static void main (String args[]) {
	boolean  sts           = true;
	String	 wordFileName  = " ";

        System.out.println("John & Sofiya's Spelling Checker Version 1.02");

	byte inByte[] = new byte[2];
	String tmpString = " ";
	String retString = " ";

	int addIndic	=0;
	retString	=" ";
	char  ch = " ";

	try {
	    System.out.println("Do you want to add to the Personal Dictionary Y=yes");

	    DataInputStream stdin = new DataInputStream(System.in);
//	    stdin.flush();

	    inByte[0] = stdin.readByte();	
            System.out.println("byte0=" + " " + inByte[0]);
	    inByte[1] = stdin.readByte();
	    System.out.println("byte1=" + " " + inByte[1]);   
	    tmpString		= new String( inByte);
	    retString		= tmpString.trim();

	    retString=retString.valueOf(ch);

	    System.out.println("Entered option=" + retString);
	    stdin.close();
	  } catch (IOException e) {System.out.println("Error on scrn input" + e.toString() );
	}


	System.exit(1);
    }


}
////////////////////////////////////////////////////////////////////////