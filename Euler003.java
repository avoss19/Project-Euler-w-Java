/* The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

import java.lang.Math;

class Euler003{
  private static long factor(long x){
    long fac = 0;
    long facTemp = 0;

    for(long i = 3; i < Math.sqrt(x); i += 2){
      if(x % i == 0){
        facTemp = x / i;
        if(factor(i) == 0){
          if(i > fac)
            fac = i;
        }
      }
    }

    return fac;
  }

  public static void main(String arg[]){
    System.out.println(factor(600851475143L));
  }
}
