package wendy.practice;

import java.util.Comparator;

public class DescCompare implements Comparator<Element> {
	@Override
	public int compare(Element e1, Element e2) {
		return e2.getName().compareTo(e1.getName());
	}
}
