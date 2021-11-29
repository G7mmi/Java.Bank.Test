package model;
/**
 * speichert wichtigste Informationen zu einem Konto 
 * @author sven
 *
 */
public class Konto {
	
	private String iban;
	private double kontostand;

	/**
	 * Konstruktor für Konto-Objekte
	 * @param iban
	 * @param kontostand
	 */
	public Konto(String iban) {
		super();
		this.iban = iban;
		this.kontostand = 0;
	}
	
	/**
	 * gibt aktuellen Kontostand zurück
	 * @return
	 */
	public double getKontostand() {
		return kontostand;
	}
	
	public String getIban(){
		return iban;
	}
	
	/**
	 * erhÃ¶ht den kontostand und betrag
	 * @param betrag
	 */
	public void einzahlen(double betrag) {
		if (betrag > 0 ) {
		kontostand += betrag;
	} else {
		System.out.println("Bitte Positiven Betrag einzahlen");
	}
	}
	
	/**
	 * verringert Kontostand und gewÃ¼nschten Betrag und zahlt diesen aus, 
	 * wenn Konto ausreichend gedeckt ist
	 * 
	 * @param betrag gewünschter betrag
	 * @return gewünschte betrag
	 */
	public double abheben(double betrag) {
		if (betrag <= kontostand && betrag > 0) {
		kontostand = kontostand - betrag;
		return betrag;
	}else {
		System.out.println("Kontodeckung für gewünschten Betrag nicht ausreichend oder Betrag negativ." 
				+ "Max. Betrag = " + kontostand);
		return 0;
	}

	
	}
}
