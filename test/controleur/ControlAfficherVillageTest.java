package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;

	@BeforeEach
	void InitialiserSituation() throws Exception {
		village = new Village("NomVillage", 20, 5);
	}

	@Test
	void test() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);

		assertEquals(5, controlAfficherVillage.donnerNbEtals());
		assertEquals("NomVillage", controlAfficherVillage.donnerNomVillage());

	}

}
