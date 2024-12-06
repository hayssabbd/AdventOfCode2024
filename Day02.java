/*
 * Day02
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
import java.util.stream.Collectors;

/**
 * @author mae.tan
 */
public class Day02 {
  private String FILE = "{}_input.txt";

  public void solve() throws Exception {
    Path currentRelativePath = Paths.get("");
    File file = new File(currentRelativePath.toAbsolutePath() + File.separator +
        FILE.replace("{}", this.getClass().getSimpleName()));

    BufferedReader br = new BufferedReader(new FileReader(file));

    String fileLine;
    List<String[]> reports = new ArrayList<>();

    while ((fileLine = br.readLine()) != null) {
      String[] levels = fileLine.split("\\s");
      if (levels.length > 0) {
        reports.add(levels);
      }
    }

    System.out.println("Reports = " + reports.size());
    List<String[]> safeReports = reports.stream().filter(this::checkSafe).collect(Collectors.toList());
    safeReports.forEach(report -> {
      System.out.print("[");
      for (int i = 0; i < report.length; i++) {
        System.out.print(report[i] +  " ");
      }
      System.out.print("]\n");
    });

    List<String[]> unSafeReports = reports.stream().filter(report -> !checkSafe(report)).collect(Collectors.toList());
    List<String[]> dampenedReports = unSafeReports.stream().filter(this::checkSafeWithDampener).collect(Collectors.toList());

    System.out.println("Safe Levels = " + safeReports.size());
    System.out.println("Safe Levels With Dampener = " + (safeReports.size() + dampenedReports.size()));
  }

  public boolean checkSafeWithDampener(String[] levels) {
    boolean safeWithDampener = false;
    if (levels != null) {
      for (int i = 0; i < levels.length; i++) {
        long[] reducedLevels = getReducedLevels(i, levels);
        if (checkDecreasing(reducedLevels) || checkIncreasing(reducedLevels)) {
          safeWithDampener = checkGapIsBetweenOneAndThree(reducedLevels);
          if (safeWithDampener) {
            break;
          }
        }
      }
    }
    return safeWithDampener;
  }

  public long[] getReducedLevels(int index, String[] levels) {
    List<String> reducedLevels = new ArrayList<>();
    for (int i = 0; i < levels.length; i++) {
      if (i != index) {
        reducedLevels.add(levels[i]);
      }
    }
    long[] reduced = new long[reducedLevels.size()];
    for (int i = 0; i < reducedLevels.size(); i++) {
      reduced[i] = Long.parseLong(reducedLevels.get(i));
    }
    return reduced;
  }

  public boolean checkSafe(String[] levels) {
    boolean safe = false;
    if (levels != null) {
      long[] longLevels = new long[levels.length];
      for (int i = 0; i < levels.length; i++) {
        longLevels[i] = (Long.parseLong(levels[i]));
      }
      if (checkDecreasing(longLevels) || checkIncreasing(longLevels)) {
        safe = checkGapIsBetweenOneAndThree(longLevels);
      }
    }
    return safe;
  }

  public boolean checkIncreasing(long[] levels) {
    boolean increasing = true;
    for (int i = 1; i < levels.length; i++) {
      if (levels[i - 1] > levels[i]) {
        increasing = false;
        break;
      }
    }
    return increasing;
  }

  public boolean checkDecreasing(long[] levels) {
    boolean decreasing = true;
    for (int i = 1; i < levels.length; i++) {
      if (levels[i - 1] < levels[i]) {
        decreasing = false;
        break;
      }
    }
    return decreasing;
  }

  public boolean checkGapIsBetweenOneAndThree(long[] levels) {
    boolean acceptableGap = true;
    for (int i = 1; i < levels.length; i++) {
      long gap = Math.abs(levels[i - 1] - levels[i]);
      if (gap > 3 || gap < 1) {
        acceptableGap = false;
        break;
      }
    }
    return acceptableGap;
  }

  public static void main(String[] args) {
    Day02 day02 = new Day02();
    try {
      day02.solve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
