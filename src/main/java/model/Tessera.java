package model;

public class Tessera {
	int codicetessera;
	int categoria;
	float saldo;
	String emailutente;
	
	 public Tessera(){
	     }
	 
	 public Tessera(int codicetessera, int categoria, float saldo, String emailutente){
		 this.codicetessera=codicetessera;
		 this.categoria=categoria;
		 this.saldo=saldo;
		 this.emailutente=emailutente;
	 }
	 public int getCodicetessera() {
			return codicetessera;
		}

		public void setCodicetessera(int codicetessera) {
			this.codicetessera = codicetessera;
		}
		
		public int getCategoria() {
			return categoria;
		}

		public void setCategoria(int categoria) {
			this.categoria = categoria;
		}
		
		public float getSaldo() {
			return saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
		}
		
		public String getEmailutente() {
			return emailutente;
		}

		public void setEmailutente(String emailutente) {
			this.emailutente = emailutente;
		}
		
		@Override
		public String toString() {
			return "Tessera [codicetessera="+codicetessera +"categoria=" + categoria + ", saldo=" + saldo + ", emailutente=" + emailutente +"]";
		}
	 
}