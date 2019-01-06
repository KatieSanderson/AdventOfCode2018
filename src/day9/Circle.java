package day9;

import java.util.ArrayList;
import java.util.List;

public class Circle {

	private final List<Integer> list;

	public Circle() {
		this.list = new ArrayList<>();
	}

	public int get(int index) {
		index = (index + list.size()) % list.size();
		return list.get(index);
	}

	public void remove(int index) {
		index = (index + list.size()) % list.size();
		list.remove(index);
	}

	public int size() {
		return list.size();
	}

	public void add(int index, int value) {
		System.out.println("index: " + index + " listsize: " + list.size());
		if (list.isEmpty()) {
			list.add(value);
		} else {
			index = (index + list.size()) % list.size();
			if (index == 0) {
				list.add(value);
			} else {
				list.add(index, value);
			}
		}
	}

}
