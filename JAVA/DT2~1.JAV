// Manipulation of an date using OOP concepts
// Copyright John B 1998
class Dt2 {
    public static void main (String args[]) {
        System.out.println("Johno's OOP Date handler Version 1.01");
        int     mday     =1;
        String  mmonth   ="Aug";
        int     myear    =1998;
        String  dtstring ="";
        boolean sts      =false;
        DateCls dtobj    =new DateCls();
        DateCls dtobj2   =new DateCls();

// Set the date in the first date object
        dtobj.setday(mday);
        dtobj.setmth(mmonth);
        dtobj.setyear(myear);

        dtstring= dtobj.getday()
                + "-" + dtobj.getmth()
                + "-" + dtobj.getyear();

        System.out.println("Date= " + dtstring);

// Set the date in the second date object
        dtobj2.setday(2);
        dtobj2.setmth("Sep");
        dtobj2.setyear(1997);

        dtstring= dtobj2.getday()
                + "-" + dtobj2.getmth()
                + "-" + dtobj2.getyear();

        System.out.println("Date= " + dtstring);

// Add a few days to the second date object
        sts=dtobj2.addday(15);
        dtstring= dtobj2.getday()
                + "-" + dtobj2.getmth()
                + "-" + dtobj2.getyear();

        System.out.println("Date= " + dtstring);

// Set day to first of month
        dtobj2.setday();

        dtstring= dtobj2.getday()
                + "-" + dtobj2.getmth()
                + "-" + dtobj2.getyear();

        System.out.println("Date= " + dtstring);

    }
}
class DateCls {
        int    aDay  =0;
        String aMonth="";
        int    aYear =0;

        public int getday() {
            return aDay;
        }

        public String getmth() {
            return aMonth;
        }

        public int getyear() {
            return aYear;
        }

        public void setday(int pDay) {
            aDay   = pDay;
        }

        public void setmth(String pMonth) {
            aMonth = pMonth;
        }

        public void setyear(int pYear) {
            aYear  = pYear;
        }

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
}
//////////////////////////////////////////////////////////////////////////////
