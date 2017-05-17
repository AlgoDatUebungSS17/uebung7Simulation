package edu.hm.cs.algdat17.des.demo;

import edu.hm.cs.algdat17.des.generic.AbstractSimulator;
import edu.hm.cs.algdat17.des.generic.TimedEvent;

/**
 * Event, das das Betreten des Raumes durch einen Kunden repräsentiert.
 * 
 * @author katz.bastian
 */
public class LeaveRoomEvent extends TimedEvent<Room> {

	public LeaveRoomEvent(double time) {
		super(time);
	}

	@Override
	protected void execute(AbstractSimulator<Room> simulator, Room world) {
		world.leave(getTime());
	}

}
