package edu.hm.cs.algdat17.des.beer;


import edu.hm.cs.algdat17.des.generic.AbstractSimulator;
import edu.hm.cs.algdat17.des.generic.TimedEvent;

public class OrderBeerEvent  extends TimedEvent<Pub> {

	
	public OrderBeerEvent(double time) {
		super(time);	
	}

	@Override
	protected void execute(AbstractSimulator<Pub> simulator, Pub pub) {
		
		pub.orderBeer(getTime());
		
		simulator.insert(new OrderBeerEvent(getTime()+360 + simulator.getRandom().nextInt(240)));
	}
	
}
