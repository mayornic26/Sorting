
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

 public class SortingProof {
	public static void insertionSort() {
		//Insertion Sort code
		int[] insertionArray = new int[100];
	
         try {
			//Import the file into an array
			File myObj = new File("sample_dataNico.csv");
			Scanner myReader = new Scanner(myObj);
			int position = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				insertionArray[position] = Integer.parseInt(data);
				position++;
			}
			myReader.close();
			//Begin the sorting algorithim
			int insertMoves = 0;
			int insertCompare = 0;
			//start from the second element and move through it
			for (int j = 1; j < insertionArray.length; j++)
            {
			  insertCompare++; 
              int temp = insertionArray[j];
              int possibleIndex = j;
              //While we are not at the begninning and the current value is less than the previous value
              while (possibleIndex > 0 && temp < insertionArray[possibleIndex - 1])
              {
				  if(temp < insertionArray[possibleIndex - 1]) {
                     insertCompare++; 
                   }
                  //Shift the larger value one position to the right
                  insertionArray[possibleIndex] = insertionArray[possibleIndex - 1];
                  possibleIndex--;
              }
              insertionArray[possibleIndex] = temp;
              insertMoves++; //increase the moves counter
            }
            
			//show results on the screen
			System.out.println("The sorted Array with insertio sort looks like:");
			for(int i = 0; i < insertionArray.length; i++){
				System.out.print(insertionArray[i] + " ");
			}
			System.out.println("");
			System.out.println("The number of moves with the insertion algorithim is: " + insertMoves);
			System.out.println("The number of comparisons with insertion alogrithim is: " + insertCompare);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }
    
    public static void selectionSort() {
		//Selection Sort code
		int[] selectionArray = new int[100];
	
         try {
			//Import the file into an array
			File myObj = new File("sample_dataNico.csv");
			Scanner myReader = new Scanner(myObj);	
			int position = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				selectionArray[position] = Integer.parseInt(data);
				position++;
			}
			myReader.close();
			//Begin selection the soritng algorithim
			int selectionMoves = 0;
			int selectionCompare = 0;
			for (int j = 0; j < selectionArray.length - 1; j++) //iterate through the array 
            {
              int minIndex = j;
              for (int k = j + 1; k < selectionArray.length; k++) //search the rest of the array for a smaller element
              {
			  	selectionCompare++; //increase the compare counter
                if (selectionArray[k] < selectionArray[minIndex])
                {
                    minIndex = k;
                }
              }
              int temp = selectionArray[j]; //Temporarily store the value at index j (the current position)
              selectionArray[j] = selectionArray[minIndex]; // Replace the value at index j with the smallest value found
              selectionArray[minIndex] = temp; // puts the original value from index j into the minIndex position
              selectionMoves++; //increase the moves counter
            }
			//show results on the screen
			System.out.println("The sorted Array with selection sort looks like:");
			for(int i = 0; i < selectionArray.length; i++){
				System.out.print(selectionArray[i] + " ");
			}
			//prints the moves and compare 
			System.out.println("");
			System.out.println("The number of moves with the selection algorithim is: " + selectionMoves);
			System.out.println("The number of comparisons with selection alogrithim is: " + selectionCompare);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
    }
    
    //calls the methods to print
    public static void main(String[] args){
	  insertionSort();
	  selectionSort();
	}
}
