package error;

import error.AnimalCreationException;;

public class AnimalInvalidSizeException extends AnimalCreationException {
	
	public AnimalInvalidSizeException() {
		
		super("Animal size is invalid");
	}

}
