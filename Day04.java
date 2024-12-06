/*
 * Day04
 *
 * Copyright BBD (Benefits by Design) 04 December 2024
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

/**
 * @author mae.tan
 */
public class Day04 {
  private String FILE = "{}_input.txt";

  public void solve() throws Exception {
    Path currentRelativePath = Paths.get("");
    File file = new File(currentRelativePath.toAbsolutePath() + File.separator +
        FILE.replace("{}", this.getClass().getSimpleName()));

    BufferedReader br = new BufferedReader(new FileReader(file));

    String fileLine;
    ArrayList<String> lines = new ArrayList<>();
    while ((fileLine = br.readLine()) != null) {
      lines.add(fileLine);
    }
    char[][] grid = new char[140][140];
    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      for (int j = 0; j < line.length(); j++) {
        grid[i][j] = line.charAt(j);
      }
    }
    /*
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
     */
    int count = countHorizontalXmas(grid) + countHorizontalSamx(grid) + countVerticalXmas(grid) +
        countVerticalSamx(grid) + countDiagonalRightXmas(grid) + countDiagonalRightSamx(grid) +
        countDiagonaLeftXmas(grid) + countDiagonaLeftSamx(grid);
    System.out.println("XMAS count = " + count);
  }

  public int countHorizontalXmas(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'X') {
          if (j+1 < 140 && grid[i][j+1] == 'M') {
            if (j+2 < 140 && grid[i][j+2] == 'A') {
              if (j+3 < 140 && grid[i][j+3] == 'S') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Horizontal XMAS = " + count);
    return count;
  }

  public int countHorizontalSamx(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'S') {
          if (j+1 < 140 && grid[i][j+1] == 'A') {
            if (j+2 < 140 && grid[i][j+2] == 'M') {
              if (j+3 < 140 && grid[i][j+3] == 'X') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Horizontal SAMX = " + count);
    return count;
  }

  public int countVerticalXmas(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'X') {
          if (i+1 < 140 && grid[i+1][j] == 'M') {
            if (i+2 < 140 && grid[i+2][j] == 'A') {
              if (i+3 < 140 && grid[i+3][j] == 'S') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Vertical XMAS = " + count);
    return count;
  }

  public int countVerticalSamx(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'S') {
          if (i+1 < 140 && grid[i+1][j] == 'A') {
            if (i+2 < 140 && grid[i+2][j] == 'M') {
              if (i+3 < 140 && grid[i+3][j] == 'X') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Vertical SAMX = " + count);
    return count;
  }

  public int countDiagonalRightXmas(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'X') {
          if (i+1 < 140 && j+1 < 140 && grid[i+1][j+1] == 'M') {
            if (i+2 < 140 && j+2 < 140 && grid[i+2][j+2] == 'A') {
              if (i+3 < 140 && j+3 < 140 && grid[i+3][j+3] == 'S') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Diagonal Right XMAS = " + count);
    return count;
  }

  public int countDiagonalRightSamx(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'S') {
          if (i+1 < 140 && j+1 < 140 && grid[i+1][j+1] == 'A') {
            if (i+2 < 140 && j+2 < 140 && grid[i+2][j+2] == 'M') {
              if (i+3 < 140 && j+3 < 140 && grid[i+3][j+3] == 'X') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Diagonal Right SAMX = " + count);
    return count;
  }

  public int countDiagonaLeftXmas(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'X') {
          if (i-1 >= 0 && j+1 < 140 && grid[i-1][j+1] == 'M') {
            if (i-2 >= 0 && j+2 < 140 && grid[i-2][j+2] == 'A') {
              if (i-3 >= 0 && j+3 < 140 && grid[i-3][j+3] == 'S') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Diagonal Left XMAS = " + count);
    return count;
  }

  public int countDiagonaLeftSamx(char[][] grid) {
    int count = 0;
    for (int i = 0; i < 140; i++) {
      for (int j = 0; j < 140; j++) {
        if (grid[i][j] == 'S') {
          if (i-1 >= 0 && j+1 < 140 && grid[i-1][j+1] == 'A') {
            if (i-2 >= 0 && j+2 < 140 && grid[i-2][j+2] == 'M') {
              if (i-3 >= 0 && j+3 < 140 && grid[i-3][j+3] == 'X') {
                count++;
              }
            }
          }
        }
      }
    }
    System.out.println("Diagonal Left XMAS = " + count);
    return count;
  }

  public static void main(String[] args) {
    Day04 day04 = new Day04();
    try {
      day04.solve();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
