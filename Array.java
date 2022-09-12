package stuff.java;

public class Array {

        private int [] [] arr;
        /**
         * @param args command line parameters
         */
        public static void main(String[] args) {
            int[][] spreadsheet = new int[][] {
                    {1,2,3},
                    {4,5,6},
                    {7,8,9}
            };
            System.out.println("Max: " + max(spreadsheet));
            System.out.println("Sum of row 0: " + rowSum(spreadsheet,0));
            System.out.println("Sum of col 0: " + columnSum(spreadsheet,0));
            int[] rowSums = allRowSums(spreadsheet);
            for(int row = 0; row < rowSums.length; row++) {
                System.out.println("Sum of row " + row + ": " + rowSums[row]);
            }

        }

        /**
         * @param a 2D array
         * @return the maximum value in the 2d parameter array a
         */

        public static int max(int[][] a) {

            int maximum = a[0][0];

            //checks every value in the array and compares it to the previous largest number
            for (int [] max : a) {
                for (int val : max) {
                    //checks if the value is null before comparing
                    if (Integer.toString(val)!=null){
                        //compares then sets if true
                        if (maximum < val){
                            maximum = val;
                        }
                        else {
                            continue;
                        }
                    }
                }
            }

            return maximum;
        }

        /**
         * @param a 2D array
         * @param x row index
         * @return the sum of the elements in Row x of a
         */
        public static int rowSum(int[][] a, int x) {

            int total = 0;

            //adds up the value in the row
            for (int i = 0; i < a[x].length; i++) {
                total = total + a[x][i];
            }

            return total;
        }

        /**
         * @param a 2D array
         * @param x column index
         * @return the sum of the elements in Column x of a (careful with rows of different lengths!)
         */
        public static int columnSum(int[][] a, int x) {
            int total = 0;
            int maxlength = 0;
            int maxrow = 0;
            int [] [] newarr;
            int rowlength = 0;

            //finds maximum length for both rows and columns
            for (int j = 0; j < a.length; j++){
                if (maxlength < a[j].length){
                    maxlength = a[j].length;
                }
            }
            for (int k = 0; k < a.length; k++){
                if (maxrow < a.length){
                    maxrow = a.length;
                }
            }

            // setting the length of the new array with the maximum row and columns that the old array had
            newarr = new int [maxrow] [maxlength];
            /*
            0,0,0,0
            0,0,0,0
            0,0,0,0

                                {-10,-12,-3, 0},
                                {-4,-5,-6,-8},
                                {-7,-8, 0, 0}
             */


            // sets the values of the old array into the new array
            for (int row = 0; row < a.length; row++) {
                for (int column = 0; column < a[rowlength].length; column++) {
                    newarr[row][column] = a[row][column];
                }
                rowlength++;
            }

            // adds the sum of the column
            for (int i = 0; i < newarr.length; i++) {
                total = total + newarr[i][x];

            }

            return total;
        }


        /**
         * @param a 2D array
         * @return calculates the row sum for every row and returns each of the values in an array. Index i of the return array contains the sum of elements in row i.
         */
        public static int[] allRowSums(int[][] a) {

            int [] sum = new int [a.length];

            for (int row = 0; row < a.length;row++) {
                //sets or resets the sum of the row to 0
                int sumOfRow = 0;

                for (int column = 0; column < a[0].length;column++) {
                    //adds up all the numbers in that row
                    sumOfRow += a[row][column];
                }
                //sets that specific row total value into that the next element in the array
                sum[row] = sumOfRow;
            }
            return sum;
        }

}
