package wendy.practice;

import java.util.Comparator;

public class AscCompare implements Comparator<Element> {
	@Override
	public int compare(Element e1, Element e2) {
		return e1.getName().compareTo(e2.getName());
	}
}
