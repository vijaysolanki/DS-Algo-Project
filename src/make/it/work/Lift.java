package make.it.work;

import java.util.ArrayList;
import java.util.List;

public class Lift {
  
  DIRECTION    direction    = null;
  int          capacity     = 0;
  List<Person> personInLift = new ArrayList<>();
  //Ground floor
  int          currentFlr   = 0;
  int          toFlr        = 0;
  
  public Lift() {
  }
  
  public Lift(DIRECTION lftdirection, int liftCapacity) {
    this.direction = lftdirection;
    this.capacity = liftCapacity;
  }
  
  public boolean isFull() {
    return personInLift.size() >= capacity;
  }
  
  public void in(Person person) {
    personInLift.add(person);
  }
  
  public boolean out(Person person) {
    return personInLift.remove(person);
  }
  
  public List<Person> listOfPeopleInsideLift() {
    return personInLift;
  }
  
  public void moveUp() {
    currentFlr++;
  }
  
  public void moveDown() {
    currentFlr--;
  }
  
  public int getCurrentFloor() {
    return currentFlr;
  }
  
  public void setFloorToVisit(int flr) {
    currentFlr = flr;
  }
  
  public DIRECTION getDirection() {
    return direction;
  }
  
  public void setDirection(DIRECTION directionToTravel) {
    this.direction = directionToTravel;
  }
  
  public boolean isEmpty() {
    return personInLift.isEmpty();
  }
}
