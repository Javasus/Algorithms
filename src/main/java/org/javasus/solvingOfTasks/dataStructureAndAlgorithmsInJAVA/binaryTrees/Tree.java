package org.javasus.solvingOfTasks.dataStructureAndAlgorithmsInJAVA.binaryTrees;

import java.util.Stack;

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
    Node newNode = new Node();
    newNode.iData = id;
    newNode.dData = dd;
    if (root == null) {
      root = newNode;
    } else {
      Node current = root;
      Node parent;
      while (true) {
        parent = current;
        if (id < current.iData) {
          current = current.leftChild;
          if (current == null) {
            parent.leftChild = newNode;
            return;
          }
        } else {
          current = current.rightChild;
          if (current == null) {
            parent.rightChild = newNode;
            return;
          }
        }
      }
    }
//    Time complexity O(Log2N)
//    Space complexity O(1)
  }

  // Delete node
  public boolean delete (int key) {
    return true;
  }

  // Return next node when delete node with children
  private Node getSuccessor (Node delNode) {
    return new Node();
  }

  public void minimum () {
    Node current, last = null;
    current = root;
    while (current != null) {
      last = current;
      current = current.leftChild;
    }
    System.out.println( last.iData);
  }

  public void maximum () {
    Node current, last = null;
    current = root;
    while (current != null) {
      last = current;
      current = current.rightChild;
    }

    System.out.println(last.iData);
  }

  // Варианты вывода узлов дерева в зависимости от выбранного типа:
  // PreOrder (Прямой), InOrder (симметричный, по умолчанию), PostOrder (Обратный).
  public void traverse (String traverseType) {
    switch(traverseType) {
    case "pre order"  : System.out.print("Pre order: ");
                        preOrder(root);
                        break;
    case "in order"   : System.out.print("In order: ");
                        inOrder(root);
                        break;
    case "post order" : System.out.print("Post order: ");
                        postOrder(root);
                        break;
    }
    System.out.println("\n _________________________________________________");
  }

  private void preOrder (Node localRoot) {
    if (localRoot != null) {
      System.out.print(localRoot.iData + " ");
      preOrder(localRoot.leftChild);
      preOrder(localRoot.rightChild);
    }
  }

  private void inOrder (Node localRoot) {
    if (localRoot != null) {
      inOrder(localRoot.leftChild);
      System.out.print(localRoot.iData + " ");
      inOrder(localRoot.rightChild);
    }
  }

  private void postOrder (Node localRoot) {
    if (localRoot != null) {
      postOrder(localRoot.leftChild);
      postOrder(localRoot.rightChild);
      System.out.print(localRoot.iData + " ");
    }
  }

  // Вывод дерева на экран
  public void displayTree() {
    Stack globalStack = new Stack();
    globalStack.push(root);
    int nBlanks = 32;
    boolean isRowEmpty = false;
    System.out.println("................................................................");
    while (isRowEmpty == false) {
      Stack localStack = new Stack();
      isRowEmpty = true;
      for (int j = 0; j  < nBlanks; j ++) {
        System.out.print(' ');
      }
      while (globalStack.isEmpty() == false) {
        Node temp = (Node) globalStack.pop();
        if (temp != null) {
          System.out.print(temp.iData);
          localStack.push(temp.leftChild);
          localStack.push(temp.rightChild);

          if (temp.leftChild != null || temp.rightChild != null) {
            isRowEmpty = false;
          }
        } else {
          System.out.print("__");
          localStack.push(null);
          localStack.push(null);
        }
        for (int j = 0; j < nBlanks * 2 - 2; j++) {
          System.out.print(' ');
        }
      }
      System.out.println();
      nBlanks /= 2;
      while (localStack.isEmpty() == false) {
        globalStack.push(localStack.pop());
      }

    }
    System.out.println("................................................................");
  }

}
