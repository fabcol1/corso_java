package esercizioEreditarieta;

public class Uomo extends EssereVivente implements NonParlaInterface, SaCamminareInterface, GiocaConLaPallaInterface, NuotaInterface  {
	String cognome;
	String occupazione;
	
	public void dorme() {
	}
	public void programma() {
	}
	@Override
	public void cammina() {
	}
	@Override
	public void nuota() {
	}
	@Override
	public void giocaConLaPalla() {
	}
}
