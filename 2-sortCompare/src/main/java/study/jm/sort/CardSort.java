/*
 * @(#)CardSort.java $version 2014. 3. 28.
 *
 */

package study.jm.sort;

import study.jm.model.Card;

/**
 * @author 안정민
 */
public class CardSort {

	public Card[] mergeSort(Card[] cards, int start, int end) {

		int median = (start + end) / 2;

		if (start < end) {
			mergeSort(cards, start, median);
			mergeSort(cards, median + 1, end);
			merge(cards, start, median, end);
		}

		return cards;
	}

	private void merge(Card[] cards, int start, int median, int end) {
		int i, j, k, m, n;
		int length = cards.length;

		Card[] tempArr = new Card[length];
		i = start;
		j = median + 1;
		k = start;

		while (i <= median && j <= end) {
			if (cards[i].getNumber() > cards[j].getNumber()) {
				tempArr[k++] = cards[j++];
			} else {
				tempArr[k++] = cards[i++];
			}
		}

		m = (i > median) ? j : i;
		n = (i > median) ? end : median;

		for (; m <= n; m++) {
			tempArr[k++] = cards[m];
		}

		for (m = start; m <= end; m++) {
			cards[m] = tempArr[m];
		}
	}

	public Card[] quicksort(Card[] cards, int left, int right) {
		if (right <= left)
			return cards;
		int i = partition(cards, left, right);
		quicksort(cards, left, i - 1);
		quicksort(cards, i + 1, right);

		return cards;
	}

	private int partition(Card[] cards, int left, int right) {
		int i = left - 1;
		int j = right;
		while (true) {
			while (less(cards[++i], cards[right]))
				;
			while (less(cards[right], cards[--j]))
				if (j == left)
					break;
			if (i >= j)
				break;
			exch(cards, i, j);
		}
		exch(cards, i, right);
		return i;
	}

	private boolean less(Card card1, Card card2) {
		return (card1.getNumber() < card2.getNumber());
	}

	private void exch(Card[] cards, int i, int j) {
		Card swap = cards[i];
		cards[i] = cards[j];
		cards[j] = swap;
	}
}
