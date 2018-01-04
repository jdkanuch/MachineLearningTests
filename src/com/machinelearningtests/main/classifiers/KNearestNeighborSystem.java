package com.machinelearningtests.main.classifiers;

import com.machinelearningtests.util.InputDataManager;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;

public class KNearestNeighborSystem {
	InputDataManager dm; 
	Instances ds;

	public KNearestNeighborSystem() throws Exception{
		dm = new InputDataManager();

		ds = dm.loadCSVData("data/iris.arff"); // loads the data into a dataset object
		ds.setClassIndex(ds.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		
		// Make sure loaded
		//System.out.println("\nDataset:\n");
		//System.out.println(ds.toSummaryString());
		
		Classifier ibk = new IBk(4); // kNN classifier object
		ibk.buildClassifier(ds); // builds the classifier based on the dataset, trains the model.
		
		System.out.println(ibk);

		Evaluation eval = new Evaluation(ds);
		eval.evaluateModel(ibk, ds);
		/** Print the algorithm summary */
		System.out.println("** KNN Demo  **");
		System.out.println(eval.toSummaryString());
	    System.out.println(eval.toClassDetailsString());
		System.out.println(eval.toMatrixString());		

	}

	public void discretizeData(){
		// Discreting attributes in Weka
		/*
				 Discretize discretize = new Discretize();
				 String[] options = new String[4];
				 options[0] = "-B"; // Bins (category) options
				 options[1] = "5"; // Number of bins
				 options[2] = "-R"; // Range of attributes to apply the discretize filter
				 options[3] = "1,3"; // Range of attributes to apply the discretize filter, 1-indexed
				 discretize.setOptions(options);
				 discretize.setInputFormat(ds);
				 Instances dds = Filter.useFilter(ds, discretize);
				 System.out.println(dds.toSummaryString());
				 System.out.println(dds);
		 */
	}
}
