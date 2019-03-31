import java.io.*;
import java.util.Random;

public class InputGenerator {
  public static void main(String[] args) {
    FileWriter fw = null;
    try {
      fw = new FileWriter("./clear strike/src/input.txt");
      for (int i = 0; i < 50; i++) {
          Random ran = new Random();
          Integer value = ran.nextInt(6) + 1 ;
        fw.write(value.toString());
        fw.write("\n");
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (fw != null) {
          fw.flush();
          fw.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
