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
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    File file = new File("C:\\Docs\\advent.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;

    List<Pair> ruleList = new ArrayList<>();

    while ((line = br.readLine()) != null) {
      String[] stringNumbers = line.split("\\|");
      Pair pair = new Pair(Integer.parseInt(stringNumbers[0]), Integer.parseInt(stringNumbers[1]));
      ruleList.add(pair);
    }

    int sum = 0;

    file = new File("C:\\Docs\\advent2.txt");
    br = new BufferedReader(new FileReader(file));
    boolean correct;
    boolean originallyCorrect;
    while ((line = br.readLine()) != null) {
      int[] update = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
      correct = false;
      originallyCorrect = true;
      while (!correct) {
        correct = true;
        for (int ctr = 1; ctr < update.length; ctr++) {
          int firstPage = update[ctr];
          for (int search = 0; search < ctr; search++) {
            int secondPage = update[search];
            for (Pair pair : ruleList) {
              if (pair.firstPage == firstPage && pair.secondPage == secondPage) {
                correct = false;
                originallyCorrect = false;
                update[ctr] = secondPage;
                update[search] = firstPage;
                break;
              }
            }
            if (!correct) {
              break;
            }
          }
          if (!correct) {
            break;
          }
        }
      }
      if(!originallyCorrect){
        int middleNumber = update[update.length / 2];
        sum+= middleNumber;
      }
    }

    System.out.println(sum);

  }

  private static class Pair {

    public int firstPage;
    public int secondPage;

    public Pair(int firstPage, int secondPage) {
      this.firstPage = firstPage;
      this.secondPage = secondPage;
    }

    public int getFirstPage() {
      return firstPage;
    }

    public void setFirstPage(int firstPage) {
      this.firstPage = firstPage;
    }

    public int getSecondPage() {
      return secondPage;
    }

    public void setSecondPage(int secondPage) {
      this.secondPage = secondPage;
    }
  }


}

