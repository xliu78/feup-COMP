package bgl2sdl;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import gen.*;

import java.io.*;


/**
 * Created by Lycantropus on 04-05-2015.
 */
public class bgl2sdl {

	public static void  main(String[] args) throws IOException {

		//java.util.Scanner sc = new java.util.Scanner(System.in);


		System.out.println("Enter some XML from:\n(1): Console\n(2): File");
		//int opt = sc.nextInt();

		//ANTLRInputStream input = null;
		
		//if(opt == 1){
			System.out.println("Start input:");
			ANTLRInputStream input = new ANTLRInputStream(System.in);
		//	System.out.println("End input");
		/*}else{
			System.out.println("Filename: ");
			FileInputStream in = null;
			String filename = sc.next();
			ANTLRInputStream input=new ANTLRInputStream(new FileInputStream(new File(filename)));
		}*/
		
		System.out.println("Entered: " + input + "\nCreating lexer now...");
		XMLLexer lexer = new XMLLexer(input);

		System.out.println("Creating tokens...");
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		System.out.println("Creating parser...");
		XMLParser parser = new XMLParser(tokens);

		System.out.println("Creating parsetree...");
		ParseTree tree = parser.startpoint();

		System.out.println("Tree LISP style:");
		System.out.println(tree.toStringTree(parser));

		System.out.println("Initializing walker...");
		ParseTreeWalker walker = new ParseTreeWalker();

		walker.walk(new Listener(parser), tree);
		System.out.println("walker ended");









	}
}
