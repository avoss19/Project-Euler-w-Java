/* 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of
 * the numbers from 1 to 20?
 */

class Euler005{
  public static boolean check(int x, int min, int max){
    for(int i = 2; i <= max; i++){
      if(x % i != 0){
        return false;
      }
    }
    return true;
  }

  public static int calc(int min, int max){
    for(int i = 2; i > 0; i++)
      if(check(i, min, max))
        return i;
    return 0;
  }

  public static void main(String arg[]){
    System.out.println(calc(1, 20));
  }
}
