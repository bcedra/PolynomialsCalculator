package polinom;

public class Monom{
	private int grad;
	private float coef;

	public void setMonom(int g,float c){
		grad = g;
		coef = c;
	}
	
	public void setGrad(int g){
		grad= g;
	}
	public void setCoef(float c){
		coef= c;
	}
	
	public int getGrad(){
		return grad;
	}
	
	public float getCoef(){
		return coef;
	}
	
	public void printMonom(){
			System.out.println(coef + "x^" + grad);
	}
}