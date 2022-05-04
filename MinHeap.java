class Solution {
  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap();
    minHeap.add(10);
    minHeap.add(5);
    minHeap.add(15);
        minHeap.add(1);
    System.out.println(minHeap.peek());
  }
}

class MinHeap {
  int capacity = 10;
  int size = 0;
  int[] elements = new int[capacity];

  private int getLeftChildIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  private int getRightChildIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }

  private int getParentIndex(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private boolean hasRightChild(int index) {
    return getRightChildIndex(index) < size;
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private int leftChild(int parentIndex) {
    return elements[getLeftChildIndex(parentIndex)];
  }

  private int rightChild(int parentIndex) {
    return elements[getRightChildIndex(parentIndex)];
  }

  private int parent(int childIndex) {
    return elements[getParentIndex(childIndex)];
  }

  private void swap(int index1, int index2) {
    int temp = elements[index1];
    elements[index1] = elements[index2];
    elements[index2] = temp;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      elements = Arrays.copyOf(elements, capacity * 2);
      capacity *= 2;
    }
  }

  public int peek() {
    return elements[0];
  }

  public void add(int data) {
    ensureCapacity();
    elements[size] = data;
    size++;
    heapifyUp();
  }

  private void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && parent(index) > elements[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }

  public int removeMin() {
    int item = elements[0];
    elements[0] = elements[size - 1];
    size--;
    heapifyDown();
    return item;
  }

  private void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smallerChildIndex = getLeftChildIndex(index);
      if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
        smallerChildIndex = getRightChildIndex(index);

      }
      if (elements[index] < elements[smallerChildIndex]) {
        break;
      } else {
        swap(smallerChildIndex, elements[index]);
      }
      index = smallerChildIndex;
    }
  }
}
