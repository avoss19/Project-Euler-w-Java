/* If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?

 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */

class NumberValues{
  public String[] onesString = {"one", "two", "three", "four", "five", "six",
                                  "seven", "eight", "nine"};
  public String[] teensString = {"eleven", "twelve", "thirteen", "fourteen",
                                  "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
  public String[] tensString = {"ten", "twenty", "thirty", "forty", "fifty",
                                  "sixty", "seventy", "eigthy", "ninety"};
  public String hundredString = "hundred";
  public String thousandString = "thousand";
  public String andString = "and";

  public int[] ones;
  public int[] teens;
  public int[] tens;
  public int hundred;
  public int thousand;
  public int and;

  private int[] strToInt(String[] str){
    int[] intVal = new int[str.length];

    for(int i = 0; i < str.length; i++)
      intVal[i] = str[i].length();

    return intVal;
  }

  public void convert(){
    this.ones = strToInt(this.onesString);
    this.teens = strToInt(this.teensString);
    this.tens = strToInt(this.tensString);
    this.hundred = hundredString.length();
    this.thousand = thousandString.length();
    this.and = andString.length();
  }
}

class Euler{
  private int max;
  private int solution = 0;
  private NumberValues nums;

  Euler(int max){
    this.max = max;
    this.nums = new NumberValues();
    this.nums.convert();
  }

  public void run(){
    this.solution = 0;

    // Max of 1000
    for(int i = this.max; i > 0; i--){
      // Thousand
      if(i == 1000)
        this.solution += this.nums.thousand + this.nums.ones[0];

      // Hundreds Place
      if((i / 100) > 0 && (i != 1000))
        this.solution += this.nums.hundred + this.nums.ones[(i / 100) - 1];

      // Tens Place 20 & up
      if((i % 100) != 0 && (i % 100) >= 20)
        this.solution += this.nums.tens[(i % 100) / 10 - 1];

      // Teens
      if((i % 100) > 10 && (i % 100) < 20)
        this.solution += this.nums.teens[(i % 10) - 1];

      // Ten
      if((i % 100) == 10)
        this.solution += this.nums.tens[0];

      // Ones
      if((i % 10) != 0 && (i % 100) / 10 != 1)
        this.solution += this.nums.ones[(i % 10) - 1];

      // And
      if((i > 100) && (i < 1000) && (i % 100) != 0)
        this.solution += this.nums.and;
    }
  }

  public int solution(){
    return solution;
  }
}

class Euler017{
  public static void main(String args[]){
    Euler calc = new Euler(1000);
    calc.run();
    System.out.println(calc.solution());
  }
}
