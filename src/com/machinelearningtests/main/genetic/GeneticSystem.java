package com.machinelearningtests.main.genetic;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GeneticSystem {

	DNA[] population = new DNA[150]; 					// set up the population win N number of organisms
	ArrayList<DNA> matingPool = new ArrayList<DNA>(); 	// Holds multiple instances of organisms based on how fit they are
	String target = "to be or not to be"; 				// Target String to Evolve
	float mutationRate = 0.01f; 						// 1% mutation rate
	int generations = 150;  							// number of generations to simulate
	boolean finished; 									// finished evolving?
	int perfectScore = 1;								// All characters match

	public GeneticSystem(){
		System.out.println("---- Genetic Algorithm Testing ----");

		// Initialize the populations
		init();

		// Run simulation
		for(int i = 0; i < generations; i++){

			if(!finished){

				runSystem(i);
			} else {
				System.out.println("DONE!");
				break;
			}
		}

	}

	public void init(){
		finished = false;

		for(int i = 0; i < population.length; i++){
			population[i] = new DNA();
		}

	}

	public void runSystem(int generation){
		// Calculate the Fitness and avg fitness
		for(int i = 0; i < population.length;i++){
			population[i].calcFitness(target);
		}
		float avg = getAverageFitness();

		String champ = getMostFit();
		
		// Create Mating Pool
		matingPool();

		// Reproduction
		reproduction();

		
		// Report
		System.out.println(generation + " | " + "Avg Fitness : "+ avg + " | " + champ);


	}

	public void matingPool(){
		matingPool.clear();

		for(int i = 0; i < population.length; i++){

			int n = (int)(population[i].fitness * 100);
			// For all members of the population, add the population member to the mating pool n many times.
			for(int j = 0; j < n; j++){
				matingPool.add(population[i]);
			}

		}
	}

	public void reproduction(){

		// Reproduce for all in mating pool
		for(int i = 0; i< population.length;i++){

			// Get Parents
			// Get two random indices in the mating pool
			int a = ThreadLocalRandom.current().nextInt(matingPool.size());
			int b = ThreadLocalRandom.current().nextInt(matingPool.size());

			// Get parents with indices
			DNA parentA = matingPool.get(a);
			DNA parentB = matingPool.get(b);

			// Crossover function defined in DNA object
			DNA child = parentA.crossover(parentB);

			// Mutate the genes randomly
			child.mutate(mutationRate);

			// Add the child to the current population
			population[i] = child;
		}

	}

	String getMostFit(){
		float worldRecord = 0;
		int index = 0;
		for(int i = 0; i < population.length; i++){
			if(population[i].fitness > worldRecord){
				index = i;
				
				worldRecord = population[i].fitness;
			}
		}

		// End simulation if perfect score
		if(worldRecord == perfectScore){
			finished = true;
		}

		// Returns the phrase of the best fit
		return population[index].getPhrase() + " | " + worldRecord;
	}

	// Compute average fitness for the population
	float getAverageFitness() {
		float total = 0;
		for (int i = 0; i < population.length; i++) {
			total += population[i].fitness;			
		}
	
		return total / population.length;
	}

}
