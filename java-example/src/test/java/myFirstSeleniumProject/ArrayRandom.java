package myFirstSeleniumProject;

import java.util.Random;

public class ArrayRandom {
  public static int getRandom(int[] array) {
    int rnd = new Random().nextInt(array.length);
    return array[rnd];
  }
}
