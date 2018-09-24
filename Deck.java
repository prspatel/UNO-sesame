import java.util.ArrayList;
import java.util.*;
public class Deck {
	 ArrayList<Card> cards = new ArrayList<Card>();
	 ArrayList<Card> temp = new ArrayList<Card>();
	 

	    String[] values = {"1","2","3","4","5","6","7"};
	    String[] suit = {"red", "yellow", "blue", "green"};

	  //  static boolean firstThread = true;
	    public Deck(){
	        for (int i = 0; i<suit.length; i++) {
	            for(int j=0; j<values.length; j++){
	                this.cards.add(new Card(suit[i],values[j]));
	            }
	        }
	       Card ernieBr= new Card("red","Ernie & Bert");
	       Card ernieBg= new Card("green","Ernie & Bert");
	       Card OscarB= new Card("blue","Oscar the Crouch");
	       Card OscarY= new Card("yellow","Oscar the Crouch");
	       Card wild= new Card("wild","wild");

	       this.cards.add(ernieBr);
	       this.cards.add(ernieBg);
	       this.cards.add(OscarB);
	       this.cards.add(OscarY);
	       for(int i=0; i<4;i++)
	       {
	    	   this.cards.add(wild);
	       }
	       shuffle();
	        
	        
	        
	        //shuffle the deck when its created
	      // Collections.shuffle(this.cards);

	    }
	    public void shuffle()
	    {

		       Collections.shuffle(this.cards);
	    }
	    public ArrayList<Card> getDeck(){
	        return cards;
	    }
	    public Card getCard()
	    {
	    	Card f =new Card();
	    	f= cards.get(0);
	    	temp.add(f);
	    	cards.remove(0);
	    	return f;
	    }
	    public void fullDeck()
	    {
	    	for(int i=0;i<temp.size();i++)
	    	{
	    		cards.add(temp.get(i));
	    	}
	    	
	    }
	 

	 /*  public static void main(String[] args){
	    	Deck deck = new Deck();

	        //print out the deck.
	       // System.out.println(deck.getDeck());
	        //deck=new Deck();
	        System.out.println("\n\n\n"+deck.getDeck());
	        System.out.println("\n"+deck.getCard());
	        System.out.println("\n\n\n"+deck.getDeck());
	        System.out.println("\n\n\n"+deck.fullDeck());
	    }*/

}
