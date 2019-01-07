//TestClass
package com.zia.NLPpractice.Testclass;

import com.zia.NLPpractice.Tokenizer.*;
import com.zia.NLPpractice.Postagger.*;
import com.zia.NLPpractice.Chunker.*;
import com.zia.NLPpractice.Parser.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

public class TestClass{

	public String retriveData(String path) throws FileNotFoundException, IOException{
		String data = "",buffer="";
		try(BufferedReader read = new BufferedReader(new FileReader(path))){
			while((buffer = read.readLine()) != null)
				data += buffer;
		}
		buffer = null;
		return data;
	}

	public static <T>void print(ArrayList<T> list){
		list.forEach(data -> {
			System.out.println(data);
		});
	} 

	public ArrayList<String> getTokens() throws FileNotFoundException, IOException{
		String path = "/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/practice code/datas/sampleInput.txt";
		String fdata = retriveData(path);

		return new TokenizerPractice().tokenizeData(fdata,"/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/Pre-defined Datas/en-token.bin");
	}

	public ArrayList<String> getTags() throws FileNotFoundException, IOException{
		String path = "/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/Pre-defined Datas/en-pos-perceptron.bin";
		String fdata = retriveData("/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/practice code/datas/sampleInput.txt");
		Object[] objs = getTokens().toArray();

		return new PosTaggerPractice(path).tagAll(Arrays.copyOf(objs, objs.length, String[].class));/*.forEach(data -> {
			System.out.println(data);
		});*/
	}

	public ArrayList<String> testChunker() throws FileNotFoundException, IOException{
		String path = "/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/Pre-defined Datas/en-chunker.bin";
		String fdata = retriveData("/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/practice code/datas/sampleInput.txt");
		Object[] objs = getTags().toArray();
		Object[] toks = getTokens().toArray();
		return new ChunkerPractice(path).chunkIt(Arrays.copyOf(toks, toks.length, String[].class), Arrays.copyOf(objs, objs.length, String[].class));/*.forEach(data -> {
			System.out.println(data);
		});*/
	}

	public void testParser() throws FileNotFoundException, IOException{
		String fdata = retriveData("/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/practice code/datas/sampleInput.txt");
		String path = "/Users/arjun-7412/Documents/Code Stash/LearnUtil/Open-NLP/Pre-defined Datas/en-parser-chunking.bin";
		new ParserPractice(path).parseIt(fdata);
	}

	public void printTemp(ArrayList<String> words, ArrayList<String> chunk){
		for(int i=0; i < words.length; i++)
			System.out.println(words.get(i)+" - "+chunk.get(i));
	}

	public static void main(String...params) throws Exception{
		TestClass testClass = new TestClass();
		//testClass.testTokenizer();
		//print(testClass.getTags());
		/*System.out.println("-----------------\n");*/
		//print(testClass.testChunker());
		testClass.printTemp(testClass.testTokenizer(), testClass.testChunker());
		//testClass.testParser();
	}
}
