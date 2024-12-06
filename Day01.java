/*
 * Day01
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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author mae.tan
 */
public class Day01 {
  private String FILE = "{}_input.txt";

  public void solve() throws Exception {
    Path currentRelativePath = Paths.get("");
    File file = new File(currentRelativePath.toAbsolutePath() + File.separator +
        FILE.replace("{}", this.getClass().getSimpleName()));

    BufferedReader br = new BufferedReader(new FileReader(file));

    String fileLine;
    List<Integer> groupOne = new ArrayList<>();
    List<Integer> groupTwo = new ArrayList<>();

    while ((fileLine = br.readLine()) != null) {
      String[] locationIds = fileLine.split("\\s+");
      groupOne.add(Integer.parseInt(locationIds[0]));
      groupTwo.add(Integer.parseInt(locationIds[1]));
    }
    Collections.sort(groupOne);
    Collections.sort(groupTwo);

    int totalDistance = getTotalDistance(groupOne, groupTwo);
    System.out.println("Total Distance = " + totalDistance);
    long similarityScore = getSimilarityScore(groupOne, groupTwo);
    System.out.println("Similarity Score = " + similarityScore);
  }

  public int getTotalDistance(List<Integer> groupOne, List<Integer> groupTwo) {
    int totalDistance = 0;
    for (int i = 0; i < groupOne.size(); i++) {
      totalDistance += Math.abs(groupOne.get(i) - groupTwo.get(i));
    }
    return totalDistance;
  }

  public long getSimilarityScore(List<Integer> groupOne, List<Integer> groupTwo) {
    List<Long> similarityScores = new ArrayList<>();
    groupOne.forEach(value -> {
      long count = groupTwo.stream().filter(anotherValue -> Objects.equals(value, anotherValue)).count();
      similarityScores.add(value * count);
    });
    return similarityScores.stream().mapToLong(Long::longValue).sum();
  }

  public static void main(String[] args) {
    Day01 day01 = new Day01();
    try {
      day01.solve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
