/** LatticeState.java
*
* LatticeState extends the abstract SearchState
* and implements goalP, getSuccessors and sameState
* 
* @author Daniel Whiteman
*
*/

import java.util.*;
public class LatticeState extends SearchState{
	//private instance field
	private WordH word;
	
	/**
	 * Constructor, Instantiates a LatticeState object
	 * @param w WordH object to store a word hypothesis
	 * @param c integer to store object to store the local cost of the state 
	 * @author Daniel Whiteman
	 */
	public LatticeState(WordH w, int c) {
		word = w;
		localCost = c;
	}
	
	/**
	 * toString method
	 * @author Daniel Whiteman
	 */
	public String toString(){
		return("Word: "+word+", Cost: "+localCost);
	}
	
	/**
	 * Accessor for word
	 * @return word word hypothesis
	 * @author Daniel Whiteman
	 */
	public WordH getWord(){return word;}
	
	/**
	 * Accessor for localCost
	 * @return localCost local cost
	 * @author Daniel Whiteman
	 */
	public int getCost(){return localCost;}
	
	/**
	 * Checking if the current state is in a goal state
	 * @param searcher instance of the current search being performed
	 * @return 		   boolean to indicate a goal state or not
	 * @author Daniel Whiteman
	 */
	public boolean goalP(Search searcher){
		//Casting the searcher to a LatticeSearch object
		LatticeSearch wSearcher = (LatticeSearch) searcher;
		return(word.getEnd() == wSearcher.getGoal());
	}
	
	/**
	 * Checking if two states are identical
	 * @param n2 SearchState object of the state we want to compare to
	 * @return   boolean to indicate same state or not
	 * @author Daniel Whiteman
	 */
	public boolean sameState(SearchState n2) {
		//Casting n2 to a LatticeState object
		LatticeState ls2 = (LatticeState) n2;
		//Checking each instance field to test for same state
		if(ls2.getWord().getWord() == this.word.getWord()) {
			
			if (ls2.getWord().getStart() == this.word.getStart()) {
				
				if (ls2.getWord().getEnd() == this.word.getEnd()) {
					
					if (ls2.getWord().getCost() == this.word.getCost()) {
						
						if (ls2.getCost() == this.getCost()) {
							//Return true if all tests are passed
							return true;
						}
					}
				}
			}
		}
		//Return false if all tests are passed
		return false;
	}
	
	/**
	 * Checking if two states are identical
	 * @param n2 SearchState object of the state we want to compare to
	 * @return   boolean to indicate same state or not
	 * @author Daniel Whiteman
	 */
	public ArrayList<SearchState> getSuccessors(Search searcher){
		//Casting searcher to a LatticeSearch object
		LatticeSearch wSearcher = (LatticeSearch) searcher;
		
		//Getting the word lattice
		WordLattice latt = wSearcher.getLatt();
		ArrayList<SearchState> slis = new ArrayList<SearchState>();
		//Getting all the words that start when the current node ends
		ArrayList<WordH> successors = latt.wordsAtT(word.getEnd());
		
		//For each word, create a lattice state object with the transition cost
		//and cast each one to a SearchState type before adding it to slis
		for(WordH wh: successors){
			int globalCost = wh.getCost() + 
			(wSearcher.getBg().getCost(this.word.getWord(), wh.getWord()));
			
			LatticeState succ = new LatticeState(wh, globalCost);
			slis.add((SearchState) succ);
		}
		return slis;
	}
}
















