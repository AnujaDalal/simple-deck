package com.mytest.deckcard;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import javax.naming.OperationNotSupportedException;

import org.junit.Before;
import org.junit.Test;


public class DeckTest
{
  Deck deck;
  
  @Before
  public void setUp()
  {
    deck = new Deck();
    deck.shuffle(); 
  }
  
  @Test  
  public void testDeal_success()
  {    
    try
    {
      Card card = deck.deal();      
      assertThat(card, is(notNullValue()));
      assertThat(deck.size(), is(equalTo(51)));
      
      Card[] cards = deck.deal(10);
      assertThat(cards.length, is(equalTo(10)));
      assertThat(deck.size(), is(equalTo(41))); // (52 - 11)
    }
    catch (OperationNotSupportedException e)
    {
      fail("Card is not received." + e.getMessage());
    }    
  }
  
  @Test(expected=OperationNotSupportedException.class)
  public void testDeal_fail() throws OperationNotSupportedException
  { 
    deck.deal(52);
    assertThat(deck.size(), is(equalTo(0)));
    deck.deal();
    assertThat(deck.size(), is(equalTo(0)));
  }  
}
