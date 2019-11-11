import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;

/* By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by
 * trying every route. However, Problem 67, is the same challenge with a
 * triangle containing one-hundred rows; it cannot be solved by brute force,
 * and requires a clever method! ;o)
 */

class Euler018{
  public static ConcurrentLinkedQueue<String> readFile(String path){
    File f = new File(path);
    try{
      Scanner scan = new Scanner(f);
      ConcurrentLinkedQueue<String> content = new ConcurrentLinkedQueue<>();

      String temp;
      boolean end = false; // check for end of file
      while(scan.hasNext() && !(end)){
          temp = scan.nextLine();
          // Don't include "END" which indicates end of file
          if(!(temp.toLowerCase().equals("end")))
              content.add(temp);
          else
              end = true;
          }
        return content;
      } catch(FileNotFoundException e){
        System.out.println(e.getMessage());
      }
      return null;
  }

  public static int[] convertStringArrayToIntArray(String[] d){
    int[] data = new int[d.length];
    for(int i = 0; i < data.length; i++)
      data[i] = Integer.parseInt(d[i]);
    return data;
  }

  /**
   *  Destructive to data
   */
  public static ArrayList<int[]> preparedData(ConcurrentLinkedQueue<String> data){
    ArrayList<int[]> preparedData = new ArrayList<>(data.size());
    while(!data.isEmpty()){
      preparedData.add(convertStringArrayToIntArray(data.poll().split(" ")));
    }

    return preparedData;
  }

  public static int max(int a, int b){
    if(a > b)
      return a;
    return b;
  }

  public static int getIntArrayMax(int[] array){
    int max = 0;
    for(int i = 0; i < array.length; i++)
      if(array[i] > max)
        max = array[i];
    return max;
  }

  public static void main(String[] args){
    ConcurrentLinkedQueue<String> data = readFile("data/Euler018");
    ArrayList<int[]> preparedData = preparedData(data);
    data = null; // help w/ garbage collection

    int[] current;
    int[] temp;
    current = preparedData.get(0);
    for(int i = 1; i < preparedData.size(); i++){
      temp = new int[preparedData.get(i).length];
      for(int j = 0; j < preparedData.get(i).length; j++){
        if(j == 0)
          temp[0] = preparedData.get(i)[0] + current[0];
        else if(j == preparedData.get(i).length - 1)
          temp[preparedData.get(i).length - 1] = preparedData.get(i)[preparedData.get(i).length - 1] + current[current.length - 1];
        else
          temp[j] = max(current[j - 1], current[j]) + preparedData.get(i)[j];
      }
      current = temp;
    }

    System.out.println(getIntArrayMax(current));
  }
}
