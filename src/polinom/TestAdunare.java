package polinom;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAdunare {

	@Test
	public void test() {
		Operatie testA = new Operatie();
		Polinom p1 = new Polinom();
		Polinom p2 = new Polinom();
		Polinom rez = new Polinom();
		p1.setString("x^2-x+1");
		p2.setString("-x+x^2");
		testA.spargePolinom(p1);
		testA.spargePolinom(p2);
		rez = testA.adunare(p1, p2);
		rez.pol=rez.printPolinom();
		assertEquals("+2x^2-2x+1",rez.pol);
	}
}