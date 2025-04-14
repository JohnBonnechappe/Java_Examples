/** Example of reading a file.
 * This program reads a file and lists each line.
 */

class Tst3 {
    public static void main (String args[]) {

	Tst3 t3 = new Tst3();

	String   dictFileName  ="dict.dat";

	System.out.println("The string is=" + dictFileName);

	t3.meth1();
    }

    public void meth1() {
	System.out.println("Now in meth1");
    }
}
////////////////////////////////////////////////////////////////////////