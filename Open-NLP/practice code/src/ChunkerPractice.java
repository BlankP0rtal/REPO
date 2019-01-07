//Chunker
//POS-Tag
package com.zia.NLPpractice.Chunker;

import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.chunker.ChunkerME;
import java.util.ArrayList;


public class ChunkerPractice{
	private ChunkerME chunkerME = null;
	
	public ChunkerPractice(String modelPath) throws java.io.IOException{
		chunkerME = new ChunkerME(new ChunkerModel(new java.io.FileInputStream(modelPath)));
	}

	public ArrayList<String> chunkIt(String[] toks, String[] tags){
		return new ArrayList<String>(java.util.Arrays.asList(chunkerME.chunk(toks,tags)));
	}
}