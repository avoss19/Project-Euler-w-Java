/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.

 * How many such routes are there through a 20×20 grid?
 */

import java.util.Arrays;

class Euler{
  private long grid[][];
  private int x;
  private int y;

  Euler(int x, int y){
    this.x = x;
    this.y = y;
    this.grid = new long[x + 1][y + 1];
    Arrays.fill(grid[x], 2);
    this.grid[x - 1][y] = 1;
    this.grid[x][y - 1] = 1;
  }

  public void calc(){
    for(int i = this.x - 1; i >= 0; i--){
      for(int j = this.y - 1; j >= 0; j--){
        this.grid[i][j] = this.grid[i + 1][j] + this.grid[i][j + 1];
      }
    }
  }

  public long result(){
    return grid[0][0];
  }
}


class Euler015{
  public static void main(String[] args){
    Euler run = new Euler(20, 20);
    run.calc();
    System.out.println(run.result());
  }
}
