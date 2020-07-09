package obslugaWyjatkow;

import java.util.*;

public class Trojkat extends Figura{
	private double x1, y1, x2, y2, x3, y3;
	
	public Trojkat(String s) throws NoSuchElementException {
		Scanner scanner = new Scanner(s);
		scanner.next();  // tutaj moglby wystapic wyjatek NoSuchElementException gdyby nie bylo żadnych znakow w danym stringu (wierszu pliku tekstowego), ale wczesniej sie pojawi inny zwiazany z tym problemem wyjatek w klasie Main w linijce 53
		this.x1 = scanner.nextDouble(); // W ponizszych 6 linijkach moga wystapic wyjatki: NoSuchElementException jesli nie ma wiecej znakow w danym stringu lub InputMismatchException jesli w danym stringu wystepuje niewlasciwe wyrazenie np. litera zamiast liczby
		this.y1 = scanner.nextDouble(); // W obu przypadkach pomijamy dana Figure (nie tworzymy jej i nie bierzemy danej figury pod uwage w dalszych obliczeniach)
		this.x2 = scanner.nextDouble(); // klasa InputMismatchException jest podklasa NoSuchElementException wiec w formule catch wystarczy napisac NoSuchElementException zeby schwytac 2 wyjatki jednoczesnie
		this.y2 = scanner.nextDouble(); // powyzsze wyjatki zostana obsluzone w klasie Main gdzie jest wywolywany dany konstruktor 
		this.x3 = scanner.nextDouble(); 
		this.y3 = scanner.nextDouble(); 
		scanner.close();		
	}
	
	public double powierzchnia(){
		this.powierzchnia = 0.5 * Math.abs((x2 - x1)*(y3 - y1) - (y2 - y1)*(x3 - x1)); //wzor na obliczanie pola trojkata na podstawie wspolrzednych wierzcholkow na plaszczyznie
		return this.powierzchnia;
	}

	public String toString(){
		return "T " + this.x1 + ", " + this.y1 + ", " + this.x2 + ", " + this.y2 + ", " + this.x3 
				+ ", " + this.y3;
		}
}
