/*
 * Day03
 *
 * Copyright BBD (Benefits by Design) 03 December 2024
 * This code source file, including any concepts, ideas and algorithms expressed
 * herein, is the sole intellectual property of Benefits by Design and may
 * not be copied, distributed or modified in any way without the permission of
 * BBD (Benefits by Design)
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mae.tan
 */
public class Day03 {
  private String FILE = "{}_input.txt";

  public void solve() throws Exception {
    Path currentRelativePath = Paths.get("");
    File file = new File(currentRelativePath.toAbsolutePath() + File.separator +
        FILE.replace("{}", this.getClass().getSimpleName()));

    BufferedReader br = new BufferedReader(new FileReader(file));

    String fileLine;
    List<String> lines = new ArrayList<>();
    List<String> multipliers = new ArrayList<>();
    Pattern p = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
    while ((fileLine = br.readLine()) != null) {
      lines.add(fileLine);
      Matcher m = p.matcher(fileLine);
      while (m.find()) {
        multipliers.add(m.group());
      }
    }

    List<Long> products = new ArrayList<>();
    multipliers.forEach(multiply -> {
      products.add(multiplyFunction(multiply));
    });

    System.out.println("Sum of all multiply functions = " + products.stream().mapToLong(Long::longValue).sum());
    System.out.println("File lines = " + lines.size());
    String fileContents = String.join("", lines);
    System.out.println("Sum of enabled multiply functions = " + getCanMultiplyFunctions(fileContents));
  }

  public long multiplyFunction(String multiplyFunction) {
    // System.out.println(multiplyFunction);
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(multiplyFunction);
    List<Long> multipliers = new ArrayList<>();
    while (m.find()) {
      multipliers.add(Long.parseLong(m.group()));
    }
    // System.out.println(multipliers.get(0) + " * " + multipliers.get(1));
    return multipliers.get(0) * multipliers.get(1);
  }

  public long getCanMultiplyFunctions(String data) {
    Pattern pDont = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)|don\'t\\(\\)|do\\(\\)");
    Matcher mDont = pDont.matcher(data);
    List<String> instructions = new ArrayList<>();
    while (mDont.find()) {
      instructions.add(mDont.group());
    }
    boolean doMultiply = true;
    long sum = 0;
    for (String instruction : instructions) {
      if (instruction.equals("don't()")) {
        doMultiply = false;
      } else if (instruction.equals("do()")) {
        doMultiply = true;
      } else {
        if (doMultiply) {
          sum += multiplyFunction(instruction);
        }
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    Day03 day03 = new Day03();
    try {
      day03.solve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
