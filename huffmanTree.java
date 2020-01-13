
import java.io.*;
import java.util.*;
import java.lang.Object;

/**
 * <p>
 * Title: The HuffmanTree Class
 * </p>
 *
 * <p>
 * Description: This class models a Huffman Tree with an header, nodes, count of
 * total characters. In addition to sorting and creating a tree, it does a post
 * traversal through the tree to create the header.
 * </p>
 *
 * @author Robenson Sam, Katherine Lawrence, Ge Ding
 */
public class huffmanTree {
	private static String header = ""; // static variable which stores the header
	private static int var = 0; // static variable which stores hows many integer are in the sentency

	/**
	 * getChar method -- returns the array of character in the file
	 * 
	 * @param file a string which represents a file
	 * @return the array of chars
	 */
	public char[] getChars(String file) {
		char arr[] = null;
		File filename = new File(file);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(filename));
			String text2 = null;
			String text = null;
			while ((text = reader.readLine()) != null) {
				text2 = text;
			}
			arr = text2.toCharArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}

	/**
	 * cntvars method -- takes the characters from the files and counts how many
	 * times the value repeat in the file
	 * 
	 * @param file a string which represents a file
	 * @return returns the frequency of the the variables
	 */
	public int[] cntvars(String file) {
		int arr[] = new int[256];
		Arrays.fill(arr, 0);
		File filename = new File(file);
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(filename));
			String text2 = null;
			String text = null;
			while ((text = reader.readLine()) != null) {
				text2 = text;
			}
			char[] chararray = text2.toCharArray();

			for (int i = 0; i < chararray.length; i++) {
				arr[(int) chararray[i]] += 1;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		return arr;
	}

	/**
	 * nodeCombine method -- takes the characters from the files and counts how many
	 * times the value repeat in the file
	 * 
	 * @param nodeA a node which represents a character & frequency
	 * @param nodeB a node which represents a character & frequency
	 * @return returns a node with both A and B combined
	 */
	public node nodeCombine(node nodeA, node nodeB) {
		char newChar = '0';
		int nfreq = nodeA.getFreq() + nodeB.getFreq();

		node combinedNode = new node(newChar, nfreq);

		combinedNode.setLeft(nodeA);
		combinedNode.setRight(nodeB);

		return combinedNode;

	}

	/**
	 * createHuffmanTree method -- creates a node tree that sort the values and then
	 * combines them to create a Huffman tree
	 * 
	 * @param frequency the frequency of each character
	 * @return returns a Huffman tree which contains all the values
	 */
	public node[] createHuffmanTree(int[] frequency) {
		ArrayList<node> nodeTree = new ArrayList<node>();
		int treeCounter = 0;
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] != 0) {
				treeCounter++;
				nodeTree.add(new node((char) i, frequency[i]));
				Collections.sort(nodeTree);
			}
			var = nodeTree.size();
		}
		while (nodeTree.size() > 1) {
			node node1 = nodeTree.remove(0);
			node node2 = nodeTree.remove(0);
			node temp = nodeCombine(node1, node2);
			nodeTree.add(temp);
			Collections.sort(nodeTree);
		}
		node nodeTree2[] = new node[nodeTree.size()];
		for (int i = 0; i < 1; i++) {
			nodeTree2[i] = nodeTree.remove(0);
		}
		return nodeTree2;
	}

	/**
	 * printPostorder method -- goes through the array in post order and stores the
	 * values in a static global variable called header
	 * 
	 * @param node the root node of the tree
	 */
	public void printPostorder(node node) {

		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.getLeft());

		// then recur on right subtree
		printPostorder(node.getRight());
		if (var <= 0) {
			header += (node.getchars());
		}
		// now deal with the node
		else if (node.getchars() != ' ' && var > 0 && node.getchars() != '0') {
			header += ("1" + node.getchars());
			var--;
			// System.out.print(node.toString());
		} else if (node.getchars() != ' ' && var > 0 && node.getchars() == '0') {
			header += (node.getchars());
		} else if (node.getchars() == ' ' && var > 0 && node.getchars() != '0') {
			header += ("1 ");
		}

	}

	/**
	 * asciiArray method -- creates an array which uses each character ASCII values
	 * for locations
	 * 
	 * @param node the root node for the tree
	 * @return return a string which contains the encryption of the each character
	 */
	public String[] asciiArray(node k) {
		String arr[] = new String[256];

		String encryptVal = "";
		return getasciiArray(k, arr, encryptVal);

	}

	/**
	 * getasciiArray -- creates an ASCII array which contains the values of each
	 * character encrypted
	 * 
	 * @param val     the root of tree
	 * @param arr     the array which contains the all the strings encryption values
	 * @param encrypt the encryption value for a single character
	 * @return returns a String array which contains all the values encryption
	 */
	public String[] getasciiArray(node val, String[] arr, String encrypt) {
		String temp = encrypt;
		String temp2 = encrypt;

		if (val.getLeft() != null) {
			temp += '0';
			getasciiArray(val.getLeft(), arr, temp);
		} else if (val.getRight() == null && val.getRight() == null) {
			arr[(int) val.getchars()] = temp;
		}

		if (val.getRight() != null) {
			temp2 += '1';
			getasciiArray(val.getRight(), arr, temp2);
		} else if (val.getRight() == null && val.getLeft() == null) {
			arr[(int) val.getchars()] = temp2;
		}

		return arr;
	}

	/**
	 * encode -- creates a tree based on the file that the user inputs and output
	 * the header and encrypted text to the output file
	 * 
	 * @param inputfile  a string which contains the file name for the input file
	 * @param outputFile a string which contains the file name for the output file
	 */
	public void encode(String inputfile, String outputFile) {
		BufferedWriter writer;
		int[] frequencyCount = cntvars(inputfile);
		node[] newTree = createHuffmanTree(frequencyCount);
		node rootTree = newTree[0];
		printPostorder(rootTree);
		String tempHeader = "Header: ";
		tempHeader += header;
		tempHeader += "0" + rootTree.getFreq() + "#";
		header = "";
		char characters[] = getChars(inputfile);
		String[] asciiArray = asciiArray(rootTree);
		String encyptedText = "Encrypted Text: ";

		for (int i = 0; i < characters.length; i++) {
			encyptedText += asciiArray[(char) characters[i]];
		}

		try {
			writer = new BufferedWriter(new FileWriter(outputFile));
			writer.write(tempHeader);
			writer.newLine();
			writer.write(encyptedText);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
