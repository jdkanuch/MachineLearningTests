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
		int kFolds = 10;
		
		// Test Dataset for Eval
		DataSource tsrc = new DataSource("data/iris.arff"); // TODO change this to actual test data
		Instances tds = tsrc.getDataSet();
		tds.setClassIndex(ds.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting

		// Evaluate model
		//eval.evaluateModel(tree, tds);
		eval.crossValidateModel(tree, tds, kFolds, rand); // Cross validates model with k-folds defined above and the random seed
		// System.out.println(eval.toSummaryString("Evaluation Results : \n",false));
		
		// Printing various output
		System.out.println("Correct % = "+eval.pctCorrect());
		System.out.println("Incorrect % = "+eval.pctIncorrect());
		System.out.println("AUC = "+eval.areaUnderROC(1));
		System.out.println("kappa = "+eval.kappa());
		System.out.println("MAE = "+eval.meanAbsoluteError());
		System.out.println("RMSE = "+eval.rootMeanSquaredError());
		System.out.println("RAE = "+eval.relativeAbsoluteError());
		System.out.println("RRSE = "+eval.rootRelativeSquaredError());
		System.out.println("Precision = "+eval.precision(1));
		System.out.println("Recall = "+eval.recall(1));
		System.out.println("fMeasure = "+eval.fMeasure(1));
		System.out.println("Error Rate = "+eval.errorRate());
	    //the confusion matrix
		System.out.println(eval.toMatrixString("=== Overall Confusion Matrix ===\n"));
		
		
	}

}
