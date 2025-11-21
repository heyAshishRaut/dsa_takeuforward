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
        int left = low;
        int right = mid + 1;


    }

    public static void main(String[] args) {
        int []ans;
        ans = new int[6];
    }
}