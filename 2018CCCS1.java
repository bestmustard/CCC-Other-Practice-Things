import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    ArrayList <Double> villages = new ArrayList<Double>();
    for (int i = 0; i < n; i ++) {
      villages.add(in.nextDouble());
    }
    Collections.sort(villages);
    System.out.println(villages);
    double min = Double.MAX_VALUE;
    for (int i = 1; i < n-1; i ++) {
      double dist = (villages.get(i) - villages.get(i-1)) /2 + (villages.get(i+1) - villages.get(i))/2;
      if (dist < min) {
        min = dist;
      }
    }
    System.out.println(String.format("%.1f", min)); 
    
  }
}
