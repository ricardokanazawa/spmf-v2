package ca.pfv.spmf.test;

import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.associationrules.TopKRules_and_TNR.AlgoTopKClassRules;
import ca.pfv.spmf.algorithms.associationrules.TopKRules_and_TNR.AlgoTopKRules;
import ca.pfv.spmf.algorithms.associationrules.TopKRules_and_TNR.Database;

/**
 * Example of how to use the TOPKClassRules algorithm in source code.
 * This algorithm is designed to find association rules where the consequent
 * is fixed to a specific item.
 * @author Philippe Fournier-Viger (Copyright 2010)
 */
public class MainTestTopKClassRules {

	public static void main(String [] arg) throws Exception{
		// Load database into memory
		Database database = new Database(); 
		database.loadFile("C:\\temp\\transacoes\\PRESTADOR 1\\61100016.txt"); 
		
		int k = 20; 
		double minConf = 0.80;
		
		// the item to be used as consequent for generating rules
		int[] itemToBeUsedAsConsequent = new int[]{61100016};
		
		AlgoTopKClassRules algo = new AlgoTopKClassRules();
		
//		// This optional parameter allows to specify the maximum number of items in the 
//		// left side (antecedent) of rules found:
//		algo.setMaxAntecedentSize(2);  // optional
//
		algo.runAlgorithm(k, minConf, database, itemToBeUsedAsConsequent);

		algo.printStats();
		algo.writeResultTofile("C:\\temp\\transacoes\\PRESTADOR 1\\61100016_output_topkclassrules_alterado.txt");   // to save results to file

	}

	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestTopKClassRules.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
