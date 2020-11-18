package it.unibo.oop.lab.collections1;

import java.util.*;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int ELEMS = 100_000;
	private static final int READINGACTIONS = 1000;
	private static final int TO_MS = 1_000_000;

	private UseCollection() {
	}

	/**
	 * @param s unused
	 */
	public static void main(final String... s) {

		/*
		 * 1) Create a new ArrayList<Integer>, and populate it with the numbers from
		 * 1000 (included) to 2000 (excluded).
		 */

		List<Integer> lista = new ArrayList<>();
		for (int i = 1000; i < 2000; i++) {
			lista.add(i);
		}

		/*
		 * 2) Create a new LinkedList<Integer> and, in a single line of code without
		 * using any looping construct (for, while), populate it with the same contents
		 * of the list of point 1.
		 */

		List<Integer> secondalista = new LinkedList<>(lista);

		/*
		 * 3) Using "set" and "get" and "size" methods, swap the first and last element
		 * of the first list. You can not use any "magic number". (Suggestion: use a
		 * temporary variable)
		 */

		Integer temp = lista.set(lista.size() - 1, lista.get(0));
		lista.set(0, temp);

		/*
		 * 4) Using a single for-each, print the contents of the arraylist.
		 */

		for (Integer i : lista) {
			System.out.println(i);
		}

		/*
		 * 5) Measure the performance of inserting new elements in the head of the
		 * collection: measure the time required to add 100.000 elements as first
		 * element of the collection for both ArrayList and LinkedList, using the
		 * previous lists. In order to measure times, use as example
		 * TestPerformance.java.
		 */

		System.out.println("ADDING " + ELEMS + " ELEMS");
		long time = System.nanoTime();
		for (int i = 1; i <= ELEMS; i++) {
			lista.add(0, i);
		}

		time = System.nanoTime() - time;
		System.out.println("lista: It took " + time + "ns (" + time / TO_MS + "ms)");

		time = System.nanoTime();
		for (int i = 1; i <= ELEMS; i++) {
			secondalista.add(0, i);
		}

		time = System.nanoTime() - time;
		System.out.println("secondalista: It took " + time + "ns (" + time / TO_MS + "ms)");

		/*
		 * 6) Measure the performance of reading 1000 times an element whose position is
		 * in the middle of the collection for both ArrayList and LinkedList, using the
		 * collections of point 5. In order to measure times, use as example
		 * TestPerformance.java.
		 */

		System.out.println("READING " + READINGACTIONS + " TIMES A MIDDLE ELEMENT");
		time = System.nanoTime();
		for (int i = 1; i < READINGACTIONS; i++) {
			lista.get((Integer) lista.size() / 2);
		}

		time = System.nanoTime() - time;
		System.out.println("lista: It took " + time + "ns (" + time / TO_MS + "ms)");

		time = System.nanoTime();
		for (int i = 1; i < READINGACTIONS; i++) {
			secondalista.get((Integer) secondalista.size() / 2);
		}

		time = System.nanoTime() - time;
		System.out.println("secondalista: It took " + time + "ns (" + time / TO_MS + "ms)");

		/*
		 * 7) Build a new Map that associates to each continent's name its population:
		 * 
		 * Africa -> 1,110,635,000
		 * 
		 * Americas -> 972,005,000
		 * 
		 * Antarctica -> 0
		 * 
		 * Asia -> 4,298,723,000
		 * 
		 * Europe -> 742,452,000
		 * 
		 * Oceania -> 38,304,000
		 */

		Map<String, Long> continents = new HashMap<>();
		continents.put("Africa", 1110635000L);
		continents.put("Americas", 972005000L);
		continents.put("Antarctica", 0L);
		continents.put("Asia", 4298723000L);
		continents.put("Europe", 742452000L);
		continents.put("Oceania", 38304000L);

		/*
		 * 8) Compute the population of the world
		 */

		long popolazionetotale = 0;

		for (Long popcontinente : continents.values()) {
			popolazionetotale += popcontinente;
		}

		System.out.println("Population of the world: " + popolazionetotale);
	}
}
