package com.sample.models;

import java.io.Serializable;

public class Souscription implements Serializable {


	private EnergieType energieType;
	private long puissanceFiscale;
	private String montantRC;
	private double primeAnnuel;

	public EnergieType getEnergieType() {
		return energieType;
	}

	public void setEnergieType(EnergieType energieType) {
		this.energieType = energieType;
	}

	public long getPuissanceFiscale() {
		return puissanceFiscale;
	}
	
	public void setPuissanceFiscale(long puissanceFiscale) {
		this.puissanceFiscale = puissanceFiscale;
	}
	
	public double getPrimeAnnuel() {
		return primeAnnuel;
	}
	
	public void setPrimeAnnuel(double primeAnnuel) {
		this.primeAnnuel = primeAnnuel;
	}

	public String getMontantRC() {
		return montantRC;
	}

	public void setMontantRC(String montantRC) {
		this.montantRC = montantRC;
	}

	/**
	 * 
	 */
	public Souscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param energieType
	 * @param puissanceFiscale
	 * @param montantRC
	 * @param primeAnnuel
	 */
	public Souscription(EnergieType energieType, long puissanceFiscale, String montantRC, double primeAnnuel) {
		super();
		this.energieType = energieType;
		this.puissanceFiscale = puissanceFiscale;
		this.montantRC = montantRC;
		this.primeAnnuel = primeAnnuel;
	}



	public enum EnergieType implements Serializable {
        ESSENCE,
        DIESEL;
    }
	
}
