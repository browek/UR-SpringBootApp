package urz.projekt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="samochod", schema="wypozyczalnia")
public class Samochod {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="marka")
	private String marka;
	
	@Column(name="model")
	private String model;
	
	@Column(name="rok_produkcji")
	private int rok_produkcji;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@JoinColumn(name="klient_id")
	private Klient klient;
	
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getRok_produkcji() {
		return rok_produkcji;
	}
	public void setRok_produkcji(int rok_produkcji) {
		this.rok_produkcji = rok_produkcji;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
