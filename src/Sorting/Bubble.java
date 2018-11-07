package Sorting;

class Bubble {
	
	void bubbleSort(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          int t = arr[j];
            arr[j] = arr[j + 1];
							arr[j + 1] = t;
        }
      }
    }
	}
	
  public static void main(String args[]) { 
		
    int nums[] = {99, -10, 100123, 18, -978, 5623, 463, -9, 287, 49};
    Bubble bub = new Bubble();
		
		bub.bubbleSort(nums);
		
		for(int i : nums){
			System.out.println(i);
		}
  }
}

