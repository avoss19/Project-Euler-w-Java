/* The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */

class Euler006{
  public static double sumOfSquares(int max){
    double sum = 0;
    for(double i = 1; i <= max; i++){
      sum += Math.pow(i, 2);
    }
    return sum;
  }

  public static double squareOfSum(int max){
    double sum = 0;
    for(double i = 1; i <= max; i++){
      sum += i;
    }
    return Math.pow(sum, 2);
  }

  public static void main(String arg[]){
    int max = 100;
    double difference = squareOfSum(max) - sumOfSquares(max);

    System.out.println((int) difference);
  }
}
