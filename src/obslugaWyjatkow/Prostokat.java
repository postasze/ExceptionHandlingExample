package obslugaWyjatkow;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Prostokat extends Figura{
	private double x1, y1, x2, y2;
	
	public double powierzchnia(){
		this.powierzchnia = Math.abs(x1 - x2) * Math.abs(y1 - y2);
		return this.powierzchnia;
	}
	
	public Prostokat(String s) throws NoSuchElementException {
		Scanner scanner = new Scanner(s);
		scanner.next();
		this.x1 = scanner.nextDouble(); // W ponizszych 4 linijkach moga zostac rzucone wyjatki, komentarz na ich temat jest w klasie Trojkat
		this.y1 = scanner.nextDouble();
		this.x2 = scanner.nextDouble();
		this.y2 = scanner.nextDouble();
		scanner.close();
	}
	
	public String toString(){
		return "P " + this.x1 + ", " + this.y1 + ", " + this.x2 + ", " + this.y2;
		}
}
