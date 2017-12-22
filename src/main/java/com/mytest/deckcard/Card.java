package com.mytest.deckcard;

public class Card
{
  public enum Suit
  { Club, Diamond, Heart, Spade };
  
  public enum Rank
  { 
    Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);

    private final int rank;
    
    private Rank (int rank)
    { this.rank = rank; }

    public int getRank()
    { return rank;  }
  };
  
  private Suit suit;
  private Rank rank;
  
  public Card(Suit s, Rank r)
  {
    this.suit = s;
    this.rank = r;
  }
  
  public Suit getSuit()
  { return suit;  }
  
  public Rank getRank()
  { return rank;  }
}
