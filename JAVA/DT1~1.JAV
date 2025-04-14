// Manipulation of an date using OOP concepts
// Copyright John B 1998
class Dt1 {
    public static void main (String args[]) {
        System.out.println("Johno's OOP Date handler Version 1.01");
        int     mday     =1;
        String  mmonth   ="Aug";
        int     myear    =1998;
        String  dtstring ="";
        DateCls dtobj    =null;
        DateCls dtobj2   =null;
//
        dtobj = new DateCls();

        dtobj.setday(mday);
        dtobj.setmth(mmonth);
        dtobj.setyear(myear);

        dtstring= dtobj.getday() + dtobj.getmth() + dtobj.getyear();

        System.out.println("Date= " + dtstring);

//
        dtobj2 = new DateCls();

        dtobj2.setday(2);
        dtobj2.setmth("Sep");
        dtobj2.setyear(1997);

        dtstring= dtobj2.getday() + dtobj2.getmth() + dtobj2.getyear();

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
}
//////////////////////////////////////////////////////////////////////////////
