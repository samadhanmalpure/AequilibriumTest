package controller;

import java.util.ArrayList;

/**
 * Created by Samadhan on 03-06-2017.
 */
public class Castles {

    public static void main(String[] args){
        Castles test = new Castles();

        int[] arr = {0,0,0,0,1,1,1,1,1,2,2,2,2,3,3,3,3,6,6,6,6,2,2,2,2,5,5,5,5,5,1,1,1,1,1,8,6,3,6,3,2,4,2,1,3,1,3,35,21,9,7,54,32,21,312,345,546,546,6,324};
        int[] arr1  = {0,20,0,1,3,4,1,1,71,15,2,2,2,22,3,3,3,3,6,6,6,6,2,2,2,2,5,5,5,5,5,1,1,1,1,1,8,6,3,6,3,2,4,2,1,3,1,3,35,21,9,7,54,32,21,312,345,546,546,6,324};
        int[] arr2 = {0,0,0,1,1,1,2,2,2};
        int[] arr3 = {2,6,6,6,3};
        int[] arr4 = {1,2,1,1,7,1,4,2,3};

        System.out.println("number of crestles in arr --> "+ test.findNumberOfCastles(arr));
        System.out.println("number of crestles in arr1 --> "+ test.findNumberOfCastles(arr1));
        System.out.println("number of crestles in arr2 --> "+ test.findNumberOfCastles(arr2));
        System.out.println("number of crestles in arr3 --> "+ test.findNumberOfCastles(arr3));
        System.out.println("number of crestles IN arr4--> "+ test.findNumberOfCastles(arr4));
    }

    private  int findNumberOfCastles(int[] landHeightValueArray) {

        //declaring two arrayList for adding peak values and valley values.

        ArrayList<Integer> peakList = new ArrayList<>();
        ArrayList<Integer> valleyList = new ArrayList<>();

        //Calculate length of array.
        int lengthOflandHeightValueArray = landHeightValueArray.length;

        /*Iterate through the array to find out peak and valley values from the given array.
          Peak - A peak is an integer or series of integers that is above the immediately preceding and following
                 ints. For example, in the sequence [2,6,6,6,3] the sequence of 3 6s is a peak.

          Valley - A valley is an integer or series of integers that is below the immediately preceding and
                   following ints. For example, in the sequence [6,1,4] the "1" would be a valley.

           Start iteration from the first value as for finding the peak or valley, we have to compare that element with its previous
            and next element. So for the first and last element, this condition fails.
         */

        for (int i = 1; i < lengthOflandHeightValueArray;i++ ) {

            /*
              If the previous value is less than the current value, check for the duplicate digits
               immediately following the current element.

               Get the position of last duplicate element, and compare the next position element value with the current value.

               If the value is less than the current value then the current value is the peak value.

               Add that value in peak list.

               Apply the same login for finding the valley values as well and add that value in the valley list.

               The number of crastles = Number of Peaks + Number of Valleys.

               The first if block is for finding peak list.

             */
            if(landHeightValueArray[i-1] < landHeightValueArray[i]){
                int j= i+1;
                while(j != lengthOflandHeightValueArray && landHeightValueArray[i] == landHeightValueArray[j] ){
                    j++;
                }

                if(j == lengthOflandHeightValueArray)
                    j--;

                if(landHeightValueArray[i] > landHeightValueArray[j]){
                    peakList.add(landHeightValueArray[i]);
                }

            }

            // This if block is used for finding valley list.
            if(landHeightValueArray[i-1] > landHeightValueArray[i]){
                int j= i+1;
                while(j != lengthOflandHeightValueArray && landHeightValueArray[i] == landHeightValueArray[j] ){
                    j++;
                }

                if(j == lengthOflandHeightValueArray)
                    j--;

                if(landHeightValueArray[i] < landHeightValueArray[j]){
                    valleyList.add(landHeightValueArray[i]);
                }

            }
        }

        return  peakList.size() + valleyList.size();
    }
}
