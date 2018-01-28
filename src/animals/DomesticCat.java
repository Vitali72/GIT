package animals;

import input.Input;
import interfaceZoo.Soundable;
import interfaceZoo.Jumpable;
import main.Main;

public class DomesticCat extends Feline {
    private int swarmSize;

    public DomesticCat(String nickName, double size) {
        super(nickName, size);
        this.type = "cat";
    }

    public static DomesticCat createCat() {
        System.out.println("Enter nickname of your cat..");
        String nickName = Main.sc.nextLine();
        double size = Input.inputNumber("Enter size of your cat..");
        return new DomesticCat(nickName, size);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow....");
    }

    @Override
    public double jump() {
        return (2 + 3 * getSize());
    }
}
