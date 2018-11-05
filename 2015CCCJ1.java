import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sr = new Scanner(System.in);
    int mth = sr.nextInt();
    int day = sr.nextInt();
    if (mth*100+day > 218) {
      System.out.println("After");
    } else if (mth*100+day == 218) {
      System.out.println("Special");
    }
    else {
      System.out.println("Before");
    }
    sr.close();
  }
}
