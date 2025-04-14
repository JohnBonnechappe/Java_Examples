/** Example of reading a file.
 * This program reads a file and lists each line.
 */

class Tst4 {
    public static void main (String args[]) {

	Tst4 t4 = new Tst4();

	String   dictFileName  ="dict.dat";

	dictFileName = "dict2.dat";

	System.out.println("The string is=" + dictFileName);

	t4.meth1(dictFileName);

	System.out.println("Returned=" + dictFileName);
    }

    public void meth1(String dictFileName) {
	System.out.println("Now in meth1=" + dictFileName);
	dictFileName = "dict3.dat";

	System.out.println("Now in meth1=" + dictFileName);
    }
}
////////////////////////////////////////////////////////////////////////