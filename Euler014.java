/* The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

class Euler014{
  public static double lenChain(double x){
    double len = 1;

    while(x > 1){
      if(x % 2 == 0){
        len++;
        x /= 2;
      } else {
        len++;
        x = 3*x + 1;
      }
    }

    return len;
  }

  public static double calc(double max){
    double solution = 0;
    double tempLen = 0;
    double largestLen = 0;

    for(double i = 0; i < max; i++){
      tempLen = lenChain(i);
      if(tempLen > largestLen){
        largestLen = tempLen;
        solution = i;
      }
    }
    return solution;
  }

  public static void main(String arg[]){
    System.out.println(calc(1e6));
  }
}
