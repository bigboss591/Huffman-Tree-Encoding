//************************************************************************************

//mainClass.java
//Author: Robenson Sam, Katherine Lawrence, Ge Ding
//Assignment: Lab1
//Course: CSCI651
//This Program is the creates a Huffman tree and encodes is based on content in the input and output folder
//************************************************************************************

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		huffmanTree tree = new huffmanTree(); // creates the Huffman tree object
		tree.encode("test1.txt", "output.txt"); // calls the encodes method on an input and output file
	}
}
