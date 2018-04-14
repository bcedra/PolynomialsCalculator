package polinom;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args){
		ArrayList<Polinom> rezimpartire = new ArrayList<Polinom>() ;
		System.out.println("1. 1x in loc de +x \n2. spatiu gol inseamna 0");
		System.out.println("Da mi polinom 1");
		Polinom pol1 = new Polinom(true);
		System.out.println("Da mi polinom 2");
		Polinom pol2 = new Polinom(true);
		Operatie operatie = new Operatie();
		Polinom rez = new Polinom();
		operatie.spargePolinom(pol1);
		operatie.spargePolinom(pol2);
		pol1.sort();
		pol2.sort();

		System.out.print("\nP1(x)'=");
		rez=operatie.derivare(pol1);
		rez.printPolinom();
		System.out.print("\nP2(x)'=");
		rez=operatie.derivare(pol2);
		rez.printPolinom();
		System.out.print("\nSP1(x)dx=");
		rez=operatie.integrare(pol1);
		rez.printPolinom();
		System.out.print("\nSP2(x)dx=");
		rez=operatie.integrare(pol2);
		rez.printPolinom();
		System.out.print("\nP1(x)*P2(x)dx=");
		rez=operatie.inmultire(pol1,pol2);
		rez.printPolinom();
		System.out.print("\nP1(x)+P2(x)dx=");
		rez=operatie.adunare(pol1,pol2);
		rez.printPolinom();
		System.out.print("\nP1(x)-P2(x)dx=");
		rez=operatie.scadere(pol1,pol2);
		rez.printPolinom();
		System.out.print("\nP1(x)/P2(x)dx=");
		rezimpartire=operatie.impartire(pol1, pol2);
		rezimpartire.get(1).printPolinom(); // cat
		System.out.print("           R(x)=");
		rezimpartire.get(0).printPolinom(); // rest
	}
}