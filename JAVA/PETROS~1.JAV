// Illustration of an object calling another
// Copyright John B 07-Aug-1998
//
// This routine expects 3 args when it is called.
//
class PetroSite {
    public static void main (String args[]) {
        boolean sts      =false;
        SiteCls siteobj  =new SiteCls();
	int    p1 = 0;
	String p2 = " ";
	int    p3 = 0;

        System.out.println("Johno's DemoSite Version 1.01");
	System.out.println("First  Param=" + args[0]);
	System.out.println("Second Param=" + args[1]);
	System.out.println("Third  Param=" + args[2]);

	p1 = Integer.parseInt(args[0]);
	p2 =		      args[1];
	p3 = Integer.parseInt(args[2]);

	siteobj.setSite(p1,p2,p3);

	System.out.println("Site=" + siteobj.toString());
    }
}
class SiteCls {
        int    siteCode      =0;
        String siteName      ="";
        int    sitePostcode  =0;

        public int getSitecode() {
            return siteCode;
        }

        public String getName() {
            return siteName;
        }

        public int getPostcode() {
            return sitePostcode;
        }

        public void setSite(int siteCode,String siteName,int sitePostcode) {
            this.siteCode     = siteCode;
            this.siteName     = siteName;
            this.sitePostcode = sitePostcode;
        }

        public String toString() {
            return (siteCode + " " + siteName + " " + sitePostcode);
        }
/*
        public boolean addday(int pDayCount) {
            int tmpDay=0;
            tmpDay = aDay + pDayCount;
            if (tmpDay <= 30) {
                aDay = tmpDay;
                return true;     
            }
            else {
                return false;
            }
        }
//Note that this is an "Overloaded" method. ie already defined.
        public void setday() {
            aDay   = 1;
        }

*/
}
//////////////////////////////////////////////////////////////////////////////
