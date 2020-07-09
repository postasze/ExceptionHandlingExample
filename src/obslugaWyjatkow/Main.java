package obslugaWyjatkow;

import java.io.*;
import java.util.*;

// Jesli w danym pliku tekstowym liczba n bedzie mniejsza niz liczba linijek opisujacych figure, to nadmiarowe linijki nie sa brane pod uwage
// Dodatkowo jesli w danym wierszu pliku tekstowego liczba argumentow bedzie wieksza niz wymagana dla danej figury to nadmiarowe argumenty nie beda brane pod uwage

public class Main {
	private static String [] tablicaDanych;
	private static Figura [] tablicaFigur;
	private static int iloscFigur;

   private static void czytajPlik(String nazwaPliku) {
		
	   try {
	        File file = new File(nazwaPliku); // tutaj moglby wystapic wyjatek braku pliku ale jesli program nie dostanie pliku jako argument to inny wyjatek wystapi wczesniej w linijce 88
	        Scanner scanner = new Scanner(file);
	        iloscFigur = Integer.parseInt(scanner.nextLine()); // zakladamy ze liczba calkowita n wystapi w kazdym pliku nawet w tym z bledami (liczba n moze byc bledna np. n = 12, a figur jest 8)
	        tablicaDanych = new String [iloscFigur];
	        
	        for(int i = 0; i < iloscFigur; i++) {
	        	try {
	        		tablicaDanych[i] = scanner.nextLine(); // tutaj moze wystapic wyjatek NoSuchElementException gdy nie ma nastepnej linii w danym pliku tekstowym
	        	} catch (NoSuchElementException e) {
	        		if(i == 0) {
	        			System.out.println("Blad. Plik nie zawiera żadnych danych. Koniec pracy programu");
	        			System.exit(1);
	        		}
	        		else {
	        			System.out.println("Blad. Liczba n (" + iloscFigur + ") jest wieksza niz liczba linijek pliku tekstowego opisujacych figury (" +
	        		i + "). Program kontunuuje prace dla liczby figur rownej liczbie linijek w pliku");
	        			iloscFigur = i;
	        			break;
	        		}
	        	}
	        }
	          scanner.close();
	          
	        } catch (FileNotFoundException e) {
	          System.out.println("Blad. nie znaleziono pliku. Koniec pracy programu");
	          System.exit(1);
	        }
   }
   
   private static void stworzTabliceFigur() {
	   tablicaFigur = new Figura[iloscFigur];
	   char znak;
	   int j = 0;
	   
	   for(int i = 0; i < iloscFigur; i++) {
		   try {
			   znak = tablicaDanych[i].charAt(0); // tutaj moze wystapic wyjatek StringIndexOutOfBoundsException gdy nie ma żadnych znakow w danym stringu (w danym wierszu pliku tekstowego)
			   try {
				   if(znak == 'T') tablicaFigur[j] = new Trojkat(tablicaDanych[i]); // konstruktor kazdej z trzech figur rzuca wyjatek NoSuchElementException
				   else if(znak == 'P') tablicaFigur[j] = new Prostokat(tablicaDanych[i]);
				   else if(znak == 'K') tablicaFigur[j] = new Kolo(tablicaDanych[i]);
				   j++;
			   } catch (NoSuchElementException e1) {
				   System.out.println("Blad. W " + (i + 1) + " wierszu znajduje sie niewlasciwe wyrazenie lub brakuje niektorych argumentow. Program kontynuuje prace dla liczby figur zmniejszonej o 1");
			   }
		   } catch (StringIndexOutOfBoundsException e2) {
			   System.out.println("Blad. W " + (i + 1) + " wierszu nie ma zadnych znakow. Program kontynuuje prace dla liczby figur zmniejszonej o 1");
		   }
	   }
	   iloscFigur = j; // j jest rownej i minus liczba wierszy zawierajacych bledy
   }
   
   private static void obliczSumePol() {
	   double sumaPol = 0;
	   for(int i = 0; i < iloscFigur; i++){
		   sumaPol = sumaPol + tablicaFigur[i].powierzchnia();
	   }
	   System.out.println("Suma pol powierzchni wszystkich figur wynosi " + sumaPol);  
   }
   
   private static void  wypiszFigury() {
	   System.out.println("liczba figur wynosi " + iloscFigur);
	   System.out.println("Wypisywanie wszystkich figur (kazda w osobnym wierszu)");
	   System.out.println();
	   for(int i = 0; i < iloscFigur; i++){
		   System.out.println(tablicaFigur[i]);
	   }  
   }
   
   public static void main(String[] args){
	   try {
		   czytajPlik(args[0]); // tutaj moze wystapic wyjatek ArrayIndexOutOfBoundsException gdy lista argumentow programu (String[] args) bedzie pusta
       } catch (ArrayIndexOutOfBoundsException e) {
	          System.out.println("Blad. Program nie otrzymal pliku tekstowego jako argument. Koniec pracy programu");
	          System.exit(1);
	        }
	   stworzTabliceFigur();
	   System.out.println();
	   obliczSumePol();
	   wypiszFigury();
   }
}

