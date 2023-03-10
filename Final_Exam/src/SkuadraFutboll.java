
public class SkuadraFutboll {

	private String name ;
	private int win ; 
	private int loss ; 
	
	SkuadraFutboll(String name, int win  , int loss){
		this.name = name; 
		this.win = win ;
		this.loss = loss ; 
	}
	
	SkuadraFutboll(String name){
		this.name = name; 
		this.win = 0;
		this.loss = 0 ; 
	}
	
	public void nextWin() {
		this.win++ ; 
	}
	
	public void nextLoss() {
		this.loss++ ; 
	}
	
	public Boolean rezultat_mire() {
		return this.win>this.loss? true : false ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}
	
}
