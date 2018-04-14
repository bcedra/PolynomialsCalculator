package polinom;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInmultire {

	@Test
	public void test() {
		Operatie testI = new Operatie();
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		Polinom rez = new Polinom();
		p1.setString("x+1");
		p2.setString("x+1");
		testI.spargePolinom(p1);
		testI.spargePolinom(p2);
		rez = testI.inmultire(p1, p2);
		rez.pol=rez.printPolinom();
		assertEquals("+x^2+2x+1",rez.pol);
	}
}