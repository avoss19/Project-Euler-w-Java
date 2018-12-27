/* By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

class Euler007{
  public static boolean primeCheck(int x){
    for(int i = 2; i < x; i++)
      if(x % i == 0)
        return false;
    return true;
  }

  public static int calc(int max){
    int nth = 1;
    for(int i = 3; i > 0; i+=2){
      if(primeCheck(i))
        nth += 1;
      if(nth == max)
        return i;
    }
    return 0;
  }

  public static void main(String arg[]){
    System.out.println(calc(10001));
  }
}
