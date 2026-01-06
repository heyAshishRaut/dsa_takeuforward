import java.util.Arrays;

public class Main {
    public static void selectionSort(int []A) {
        for(int i = 0; i < A.length; i++) {
           for(int j = i + 1; j < A.length; j++) {
               if (A[i] > A[j]) {
                   int temp = A[j];
                   A[j] = A[i];
                   A[i] = temp;
               }
           }
        }

        System.out.println(Arrays.toString(A));
    }

    public static void bubbleSort(int []A) {
        for(int i = 0; i < A.length; i++) {
            boolean swap = false;
            for(int j = 0; j < A.length - 1 - i; j++) {
                if(A[j] > A[j + 1]) {
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;

                    swap = true;
                }
            }
            if(!swap) {
                break;
            }
        }

        System.out.println(Arrays.toString(A));
    }

    public static void insertionSort(int []A) {
        for(int i = 0; i < A.length; i++) {
            int j = i;
            while(j > 0 && A[j - 1] > A[j]) {
                int temp = A[j - 1];
                A[j - 1] = A[j];
                A[j] = temp;
                j--;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    public static void mergeSort(int []A, int low, int high) {
        if(low >= high) {
            return;
        }

        else {
            int mid = low + (high - low) / 2;

            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }

    public static void merge(int []A, int low, int mid, int high) {
        int size1 = mid - low + 1;
        int size2 = high - mid;

        int []L = new int[size1];
        int []R = new int[size2];

        for(int i = 0; i < size1; i++) {
            L[i] = A[low + i];
        }

        for(int i = 0; i < size2; i++) {
            R[i] = A[mid + 1 + i];
        }

        int i = 0, j = 0, k = low;

        while(i < size1 && j < size2) {
            if(L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < size1) {
            A[k] = L[i];
            i++;
            k++;
        }

        while(j < size2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int []A, int low, int high) {
        if(low > high) {
            return;
        }
        int pivot = partition(A, low, high);
        quickSort(A, low, pivot - 1);
        quickSort(A, pivot + 1, high);
    }

    public static int partition(int []A, int low, int high) {
        int pivot = A[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(A[j] < pivot) {
                i++;

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        int temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int []A = {1, 5, 3, 4, 2};
//        selectionSort(A);
//        bubbleSort(A);
//        insertionSort(A);
//        mergeSort(A, 0, A.length - 1);
//        quickSort(A, 0, A.length - 1);

        System.out.println(Arrays.toString(A));
    }
}