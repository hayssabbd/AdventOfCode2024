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
    }

    XMAS_ARRAYS = new String[COLUMNS][ROWS];

    br = new BufferedReader(new FileReader(file));

    for(int row = 0; row < ROWS; row++){
      XMAS_ARRAYS[row] = br.readLine().split("");
    }


    for(int row = 0; row < ROWS; row++){
      for(int col = 0; col < COLUMNS; col++){

        if(XMAS_ARRAYS[row][col].equals(X)){
          searchForXmas(row, col);
        }
      }
    }
    System.out.println(XMAS_COUNT);

  }

  public static void searchForXmas(int row, int col){
    if(row > 2){
      searchUpForXmas(row, col);
    }
    if(row > 2 && col < COLUMNS-3){
      searchUpRightForXmas(row, col);
    }
    if(col < COLUMNS-2){
      searchRightForXmas(row, col);
    }
    if(row < ROWS-3 && col < COLUMNS-3){
      searchDownRightForXmas(row, col);
    }
    if(row < ROWS-3){
      searchDownForXmas(row, col);
    }
    if(row < ROWS-3 && col > 2){
      searchDownLeftForXmas(row, col);
    }
    if(col > 2){
      searchLeftForXmas(row, col);
    }
    if(row > 2 && col > 2){
      searchUpLeftForXmas(row, col);
    }
  }

  private static void searchUpLeftForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row-1][col-1].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row-2][col-2].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row-3][col-3].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchLeftForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row][col-1].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row][col-2].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row][col-3].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchDownLeftForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row+1][col-1].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row+2][col-2].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row+3][col-3].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchDownForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row+1][col].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row+2][col].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row+3][col].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchDownRightForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row+1][col+1].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row+2][col+2].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row+3][col+3].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchRightForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row][col+1].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row][col+2].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row][col+3].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchUpRightForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row-1][col+1].equals(M)){
      return;
    }
    if(!XMAS_ARRAYS[row-2][col+2].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row-3][col+3].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }

  private static void searchUpForXmas(int row, int col) {
    if(!XMAS_ARRAYS[row-1][col].equals(M)){
      return;
    } 
    if(!XMAS_ARRAYS[row-2][col].equals(A)){
      return;
    }
    if(!XMAS_ARRAYS[row-3][col].equals(S)){
      return;
    }
    XMAS_COUNT++;
  }
}

