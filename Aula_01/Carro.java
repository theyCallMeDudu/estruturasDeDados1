package aula_01;

public class Carro {
	private String modelo;
	private Motor motor;
	
	public Carro(String modelo, Motor motor) {
		this.modelo = modelo;
		this.motor = motor;
	}
	
	public double velocidadeMaxima() {
		
		if (this.motor == null) {
			return 0;
		}
		
		if(this.motor.getCilindrada() <= 1.0) {
			return 140;
		}
		else if(this.motor.getCilindrada() <= 1.6){
			return 180;
		}
		else if(this.motor.getCilindrada() <= 2.0){
			return 220;
		}
		else {
			return 260;
		}
		
	}
}
