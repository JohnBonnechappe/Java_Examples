// Manipulation of an array using OOP concepts
// Copyright John B 1998
class Ar2 {
    public static void main (String args[]) {
        System.out.println("Johno's OOP Array handler Version 1.01");

        float atot = 0;
        float aave = 0;
        float amax = 0;
        float amin = 0;
        int i;
        amin = arry[0];
               System.out.println("Index=" + i + "  Element=" + arry[i]);

        arrayave(array_ave);

        System.out.println("Tot=!"+ atot);
        System.out.println("Ave=!"+ array_ave);
        System.out.println("Min=!"+ array_min);
        System.out.println("Max=!"+ array_max);

}


Class Thearray {
        float arry[] ={1.9f,2.7f,3.11f,4f,5f,6f,7f,8f,9f,10f};
        float arrysize=0;
        string arryowner="";

        public string getelem(int i) {
            return arry[i];

        }

        public boolean newelem(string newelem) {
            if (arrysize = 10) {
                return false;
            else
                int j=arrysize+1;
                arry[j]=newelem;
                return true;
            }
        }

        public void setelem(int i, string newelem) {
                arry[i]=newelem;
            }
        }


        public float arrayave(float ave) {
            for (i=0; i<10; i++)  {

              atot = atot + arry[i];
//
// Get the min and max of the array
//
            }
            aave = atot / 10;

      }

        public float arraymin(float min) {
              if (i > 0) {
                  int j = i - 1;
                  if (arry[i] > arry[j]) {
                      amax = arry[i];
                  }
                  if (arry[i] < arry[j]) {
                      amin = arry[i];
                  }

              }

            if arrysize = 10) {
                return false;
            else
                return true;
            }
        }

        public float arraymin(float max) {
            if arrysize = 10) {
                return false;
            else
                return true;
            }
        }



}
