package it.unibo.oop.lab06.generics1;

import java.util.*;

public class GraphImpl<N> implements Graph<N> {

	private Map<N, Set<N>> grafo;

	public GraphImpl() {
		this.grafo = new HashMap<N, Set<N>>();
	}

	public void addNode(N node) {
		if (node != null || !this.grafo.containsKey(node)) {
			this.grafo.put(node, new HashSet<N>());
		}
	}

	public void addEdge(N source, N target) {
		if (source != null && target != null) {
			this.grafo.get(source).add(target);
		}
	}

	public Set<N> nodeSet() {
		return this.grafo.keySet();
	}

	public Set<N> linkedNodes(N node) {
		return this.grafo.get(node);
	}

	public List<N> getPath(N source, N target) {
		return null;
	}

}

