import java.util.concurrent.Callable;

interface Bird {
    Egg lay();
}

class Chicken implements Bird{
    public Chicken() {
    }
    
    public Egg lay()
    {
    	Callable<Bird> chicken = new Callable<Bird>() {

			@Override
			public Bird call() throws Exception {
				return new Chicken();
			}
		};
        return new Egg(chicken);
    }

    public static void main(String[] args) throws Exception {
        Chicken chicken = new Chicken();
        System.out.println(chicken instanceof Bird);
    }
}

class Egg {
	Callable<Bird> bird ;
    boolean alreadyHatched;
    public Egg(Callable<Bird> createBird) {
    	this.bird = createBird;
        this.alreadyHatched = false;
//        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public Bird hatch() throws Exception {
    	if(null != bird && !alreadyHatched)
    	{
            alreadyHatched = true;
    		return bird.call();
    		
    	}
    	new Thread().join();
         throw new IllegalStateException("Egg's can't hatch twice");
    	
    }
}