package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends RuntimeException {
	private final int transazioni ;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TransactionsOverQuotaException(String s, int a) {
		super(s);
		this.transazioni = a;
	}
	
	public String toString() {
		return "TransactionsOverQuotaException [transazioni=" + transazioni + "]";
	}
	
	

}
