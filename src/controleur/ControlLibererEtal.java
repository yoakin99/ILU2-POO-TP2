package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;


public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private Village village;

	public ControlLibererEtal(ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
		this.village = village;
	}

	public boolean isVendeur(String nomVendeur) {
		return null != controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [3] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		village.partirVendeur(etal.getVendeur());
		return etal.etatEtal();
	}

}
