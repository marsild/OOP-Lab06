package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends RuntimeException {

	private final int idinserito;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WrongAccountHolderException(String s, int id) {
		super(s);
		this.idinserito = id;
	}
	
	public String toString() {
		return "WrongAccountHolderException [id inserito=" + this.idinserito + "]";
	}
	
	
}
