package org.javasus.solvingOfTasks.CrackingTheCoding.arraysAndStrings;

// Для двух строк напиши метод, является ли одна строка перестановкой другой.
public class SolutionCheckPermutation {
  public static void main (String[] args) {
    SolutionCheckPermutation sol = new SolutionCheckPermutation();
    String s1 = "roman";
    String s2 = "narom";
    String s3 = "Koala";
    String s4 = "Loako";
    System.out.println("Являеться ли слово - " + s1 + " перестановкой слова - " + s2 + " ? - " + sol.isPermutation(s1, s2));
    System.out.println("Являеться ли слово - " + s3 + " перестановкой слова - " + s4 + " ? - " + sol.isPermutation(s3, s4));
  }

  public boolean isPermutation(String str1, String str2) {
    if (str1.length() != str2.length()) return false;
    int[] chars = new int[128]; // ASCII
    for (int i = 0; i < str1.length(); i++) {
      int count = str1.charAt(i);
      chars[count]++;
    }
    for (int j = 0; j < str2.length(); j++) {
      int count = str2.charAt(j);
      chars[count]--;
    }
    for (int k : chars) {
      if (k != 0) return false;
    }
    return true;
  }
}
