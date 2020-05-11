/**
 * Diego Hernandez
 * This program is a linear congruential random number generator.
 * x_i = (a * x_i + c) % K
 * u_i = x_i/K
 */

import java.text.*;
import java.util.Arrays;
import java.util.Scanner;

public class RandNumGen {
    public static void main(String[] args) {
        System.out.println("Input: " + Arrays.toString(args));
        Scanner s = new Scanner(System.in);

        try{
            System.out.print("Input an x_0: ");
            int x_0 = Integer.parseInt(s.nextLine());

            System.out.print("Input an a: ");
            int a = Integer.parseInt(s.nextLine());

            System.out.print("Input an c: ");
            int c = Integer.parseInt(s.nextLine());

            System.out.print("Input a k: ");
            double k = Double.parseDouble(s.nextLine());

            s.close();

            for(int j = 0; j < args.length; j++){
                int i = Integer.parseInt(args[j]);
                double u_i = lin_cong(i, k, x_0, a, c);
                DecimalFormat df = new DecimalFormat("###.####");
                System.out.println("u_" + i + " = " + df.format(u_i));
            }
        }catch (NumberFormatException e){
            System.out.println("Error: Enter a list of integers.");
        }catch (Exception e){
            System.out.println("Error: Something went wrong.");
        }
    }

    /**
     * Computes the recursive rule of the linear congruential random number generator
     * x_i = (a * x_(i - 1) + c) % k
     * 
     * @param i represents the ith random number u_i
     * @param k variable for equation
     * @param x_0 base case of recursion solving x_i
     * @param a variable for equation solving x_i
     * @param c variable for equation solving x_i     
     * @return x_i as defined above
     */
    public static double lin_cong_recurse(int i, double k, int x_0, int a, int c){
        if(i == 0){
            return x_0;
        }
        return (a * lin_cong_recurse(i - 1, k, x_0, a, c) + c) % k;
    }

    /**
     * Computes a random number using the linear congruential random number generator
     * u_i = x_i/k
     * 
     * 
     * @param i represents the ith random number u_i
     * @param k variable for equation
     * @param x_0 base case of recursion solving x_i
     * @param a variable for equation solving x_i
     * @param c variable for equation solving x_i
     * @return u_i as defined above
     */
    public static double lin_cong(int i, double k, int x_0, int a, int c){
        double x_i = lin_cong_recurse(i, k, x_0, a, c);
        return x_i/k;
    }
}