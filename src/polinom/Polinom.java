package polinom;

import java.util.ArrayList;
import java.util.Scanner;

public class Polinom {
	public String pol;
	public ArrayList<Monom> mon = new ArrayList<Monom>() ;
	
	static Scanner reader = new Scanner(System.in);
	
	public Polinom (boolean nimic){
		pol = reader.next();
		
	}
	
	public Polinom (){}
	
	public void setString(String s){
		pol = s;
	}
	
	public void addMonom(int g,float c){
		Monom m = new Monom();
		m.setCoef(c);
		m.setGrad(g);
		mon.add(m);
	}
	
	public String printPolinom(){ //clasa de tip case
		String s = new String();
		for (Monom i: mon){
				if (i.getCoef()==0){ //0
					s = s + "";
				}
				if (i.getCoef()== 1 && i.getGrad()==1){ //x
					s = s +"+x";
				}
				if (i.getCoef()== -1 && i.getGrad()==1){ //-x
					s = s +"-x";
				}
				if (i.getCoef()==1 && i.getGrad()==0){ //1
					s = s + "+1";
				}
				if (i.getCoef()==-1 && i.getGrad()==0){ //-1
					s = s + "-1";
				}
				if (i.getCoef()>=2 && i.getGrad()==1 && (float)i.getCoef()==(int)i.getCoef()){ //nx natural
					s = s + "+" + (int)(i.getCoef()) + "x";
				}
				if (i.getCoef()<=-2 && i.getGrad()==1 && (float)i.getCoef()==(int)i.getCoef()){ //-nx natural
					s = s + (int)(i.getCoef()) + "x";
				}
				if (i.getCoef()>=2 && i.getGrad()==0 && (float)i.getCoef()==(int)i.getCoef()){ //n natural
					s = s + "+" + (int)i.getCoef();
				}
				if (i.getCoef()<=-2 && i.getGrad()==0 && (float)i.getCoef()==(int)i.getCoef()){ //-n natural
					s = s + (int)i.getCoef();
				}
				if (i.getCoef()== 1 && i.getGrad()>=2){ //x^n
					s = s + "+x^" + i.getGrad();
				}
				if (i.getCoef()== -1 && i.getGrad()>=2){ //-x^n
					s = s + "-x^" + i.getGrad();
				}
				if (i.getCoef()>1 && i.getGrad()>1 && (float)i.getCoef()==(int)i.getCoef()){ //nx^n (1,n) natural
					s = s + "+" + (int)i.getCoef() + "x^" + i.getGrad();
				}
				if (i.getCoef()<-1 && i.getGrad()>1 && (float)i.getCoef()==(int)i.getCoef()){ //-nx^n (-n,-1) natural
					s = s + (int)i.getCoef() + "x^" + i.getGrad();
				}
				if (i.getCoef()>1 && i.getGrad()>1 && (float)i.getCoef()!=(int)i.getCoef()){ //nx^n (1,n) float
					s = s + "+" + String.valueOf(i.getCoef()) + "x^" + i.getGrad();
				}
				if (i.getCoef()<-1 && i.getGrad()>1 && (float)i.getCoef()!=(int)i.getCoef()){ //-nx^n (-n,-1) float
					s = s + String.valueOf(i.getCoef()) + "x^" + i.getGrad();
				}
				if (i.getCoef()>1 && i.getGrad()==0 && (float)i.getCoef()!=(int)i.getCoef()){ //n float(1,n) grad=0
					s = s + "+" + String.valueOf(i.getCoef());
				}
				if (i.getCoef()<-1 && i.getGrad()==0 && (float)i.getCoef()!=(int)i.getCoef()){ //-n float (-n,-1) grad=0
					s = s + String.valueOf(i.getCoef());
				}
				if (i.getCoef()>1 && i.getGrad()==1 && (float)i.getCoef()!=(int)i.getCoef()){ //nx float(1,n)
					s = s + "+" + String.valueOf(i.getCoef()) + "x";
				}
				if (i.getCoef()<-1 && i.getGrad()==1 && (float)i.getCoef()!=(int)i.getCoef()){ //-nx float (-n,-1) 
					s = s + String.valueOf(i.getCoef()) + "x";
				}
				if (i.getCoef()>0 && i.getCoef()<1 && i.getGrad()!=0 && i.getGrad()!=1){ //nx^n (0,1)
					s = s + "+" + String.valueOf(i.getCoef()) + "x^" +i.getGrad() ;
				}
				if (i.getCoef()>-1 && i.getCoef()<0 && i.getGrad()!=0 && i.getGrad()!=1){ //-nx^n (-1,0)
					s = s + String.valueOf(i.getCoef()) + "x^" + i.getGrad();
				}
				if (i.getCoef()>0 && i.getCoef()<1 && i.getGrad()==0){ //nx^n (0,1) float grad=0
					s = s + "+" + String.valueOf(i.getCoef());
				}
				if (i.getCoef()>-1 && i.getCoef()<0 && i.getGrad()==0){ //-nx^n (-1,0) float grad=0
					s = s + String.valueOf(i.getCoef());
				}
				if (i.getCoef()>0 && i.getCoef()<1 && i.getGrad()==1){ //nx^n (0,1) flaot grad=1
					s = s + "+" + String.valueOf(i.getCoef()) + "x";
				}
				if (i.getCoef()>-1 && i.getCoef()<0 && i.getGrad()==1){ //-nx^n (-1,0) flaot grad=1
					s = s + String.valueOf(i.getCoef()) + "x";
				}
		}	
		System.out.println(s);
		return s;	
	}	

	public void sort(){
		int auxg;
		float auxc;
		for (Monom i: mon)
			for (Monom j:mon){
				if (i.getGrad()>j.getGrad()){
					auxg=i.getGrad();
					auxc=i.getCoef();
					i.setGrad(j.getGrad());
					i.setCoef(j.getCoef());
					j.setCoef(auxc);
					j.setGrad(auxg);
				} 
			}
	}
	
	public Monom getMonGradMax(){
		int maxGrad=-1;
		float coefOfMaxGrad=0;
		Monom max = new Monom();
		for (Monom i: mon){
			if (i.getGrad()>maxGrad){
				maxGrad=i.getGrad();
				coefOfMaxGrad=i.getCoef();
			}
		}
		max.setCoef(coefOfMaxGrad);
		max.setGrad(maxGrad);
		return max;		
	}
}	