package com.machinelearningtests.main.genetic;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.machinelearningtests.util.RandomGen;

public class DNA {

	
	char[] genes = new char[18];
	
	
	float fitness;
	
	

	Random rand = new Random();
	
	public DNA(){
		createPopulation();

	}

	public void createPopulation(){
		// create genes randomly
		for(int i = 0;i < genes.length;i++){
			int randomNum = ThreadLocalRandom.current().nextInt(32, 128);
			genes[i] = (char) randomNum;
		}

	}
	
	public void calcFitness(String target){
		int score = 0;
		
		for(int i = 0; i < genes.length; i++){
			if(genes[i] == target.charAt(i)){
				score++;
			}
		}
		this.fitness = (float)score/target.length();
		
		
	}
	
	public DNA crossover(DNA partner){
		DNA child = new DNA(); // new DNA, will be random but will be overwritten
		
		int midpoint = (int) ThreadLocalRandom.current().nextInt(genes.length); // gets random midpoint in genes array
		
		
		// for each gene in child object, anything to the left of random midpoint is from parent a, after random midpoint is parent b
		for(int i = 0; i < genes.length; i++){
			if(i > midpoint){
				child.genes[i] = genes[i];
			} else {
				child.genes[i] = partner.genes[i];
			}
		}
		
		// TODO
		// Implement that each gene has a 50/50 chance to come from one or another parent
		
		return child;
	}
	
	public void mutate(float mutationRate){
		for(int i = 0; i< genes.length; i++){
			if(rand.nextFloat() < mutationRate){
				genes[i] = (char) ThreadLocalRandom.current().nextInt(32, 128);
			}
		}
	}
	
	public String getPhrase(){
		// Phenotype
		return new String(genes);
	}

}
