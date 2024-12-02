/*
 * Main
 *
 * Copyright BBD (Benefits by Design) 28 November 2024
 * This code source file, including any concepts, ideas and algorithms expressed
 * herein, is the sole intellectual property of Benefits by Design and may
 * not be copied, distributed or modified in any way without the permission of
 * BBD (Benefits by Design)
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import org.w3c.dom.ls.LSOutput;

public class Main {

  public static void main(String[] args) throws IOException {

    File file = new File("C:\\Docs\\advent.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    int safeCount = 0;

    while ((line = br.readLine()) != null) {
      String[] numberStrings = line.split(" ");
      int[] numberArray = Arrays.stream(numberStrings).mapToInt(Integer::parseInt).toArray();

      boolean increasingNumbers = numberArray[0] < numberArray[1];
      boolean decreasingNumbers = numberArray[0] > numberArray[1];
      boolean safe = true;

      for (int ctr = 0; ctr < numberArray.length; ctr++) {
        if (ctr < numberArray.length - 1) {
          int currentNumber = numberArray[ctr];
          int nextNumber = numberArray[ctr + 1];

          if (currentNumber == nextNumber){
            safe = false;
            break;
          }
          if (Math.abs(currentNumber - nextNumber) > 3) {
            safe = false;
            break;
          }
          if (increasingNumbers) {
            if (currentNumber > nextNumber) {
              safe = false;
              break;
            }
            //unnecessary as decreasing numbers will always be true by this point, but more clear
          } else if (decreasingNumbers) {
            if (currentNumber < nextNumber) {
              safe = false;
              break;
            }
          }
        }
      }

      if (safe){
        safeCount++;
      }
    }
    System.out.println(safeCount);
  }
}


