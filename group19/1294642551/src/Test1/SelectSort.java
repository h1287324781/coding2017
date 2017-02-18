package Test1;

public class SelectSort {

	public static void main(String[] args) {
		
		int[] arr = {34, 19, 11, 109, 3, 56};
		printArr(arr);
		selectSort(arr);
		printArr(arr);


	}

	public static void printArr(int[] arr) {

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	public static void selectSort(int[] arr) {
		
		for(int i = 0; i < arr.length -1; i++)
		{
			for(int j = i +1; j < arr.length; j++)
			{
				if (arr[j] < arr[i])
					swap(arr, i ,j);
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
