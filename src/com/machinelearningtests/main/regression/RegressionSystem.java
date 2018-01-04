package com.machinelearningtests.main.regression;

import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.gui.visualize.Plot2D;

public class RegressionSystem {
	DataSource source;
	Instances ds;
	
	public RegressionSystem() throws Exception {
		source = new DataSource("data/housing.arff");
		
		ds = source.getDataSet(); // loads the data into a dataset object
		ds.setClassIndex(ds.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		
		//System.out.println(ds.toSummaryString());
		
		// Build Model
//		LinearRegression lr = new LinearRegression();
//		lr.buildClassifier(ds); // note you still use build classifier
//		
//		// output model
//		System.out.println(lr);
		
		// SVM Regression
		SMOreg smoReg = new SMOreg();
		smoReg.buildClassifier(ds);
		System.out.println(smoReg);

		
	}

}
