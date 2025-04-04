package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlEmmenager controlEmmenager;
	private ControlPrendreEtal controlPrendreEtal;
	private ControlVerifierIdentite controlVerifierIdentite;
	private Village village;
	
	@BeforeEach
	void initialiserSitutation()  {
		village = new Village("Nom village" , 10, 3);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlEmmenager = new ControlEmmenager(village);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
	}

	@Test
	void test() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		
		assertFalse(controlLibererEtal.isVendeur("Bodemine"));
		
		controlEmmenager.ajouterGaulois("Bodemine", 10);
		controlPrendreEtal.prendreEtal("Bodemine", "pain", 5);
		assertTrue(controlLibererEtal.isVendeur("Bodemine"));
		
		controlLibererEtal.libererEtal("Bodemine");
		assertFalse(controlLibererEtal.isVendeur("Bodemine"));
	}

}
