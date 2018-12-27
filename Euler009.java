/* A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

class Euler009{
  public static boolean tripleCheck(int a, int b){
    // a + b + sqrt(a^2 + b^2) = 1000

    double s = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

    if(!(s % 1 == 0))
      return false;

    if(!(a + b + s == 1000))
      return false;

    return true;
  }

  public static double tripletCalc(int sum){
    int product = 1;

    // a < b < c
    // a + b + c = 1000
    // a^2 + b^2 = c^2

    // a + b + c = 1000
    // sqrt(a^2 + b^2) = c

    // a + b + sqrt(a^2 + b^2) = 1000

    for(int a = 1; a < sum; a++){
      for(int b = 1; b < sum; b++){
        if(tripleCheck(a, b))
          return a*b*Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
      }
    }

    return 0;
  }

  public static void main(String arg[]){
    double solution = tripletCalc(1000);
    System.out.println(solution);
    System.out.println((int) solution);
  }
}
