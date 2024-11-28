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

  public static void main(String[] args) throws IOException {

    // File path is passed as parameter
    File file = new File("C:\\Documents\\file_name.txt");

    // Note:  Double backquote is to avoid compiler
    // interpret words
    // like \test as \t (ie. as a escape sequence)

    // Creating an object of BufferedReader class
    BufferedReader br
        = new BufferedReader(new FileReader(file));

    // Declaring a string variable
    String st;
    // Condition holds true till
    // there is character in a string
    while ((st = br.readLine()) != null)

    // Print the string
    {
      System.out.println(st);
    }
  }
}
