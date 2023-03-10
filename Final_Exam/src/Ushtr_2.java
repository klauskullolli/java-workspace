
public class Ushtr_2 {

	public static void main(String[] args) {
		SkuadraFutboll team = new SkuadraFutboll("Polis2020", 4 , 3) ;
		System.out.println(team.rezultat_mire());
		team.nextWin();
		team.nextWin();
		team.nextLoss();
		team.nextLoss();
		team.nextLoss();
		System.out.println(team.rezultat_mire());
		
	}

}
