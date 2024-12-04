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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {

    File file = new File("C:\\Docs\\advent.txt");
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;

    line = br.lines().collect(Collectors.joining());
    line = line.replaceAll("\n", "");
    line = line.replaceAll("don't\\(\\).*?(do\\(\\)|$)", "#");

    Pattern mul = Pattern.compile("mul\\(\\d+,\\d+\\)");
    int sum = 0;
    Matcher matcher = mul.matcher(line);

    while (matcher.find()) {
      String match = matcher.group();

      int firstNumber = Integer.parseInt(
          match.substring(match.indexOf("(") + 1, match.indexOf(",")));
      int secondNumber = Integer.parseInt(
          match.substring(match.indexOf(",") + 1, match.indexOf(")")));
      sum += firstNumber * secondNumber;
    }
    System.out.println(sum);
  }
}

