package edu.grinnell.csc207.util;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Stack;

/**
 * Simple binary trees.
 *
 * @author Samuel A. Rebelsky
 * @author Benjamin Sheeley
 * @author Jacob Bell
 *
 * @param <T>
 *   The type of value stored in the tree.
 */
public class BinaryTree<T> implements Iterable<T> {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The root of the tree.
   */
  BinaryTreeNode<T> root;

  /**
   * The number of values in the tree.
   */
  int size;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new, empty, tree.
   */
  public BinaryTree() {
    this.size = 0;
    this.root = null;
  } // BinaryTree

  /**
   * Create a new, somewhat balanced, tree.
   *
   * @param values
   *   The values to put in the tree.
   */
  public BinaryTree(T[] values) {
    this.size = values.length;
    this.root = makeTree(values, 0, values.length);
  } // BinaryTree(T[])

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Dump the tree to some output location.
   *
   * @param pen
   *   The output location.
   */
  public void dump(PrintWriter pen) {
    dump(pen, root, "");
  } // dump(PrintWriter)

  public void elements01(PrintWriter pen) {
    elements01(pen, root);
    pen.println();
  } // elements01(PrintWriter)

  public void elements02(PrintWriter pen) {
    elements02(pen, root);
    pen.println();
  } // elements01(PrintWriter)

  /**
   * Get an iterator for the tree.
   *
   * @return the iterator.
   */
  public Iterator<T> iterator() {
    return new Iterator<T>() {

      public boolean hasNext() {
        // STUB
        return false;
      } // hasNext()

      public T next() {
        // STUB
        return null;
      } // next()
    }; // new Iterator()
  } // iterator()

  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Dump a portion of the tree to some output location.
   *
   * @param pen
   *   Where to dump the output.
   * @param node
   *   The node to dump.
   * @param indent
   *   How far to indent the dumped values.
   */
  void dump(PrintWriter pen, BinaryTreeNode<T> node, String indent) {
    if (node == null) {
      pen.println(indent + "<>");
    } else {
      pen.println(indent + node.value);
      if ((node.left != null) || (node.right != null)) {
        dump(pen, node.left, indent + "  ");
        dump(pen, node.right, indent + "  ");
      } // if has children
    } // else
  } // dump

  void elements01(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) {
      return;
    } else {
      pen.print(node.value + " ");
      if ((node.left != null) || (node.right != null)) {
        elements01(pen, node.left);
        elements01(pen, node.right);
      }
      pen.flush();
    }
  }

  void elements02(PrintWriter pen, BinaryTreeNode<T> node) {
    if (node == null) {
      return;
    } else {
      if (node.left != null) {
        elements02(pen, node.left);
      }
      pen.print(node.value + " ");
      if (node.right != null) {
        elements02(pen, node.right);
      }
      pen.flush();
    }
  }

  /**
   * Build a tree from a subarray from lb (inclusive) to ub (exclusive).
   *
   * @param values
   *   The array from which to draw values.
   * @param lb
   *   The lower bound of the subarray (inclusive).
   * @param ub
   *   The upper bound of the subarray (exclusive).
   *
   * @return
   *   The root of the newly made tree.
   */
  BinaryTreeNode<T> makeTree(T[] values, int lb, int ub) {
    if (ub <= lb) {
      return null;
    } else if (ub - lb == 1) {
      return new BinaryTreeNode<T>(values[lb]);
    } else {
      int mid = lb + (ub - lb) / 2;
      return new BinaryTreeNode<T>(values[mid], makeTree(values, lb, mid),
          makeTree(values, mid + 1, ub));
    } // if/else
  } // makeTree(T[], int, int)

  /**
 * Print all of the elements in some order or other.
 * 
 * Note: We are trying to avoid recursion.
 */
public void print(PrintWriter pen) {
  // A collection of the remaining things to print
  Stack<Object> remaining = new Stack<Object>();
  remaining.push(this.root);
  // Invariants: 
  //   remaining only contains Strings or Nodes
  //   All values in the tree are either
  //     (a) already printed,
  //     (b) in remaining, or
  //     (c) in or below a node in remaining
  while (!remaining.isEmpty()) {
    Object next = remaining.pop();
    if (next instanceof BinaryTreeNode<?>) {
      @SuppressWarnings("unchecked")
      BinaryTreeNode<T> node = (BinaryTreeNode<T>) next;
      if (node.left != null) {
        remaining.push(node.left);
      } // if (node.left != null)
      remaining.push(node.value);
      if (node.right != null) {
        remaining.push(node.right);
      } // if (node.right != null)
    } else {
      pen.print(next);
      pen.print(" ");
    } // if/else
  } // while
  pen.println();
} // print(PrintWriter)

} // class BinaryTree
