public class Main {
    public static void mergeSort(int low, int high, int []A) {
        int mid = (low + high) / 2;

        if(low >= high) {
            return;
        }
        else {
            mergeSort(low, mid, A);
            mergeSort(mid + 1, high, A);

            merge(low, mid, high, A);
        }
    }

    public static void merge(int low, int mid, int high, int []A) {
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
                k++;
            }
            else {
                A[k] = R[j];
                j++;
                k++;
            }
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
        if(low < high) {
            int pi = partition(A, low, high);

            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }

    public static int partition(int []A, int low, int high) {
        int pivot = A[high];

        int i = low - 1;

        for(int j = low; j <= high - 1; j++) {
            if(A[j] < pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, high);
        return i + 1;
    }

    public static void swap(int []A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void recursiveBubbleSort(int []A, int length) {
        if(length == 1) {
            return;
        }
        else {
            for(int i = 0; i < length - 1; i++) {
                if(A[i] > A[i + 1]) {
                    int swap = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = swap;
                }
            }
            recursiveBubbleSort(A, length - 1);
        }
    }

    public static void recursiveInsertionSort(int start, int []A) {
        if(start >= A.length) {
            return;
        }
        else {
            while(start > 0 && A[start - 1] > A[start]) {
                int swap = A[start - 1];
                A[start - 1] = A[start];
                A[start] = swap;
                start--;
            }
            recursiveInsertionSort(start + 1, A);
        }
    }

    public static void main(String[] args) {
        int []A = {10, 2, 3, 7, 5, 8, 9, 4, 1, 6};

//        mergeSort(0, A.length - 1, A);

//        quickSort(A, 0, A.length - 1);

//        recursiveBubbleSort(A, A.length);

//        recursiveInsertionSort(0, A);

        for(int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println( );
    }
}