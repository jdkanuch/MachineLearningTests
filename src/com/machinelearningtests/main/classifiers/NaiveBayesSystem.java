package com.machinelearningtests.main.classifiers;

import com.machinelearningtests.util.InputDataManager;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.SMO;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class NaiveBayesSystem {
	InputDataManager dm;
	DataSource source;
	Instances ds;

	public NaiveBayesSystem() throws Exception{
		source = new DataSource("data/iris.arff");

		ds = source.getDataSet(); // loads the data into a dataset object
		ds.setClassIndex(ds.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting

		// Naive Bayes code
		//NaiveBayes nb = new NaiveBayes();
		//nb.buildClassifier(ds); // builds the naive bayes classifier
		//System.out.println(nb.getCapabilities().toString());
		
		// SVM
		SMO svm = new SMO();
		svm.buildClassifier(ds); // builds the SVM classifier
		System.out.println(svm.getCapabilities().toString());
		
		// Decision Tree (J48)
		String[] opt = new String[4];
		opt[0] = "-C"; opt[1] = "0.11"; // pruned tree with confidence 0.11
		opt[2] = "-M"; opt[3] = "3"; // Minimum # of objects...look at documentation
		J48 tree = new J48();
		tree.setOptions(opt);
		tree.buildClassifier(ds);
		System.out.println(tree.getCapabilities().toString());
		System.out.println(tree.graph());

	}
}
