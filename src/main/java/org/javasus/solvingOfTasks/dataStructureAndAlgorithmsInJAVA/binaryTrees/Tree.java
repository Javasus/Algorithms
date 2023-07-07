package org.javasus.solvingOfTasks.dataStructureAndAlgorithmsInJAVA.binaryTrees;

public class Tree {
  private Node root;

  public Tree() {
    root = null;
  }
  // find node
  public Node find(int key) {
    Node current = root;
    while (current.iData != key) {
      if (key < current.iData) {
        current = current.leftChild;
      } else {
        current = current.rightChild;
      }
      if (current == null) {
       return null;
      }
    }
    return current;
//    Time complexity O(Log2N)
//    Space complexity O(1)
  }

  // insert node
  public void insert(int id, double dd) {

  }

  // Delete node
  public boolean delete (int key) {
    return true;
  }

  // Return next node when delete node with children
  private Node getSuccessor (Node delNode) {
    return new Node();
  }

  // Варианты вывода узлов дерева в зависимости от выбранного типа:
  // PreOrder (Прямой), InOrder (симметричный, по умолчанию), PostOrder (Обратный).
  public void traverse (int traverseType) {

  }

  private void preOrder (Node localRoot) {

  }

  private void inOrder (Node localRoot) {

  }

  private void postOrder (Node localRoot) {

  }

  // Вывод дерева на экран
  public void displayTree() {

  }
}
