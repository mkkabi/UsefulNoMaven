
package Search;

    import java.lang.reflect.Array;
    import java.util.Arrays;
    import java.util.Scanner;

    public class Binary
    {
       public static void main(String args[])
       {
          int array[];

          Scanner input = new Scanner(System.in);
          System.out.println("Enter number of elements:");
         int Size_Of_Array = input.nextInt(); 

          array = new int[Size_Of_Array];

          System.out.println("Enter " + Size_Of_Array + " integers");

          for (int counter = 0; counter < Size_Of_Array; counter++)
              array[counter] = input.nextInt();

          Arrays.sort(array);
          System.out.println("Sorting Array is :-");
          for (int counter = 0; counter < Size_Of_Array; counter++)
              System.out.println(array[counter]);

          System.out.println("Enter the search value:");
          int  Searching_item = input.nextInt();

          int First_Index=0;
          int Last_Index=Size_Of_Array-1;
          int Middle_Index=(First_Index+Last_Index)/2;

          while(First_Index <= Last_Index)
          {
              if(array[Middle_Index] < Searching_item)
              {
                  First_Index=Middle_Index+1;
              }
              else if ( array[Middle_Index] == Searching_item ) 
              {
                System.out.println(Searching_item + " found at location " + (Middle_Index + 1) + ".");
                break;
              }
              else
              {
                  Last_Index = Middle_Index - 1;
              }
              Middle_Index = (First_Index + Last_Index)/2;

              if ( First_Index > Last_Index )
              {
                  System.out.println(Searching_item + " is not found.\n");
              }
          }
        }
    }