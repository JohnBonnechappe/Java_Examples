/** Example of reading a file.
 * This program reads a file and lists each line.
 */

class Tst5 {
    String   dictFileName  ="dict.dat";

    public static void main (String args[]) {

	Tst5 t5 = new Tst5();

	t5.dictFileName = "dict2.dat";

	System.out.println("The string is=" + t5.dictFileName);

	t5.meth1(t5.dictFileName);

	System.out.println("Returned=" + t5.dictFileName);
    }

    public void meth1(String dictFN) {
	System.out.println("Now in meth1=" + dictFN);
	dictFN = "dict3.dat";

	System.out.println("Now in meth1=" + dictFN);

	dictFileName="aaaaa";
    }
}
////////////////////////////////////////////////////////////////////////