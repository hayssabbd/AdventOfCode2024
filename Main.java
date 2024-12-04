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

public class Main {

  public static int ROWS = 0;
  public static int COLUMNS = 0;
  public static int XMAS_COUNT = 0;
  static String[][] XMAS_ARRAYS;
  public static String X = "X";
  public static String M = "M";
  public static String A = "A";
  public static String S = "S";

  public static void main(String[] args) throws IOException {

    File file = new File("C:\\Docs\\advent.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;

    while ((line = br.readLine()) != null) {
      ROWS++;
      COLUMNS = line.length();
      System.out.println(line);
    }

    XMAS_ARRAYS = new String[COLUMNS][ROWS];

    br = new BufferedReader(new FileReader(file));

    for(int row = 0; row < ROWS; row++){
      XMAS_ARRAYS[row] = br.readLine().split("");
    }


    for(int row = 0; row < ROWS; row++){
      for(int col = 0; col < COLUMNS; col++){

        if(XMAS_ARRAYS[row][col].equals(M)){
          searchForCrossedMas(row, col);
        }
      }
    }

    //every MAS cross was counted twice so divide by two
    System.out.println(XMAS_COUNT/2);
  }

  private static void searchForCrossedMas(int row, int col) {
    if (upRightMas(row, col)) {
      if(downRightMas(row-2,col)){
        XMAS_COUNT++;
      } if(upLeftMas(row, col+2)){
        XMAS_COUNT++;
      }
    }
    if (downRightMas(row, col)){
      if(upRightMas(row+2,col)){
        XMAS_COUNT++;
      } if(downLeftMas(row, col+2)){
        XMAS_COUNT++;
      }
    }
    if (upLeftMas(row,col)){
      if(upRightMas(row, col-2)){
        XMAS_COUNT++;
      } if (downLeftMas(row-2, col)){
        XMAS_COUNT++;
      }
    }
    if (downLeftMas(row, col)){
      if (downRightMas(row, col-2)){
        XMAS_COUNT++;
      }  if (upLeftMas(row+2, col)){
        XMAS_COUNT++;
      }
    }
  }

  private static boolean downLeftMas(int row, int col) {
    return (row < ROWS -2 && col > 1 && XMAS_ARRAYS[row][col].equals(M) && XMAS_ARRAYS[row+1][col-1].equals(A) && XMAS_ARRAYS[row+2][col-2].equals(S));
  }

  private static boolean upLeftMas(int row, int col) {
    return (row > 1 && col > 1 && XMAS_ARRAYS[row][col].equals(M) && XMAS_ARRAYS[row-1][col-1].equals(A) && XMAS_ARRAYS[row-2][col-2].equals(S));
  }

  private static boolean downRightMas(int row, int col) {
    return (row < ROWS-2 && col < COLUMNS-2 && XMAS_ARRAYS[row][col].equals(M) && XMAS_ARRAYS[row+1][col+1].equals(A) && XMAS_ARRAYS[row+2][col+2].equals(S));
  }

  private static boolean upRightMas(int row, int col) {
    return ((row > 1 && col < COLUMNS-2) && XMAS_ARRAYS[row][col].equals(M) && XMAS_ARRAYS[row-1][col+1].equals(A) && XMAS_ARRAYS[row-2][col+2].equals(S));
  }

}

