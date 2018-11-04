import java.io.*;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader userIn = new BufferedReader(new InputStreamReader (System.in));
    int defVal = Integer.MAX_VALUE;
    int startX = 0;
    int startY = 0;
		String[] tokens = userIn.readLine().split(" ");
    int endX = Integer.parseInt(tokens[0]);
    int endY = Integer.parseInt(tokens[1]);
    int [][] dist = new int [10][10];
    char [][] grid = {
      {'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
      {' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' '},
      {' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', 'X', ' '},
      {'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {'X', 'X', 'X', 'X', 'X', 'X', 'X', ' ', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' '},
      {' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
      {' ', ' ', ' ', 'X', ' ', ' ', ' ', 'X', ' ', ' '},
      {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'}
    };
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        dist [i][j] = defVal;
        if (grid [i][j] == 'B') {
          startX = j;
          startY = i;
        }
        else if (grid [i][j] == 'X') {
          dist [i][j] = -1;
        }

      }
    }
    ArrayList <Integer> xQueue = new ArrayList <Integer>();
    ArrayList <Integer> yQueue = new ArrayList <Integer>();
    xQueue.add(startX);
    yQueue.add(startY);
    dist [startY][startX] = 0;
    while (!xQueue.isEmpty()) {
      int x = xQueue.get(0);
      xQueue.remove(0);
      int y = yQueue.get(0);
      yQueue.remove(0);
      if (grid [y][x] == ' ' || grid [y][x] == 'B') {
        if (y + 1 < 10) {
          if (dist [y + 1][x] != -1 && dist [y + 1][x] == defVal) {
            dist[y + 1][x] = dist [y][x] + 1;
            xQueue.add(x);
            yQueue.add(y + 1);
          }
        }
        if (x + 1 < 10) {
          if (dist [y][x + 1] != -1 && dist [y][x + 1] == defVal) {
            dist[y][x + 1] = dist [y][x] + 1;
            xQueue.add(x + 1);
            yQueue.add(y);
          }
        }
      if (grid [y][x] == ' ' || grid [y][x] == 'B') {
        if (y - 1 > -1) {
          if (dist [y - 1][x] != -1 && dist [y - 1][x] == defVal) {
            dist[y - 1][x] = dist [y][x] + 1;
            xQueue.add(x);
            yQueue.add(y - 1);
          }
        }
        if (x - 1 > -1) {
          if (dist [y][x - 1] != -1 && dist [y][x - 1] == defVal) {
            dist[y][x - 1] = dist [y][x] + 1;
            xQueue.add(x - 1);
            yQueue.add(y);
          }
        }
      }
    }
  }
  if (dist[endY - 1][endX - 1] == -1) {
    System.out.println("This is a wall.");
  }
  else {
    System.out.println("Betty will sweat " + dist[endY - 1][endX - 1] + "ml to get to her candy cane");
  }
}
}
