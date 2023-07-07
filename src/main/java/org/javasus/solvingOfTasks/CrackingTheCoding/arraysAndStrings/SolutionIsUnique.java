package org.javasus.solvingOfTasks.CrackingTheCoding.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Реализуйте алгоритм, определяющий, все ли символы в строке или  числовом массиве встречаются только один раз.
* А если при этом запрещено использовать дополнительные структуры данных.
//Example 1:
//    Input: nums = [1,2,3,1]
//    Output: true
//
//Example 2:
//    Input: nums = [1,2,3,4]
//    Output: false
//
//Example 3:
//    Input: nums = [1,1,1,3,3,4,3,2,4,2]
//    Output: true
* */
public class SolutionIsUnique {

  public static void main(String[] args) {
    SolutionIsUnique solution = new SolutionIsUnique();
    int[] nums1 = new int[] {1,2,3,1};
    int[] nums2 = new int[] {1,2,3,4};
    int[] nums3 = new int[] {1,1,1,3,3,4,3,2,4,2};
    String str1 = "Roman";
    String str2 = "Artur";
    System.out.println("Содержит ли массив nums1 одинаковые числа - " + solution.containsDuplicateDigits(nums1));
    System.out.println("Содержит ли массив nums2 одинаковые числа - " + solution.containsDuplicateDigits(nums2));
    System.out.println("Содержит ли массив nums3 одинаковые числа - " + solution.containsDuplicateDigits(nums3));
//    System.out.println("Содержит ли слово str1 одинаковые буквы? - " + solution.containsDuplicateChars(str1));
//    System.out.println("Содержит ли слово str2 одинаковые буквы? - " + solution.containsDuplicateChars(str2));

  }

  public boolean containsDuplicateChars (String str) {
////    используя hashMap можно проверить содержится ли встраке два любых одинаковых символа не зависимо от кодировки.
//    Map<Character, Integer> map = new HashMap<>();
//    for (int i = 0; i < str.length(); i++) {
//      int count = map.getOrDefault(str.charAt(i), 0);
//      map.put(str.charAt(i), count + 1);
//    }
//    for (var ent : map.entrySet()) {
//      if (ent.getValue() > 1) return false;
//      }
//    return true;
////    time complexity O(N)
////    space complexity O(N)


//    решение которое учитывает кодировку ASCII для английских букв - 128 симовлов
    if (str.length() > 128) return false;
    boolean[] alphabet = new boolean[128];
    for (int i = 0; i < str.length(); i++) {
      int position = str.charAt(i);
      if (alphabet[position]) {
        return false;
      }
      alphabet[position] = true;
    }
    return true;
//    time complexity O(N)
//    space complexity O(1)
  }

  public boolean containsDuplicateDigits (int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i+1]) return true;
    }
    return false;
  }
//   time complexity O(N)
//  space complexity O(1)
}
