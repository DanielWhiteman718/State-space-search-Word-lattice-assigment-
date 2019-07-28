/** LatticeSearch.java
 * 
 *LatticeSearch extends the abstract class Search
 *
 *@author Daniel Whiteman
 */


import java.util.*;
public class LatticeSearch extends Search {
	
	//Private instance fields
	private WordLattice latt;
	private LM bg;
	
	/**
	 * Constructor, Instantiates a LatticeSearch object
	 * @param latt WordLattice object to stores the word lattice
	 * @param bg LM object to store the language model
	 * @author Daniel Whiteman
	 */
	public LatticeSearch(WordLattice latt, LM bg){
		this.latt = latt;
		this.bg = bg;
	}
	
	/**
	 * Accessor for latt 
	 * @return latt word lattice
	 * @author Daniel Whiteman
	 */
	public WordLattice getLatt(){
		return latt;
	}
	
	/**
	 * Accessor for bg
	 * @return bg language model
	 * @author Daniel Whiteman
	 */
	public LM getBg() {
		return bg;
	}
	
	/**
	 * Finds the goal
	 * @return goal end time of the word lattice
	 * @author Daniel Whiteman
	 */
	public int getGoal() {
		int goal = getLatt().getEndTime();
		return(goal);
	}
	
	/**
	 * toString method
	 * @author Daniel Whiteman
	 */
	public String toString(){
		return("WordLattice: "+latt+"### LM: "+bg);
	}
}