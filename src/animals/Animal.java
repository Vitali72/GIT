package animals;

import error.AnimalCreationException;
import interfaceZoo.Jumpable;
import interfaceZoo.Soundable;

public class Animal extends Object implements Soundable, Jumpable {
	private String nickName;
	private double size;
	public String type;
	private double fill;
	private long lastFeedTime;
	private boolean isAlive;
	private IAnimalDeadListener animalDeadListener;

	public Animal(String nickName, double size) {
		this.nickName = nickName;
		this.size = size;
		fill = 1000;
		lastFeedTime = System.currentTimeMillis();
		isAlive = true;

	}

	public void setAnimalDeadListener(IAnimalDeadListener animalDeadListener) {
		this.animalDeadListener = animalDeadListener;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setAlive(boolean alive) {
		if (getFill() >= 0) {
			isAlive = false;
		} else {
			isAlive = true;
		}
	}

	public void setType(String type) {
		this.type = type;
	}

	protected void die() {
		if (animalDeadListener != null && isAlive) {

			animalDeadListener.onAnimalDead(this);
			System.out.println("animal " + this.getNickName() + " is dead");
		}
		isAlive = false;
	}

	public double getFill() {
		long timeToDeath = (System.currentTimeMillis() - lastFeedTime) / 1000;
		fill = fill - timeToDeath / 4;
		if (timeToDeath >= fill) {

			die();
		}
		return fill;
	}

	public void setFill(double fill) {
		this.fill = this.fill + fill;
		lastFeedTime = System.currentTimeMillis();
	}

	public long getLastFeedTime() {
		return lastFeedTime;
	}

	public void setLastFeedTime(long lastFeedTime) {
		this.lastFeedTime = lastFeedTime;
	}

	public void feed(double countOfFood) {
		setFill(getFill() + countOfFood);

	}

	public static Animal converFromString(String str) throws AnimalCreationException {
		String[] arrStr = str.split(",");
		switch (arrStr[0]) {
		case "wolf":
			return new ForestWolf(arrStr[1], Double.parseDouble(arrStr[2]));
		case "cat":
			return new DomesticCat(arrStr[1], Double.parseDouble(arrStr[2]));
		case "rabbit":
			return new Rabbit(arrStr[1], Double.parseDouble(arrStr[2]));
		case "raven":
			return new Raven(arrStr[1], Double.parseDouble(arrStr[2]));
		}
		throw new AnimalCreationException();
	}

	@Override
	public String toString() {

		return "Animal " + getNickName() + " Size " + getSize() + " Type " + getType();
	}

	@Override
	public void makeSound() {

	}

	@Override
	public double jump() {

		return size * 2.3;
	}

	public void sound() {
		// TODO Auto-generated method stub

	}

	public interface IAnimalDeadListener {
		void onAnimalDead(Animal animal);
	}
}
