/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.Scanner;

/**
 *
 * @author desarrollo6
 */
public class FindDigits {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        int i = 1;
        int[] array = new int[t];
        // while input numbers
        while (i <= t) {
            int n = 0;
            do {
                n = scanner.nextInt();
            } while (n <= 0);
            array[i - 1] = n;
            i++;
        }
        // Operations
        double base = 10;
        for (int num : array) {
            // Calculate Base 10 for digits number
            double div, pow = 0;
            while (true) {
                div = Math.pow(base, pow);
                if (num < div) {
                    pow--;
                    break;
                }
                pow++;
            }
            // Calculate number of uniform divisors
            int copyNum = num;
            int count = 0;
            while (pow >= 0) {
                div = Math.pow(base, pow);
                if (copyNum < div) {
                    pow--;
                    continue;
                }
                int dig = copyNum / (int)div;
                copyNum = copyNum - (dig * (int)div);
                pow--;
                if (num % dig == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
