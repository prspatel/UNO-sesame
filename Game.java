import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	public static void main(String args[]) throws Exception
	{
		ArrayList<Card> player1 = new ArrayList<>();
		ArrayList<Card> computer = new ArrayList<>();
		ArrayList<Card> discard = new ArrayList<>();

		Deck k = new Deck();
		Scanner input= new Scanner(System.in);
		//player1.add(k.getCard());
		//computer.add(k.getCard());
		boolean j = false;
		while(j==false)		
		{
			player1.add(k.getCard());
			computer.add(k.getCard());
			try
			{
				if(Integer.parseInt(player1.get(0).getValue())%1==0 && Integer.parseInt(computer.get(0).getValue())%1==0)
				{
					if(Integer.parseInt(player1.get(0).getValue()) == Integer.parseInt(computer.get(0).getValue()))
					{
						player1.remove(0);
						computer.remove(0);
						continue;
					}
					j=true;
				}
				if(Integer.parseInt(player1.get(0).getValue()) == Integer.parseInt(computer.get(0).getValue()))
				{
					player1.remove(0);
					computer.remove(0);
					continue;
				}
			}
			catch(NumberFormatException e)
			{
				player1.remove(0);
				computer.remove(0);
				continue;
			}
		}
		System.out.println("PLayer1:"+player1+"\n");
		System.out.println("Computer:"+computer+"\n");
		boolean t= false;
		if(Integer.parseInt(player1.get(0).getValue())>Integer.parseInt(computer.get(0).getValue()))
		{
			t=true;
		}
		if(t==true)
		{
			System.out.print("Player 1 goes first\n");
		}
		else
		{
			System.out.print("Computer goes first\n");
		}
		player1.remove(0);
		computer.remove(0);
		k.fullDeck();
		k.shuffle();
		
		//System.out.println(k.getDeck());
		for(int i=0;i<5;i++)
		{
			player1.add(k.getCard());
			computer.add(k.getCard());
			
		}
		//System.out.println(player1);
		//System.out.println(computer);
		//System.out.println(k.getDeck());
		boolean c= false;
		while(c==false)
		{
			discard.add(k.getCard());
			if(discard.get(0).getValue().equals("Oscar the Crouch")||discard.get(0).getValue().equals("wild")||discard.get(0).getValue().equals("Ernie & Bert"))
			{
				discard.remove(0);
			
			}
			else
			{
				c=true;
			}
		}
		//System.out.println("Discard pile:"+discard.get(discard.size()-1));
		while(!player1.isEmpty()||!computer.isEmpty())
		{
			if(k.getDeck().size()==0)
			{
				System.out.println("making new Deck");
				Card l= discard.get(discard.size()-1);
				k=new Deck();
				discard= new ArrayList<>();
				discard.add(l);
			}
			System.out.println("Player:"+player1+"\n");
			System.out.println("Computer :"+computer+"\n");

			while(t==false)//computer code
			{
				
				System.out.println("Discard pile"+discard.get(discard.size()-1)+"\n");
				boolean f=true;
				for(int i=0;i<computer.size();i++)
				{
					if(computer.get(i).getSuit().equals(discard.get(discard.size()-1).getSuit()))//checks the color
					{
						if(computer.get(i).getValue().equals("Ernie & Bert"))
						{
							discard.add(computer.get(i));
							player1.add(k.getCard());
							computer.remove(i);
							t=false;
							f=false;
							break;
						}
						else if(computer.get(i).getValue().equals("Oscar the Crouch"))
						{
							discard.add(computer.get(i));
							player1.add(k.getCard());
							player1.add(k.getCard());
							computer.remove(i);
							t=false;
							f=false;
							break;
						}
						else
						{
							discard.add(computer.get(i));
							computer.remove(i);
							t=true;
							f=false;
							break;
						}
					}
					else if(computer.get(i).getValue().equals(discard.get(discard.size()-1).getValue()))//checks value
					{
						discard.add(computer.get(i));
						computer.remove(i);
						t=true;
						f=false;
						break;
					}	
					
					
				}
				if(f==true)
				{
					
						boolean d=false;
					
						for(int i=0;i<computer.size();i++)
						{
							if(computer.get(i).getSuit().equals("wild"))//cheks wild
							{
								discard.add(computer.get(i));
								computer.remove(i);
								for(int x=0;x<computer.size();x++)
								{
									if(computer.get(x).getValue().equals("wild"))
									{
										continue;
									}
									else
									{
										discard.add(computer.get(x));
										
										computer.remove(x);
										d=true;
										t=true;
										f=false;
										break;
									}
								}
								break;
							}
						}
					if(d==false)
					{
						System.out.println("Computer Withdrawing a card");
						computer.add(k.getCard());
						t=true;
						break;
					}
					
				}
				if(computer.size()==2)
				{
					System.out.println("computer: UNO");
				}
				if(computer.isEmpty())
				{
					System.out.println("Computer wins:) Better luck next time");
					System.exit(0);
				}
					
			}
			while(t==true)//player
			{
				
				System.out.println("Discard pile:"+discard.get(discard.size()-1));
				//boolean p= true;
				System.out.println("1.throw a card.\n2.draw a card.\n3. Say Uno");
				boolean z=false;
				int l= input.nextInt();
				if(l==1)
				{
					System.out.println(player1);
					input.nextLine();
					System.out.println("Enter the card suit.\n");
					String suit = input.nextLine();
					System.out.println("Enter the card Value.\n");
					String value= input.nextLine();
					Card g= new Card(suit,value);
					System.out.println(g);
					for(int i=0;i<player1.size();i++)
					{
						if(player1.get(i).equals(g))
						{
							if(g.getValue().equals("Ernie & Bert")&& g.getSuit().equals(discard.get(discard.size()-1).getSuit()))
							{
								discard.add(player1.get(i));
								computer.add(k.getCard());
								player1.remove(i);
								t=true;
								//p=false;
								break;
							}
							else if(g.getValue().equals("Oscar the Crouch")&& g.getSuit().equals(discard.get(discard.size()-1).getSuit()))
							{
								discard.add(player1.get(i));
								computer.add(k.getCard());
								computer.add(k.getCard());
								player1.remove(i);
								t=true;
								//p=false;
								break;
							}
							else if(g.getValue().equals("wild"))//cheks wild
							{
								boolean f=false;
								do
								{
									discard.add(player1.get(i));
									player1.remove(i);
									input.nextLine();
									System.out.println("Which card on Wild\n");
									System.out.println("Enter Suit:");
									String suitw = input.nextLine();
									System.out.println("Enter Value:");
									String valuew = input.nextLine();
									Card over = new Card(suitw,valuew);
									for(int x=0;x<player1.size();x++)
									{
										if(player1.get(x).equals(over))
										{
											discard.add(player1.get(x));
											player1.remove(x);
											f=true;
											t=false;
											break;
										}
									}
								}
								while(f==false);								
							}
							else
							{
								discard.add(player1.get(i));
								player1.remove(i);
								t=false;
								break;
							}
						}
						
						
					}
			
				}
				else if(l==2)
				{
					player1.add(k.getCard());
					t= false;
				}
				else if(l==3)
				{
					if(player1.size()==2)
					{
						System.out.print("UNO");
						z=true;
					}
					else
					{
						System.out.println("more than 2 cards are left. U r penalised by 2 cards");
						player1.add(k.getCard());
						player1.add(k.getCard());
					}
				}
				
				else
				{
					System.out.println("Wrong input\n");
				}
				if(player1.size()==1&&z==false)
				{
					System.out.println("U didnt say UNO. Adding 2 carrds");
					player1.add(k.getCard());
					player1.add(k.getCard());
				}
				if(player1.isEmpty())
				{
					System.out.println("You win!!!!!");
					System.exit(0);
				}
			}
		}
		
	}

}
