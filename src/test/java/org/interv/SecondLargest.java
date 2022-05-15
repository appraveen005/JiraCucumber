package org.interv;

public class SecondLargest {

	public static void main(String[] args) {

		// int temp, size;
		// int array[] = {10, 20, 25, 63, 96, 57};
		// size = array.length;
		//
		// for(int i = 0; i<size; i++ ){
		// for(int j = i+1; j<size; j++){
		//
		// if(array[i]>array[j]){
		// temp = array[i];
		// array[i] = array[j];
		// array[j] = temp;
		// }
		// }
		// }
		// for (int i = 0; i < array.length; i++) {
		// System.out.println(array[i]);
		//
		// }
		//
		// System.out.println("Third second largest number is:: "+array[size-2]);

		int temp;
		int a[] = { 45, 26, 32, 84, 64, 86, 65, 65 };

		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {

				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;

				}

			}

		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			
		}
		System.out.println(a[a.length-2]);
	}
	

}
