package obslugaWyjatkow;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Kolo extends Figura{
	private double x1, y1;
	private double r;
	
	public double powierzchnia(){
		this.powierzchnia = Math.PI * r * r;
		return this.powierzchnia;
	}
	
	public Kolo(String s) throws NoSuchElementException {
		Scanner scanner = new Scanner(s);
		scanner.next();
		this.x1 = scanner.nextDouble(); // W ponizszych 3 linijkach moga zostac rzucone wyjatki, komentarz na ich temat jest w klasie Trojkat
		this.y1 = scanner.nextDouble();
		this.r = scanner.nextDouble();
		scanner.close();
	}
	public String toString(){
		return "K " + this.x1 + ", " + this.y1 + ", " + this.r;
		}
}
