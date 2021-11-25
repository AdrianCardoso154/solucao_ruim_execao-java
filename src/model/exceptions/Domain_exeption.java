package model.exceptions;

//runtimeException o compilador não obriga a tratar
//Exception e obrigado a tratar(tipo o parse)
public class Domain_exeption extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public Domain_exeption (String msg) {
		super(msg);
	}
}
