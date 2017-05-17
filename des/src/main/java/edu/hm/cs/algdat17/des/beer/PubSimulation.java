package edu.hm.cs.algdat17.des.beer;

import edu.hm.cs.algdat17.des.generic.Simulator;

public class PubSimulation {
	public static void main(String[] args) {
		
		// Erzeuge Zustandsobjekt
		Pub pub = new Pub();
		
		// Erzeuge Simulation mit Zeithorizont 3600 (Sekunden)
		Simulator<Pub> sim = new Simulator<Pub>(pub, 60*60*3);
		
		// Lege initiales Event (erster Kunden betritt den Raum) ab.
		sim.insert(new OrderBeerEvent(0.0));
		sim.insert(new FinishBeerEvent(7.0*60.0));
		//sim.insert(new FinishBeerEvent(7.0*60.0));
		
		// Lasse Simulation laufen
		while (sim.hasMoreEvents()) {
			sim.handleNextEvent();
		}
		
		// Werte Simulation aus.
		System.out.println("Durchschnittliche Wartezeit: "+pub.getAverageWaitTime());
		
	}
	
}
