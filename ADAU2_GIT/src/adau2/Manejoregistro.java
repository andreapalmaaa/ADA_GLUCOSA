package adau2;

public class Manejoregistro {
	
	public Manejoregistro() {
	}
	
	private String nombre;
	private float glucosa;
	private String fecha;
	
	public Manejoregistro(String nombre, float glucosa, String fecha) {
		this.nombre = nombre;
		this.glucosa = glucosa;
		this.fecha = fecha;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getGlucosa() {
		return glucosa;
	}

	public void setGlucosa(float glucosa) {
		this.glucosa = glucosa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
