package edu.grinnell.csc207.experiments;

import edu.grinnell.csc207.util.BinaryTree;

import java.io.PrintWriter;

/**
 * A place to experiment with binary trees.
 */
public class BinaryTreeExperiments {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * Run our experiments.
   *
   * @param args
   *   Command-line arguments (currently ignored).
   */
  public static void main(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] strings = {"aardvark", "billygoat", "chinchilla", "dingo", "emu",
        "frog", "gnu", "hippo", "iguana", "jackalope", "koala", "llama", "mouse", "ntalope"};
    BinaryTree<String> tree = new BinaryTree<String>(strings);

    tree.dump(pen);
    tree.elements01(pen);
    tree.elements02(pen);
    tree.print(pen);
    pen.close();
  } // main
} // class BinaryTreeExperiments
