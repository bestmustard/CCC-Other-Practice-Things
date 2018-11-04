import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
  public static int max (int a, int b) {
    if (a > b) {
      return a;
    }
    else {
      return b;
    }
  }
  public static void main(String[] args) throws IOException {
    Scanner sr = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int q = sr.nextInt();
    int n = sr.nextInt();
    ArrayList<Integer> d = new ArrayList<Integer>();
    ArrayList<Integer> p = new ArrayList<Integer>();

    String [] dmojis = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      d.add(Integer.parseInt(dmojis[i]));
    }
    String [] pegs = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      p.add(Integer.parseInt(pegs[i]));
    }
    ArrayList<Integer> combined = new ArrayList<Integer>(d);
    combined.addAll(p);
    Collections.sort(combined, Collections.reverseOrder());
    int max = 0;
    for (int i = 0; i < n; i++) {
      max += combined.get(i);
    }

    Collections.sort(d);
    Collections.sort(p);

    int min = 0;
    for (int i = 0; i < n; i++) {
      min += max(d.get(i), p.get(i));
    }
    if (q == 1) {
      System.out.println(min);
    }
    else {
      System.out.println(max);
    }
  }
}
