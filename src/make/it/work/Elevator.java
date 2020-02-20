package make.it.work;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Elevator {
  
  public int[] goElevatorGo(final int[][] queues, final int CAPACITY) {
    
    @SuppressWarnings("unused")
    final int LIFT_MAX_HEIGHT = queues.length;
    PriorityQueue<Integer> downWardsFlrToVisit = new PriorityQueue<Integer>(Comparator.reverseOrder());
    PriorityQueue<Integer> upWardsFlrToVisit = new PriorityQueue<Integer>();
    final int GROUND_FLOOR = 0;
    /***
     * start from ground location to upwards
     */
    List<Integer> liftTraversalOrder = new ArrayList<Integer>();
    
    Lift lift = new Lift(DIRECTION.UP, CAPACITY);
    //get the initial floor list to visit
    boolean onlyGoingDown = true;
    for(int currentflr = 0; currentflr < queues.length; currentflr++) {
      int[] pplsOnFlr = queues[currentflr];
      // flr has people to enter 
      if(pplsOnFlr.length > 0) {
        // this flr has to be visited
        upWardsFlrToVisit.offer(currentflr);
        //check if every person wants to go up only.
        onlyGoingDown = onlyGoingDown && isEveryOneWantsToGoDown(currentflr, pplsOnFlr);
      }
    }
    
    // start from ground floor if not already.
    if(!upWardsFlrToVisit.contains(GROUND_FLOOR)) {
      liftTraversalOrder.add(GROUND_FLOOR);
    }
    //check if every person wants to go up only.
    if(onlyGoingDown) {
      //visit from top floor to ground floor
      downWardsFlrToVisit.addAll(upWardsFlrToVisit);
      //set lift direction to down
      lift.setDirection(DIRECTION.DOWN);
      //clear initial floor list
      upWardsFlrToVisit.clear();
    }
    
    while(!lift.isEmpty() || !upWardsFlrToVisit.isEmpty() || !downWardsFlrToVisit.isEmpty()) {
      
      //remove the first entry ( which is floor to visit )
      Integer currentFlr = !upWardsFlrToVisit.isEmpty() ? upWardsFlrToVisit.remove() : downWardsFlrToVisit.remove();
      liftTraversalOrder.add(currentFlr);
      
      if(null != currentFlr && lift.getDirection() == DIRECTION.UP) {
        currentFlr = moveUpWards(queues, downWardsFlrToVisit, upWardsFlrToVisit, lift, currentFlr);
      }
      
      if(null != currentFlr && lift.getDirection() == DIRECTION.DOWN) {
        moveDownWards(queues, downWardsFlrToVisit, upWardsFlrToVisit, lift, currentFlr);
      }
    }
    
    //move back to ground floor is not already.
    if(liftTraversalOrder.get(liftTraversalOrder.size() - 1) != 0/*!onlyGoingDown && liftTraversalOrder.size() > 1*/) {
      liftTraversalOrder.add(0);
    }
    int[] traversalOrder = new int[liftTraversalOrder.size()];
    for(int i = 0; i < traversalOrder.length; i++) {
      traversalOrder[i] = liftTraversalOrder.get(i);
    }
    return traversalOrder;
  }
  
  /**
   * Move Lift downward direction while clearing out existing ppl's who want's to get down and new ppl's who want to get
   * in.
   * 
   * @param queues
   * @param downWardsFlrToVisit
   * @param upWardsFlrToVisit
   * @param lift
   * @param currentFlr
   */
  protected void moveDownWards(final int[][] queues, PriorityQueue<Integer> downWardsFlrToVisit,
                               PriorityQueue<Integer> upWardsFlrToVisit, Lift lift, Integer currentFlr) {
    //check if some one is getting out?
    clearWhoAlreadyReachedToDestination(lift, currentFlr);
    
    //check if some one is getting in?
    int[] pplsOnFlr = queues[currentFlr];
    
    // check if we have ppl
    if(pplsOnFlr.length > 0) {
      
      for(int i = 0; i < pplsOnFlr.length; i++) {
        int flrPersonWantToVisit = pplsOnFlr[i];
        
        //allow only person is going donw from current flr and lift is not full.
        if(flrPersonWantToVisit < currentFlr && !lift.isFull()) {
          Person person = new Person(currentFlr, flrPersonWantToVisit, DIRECTION.DOWN);
          //person boarded the lift.
          lift.in(person);
          // now this person is already get into the lift and no more present over the floor.
          pplsOnFlr[i] = 0;
          
          //add their floor to visit + taking care of duplicate floor 
          if(!downWardsFlrToVisit.contains(flrPersonWantToVisit)) {
            downWardsFlrToVisit.offer(flrPersonWantToVisit);
          }
        }
        // they will be either going to up or we have to return the same floor to pick them as lift was full.
        else {
          //add their floor to visit + taking care of duplicate floor 
          if(!upWardsFlrToVisit.contains(currentFlr)) {
            upWardsFlrToVisit.offer(currentFlr);
          }
        }
      }
      //Assuming we reached to top floor
      if(downWardsFlrToVisit.isEmpty() /*&& LIFT_MAX_HEIGHT*/) {
        lift.setDirection(DIRECTION.UP);
      }
    }
  }
  
  /**
   * Move Lift upward direction while clearing out existing ppl's who want's to get down and new ppl's who want to get
   * in.
   * 
   * @param queues
   * @param downWardsFlrToVisit
   * @param upWardsFlrToVisit
   * @param lift
   * @param currentFlr
   * @return
   */
  protected Integer moveUpWards(final int[][] queues, PriorityQueue<Integer> downWardsFlrToVisit,
                                PriorityQueue<Integer> upWardsFlrToVisit, Lift lift, Integer currentFlr) {
    //check if some one is getting out?
    clearWhoAlreadyReachedToDestination(lift, currentFlr);
    
    //check if some one is getting in?
    int[] pplsOnFlr = queues[currentFlr];
    // check if we have ppl
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
          if(!upWardsFlrToVisit.contains(flrPersonWantToVisit)) {
            upWardsFlrToVisit.offer(flrPersonWantToVisit);
          }
        }
        // they will be either going to down or we have to return the same floor to pick them as lift was full.
        else {
          //add their floor to visit + taking care of duplicate floor 
          if(!downWardsFlrToVisit.contains(currentFlr)) {
            downWardsFlrToVisit.offer(currentFlr);
          }
        }
      }
      //Assuming we reached to top floor
      if(upWardsFlrToVisit.isEmpty() && !downWardsFlrToVisit.isEmpty()) {
        lift.setDirection(DIRECTION.DOWN);
        //start reverse traversing when no more upward floor are available.
        currentFlr = downWardsFlrToVisit.remove();
      }
    }
    return currentFlr;
  }
  
  /**
   * Remove people from list who already reached to destination.
   * 
   * @param lift
   * @param currentFlr
   */
  protected void clearWhoAlreadyReachedToDestination(Lift lift, Integer currentFlr) {
    List<Person> listOfPeopleInsideLift = lift.listOfPeopleInsideLift();
    for(Iterator<Person> iterator = listOfPeopleInsideLift.iterator(); iterator.hasNext();) {
      Person person = iterator.next();
      if(person.outFloor() == currentFlr) {
        //remove this person from lift 
        iterator.remove();
      }
    }
  }
  
  /***
   * verify if every person on current floor want to go down only.
   * 
   * @param currentflr
   * @param pplsOnFlr
   * @return
   */
  protected boolean isEveryOneWantsToGoDown(int currentflr, int[] pplsOnFlr) {
    boolean status = false;
    for(int i = 0; i < pplsOnFlr.length; i++) {
      int flrPersonWantToVisit = pplsOnFlr[i];
      // just check if every one wants to go down.
      if(flrPersonWantToVisit < currentflr) {
        status = true;
      }
    }
    return status;
  }
  
  public static void main(String[] args) {
    System.out.println("Hello! Implement the solution and proof it with the unit tests.");
    new Elevator().goElevatorGo(null, 0);
  }
}
