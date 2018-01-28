package animals;

import input.Input;
import main.Main;

public class ForestWolf extends Canine {

    public ForestWolf(String nickName, double size) {
        super(nickName, size);
        this.type = "wolf";
    }

    public static ForestWolf createWolf() {
        System.out.println("Enter nickname of your wolf..");
        String nickName = Main.sc.nextLine();
        double size = Input.inputNumber("Enter size of your wolf..");
        return new ForestWolf(nickName, size);

    }

    @Override
    public void makeSound() {
        System.out.println("Rrrrrr!!!!!");
    }

    @Override
    public double jump() {
        return super.jump();
    }
}
