
import java.util.Comparator;

/**
 * <p>
 * Title: The Node Class
 * </p>
 *
 * <p>
 * Description: This class models a Node with an character, frequency, left and
 * right child. In addition to setting and modify the node it also allows form
 * the comparision of two nodes traversal through the tree to create the header.
 * </p>
 *
 * @author Robenson Sam, Katherine Lawrence, Ge Ding
 */
public class node implements Comparable<node> {

	private char character; // character value of the node
	private int frequency; // character frequency
	private node left; // left node
	private node right; // right node

	/**
	 * node method -- create a nodes which contains the frequency, character, right
	 * and left node
	 * 
	 * @param chars  a char which represent the character
	 * @param freq   a integer which represents the characters frequency
	 * @param nleft  a node on the left side
	 * @param nright a node on the right side
	 */
	public node(char chars, int freq, node nleft, node nright) {
		character = chars;
		frequency = freq;
		left = nleft;
		right = nright;
	}

	/**
	 * node method -- create a nodes which contains the frequency, character, right
	 * and left node
	 * 
	 */
	public node() {
		character = ' ';
		frequency = 0;
		left = null;
		right = null;

	}

	/**
	 * node method -- create a nodes which contains the frequency, character, right
	 * and left node
	 * 
	 * @param chars a char which represent the character
	 * @param freq  a integer which represents the characters frequency
	 */
	public node(char chars, int freq) {
		character = chars;
		frequency = freq;
		left = null;
		right = null;

	}

	/**
	 * setChar method -- set the character value
	 * 
	 * @param chars a char which represent the character
	 */
	public void setChar(char chars) {
		character = chars;
	}

	/**
	 * setFreq method -- set the frequency value
	 * 
	 * @param freq a integer which represent the character frequency
	 */
	public void setFreq(int freq) {
		frequency = freq;
	}

	/**
	 * setLeft method -- set the value for the left node
	 * 
	 * @param node the node on the left side
	 */
	public void setLeft(node nleft) {
		left = nleft;
	}

	/**
	 * setRight method -- set the value for the right node
	 * 
	 * @param node the node on the left side
	 */
	public void setRight(node nright) {
		right = nright;
	}

	/**
	 * getRight method -- return the node on the Right
	 * 
	 * @return returns the node on the right side
	 */
	public node getRight() {
		return right;
	}

	/**
	 * getLeft method -- return the node on the Left
	 * 
	 * @return returns the node on the left side
	 */
	public node getLeft() {
		return left;
	}

	/**
	 * getFreq method -- return the frequency of the character
	 * 
	 * @return returns the frequency of the node
	 */
	public int getFreq() {
		return frequency;
	}

	/**
	 * getChars method -- return the characters value
	 * 
	 * @return returns the char value
	 */
	public char getchars() {
		return character;
	}

	/**
	 * toString method -- return the node as a string
	 * 
	 * @return returns a string contain the frequency as character in the node
	 */
	public String toString() {
		return "Character: " + character + "Frequency: " + frequency + "\n";
	}

	/**
	 * compareTo method -- compares two nodes
	 * 
	 * @return returns the value from the compare method
	 */
	@Override
	public int compareTo(node o) {
		return Integer.compare(this.frequency, o.frequency);

	}

}
