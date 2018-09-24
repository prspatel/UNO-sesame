public class Card 
{
	private String suit;
    private String value;


    public Card(String suit, String value){
        this.suit = suit;
        this.value = value;
    }
    public Card(){}
    public String getSuit(){
        return suit;
    }
    public void setSuit(String suit){
        this.suit = suit;
    }
    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    public boolean equals(Card j)
    {
    	if(this.getSuit().equals(j.getSuit())&&this.getValue().equals(j.getValue()))
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }

    public String toString(){
        return "\n"+value + " of "+ suit;
    }
	/*public UnoCard()
	{
		Random rand = new Random();

		switch(rand.nextInt(10))
		{
			case 0: cardName = "Big Bird"; 
				break;
			case 1: cardName = "Zoe"; 
				break;
			case 2: cardName = "Cookie Monster"; 
    			break;
			case 3: cardName = "Elmo "; 
    			break;
			case 4: cardName = "Baby Bear"; 
				break;
			case 5: cardName = "Rosita"; 
				break;
			case 6: cardName = "Grover"; 
				break;
			case 7: cardName = "Ernie and Bert"; 
				break;
			case 8: cardName = "Oscar the Grouch "; 
				break;
			case 9: cardName = "Monster"; 
				break;
				
		}
		if(cardName.equals("Monster"))
		{
			color= "black";

		}
		if(cardName.equals("Ernie and Bert"))
		{
			switch(rand.nextInt(2))
			{
				case 0: color = "Red"; 
					break;
				case 1: color = "Blue"; 
					break;
			}

		}
		else if(cardName.equals("Ernie and Bert"))
		{
			switch(rand.nextInt(2))
			{
				case 0: color = "Green"; 
					break;
				case 1: color = "Yellow"; 
					break;
			}

		}
		
		else
		{
			switch(rand.nextInt(4))
	
			{
				case 0: color = "Red"; 
					break;
				case 1: color = "Green"; 
            		break;
				case 2: color = "Blue"; 
	        		break;
				case 3: color = "Yellow"; 
	        		break;
	        }
		}
	}
	public boolean equals(Object k)
	{
		
	}*/
	

}
