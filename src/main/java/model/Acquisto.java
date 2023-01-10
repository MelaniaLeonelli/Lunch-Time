package model;

public class Acquisto{
	int codordine;
	String codprodotto;
	float costo;
	
	public Acquisto (int codordine, String codprodotto, float costo){
		this.codordine=codordine;
		this.codprodotto=codprodotto;
		this.costo=costo;
	}
	public int getCodordine(){
		return codordine;
	}
	public void setCodordine(int codordine){
		this.codordine=codordine;
	}
	
	public String getCodprodotto(){
		return codprodotto;
	}
	public void setCodprodotto(String codprodotto){
		this.codprodotto=codprodotto;
	}
	
	public float getCosto(){
		return costo;
	}
	
    public void setCosto(float costo){
    	this.costo=costo;
    	
    }
    
<<<<<<< HEAD

    public String toString() {
=======
=======
>>>>>>> e1c0f993aa4f69713ab4375caa5dd025c631b829
    @Override
	public String toString(){
    	return "Acquisto [codordine="+codordine+",codprodotto="+codprodotto+",costo="+costo+"]";
    }
}