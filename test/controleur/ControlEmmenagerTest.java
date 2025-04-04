package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef abraracourix;

	@BeforeEach
	void initialiserSitutation() throws Exception {
		System.out.println("Initialisation ...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourix = new Chef("Abraracourix", 10, village);
		village.setChef(abraracourix);

	}

	@Test
	void test() {
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		assertFalse(controlEmmenager.isHabitant("Asterix"));
		controlEmmenager.ajouterGaulois("Asterix", 20);
		assertTrue(controlEmmenager.isHabitant("Asterix"));
		controlEmmenager.ajouterDruide("Panoramix", 20, 6, 5);
	}

}
