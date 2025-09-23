package org.example.recursion;

public class Basics {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial of " + n + " is: " + factorial(n));
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
        System.out.println("Sum of first " + n + " natural numbers is: " + sumOfNaturalNumbers(n));
        System.out.println("Power of 2^" + n + " is: " + power(2, n));
        System.out.println("fibonacci number:"+fibonacci(5));
    }

    // Factorial of a number
    private static int factorial(int n) {
        if (n == 0) {
            return 1; // Base case: factorial of 0 is 1
        }
        return n * factorial(n - 1); // Recursive case
    }

    // Fibonacci of a number
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Base case: fibonacci(0) = 0, fibonacci(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }

    // Sum of first N natural numbers
    private static int sumOfNaturalNumbers(int n) {
        if (n == 1) {
            return 1; // Base case: sum of first natural number is 1
        }
        return n + sumOfNaturalNumbers(n - 1); // Recursive case
    }

    // Power function (x^n)
    private static int power(int x, int n) {
        if (n == 0) {
            return 1; // Base case: any number to the power of 0 is 1
        }
        return x * power(x, n - 1); // Recursive case
    }

    //print name n times
    static void func(int i, int n){

        // Base Condition.
        if(i>n) return;
        System.out.println("Raj");

        // Function call to print till i increments.
        func(i+1,n);

    }

    static boolean palindrome(int i, String s){

        // Base Condition
        // If i exceeds half of the string, means all the elements
        // are compared, we return true.
        if(i>=s.length()/2) return true;

        // If start is not equal to end, not palindrome.
        if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;

        // If both characters are same, increment i and check start+1 and end-1.
        return palindrome(i+1,s);


    }

    static void reverseArray(int arr[], int start, int end) {
        if (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            reverseArray(arr, start + 1, end - 1);
        }
    }
}
