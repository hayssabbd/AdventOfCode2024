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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    File file = new File("C:\\Docs\\advent.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    List<Integer> firstColumn = new ArrayList<>();
    List<Integer> secondColumn = new ArrayList<>();

    while ((line = br.readLine()) != null) {
      String firstNumber = line.substring(0,5);
      String secondNumber = line.substring(8,13);
      firstColumn.add(Integer.valueOf(firstNumber));
      secondColumn.add(Integer.valueOf(secondNumber));
    }

    Collections.sort(firstColumn);
    Collections.sort(secondColumn);

    int similarity = 0;

    for (Integer firstNumber: firstColumn){

      int occurences = 0;
      for (Integer secondNumber: secondColumn) {
        if (firstNumber.intValue() == secondNumber.intValue()){
          occurences++;
        }
      }

      similarity += firstNumber * occurences;
    }

    System.out.println(similarity);
  }
}
