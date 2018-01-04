package com.machinelearningtests.main;

import com.machinelearningtests.main.classifiers.ClassifierWithFilter;
import com.machinelearningtests.main.classifiers.KNearestNeighborSystem;
import com.machinelearningtests.main.classifiers.NaiveBayesSystem;
import com.machinelearningtests.main.regression.RegressionSystem;

public class Main {

	public static void main(String[] args) {
		//GeneticSystem gs = new GeneticSystem();
		try {
			//KNearestNeighborSystem knn = new KNearestNeighborSystem();
			//NaiveBayesSystem nbs = new NaiveBayesSystem();
			// ClassifierWithFilter cf = new ClassifierWithFilter();
			RegressionSystem regSys = new RegressionSystem();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
