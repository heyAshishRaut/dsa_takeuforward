public class Main {
    public static void print1toN(int st, int num) {
        if(st > num) {
            return;
        }
        else {
            System.out.print(st + " ");
            print1toN(st + 1, num);
        }
    }

    public static void printNto1(int st, int num) {
        if(st > num) {
            return;
        }
        else {
            printNto1(st + 1, num);
            System.out.print(st + " ");
        }
    }

    public static void sumOfN(int ac, int num) {
        if(num == 0) {
            System.out.println("Sum - " + ac);
            return;
        }
        else {
            sumOfN(ac + num, num - 1);
        }
    }

    public static int factorial(int ac, int num) {
        if(num <= 1) {
            return ac;
        }
        else {
            return factorial(ac * num, num - 1);
        }
    }

    public static int[] reverseArray(int index, int []A) {
        if(index >= A.length / 2){
            return A;
        }
        else {
            int temp = A[index];
            A[index] = A[A.length - index - 1];
            A[A.length - index - 1] = temp;
            return reverseArray(index + 1, A);
        }
    }

    public static boolean checkPalindrome(int index, String s) {
        if(index >= s.length()) {
            return true;
        }
        else {
            if(s.charAt(index) != s.charAt(s.length() - index - 1)) {
                return false;
            }
            return checkPalindrome(index + 1, s);
        }
    }

    public static int fibonacci(int num) {
        if(num == 0 || num == 1) {
            return num;
        }
        else {
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }

    public static void main(String[] args) {
//        print1toN(1, 5);
//        T.C. - O(N)
//        S.C. - O(N)

//        printNto1(1, 5);
//        T.C. - O(N)
//        S.C. - O(N)

//        sumOfN(0, 5);
//        T.C. - O(N)
//        S.C. - O(N)

//        int ans = factorial(1, 5);
//        System.out.println(ans);
//        T.C. - O(N)
//        S.C. - O(N)

//        int []ans = reverseArray(0, new int[]{1, 2, 3, 4, 5});
//        for(int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i] + " ");
//        }
//        System.out.println( );
//        T.C. - O(N/2)
//        S.C. - O(N/2)

//        boolean ans = checkPalindrome(0, "ama");
//        System.out.println(ans);
//        T.C. - O(N)
//        S.C. - O(N)

//        int ans = fibonacci(5);
//        System.out.println(ans);
//        T.C. - O(2^N)
//        S.C. - O(N)
    }
}