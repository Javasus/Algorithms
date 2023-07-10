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
    Node current = root;
    Node parent = root;
    boolean isLeftChild = true;
//    Ищём нужный узел
    while (current.iData != key) {
      parent = current;
      if (key < current.iData) {
        isLeftChild = true;
        current = current.leftChild;
      } else {
        isLeftChild = false;
        current = current.rightChild;
      }
      if (current == null) {
        System.out.println("Узел не найден.");
        return false;
      }
    }
//    Если у  узла нет потомков он просто удаляется.
    if (current.leftChild == null && current.rightChild == null) {
      if (current == root) {
        root = null;
      } else if (isLeftChild) {
        parent.leftChild = null;
      } else {
        parent.rightChild = null;
      }
//    Если нет правого потомка, то узел заменяется левым поддеревом.
    } else if (current.rightChild == null) {
      if (current == root) {
        root = current.leftChild;
      } else if (isLeftChild) {
        parent.leftChild = current.leftChild;
      } else {
        parent.rightChild = current.leftChild;
      }
//    Если нет левого потомка, то узел заменяется правым поддеревом.
    } else if (current.leftChild == null) {
      if (current == root) {
        root = current.rightChild;
      } else if (isLeftChild) {
        parent.leftChild = current.rightChild;
      } else {
        parent.rightChild = current.rightChild;
      }
//    Если у узла есть и правый и левый потомок узел заменется приемником
    } else {
//    Поиск приемника с помощью метода getSuccessor().
      Node successor = getSuccessor(current);
//    Родитель связывается с посредником.
      if (current == root) {
        root = successor;
      } else if (isLeftChild) {
        parent.leftChild = successor;
      } else {
        parent.rightChild = successor;
      }
//    Приемник связывается с левым потомком current.
    }
    return true;
  }

//  метод возвращает узел со следующим значением после delNode.
//  Для этого он сначала переходит к правому потомку,
//  а затем отслеживает цепочку левых потомков этого узла.
  private Node getSuccessor (Node delNode) {
    Node successorParent = delNode;
    Node successor = delNode;
    Node current = delNode.rightChild;
    while (current != null) {
      successorParent = successor;
      successor = current;
      current = current.leftChild;
    }
    if (successor != delNode.rightChild) {
      successorParent.leftChild = successor.rightChild;
      successor.rightChild = delNode.rightChild;
    }
    return successor;
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