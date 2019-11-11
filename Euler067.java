import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.ArrayList;

/*
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom in triangle.txt (right click and
 * 'Save Link/Target As...'), a 15K text file containing a triangle with
 * one-hundred rows.
 *
 * NOTE: This is a much more difficult version of Problem 18. It is not possible
 * to try every route to solve this problem, as there are 299 altogether! If you
 * could check one trillion (1012) routes every second it would take over twenty
 * billion years to check them all. There is an efficient algorithm to solve it.
 * ;o)
*/

class Euler067{
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
    ConcurrentLinkedQueue<String> data = readFile("data/Euler067");
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
