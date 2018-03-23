package urz.projekt.model;

public class KlientSamochod {
	private Long idsamochodu;
	private Long idklienta;
	public Long getIdsamochodu() {
		return idsamochodu;
	}
	public void setIdsamochodu(Long idsamochodu) {
		this.idsamochodu = idsamochodu;
	}
	public Long getIdklienta() {
		return idklienta;
	}
	public void setIdklienta(Long idklienta) {
		this.idklienta = idklienta;
	}
	public KlientSamochod(Long idsamochodu, Long idklienta) {
		super();
		this.idsamochodu = idsamochodu;
		this.idklienta = idklienta;
	}
	
	public KlientSamochod() {
		
	}
}
