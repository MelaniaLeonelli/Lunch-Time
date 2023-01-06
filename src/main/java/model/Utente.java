package model;

public class Utente {
	String emailutente;
	String nomeutente;
	String password;
	int ruolo;
	
	public Utente() {
		
	}
	
    public Utente(String emailutente, String nomeutente, String password, int ruolo) {
        this.emailutente = emailutente;
        this.nomeutente = nomeutente;
        this.password = password;
        this.ruolo = ruolo;
    }
 

	public String getEmailutente() {
		return emailutente;
	}

	public void setEmailutente(String emailutente) {
		this.emailutente = emailutente;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getNomeutente() {
		return nomeutente;
	}

	public void setNomeutente(String nomeutente) {
		this.nomeutente = nomeutente;
	}

	public int getRuolo() {
		return ruolo;
	}

	public void setRuolo(int ruolo) {
		this.ruolo = ruolo;
	}

	@Override
	public String toString() {
		return "Utente [emailutente=" + emailutente + ", nomeutente=" + nomeutente + ", password=" + password + ", ruolo=" + ruolo + "]";
	}
	
}
