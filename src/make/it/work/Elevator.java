package make.it.work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

enum DIRECTION {
  UP, DOWN;
}


class Person {

  int       inFlr     = -1;
  int       outFlr    = -1;
  DIRECTION direction = null;
  
  Person(int start, int end, DIRECTION currentDirection) {
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


class Lift {

  DIRECTION direction = null;
  int       capacity  = 0;
  List<Person> personInLift = new ArrayList<>();
  //Ground floor
  int          currentFlr      = 0;
  int          toFlr        = 0;
  
  public Lift() {
  }
  
  public Lift(DIRECTION lftdirection, int liftCapacity) {
    this.direction = lftdirection;
    this.capacity = liftCapacity;
  }
  
  public boolean isFull()
  {
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
  
  public int getCurrentFloor()
  {
    return currentFlr;
  }
  
  public void setFloorToVisit(int flr) {
    currentFlr = flr;
  }
  
  public DIRECTION getDirection()
  {
    return direction;
  }
  
  

  public boolean isEmpty() {
    return personInLift.isEmpty();
  }
}


public class Elevator {

  
  
  public static int[] goElevatorGo(final int[][] queues, final int CAPACITY) {
    int bldHeight = 0;//sort the arrays and fine max
    //    PriorityQueue<Integer> upWardsFlrToVisit = new PriorityQueue<Integer>();
    PriorityQueue<Integer> downWardsFlrToVisit = new PriorityQueue<Integer>(Comparator.reverseOrder());
    PriorityQueue<Integer> initialFlrToVisit = new PriorityQueue<Integer>();
    
    List<Integer> liftTraversalOrder = new ArrayList<Integer>();

    /***
     * start from ground location to upwards
     */
    Lift lift = new Lift(DIRECTION.UP, CAPACITY);
    //get the initial floor list to visit
    int initialFlr = 0;
    for(int flr = 0; flr < queues.length; flr++) {
      int[] pplsOnFlr = queues[flr];
      // flr has people to enter 
      if(pplsOnFlr.length > 0) {
        // this flr has to be visited
        initialFlrToVisit.offer(flr);
      }
    }
    

    while(!lift.isEmpty() || !initialFlrToVisit.isEmpty() || !downWardsFlrToVisit.isEmpty()) {
      //remove the first entry ( which is first flow to visit )
      
      Integer currentFlr = initialFlrToVisit.remove();
      
      if(null != currentFlr && lift.getDirection() == DIRECTION.UP) {

        //check if some one is getting out?
        List<Person> listOfPeopleInsideLift = lift.listOfPeopleInsideLift();
        for(Iterator<Person> iterator = listOfPeopleInsideLift.iterator(); iterator.hasNext();) {
          Person person = iterator.next();
          if(person.outFloor() == currentFlr) {
            //remove this person from lift 
            //            iterator.remove();
            lift.out(person);
          }
        }
        
        //check if some one is getting in?
        int[] pplsOnFlr = queues[currentFlr];
        // check if we have ppls
        if(pplsOnFlr.length > 0) {

          for(int i = 0; i < pplsOnFlr.length; i++) {
            int flrPersonWantToVisit = pplsOnFlr[i];
            
            //allow only person is going up from current flr and lift is not full.
            if(flrPersonWantToVisit > currentFlr && !lift.isFull()) {
              Person person = new Person(currentFlr, flrPersonWantToVisit, DIRECTION.UP);
              //person boarded the lift.
              lift.in(person);
              // now this person is already get into the lift and no more present over the floor.
              pplsOnFlr[i] = 0;
              
              //add their floor to visit + taking care of duplicate floor 
              if(!initialFlrToVisit.contains(flrPersonWantToVisit)) {
                initialFlrToVisit.offer(flrPersonWantToVisit);
              }
            }
            // they will be either going to down or we have to return the same floor to pick them as lift was full.
            else {
              //add their floor to visit + taking care of duplicate floor 
              if(!downWardsFlrToVisit.contains(flrPersonWantToVisit)) {
                downWardsFlrToVisit.offer(flrPersonWantToVisit);
              }
            }
          }
        }
      }
      else if(lift.getDirection() == DIRECTION.DOWN)
      {
        
      }
      
    }
    
    /*int groundFlr = 0;
    for(int flr = groundFlr; flr < queues.length; flr++) {
      int[] pplsOnFlr = queues[flr];
      // flr has people to enter 
      if(pplsOnFlr.length > 0) {
        // this flr has to be visited
        initialFlrToVisit.offer(flr);
        for(int index = 0; index < pplsOnFlr.length; index++)
        {
          int flrPersonWantToVisit = pplsOnFlr[index];
          Person person = new Person(flr, flrPersonWantToVisit, DIRECTION.UP);
          
          if(flrPersonWantToVisit < flr) {
            downWardsFlrToVisit.offer(flrPersonWantToVisit);
          }
          else if(flrPersonWantToVisit > flr) {
            upWardsFlrToVisit.offer(flrPersonWantToVisit);
          }
          else
          {
    
          }
        }
      }
    }*/
    
    return new int[0];
  }
  
  public static void main(String[] args) {
    System.out.println("Hello! Implement the solution and proof it with the unit tests.");
    goElevatorGo(null, 0);
  }
}
