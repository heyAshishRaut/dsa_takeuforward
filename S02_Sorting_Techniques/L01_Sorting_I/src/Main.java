public class Main {
    public static void selectionSort(int []A) {
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                if(A[i] > A[j]) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                }
            }
        }

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void bubbleSort(int []A) {
        for(int i = 0; i < A.length; i++) {
            boolean swap = false;
            for(int j = 0; j < A.length - i - 1; j++) {
                if(A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;

                    swap = true;
                }
            }
            if(!swap) {
                break;
            }
        }

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void insertionSort(int []A) {
        for(int i = 0; i < A.length; i++) {
            int j = i;
            while(j > 0 && A[j - 1] > A[j]) {
                int temp = A[j];
                A[j] = A[j - 1];
                A[j - 1] = temp;
                j--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        int []A = {10, 30, 50, 20, 40, 60, 90, 70, 80};
//        selectionSort(A);

//        Selection Sort is a sorting algorithm that repeatedly finds the smallest (or largest) element from the unsorted part of the array and moves it to its correct position in the sorted part.

//        T. C. - O(N * N)
//        S. C. - O(1)

//        bubbleSort(A);
//        Bubble Sort is a simple sorting algorithm that repeatedly compares adjacent elements and swaps them if they are in the wrong order.

//        insertionSort(A);
    }
}