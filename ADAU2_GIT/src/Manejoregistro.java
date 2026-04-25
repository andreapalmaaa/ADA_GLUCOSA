package ada_glucosa;

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
			// TODO Auto-generated method stub
			return nombre;
		}

		public float getGlucosa() {
			// TODO Auto-generated method stub
			return glucosa;
		}

		public String getFecha() {
			// TODO Auto-generated method stub
			return fecha;
		}

	}
