import java.io.*;
import java.util.*;

class Main {
  
  
  public static void main(String[] args) throws IOException {
    Scanner s = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = s.nextInt();
    int [][] table = new int[n][n];

    for (int i = 0; i < n; i++) {
      String [] tokens = br.readLine().split(" ");
      // String line = tokens.replaceAll("\\s+","");    
      for (int j = 0; j < n; j ++) {
        // table[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
        table[i][j] = Integer.parseInt(tokens[j]);
      }
    }

    
    boolean diag = true;
    int d = 0;
    n -= 1;

    for (int i = 0; i < n; i++) {
      if (table[i][i] >= table [i+1][i+1]) {
        diag = false;
      }
    }
    if (diag == true) {
      d = 1;
    }
    diag = true;

    for (int i = 0; i < n; i++) {
      if (table[i][n-i] >= table [i+1][n-i-1]) {
        diag = false;

      }
    }
    if (diag == true) {
      d = 2;
    }
    diag = true;


    for (int i = 0; i < n; i++) {
      if (table[n-i][n-i] >= table [n-i-1][n-i-1]) {
        diag = false;
      }
    }
    if (diag == true) {
      d = 3;
    }
    diag = true;

    for (int i = 0; i < n; i++) {
      if (table[n-i][i] >= table [n-i-1][i+1]) {
        diag = false;
      }
    }
    if (diag == true) {
      d = 4;
    }
    
/*
    if (d == 1) {
      for (int i = 0; i <= n; i++) {
          for (int j = 0; j <= n; j ++) {
            System.out.print(table[i][j] + " ");
          }
          System.out.println();
      }
    }
    else if (d == 2) {
      for (int i = 0; i <= n; i++) {
        for (int j = n; j >= 0; j--) {
          System.out.print(table[i][j] + " ");
        }
        System.out.println();
      }
    }
    else if (d == 3) {
      for (int i = n; i >= 0; i--) {
        for (int j = n; j >= 0; j--) {
          System.out.print(table[i][j] + " ");
        }
        System.out.println();
      }
    }
    else {
      for (int i = n; i >= 0; i--) {
        for (int j = 0; j <= n; j++) {
          System.out.print(table[i][j] + " ");
        }
        System.out.println();
      }
    }
*/
  }
}
