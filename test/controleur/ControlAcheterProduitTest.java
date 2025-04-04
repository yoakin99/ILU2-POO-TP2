package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlAcheterProduitTest {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlEmmenager controlEmmenager;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	void initialiserSitutation() {
		village = new Village("Les irréductibles", 10, 10);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void test() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		ControlAcheterProduit controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite,
				controlTrouverEtalVendeur, village);
		
		assertFalse(controlAcheterProduit.isHabitant("Asterix"));
		controlEmmenager.ajouterGaulois("Asterix", 20);
		assertTrue(controlAcheterProduit.isHabitant("Asterix"));
		
		controlPrendreEtal.prendreEtal("Asterix", "Pain", 3);
		
		
		
		controlAcheterProduit.vendeurProduit("Pain");
		int val = 2;
		assertEquals(2, controlAcheterProduit.acheterProduit("Pain", 2, 0));
		assertEquals(0, controlAcheterProduit.acheterProduit("Gateau", 5, 0));
		
		
	}
	
}
