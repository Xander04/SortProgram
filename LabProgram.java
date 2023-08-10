package labProgram;

import java.util.Random;
import java.util.Scanner;

public class LabProgram {
   // Read and return an array of integers.
   // The first integer read is number of integers that follow.
   private static int[] readNums() {
	  Random rn = new Random();
	  System.out.println("Enter numbers:");
      Scanner scnr = new Scanner(System.in);
      int size = scnr.nextInt();                // Read array size
      int[] numbers = new int[size];    
	  System.out.println("Generating random Numbers"); // Create array
      for (int i = 0; i < size; ++i) {          // Read the numbers
         numbers[i] = Math.abs(rn.nextInt() % size);
      }
      return numbers;
   }

   // Print the numbers in the array, separated by spaces
   // (No space or newline before the first number or after the last.)
   private static void printNums(int[] nums) {
      for (int i = 0; i < nums.length; ++i) {
         System.out.print(nums[i]);
         if (i < nums.length - 1) {
            System.out.print(" ");
         }
      }
      System.out.println();
   }

   // Exchange nums[j] and nums[k].
   private static void swap(int[] nums, int j, int k) {
      int temp = nums[j];
      nums[j] = nums[k];
      nums[k] = temp;
   }

   // Sort numbers
   /* TODO: Count comparisons and swaps. Output the array at the end of each iteration. */
   public static long[] insertionSort(int[] numbers) {
      long[] comp = new long[2];
      long comaparisons = 0; 
      long swaps = 0;
      int i;
      int j;
      System.out.println("Sorting");
      
      for (i = 1; i < numbers.length; ++i) {
         j = i;
         //comaparisons++;
         // Insert numbers[i] into sorted part,
         // stopping once numbers[i] is in correct position
         while (j > 0 ) {
            comaparisons++;
            if (numbers[j] < numbers[j - 1]) {
               // Swap numbers[j] and numbers[j - 1]
               swap(numbers, j, j  - 1);
               --j;
               swaps++;
               
            }
            else {
               break;
            }
         }
        // printNums(numbers);
      }
      //printNums(numbers);
      comp[0] = comaparisons;
      comp[1] = swaps;
      return comp;
   }

   public static void main(String[] args) {
      // Step 1: Read numbers into an array
      int[] numbers = readNums();

      // Step 2: Output the numbers array
      //printNums(numbers);
      System.out.println();

      // Step 3: Sort the numbers array
      long[] comp = insertionSort(numbers);
      System.out.println();

      // step 4
      System.out.printf("comparisons: %d\n", comp[0]);
      System.out.printf("swaps: %d\n", comp[1]);
   }
}

