/*
 * @(#)CardFactory.java $version 2014. 3. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.jm.sort;

import static study.jm.model.Shape.*;

import java.util.ArrayList;
import java.util.List;

import study.jm.model.Card;

/**
 * @author 안정민
 */
public class CardFactory {

	private static CardFactory factory = new CardFactory();

	public static CardFactory newFactory() {
		return factory;
	}

	private List<Card> cards = new ArrayList<Card>();

	CardFactory() {
		cards.add(new Card(SPADE, 4));
		cards.add(new Card(CLUB, 1));
		cards.add(new Card(HEART, 2));
		cards.add(new Card(DIAMOND, 1));
		cards.add(new Card(SPADE, 2));
		cards.add(new Card(DIAMOND, 4));

	}

	public Card[] getCards() {
		return cards.toArray(new Card[0]);
	}
}
