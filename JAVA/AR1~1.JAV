class Ar1 {
    public static void main (String args[]) {
        System.out.println("Johno's Array handler Version 1.01");
        System.out.println("Ave, Max, min of array!");
        float arry[] ={1f,2f,3f,4f,5f,6f,7f,8f,9f,10f};
        float atot = 0;
        float aave = 0;
        float amax = 0;
        float amin = 0;
        int i;
        amin = arry[0];

        for (i=0; i<10; i++)  {
              System.out.println("Index=" + i + "  Element=" + arry[i]);
              atot = atot + arry[i];
//
// Get the min and max of the array
//
              if (i > 0) {
                  int j = i - 1;
                  if (arry[i] > arry[j]) {
                      amax = arry[i];
                  }
                  if (arry[i] < arry[j]) {
                      amin = arry[i];
                  }

              }
        }
        aave = atot / 10;

        System.out.println("Tot=!"+ atot);
        System.out.println("Ave=!"+ aave);
        System.out.println("Min=!"+ amin);
        System.out.println("Max=!"+ amax);
      }
}
