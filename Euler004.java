/* A palindromic number reads the same both ways. The largest palindrome
 * made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

import java.io.*;
import java.util.*;

class Euler004{

  public static int palCalc(int min, int max){
    for(int i = max; i > min; i--){
      if(palCheck(i))
        if(productCheck(i, min, max))
          return i;
        }

    return 0;
  }

  public static boolean productCheck(int x, int min, int max){
    int facTemp;
    for(int i = 1; i < Math.sqrt(x); i += 2){
      if(x % i == 0){
        facTemp = x / i;
        if(facTemp <= Math.sqrt(max))
          return true;
      }
    }

    return false;
  }

  public static boolean palCheck(int x){
    String pal = Integer.toString(x);
    int len = pal.length();
    int digCheck = pal.length() / 2;
    String[] digits = pal.split("");

    for(int i = 0; i < digCheck; i++){
      if(Integer.valueOf(digits[i]) != Integer.valueOf(digits[len - 1- i])){
        return false;
      }
    }

    return true;
  }

  public static void main(String arg[]){
    System.out.println(palCalc(100*100, 999*999));
  }
}
