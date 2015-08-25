/*
 * @(#)Card.java $version 2014. 3. 28.
 *
 */
package study.jm.model;

/**
 * @author 안정민
 */
public class Card implements Comparable<Card> {
	private Shape shape;
	private Integer number;

	public Card(Shape shape, Integer number) {
		this.shape = shape;
		this.number = number;
	}

	public Shape getShape() {
		return shape;
	}

	public Integer getNumber() {
		return number;
	}

	@Override
	public int compareTo(Card card) {
		return number.compareTo(card.getNumber());
	}
}