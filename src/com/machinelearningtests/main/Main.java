package com.machinelearningtests.main;

import com.machinelearningtests.main.classifiers.ClassifyInstance;
import com.machinelearningtests.main.regression.RegressionPredictor;

public class Main {

	public static void main(String[] args) {
		//GeneticSystem gs = new GeneticSystem();
		try {
			// KNearestNeighborSystem knn = new KNearestNeighborSystem();
			// NaiveBayesSystem nbs = new NaiveBayesSystem();
			// ClassifierWithFilter cf = new ClassifierWithFilter();
			// RegressionSystem regSys = new RegressionSystem();
			// EvaluationSystem es = new EvaluationSystem();
			//ClassifyInstance ci = new ClassifyInstance();
			RegressionPredictor rp = new RegressionPredictor(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
