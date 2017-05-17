package edu.hm.cs.algdat17.des.beer;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pub {
	private static final Logger LOG = LoggerFactory.getLogger(Pub.class);


	private int beerReady = 0;
	private int beersOrdered = 0;
	private ArrayList<Double> orderTimes  = new ArrayList<Double>();
	private double sumWaitTime = 0.0;
	private int ammountFinished =0;

	/**
	 * Erhöht die Anzahl der Personen im Raum um 1.
	 * 
	 * @param time
	 *            Zeitpunkt des Betretens
	 */
	public void orderBeer(double time) {
		beersOrdered++;
		LOG.info("{}s: Kunde bestellt ein Bier.", time);
		if(beerReady>0)
		{
			beerReady--;
			beersOrdered--;
			ammountFinished++;
		}
		else{
			orderTimes.add(time);
		}
	}

	/**
	 * Verringert die Anzahl der Personen im Raum um 1.
	 * 
	 * @param time
	 *            Zeitpunkt des Verlassens
	 */
	public void finishBeer(double time) {
		beerReady++;
		LOG.info("{}s:Bier wird fertig gestellt", time);
		if(beersOrdered>0)
		{
			beerReady--;
			beersOrdered--;
			sumWaitTime +=time-orderTimes.get(0);
			orderTimes.remove(0);
			ammountFinished++;
		}
	}
	
	public double getAverageWaitTime()
	{
		return sumWaitTime/ammountFinished;
	}
}
