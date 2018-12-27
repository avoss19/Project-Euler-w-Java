/* 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */

import java.lang.*;
import java.math.BigInteger;

class Euler016{
  public static int calc(int num, int pow){
    int solution = 0;

    BigInteger numPow = BigInteger.valueOf(num);
    numPow = numPow.pow(pow);
    String numStr = String.valueOf(numPow);
    char[] numList = numStr.toCharArray();

    for(char i : numList)
      solution += Character.getNumericValue(i);

    return solution;
  }

  public static void main(String arg[]){
    int num = 2;
    int pow = 1000;

    System.out.println(calc(num, pow));
  }
}
