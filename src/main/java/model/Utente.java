package model;

public class Utente {
	String emailutente;
	String nomeutente;
	String password;
	int isAdmin;
	
	public Utente() {
		
	}
	
    public Utente(String emailutente, String nomeutente, String password, int isAdmin) {
        this.emailutente = emailutente;
        this.nomeutente = nomeutente;
        this.password = password;
        this.isAdmin = isAdmin;
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

	public int getisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Utente [emailutente=" + emailutente + ", nomeutente=" + nomeutente + ", password=" + password + ", isAdmin=" + isAdmin + "]";
	}
	
}
