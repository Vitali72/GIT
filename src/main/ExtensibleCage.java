package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import animals.Animal;
import animals.Herbivore;
import animals.Predator;

public class ExtensibleCage<T extends Animal> implements Animal.IAnimalDeadListener {
	List<T> cage = new LinkedList<>();

	public int addAnimal(T ani) {
		cage.add(ani);
		ani.setAnimalDeadListener(this);
		if (cage.get(0) instanceof Predator) {
			checkHuntCondition(ani);
		}
		return cage.size();
	}

	public boolean removeAnimal(int index) {
		if (index < 0 || index >= cage.size()) {
			return false;
		} else {
			cage.remove(index);
			return true;
		}

	}

	public List<T> getCage() {

		return cage;
	}

	@Override
	public void onAnimalDead(Animal animal) {

	}

	private void checkHuntCondition(Animal animal) {
		if (animal instanceof Herbivore) {
			for (T t : cage) {
				if (t instanceof Predator) {
					((Predator) t).consume((Herbivore) animal);
					return;
				}

			}
		} else if (animal instanceof Predator) {
			for (T t : cage) {
				if (t instanceof Herbivore) {
					((Predator) animal).consume((Herbivore) t);

				}
			}
		}

	}
}
