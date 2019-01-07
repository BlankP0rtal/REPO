//Parser
package com.zia.NLPpractice.Parser;

import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.Parse;
//import opennlp.tools.parser.chunking.Parser;
import opennlp.tools.parser.Parser;
import opennlp.tools.cmdline.parser.ParserTool;


public class ParserPractice{
	private opennlp.tools.parser.chunking.Parser parser = null;
	private Parser parser2 = null;
	private Parse[] parses = null, parses2 = null;

	public ParserPractice(String path) throws java.io.FileNotFoundException, java.io.IOException{
		//parser = new opennlp.tools.parser.chunking.Parser(new ParserModel(new java.io.FileInputStream(path)));/*ParserFactory.create(new ParserModel(new java.io.FileInputStream(path)));*/
		parser2 = ParserFactory.create(new ParserModel(new java.io.FileInputStream(path)));
	}

	public void parseIt(String sentence){
		parses = ParserTool.parseLine(sentence, parser, 1);
		for(var parse : parses)
			parse.show();
		/*System.out.println("\n----\n");
		parses2 = ParserTool.parseLine(sentence, parser2, 1);
		for(Parse parse : parses2)
			parse.show();*/
	}
}