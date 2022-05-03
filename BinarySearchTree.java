class Solution {
  public static void main(String[] args) {
    Node treeNode = new Node(10);
    treeNode.add(5);
    treeNode.add(15);
    treeNode.add(2);
    treeNode.printInOrder();
    System.out.println(treeNode.contains(5));
    System.out.println(treeNode.contains(9));

  }
}

class Node {
  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  void add(int value) {
    Node newNode = new Node(value);
    if (value <= this.value) {
      if (this.left == null) {
        left = newNode;
      } else {
        this.left.add(value);
      }
    } else {
      if (this.right == null) {
        this.right = newNode;
      } else {
        this.right.add(value);
      }
    }
  }

  boolean contains(int value) {
    if (this.value == value) {
      return true;
    } else if (value < this.value) {
      if (this.left == null) {
        return false;
      } else {
        return this.left.contains(value);
      }
    } else {
      if (this.right == null) {
        return false;
      } else {
        return this.right.contains(value);
      }

    }
  }

  void printInOrder() {
    if (this.left != null) {
      this.left.printInOrder();
    }
    System.out.println(this.value);
    if (this.right != null) {
      this.right.printInOrder();
    }
  }

  void deleteNode(int value) {

  }
}
