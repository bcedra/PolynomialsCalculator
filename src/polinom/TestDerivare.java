package polinom;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDerivare {

	@Test
	public void test() {
		Operatie testD = new Operatie();
		Polinom p1 = new Polinom();
		Polinom rez = new Polinom();
		p1.setString("x^70");
		testD.spargePolinom(p1);
		rez = testD.derivare(p1);
		rez.pol=rez.printPolinom();
		assertEquals("+70x^69",rez.pol);
	}
}