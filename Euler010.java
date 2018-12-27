/* The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */

class Euler010{
  public static boolean primeCheck(int x){
    if(x % 2 == 0)
      return false;

    for(int i = 3; i <= Math.sqrt(x); i+=2)
      if(x % i == 0)
        return false;

    return true;
  }

  public static long calc(double max){
    long sum = 2;

    for(int i = 3; i < max; i+= 2){
      if(primeCheck(i))
        sum += i;
    }
    return sum;
  }

  public static void main(String arg[]){
    long solution = calc(2e6);
    System.out.println(solution);
  }
}
