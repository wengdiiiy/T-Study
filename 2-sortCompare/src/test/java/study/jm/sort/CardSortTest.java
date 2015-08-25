/*
 * @(#)CardSortTest.java $version 2014. 3. 28.
 * 
 */

package study.jm.sort;

import org.junit.Test;

import study.jm.model.Card;

/**
 * @author 안정민
 */
public class CardSortTest {
	Card[] cards = CardFactory.newFactory().getCards();
	CardSort sort = new CardSort();

	@Test
	public void merge_정렬을_수행하였을때_안정적으로_정렬이된다() throws Exception {
		for (Card card : cards) {
			System.out.println(card.getShape() + "," + card.getNumber());
		}
		System.out.println("===================");

		Card[] sortCards = sort.mergeSort(cards, 0, cards.length - 1);

		for (Card card : sortCards) {
			System.out.println(card.getShape() + "," + card.getNumber());
		}

	}

	@Test
	public void quick_정렬을_수행하였을때_불안정적으로_정렬이된다() throws Exception {
		for (Card card : cards) {
			System.out.println(card.getShape() + "," + card.getNumber());
		}
		System.out.println("===================");

		Card[] sortCards = sort.quicksort(cards, 0, cards.length - 1);

		for (Card card : sortCards) {
			System.out.println(card.getShape() + "," + card.getNumber());
		}
	}

}
