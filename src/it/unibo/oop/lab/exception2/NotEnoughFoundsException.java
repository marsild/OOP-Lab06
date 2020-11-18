package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends RuntimeException {
	
	private final double balance ;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughFoundsException(String s, double balance) {
		super(s);
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "NotEnoughFoundsException [balance=" + this.balance + "]";
	}

	
}
