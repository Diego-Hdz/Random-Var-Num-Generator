/**
 * Diego Hernandez
 * This program returns random variable realization for a continuous random variable with 
 * exponential distribution using the inverse of the cumulative distribution function
 * 
 * x_i = F^-1(u_i | delta) = -ln(1 - delta)/u_i
 * 
 */

 import java.lang.Math;

 public class RandVarGen{
     public static void main(String[] args){
         try{
            int u_i = Integer.parseInt(args[0]);
            int lambda = Integer.parseInt(args[1]);
            double x_i = exp_cdf_inv(u_i, lambda);
            System.out.println("x_i = " + x_i);
         }catch(NumberFormatException e){
             System.out.println("Error: Enter u_i and lambda as integers");
         }catch(Exception e){
             System.out.println("Erro: Something went wrong");
         }
    }

    /**
     * Returns a random variable realization for and exponential random variable with
     * x_i = -ln(1 - u_i)/delta
     * 
     * @param u_i a random number
     * @param delta the exponential random variable parameter
     * @return x_i as defined above
     */
    public static double exp_cdf_inv(int u_i, int lambda){
        return -Math.log(1.0 - u_i) / lambda;
    }
 }