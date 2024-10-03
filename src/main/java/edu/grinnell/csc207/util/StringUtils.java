package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Luis Lopez
 * @author Paden Houck
 */
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+

  /**
   * Determine whether the parens match in string.
   * 
   * @throws Exception
   */
  public static boolean checkMatching(String str) throws Exception {
    Stack<Character> parens = new LinkedStack<Character>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(' || str.charAt(i) == '[') {
        parens.push(str.charAt(i));
      } else if (str.charAt(i) == ')') {
        if (parens.peek() == '[') {
          return false;
        } else if (parens.peek() == '(') {
          parens.pop();
        }
      } else if (str.charAt(i) == ']') {
        if (parens.peek() == '(') {
          return false;
        } else if (parens.peek() == '[') {
          parens.pop();
        }
      }
    }
    return true;
  } // checkMatching
} // class StringUtils

