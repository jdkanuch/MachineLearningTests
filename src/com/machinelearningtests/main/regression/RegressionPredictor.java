package com.machinelearningtests.main.regression;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMOreg;
import weka.classifiers.trees.REPTree;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class RegressionPredictor {
	DataSource srcTr;
	DataSource srcTst;
	Instances dsr;
	Instances dsTst;

	public RegressionPredictor() throws Exception {
		// setup training data
		srcTr = new DataSource("data/housing.arff");

		dsr = srcTr.getDataSet(); // loads the data into a dataset object
		dsr.setClassIndex(dsr.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		//System.out.println(dsTraining.toSummaryString());

		// Get data to classify
		srcTst = new DataSource("data/housing_unknown.arff");
		dsTst = srcTst.getDataSet(); // loads the data into a dataset object
		dsTst.setClassIndex(dsr.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting

		// Create Model Evaluator
		Evaluation eval = new Evaluation(dsr);

		// Build Model
		SMOreg smo = new SMOreg();
		smo.buildClassifier(dsr);


		// output model
		//System.out.println(smo);

		// Output evaluation
		eval.evaluateModel(smo, dsTst);
		System.out.println("SMO Summary");
		System.out.println("======================================");
		System.out.println(eval.toSummaryString());
		
		
		// Make the predictions
		System.out.println("======================================");
		System.out.println("Actual Val | SMO Predicted");
		// Loop through instances in test dataset
		for(int i = 0; i < dsTst.numInstances(); i++){

			double actualValue = dsTst.instance(i).classValue(); // get class double value for current instance
			Instance newInst = dsTst.instance(i); // get instance object of current instance
			
			// SMO
			double predSMO = smo.classifyInstance(newInst); 	// classifies the instance and returns a double
			System.out.println(actualValue + " | "+predSMO);


			System.out.println();

		}

	}

}
