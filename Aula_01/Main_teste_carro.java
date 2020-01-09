package aula_01;

public class Main_teste_carro {

	public static void main(String[] args) {
		
		Motor m1 = new Motor(1.0);
		
		Carro c1 = new Carro("Fusca 66", m1);
		
		System.out.println(c1.velocidadeMaxima());

	}

}
