package parcheggio;

public abstract class Veicolo {
	public boolean motore = true;
	
	public void siAccende() {
		System.out.println("veicolo si accende");
	}
	public abstract void siSpegne();
	public abstract void esplode();
}

