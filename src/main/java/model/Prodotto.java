package model;

public class Prodotto{
	String idprodotto;
	String nome;
	String categoria;
	float prezzo;
	String immagine;
	String descrizione;
	int disponibile;
	
	public Prodotto(String idprodotto, String nome, String categoria, float prezzo, String immagine, String descrizione, int disponibile){
		this.idprodotto=idprodotto;
		this.nome=nome;
		this.categoria=categoria;
		this.prezzo=prezzo;
		this.immagine=immagine;
		this.descrizione=descrizione;
		this.disponibile=disponibile;
	}
	public String getIdprodotto() {
		return idprodotto;
	}

	public void setIdprodotto(String idprodotto) {
		this.idprodotto = idprodotto;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	public String getImmagine() {
		return immagine;
	}

	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public int getDisponibile() {
		return disponibile;
	}

	public void setDisponibile(int disponibile) {
		this.disponibile = disponibile;
	}
	
	@Override 
	public String toString(){
		return "Prodotto [idprodotto="+idprodotto+",nome"+nome+",categoria="+categoria+",Prezzo="+prezzo+",Immagine="+immagine+",Descrizione="+descrizione+",Disponibile="+disponibile+"]";
	}
}