/*
 * @(#)CardNumberCompare.java $version 2014. 3. 28.
 *
 * Copyright 2007 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package study.jm.sort;

import java.util.Comparator;

import study.jm.model.Card;

/**
 * @author 안정민
 */
public class CardNumberCompare implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {
		return card1.getNumber().compareTo(card2.getNumber());
	}

}
