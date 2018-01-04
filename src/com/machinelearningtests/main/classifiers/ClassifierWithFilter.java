package com.machinelearningtests.main.classifiers;

import com.machinelearningtests.util.InputDataManager;

import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;

public class ClassifierWithFilter {
	InputDataManager dm;
	DataSource source;
	Instances ds;
	public ClassifierWithFilter() throws Exception {
		source = new DataSource("data/iris.arff");

		ds = source.getDataSet(); // loads the data into a dataset object
		ds.setClassIndex(ds.numAttributes() - 1); // sets the last attribute as the one with the classes that you are predicting
		
		// Base Classifier
		J48 tree = new J48();
		Remove remove = new Remove(); // the filter
		// remove filter options
		String[] opt = new String[]{"-R","1"};
		remove.setOptions(opt);
		
		// Filter Classifier object
		FilteredClassifier fc = new FilteredClassifier();		
		fc.setFilter(remove); // pass it the filter
		fc.setClassifier(tree); // pass it the classifier
		
		fc.buildClassifier(ds); // builds the meta classifier???
		System.out.println(fc.toString());
		
	}

}
