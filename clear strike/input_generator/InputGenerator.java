import java.io.*;
import java.util.Random;
/*
 * This is the program to generate random input to feed to the main program
 * The file is generated in src folder with the name input.txt
 * */
public class InputGenerator {
  public static void main(String[] args) {
    try (FileWriter fw = new FileWriter("./clear strike/src/input.txt"); ) {
      for (int i = 0; i < 50; i++) {
        Random ran = new Random();
        Integer value = ran.nextInt(6) + 1;
        fw.write(value.toString());
        fw.write("\n");
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
