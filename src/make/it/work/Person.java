package make.it.work;

public class Person {
  
  int       inFlr     = -1;
  int       outFlr    = -1;
  DIRECTION direction = null;
  
  public Person(int start, int end, DIRECTION currentDirection) {
    this.inFlr = start;
    this.outFlr = end;
    this.direction = currentDirection;
  }
  
  public int inFloor() {
    return inFlr;
  }
  
  public int outFloor() {
    return outFlr;
  }
  
  public DIRECTION getDirection() {
    return direction;
  }
  //dont implement hashcode as we want to relay on object reference then object values.
}
