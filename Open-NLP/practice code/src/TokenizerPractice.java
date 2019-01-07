//Tokenizer
package com.zia.NLPpractice.Tokenizer;

import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TokenizerPractice{
	private String data;
	private String defaultToken;


	//Simple tokenizer
	public ArrayList<String> tokenizeData(String data){
		SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;
		ArrayList<String> tokenizedData = new ArrayList<String>(Arrays.asList(simpleTokenizer.tokenize(data)));
		return tokenizedData;
	}

	//tokenizerME
	public ArrayList<String> tokenizeData(String data,String path) throws FileNotFoundException, IOException{
		
		try(FileInputStream in = new FileInputStream(path)){
			TokenizerModel tokenizerModel = new TokenizerModel(in);
			TokenizerME tokenizerME = new TokenizerME(tokenizerModel);
			ArrayList<String> tokenizedData = new ArrayList<String>(Arrays.asList(tokenizerME.tokenize(data)));
			return tokenizedData;
		}
	}
}