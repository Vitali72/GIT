package main;
import animals.Animal;
public class SingleCage<T extends Animal> {
   private T habitant;

public T getHabitant() {
	return habitant;
}

public void setHabitant(T habitant) {
	this.habitant = habitant;
}
   public void myMethod() {
	   
	   T test;
   }
}
