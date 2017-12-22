package com.mytest.deckcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import com.mytest.deckcard.Card.Rank;
import com.mytest.deckcard.Card.Suit;

public class Deck
{
  private List<Card> deck = new ArrayList<Card>(52);
  private int cardPointer = 0;
  
  public Deck()
  {
    for (Suit s : Suit.values())
    {
      for (Rank r : Rank.values())
      {
        Card c = new Card(s, r);
        deck.add(c);
      }
    }
  }

  public void shuffle()
  {
    Collections.shuffle(deck);    
  }

  public Card deal() throws OperationNotSupportedException
  {
    if (cardPointer == deck.size())
    {
      throw new OperationNotSupportedException("All cards are removed.");
    }
    Card card =  deck.get(cardPointer);
    cardPointer++;
    return card;
  }
  
  public Card[] deal(int count) throws OperationNotSupportedException
  {
    if (count > (deck.size() - cardPointer))
    {
      throw new OperationNotSupportedException("Not sufficient cards. Remaining card count: " + (deck.size() - cardPointer));
    }
    Card[] cards = new Card[count];
    for (int i = 0 ; i < count; i ++)
    {
      cards[i] = deal();
    }
    return cards;
  }
  
  public int size()
  {
    return (deck.size() - cardPointer);
  }
  
  // Not a practical function but use it to compare cards those are remained in deck after dealing
  public void printDeck()
  {
    for (int i = cardPointer; i < deck.size(); i++)
    {
      Card c = deck.get(i);
      if (i == (deck.size() - 1))
      { System.out.print(c.getSuit() + "/" + c.getRank());  }
      else
      {
        System.out.print(c.getSuit() + "/" + c.getRank() + " --- ");
      }
    }
    System.out.println("");
  }

}
