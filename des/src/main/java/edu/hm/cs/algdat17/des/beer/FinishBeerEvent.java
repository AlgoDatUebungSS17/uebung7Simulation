package edu.hm.cs.algdat17.des.beer;

import edu.hm.cs.algdat17.des.generic.AbstractSimulator;
import edu.hm.cs.algdat17.des.generic.TimedEvent;

public class FinishBeerEvent extends TimedEvent<Pub> {

	public FinishBeerEvent(double time) {
		super(time);
	}

	@Override
	protected void execute(AbstractSimulator<Pub> simulator, Pub pub) {

		pub.finishBeer(getTime());

		simulator.insert(new FinishBeerEvent(getTime() + 60 * 7));

	}
} 