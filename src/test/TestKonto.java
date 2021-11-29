package test;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Konto;

public class TestKonto {

	@Test
	public void testKonstruktor() {
		
		//fail("Not yet implemented");
		Konto k = new Konto("alf");
		
		//prüfe, ob IBAN korrekt übernommen wurde
		assertEquals("korrekte Übernahme IBAN", "alf", k.getIban());
		//prüfe, ob Kontostand nach dem Erstellen 0 ist
		assertEquals("Kontostand am Anfang 0", 0, k.getKontostand(), 0);
	}
	
	@Test
	public void testEinzahlung() {
		
		Konto k = new Konto("CH40012345678909");
		
		k.einzahlen(420);
		//prüfe, ob Einzahlung funktioniert hat
		assertEquals("Sollte nach erster Einzahlung 420 sein", 420, k.getKontostand(),0);
		
		k.einzahlen(420);
		//prüfe, ob Einzahlung funktioniert hat
		assertEquals("Sollte nach zweiter Einzahlung 840 sein", 840, k.getKontostand(),0);
		
		k.einzahlen(-100);
		//prüufe, ob Einzahlung mit negativen Zahlen funktioniert
		assertEquals("Betrag sollte Positiv sein", 840, k.getKontostand(),0);
	}
	
	@Test 
	public void testAbheben() {
		
		Konto k = new Konto("CH400123456789");
		
		k.einzahlen(420);
		
		assertEquals("Ist Geld rausgekommen", 80, k.abheben(80),0);
		
		assertEquals("Kontostand sollte 340 sein", 340, k.getKontostand(), 0);
		
		assertEquals("Prüft ob wirklich kein Geld zurückgekommen ist", 0, k.abheben(420),0);
		
		assertEquals("Abhebung zu Goss, Kontostand bleibt 340", 340, k.getKontostand(), 0);
		
		assertEquals("Prüft ob abzuhebender Wert positiv ist", 0, k.abheben(-100),0);
		
		assertEquals("Prüft ob Kontostand nach negativer Abhebung gleich bleibt", 340, k.getKontostand(), 0);
		
		
	}
}
