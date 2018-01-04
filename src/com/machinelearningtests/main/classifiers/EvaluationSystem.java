package com.machinelearningtests.main.classifiers;

import java.util.Random;

import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class EvaluationSystem {
	DataSource source;
	Instances ds;

	public EvaluationSystem() throws Exception {
		source = new DataSource("data/iris.arff");

		ds = source.getDataSet(); // loads the data into a dataset object
		ds.setClassIndex(ds.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		System.out.println(ds.toSummaryString());	
		
		// Use the Tree Classifier
		J48 tree = new J48();
		tree.buildClassifier(ds);  // builds the model
		
		// initialize the evaluator with the training dataset
		Evaluation eval = new Evaluation(ds);
		Random rand = new Random(1);
		int folds = 10;
		
		// Test Dataset for Eval
		DataSource tsrc = new DataSource("data/iris.arff"); // TODO change this to actual test data
		Instances tds = tsrc.getDataSet();
		
		
	}

}
