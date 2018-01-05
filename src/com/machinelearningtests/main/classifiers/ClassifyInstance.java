package com.machinelearningtests.main.classifiers;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ClassifyInstance {
	DataSource srcTr;
	DataSource srcTst;
	Instances dsTraining;
	Instances dsTst;
	
	public ClassifyInstance() throws Exception {
		srcTr = new DataSource("data/iris.arff");

		dsTraining = srcTr.getDataSet(); // loads the data into a dataset object
		dsTraining.setClassIndex(dsTraining.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		//System.out.println(dsTraining.toSummaryString());
		
		int numClasses = dsTraining.numClasses(); // get number of classes
		
		// Output classes
		for(int i = 0; i<numClasses; i++){
			String classValue = dsTraining.classAttribute().value(i);
			System.out.println("Class Value "+i+" is "+classValue);
		}
		
		// Set up classifier
		NaiveBayes nb = new NaiveBayes(); // using Naive Bayes for example
		nb.buildClassifier(dsTraining);
		
		// Get data to classify
		srcTst = new DataSource("data/iris_unknown.arff");
		dsTst = srcTst.getDataSet(); // loads the data into a dataset object
		dsTst.setClassIndex(dsTraining.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		
		// Make the predictions
		System.out.println("======================================");
		System.out.println("Actual Class | NB Predicted");
		// Loop through instances in test dataset
		for(int i = 0; i < dsTst.numInstances(); i++){
			
			double actualClass = dsTst.instance(i).classValue(); // get class double value for current instance
			String actual = dsTst.classAttribute().value((int) actualClass); // converts the double to the class attribute
			Instance newInst = dsTst.instance(i); // get instance object of current instance
			double predNB = nb.classifyInstance(newInst); 	// classifies the instance and returns a double
			String predString = dsTst.classAttribute().value((int) predNB); // converts the double to the class attribute
			System.out.println(actual + " | "+predString);
			
			
		}
		

	}

}
