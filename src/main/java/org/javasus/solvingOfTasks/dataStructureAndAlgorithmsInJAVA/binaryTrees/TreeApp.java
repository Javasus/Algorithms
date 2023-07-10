package org.javasus.solvingOfTasks.dataStructureAndAlgorithmsInJAVA.binaryTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {
  public static void main (String[] args) throws IOException {
    int value;
    String trChoice;
    Tree theTree = new Tree();

    theTree.insert(50, 1.1);
    theTree.insert(30, 1.1);
    theTree.insert(20, 1.1);
    theTree.insert(40, 1.1);
    theTree.insert(60, 1.1);
    while (true) {
      System.out.print("Введите букву выражения для показа, ");
      System.out.print("i - insert, f - find, d -delete, t - traverse, s - show tree, max - show max root, min - show min root. \n");
      String choice = getString();
      switch (choice) {
      case "s" :
        theTree.displayTree();
        break;
      case "i" :
        System.out.print("Введите значение для вставки:");
        value = getInt();
        theTree.insert(value, value + 0.9);
        break;
      case "f" :
        System.out.print("Введите  значение для поиска: ");
        value = getInt();
        Node found = theTree.find(value);
        if (found != null) {
          System.out.print("Найден: " );
          found.displayNode();
          System.out.print("\n");
        }
      case "t" :
        System.out.println("Выбери порядок вывода элементов: \n1. pre order - прямой. \n2. in order - симметричный. \n3. post order - обратный");
        trChoice = getString();
        theTree.traverse(trChoice);
        break;
      case "min" :
        theTree.minimum();
        break;
      case "max" :
        theTree.maximum();
        break;
      case "d" :
        System.out.println("Введите значение для удаления: ");
        value = getInt();
        boolean result = theTree.delete(value);
        System.out.print("\n");
        if (result) {
          System.out.println("Узел с введённым значением удалён!");
        } else {
          System.out.println("Узел с введённым значение не уделён!");
        }
      }
    }
  }

  public static String getString() throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(reader);
    String st = br.readLine();
    return st;
  }

  public static int getInt() throws IOException {
    String str = getString();
    return Integer.parseInt(str);
  }
}