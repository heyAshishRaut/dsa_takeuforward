public class Main {
    public static void elementOccurrence(int []A) {
//      Given an array, we have found the number of occurrences of each element in the array.
//        Input: arr[] = {10,5,10,15,10,5};
//        Output:
//        10  3
//        5  2
//        15  1

        int max = -1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > max){
                max = A[i];
            }
        }

        int []occur = new int[max + 1];
        for(int i = 0; i < A.length; i++) {
            occur[A[i]]++;
        }

        for(int i = 0; i < occur.length; i++) {
            System.out.print(occur[i] + " ");
        }
    }

    public static void elementOccurrence2(int []A) {
        boolean []isVisited = new boolean[A.length];

        for(int i = 0; i < A.length; i++) {
            if(!isVisited[i]) {
                int key = A[i];
                int val = 1;
                for(int j = i + 1; j < A.length; j++) {
                    if(!isVisited[j] && A[j] == key) {
                        isVisited[j] = true;
                        val++;
                    }
                }
                System.out.println(key + "  " + val);
            }
        }
    }

    public static void minMaxInArray(int []A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++) {
            if(A[i] > max) {
                max = A[i];
            }
            if(A[i] < min) {
                min = A[i];
            }
        }
        System.out.println("Max - " + max);
        System.out.println("Min - " + min);
    }

    public static void main(String[] args) {
        int []A = {1, 1, 2, 3, 4, 4, 4, 5};
//        elementOccurrence(A);

//        T.C. - O(maxElementOfArray) ~ O(N)
//        S.C. - O(maxElementOfArray) ~ O(N)

//        int []A = {1, 1, 2, 3, 4, 4, 4, 5};
        elementOccurrence2(A);

//        T.C. - O(maxElementOfArray) ~ O(N)
//        S.C. - O(maxElementOfArray) ~ O(1)

//        int []A = {10, 1, 20, 30, 50, 10000, 80, 100};
//        minMaxInArray(A);

//        T.C. - O(N)
//        S.C. - O(1)
    }
}
