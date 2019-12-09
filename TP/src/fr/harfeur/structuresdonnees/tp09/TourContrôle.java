package fr.harfeur.structuresdonnees.tp09;

import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;

public class TourContr�le {

	public static final int DELAI_REPONSE_TOUR_MS = 4000;
	public static final int INTERVALLE_MS = 1000;
	
	public PriorityQueue<Vol> fileAttente = new PriorityQueue<Vol>();
	
	public TourContr�le() {
		
		Timer avionsTimer = new Timer();
		avionsTimer.scheduleAtFixedRate(new NouvelAvion(this), 0, TourContr�le.INTERVALLE_MS);
		
		Timer tourTimer = new Timer();
		tourTimer.scheduleAtFixedRate(new D�cisionTour(this), TourContr�le.DELAI_REPONSE_TOUR_MS, TourContr�le.INTERVALLE_MS);
	}

	public class NouvelAvion extends TimerTask {

		TourContr�le tour;
		
		public NouvelAvion(TourContr�le tc) {
			this.tour = tc;
		}
		
		@Override
		public void run() {
			this.tour.fileAttente.add(new Vol());
		}
	}
	
	public class D�cisionTour extends TimerTask {

		TourContr�le tour;
		
		public D�cisionTour(TourContr�le tc) {
			this.tour = tc;
		}
		
		@Override
		public void run() {
			System.out.println(this.tour);
			Vol v = this.tour.fileAttente.peek();
			v.atterrir();
			this.tour.fileAttente.remove();
		}	
	}

	public String toString() {
		return this.fileAttente.toString();
	}
	
	public static void main(String args[]) {
		new TourContr�le();
	}
	
	
}
