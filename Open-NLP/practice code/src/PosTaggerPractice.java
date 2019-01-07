//POS-Tag
package com.zia.NLPpractice.Postagger;

import java.util.ArrayList;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.postag.POSModel;

public class PosTaggerPractice{
	private POSTaggerME posTaggerME = null;
	
	public PosTaggerPractice(String modelPath) throws java.io.IOException{
		posTaggerME = new POSTaggerME(new POSModel(new java.io.FileInputStream(modelPath)));
	}

	public ArrayList<String> tagAll(String...words){
		/*System.out.println("Tags--->"+posTaggerME.getAllPosTags().length+"\n");
		java.util.Arrays.asList(posTaggerME.getAllPosTags()).forEach(tags->{
			System.out.println(tags);
		});*/
		return new ArrayList<String>(java.util.Arrays.asList(posTaggerME.tag(words)));
	}
}