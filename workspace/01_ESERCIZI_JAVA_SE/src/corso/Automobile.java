package corso;

public class Automobile {
	public int cv;
	public int numeroRuote, numeroFari;

	public void giraADestra() {
		numeroFari = 4;
		if(numeroFari==4) {
			System.out.println("La macchina è accesa");
		}
//		int z = numeroRuote*numeroFari;
	}
	
	public void giraASinistra() {
	}
}
