package animals;

import input.Input;
import interfaceZoo.Soundable;
import main.Main;

public class Raven extends Bird implements Soundable {

	public Raven(String nickName, double size) {
		super(nickName, size);
		setType("Raven");
	}
	 public static Raven createRaven() {
	        System.out.println("Enter nickname of your rabbit..");
	        String nickName = Main.sc.nextLine();
	        double size = Input.inputNumber("Enter size of your rabbit..");
	        return new Raven(nickName, size);
	    }
	@Override
	public void makeSound() {

		System.out.println("Karr");
	}

}
