package polinom;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatie {
	
	public Monom impartireMonom (Monom m1, Monom m2){
		Monom m3 = new Monom();
		m3.setMonom(m1.getGrad()-m2.getGrad(), m1.getCoef()/m2.getCoef());
		return m3;	
	}
	
	public Polinom inmultireCuMonom(Polinom p, Monom m){
		Polinom rez = new Polinom();
		for (Monom i: p.mon){
			rez.addMonom(i.getGrad()+m.getGrad(),i.getCoef()*m.getCoef());
		}
		return rez;
	}
	
	public ArrayList<Polinom> impartire (Polinom d, Polinom i){
		ArrayList<Polinom> pol = new ArrayList<Polinom>() ;
		Polinom c= new Polinom();
		Polinom r = new Polinom();
		Monom cn = new Monom();
		Polinom inmultitor = new Polinom();
		r=d;
		while ( (r.getMonGradMax().getGrad()-i.getMonGradMax().getGrad()) >= 0){
			cn = impartireMonom(r.getMonGradMax(),i.getMonGradMax());
			c.addMonom(cn.getGrad(), cn.getCoef());
			inmultitor =inmultireCuMonom(i,cn);
			r = scadere(r,inmultitor);
			for (Monom j: r.mon){
				if (j.getCoef()==0)
					j.setGrad(-1);
			}
		}
		pol.add(r);
		pol.add(c);
		return pol;
	}
	
	public Polinom inmultire (Polinom p1, Polinom p2){
		Polinom rez = new Polinom();
		for (Monom i: p1.mon){
			for (Monom j: p2.mon){
					rez.addMonom(i.getGrad() + j.getGrad(),i.getCoef() * j.getCoef());
			}
		}
		rez.sort();
		int[] grad = new int[100];
		float[] coef = new float[100];
		int k=0;
		for (Monom i: rez.mon){
			grad[k]=i.getGrad();
			coef[k]=i.getCoef();
			k++;
		}
		for (int i = 0;i<k;i++){
			if (grad[i]==grad[i+1]){
				coef[i]=coef[i]+coef[i+1];
				grad[i+1]=-1;
			}
		}
		rez.mon.clear();
		for (int i = 0;i<k;i++){
			if (grad[i]!=-1){
				rez.addMonom(grad[i], coef[i]);
			}
		}
		return rez;	
	}
	
	public Polinom adunare (Polinom p1, Polinom p2){
		Polinom rez = new Polinom ();
		Polinom copie = new Polinom ();
		for (Monom i: p1.mon){
			rez.addMonom(i.getGrad(), i.getCoef());
		}
		for (Monom j: p2.mon){
			copie.addMonom(j.getGrad(), j.getCoef());
		}
		for (Monom i: rez.mon){
			for (Monom j: copie.mon){
				if (i.getGrad() ==  j.getGrad()){
					i.setCoef(i.getCoef()+j.getCoef());
					j.setGrad(-1);
				}
			}
		}
		for (Monom j: copie.mon){
			if (j.getGrad()!=-1){
				rez.addMonom(j.getGrad(), j.getCoef());
			}
		}
		rez.sort();
		return rez;
	}
	
	public Polinom scadere (Polinom p1, Polinom p2){
		Polinom rez = new Polinom ();
		Polinom copie = new Polinom ();
		for (Monom i: p1.mon){
			rez.addMonom(i.getGrad(), i.getCoef());
		}
		for (Monom j: p2.mon){
			copie.addMonom(j.getGrad(), j.getCoef());
		}
		for (Monom i: rez.mon){
			for (Monom j: copie.mon){
				if (i.getGrad() ==  j.getGrad()){
					i.setCoef(i.getCoef()-j.getCoef());
					j.setGrad(-1);	
				}
			}
		}
		for (Monom j: copie.mon){
			if (j.getGrad()!=-1){
				rez.addMonom(j.getGrad(), -j.getCoef());
			}
		}
		rez.sort();
		return rez;
	}
	
	public Polinom derivare(Polinom p){
		Polinom rez = new Polinom();
		for (Monom i:p.mon){
			if (i.getGrad()==0){
				rez.addMonom(0, 0);
			}
			else {
			rez.addMonom(i.getGrad()-1, i.getGrad()*i.getCoef());
			}
		}
		return rez;
	}
	
	public Polinom integrare(Polinom p){
		Polinom rez = new Polinom();
		for (Monom i:p.mon){
			rez.addMonom(i.getGrad()+1, i.getCoef()/(i.getGrad()+1));
		}
		return rez;
	}

	public void spargePolinom (Polinom polinom){
		Pattern p = Pattern.compile("([+-]?\\d*\\.?\\d*)[xX](\\^(\\d+))?|([-+]?\\d+\\.?\\d*)");
		Matcher m1 = p.matcher(polinom.pol);
		while (m1.find()){
			if (m1.group(4)!=null){ 
				polinom.addMonom(0, Float.parseFloat(m1.group(4)));   
			}
			else{
				if (m1.group(1).equals("-") || m1.group(1).equals("") || m1.group(1).equals("-")){
					if (m1.group(1).equals("-")){
						if (m1.group(2)==null){
							polinom.addMonom(1, -1);
						}else{
							polinom.addMonom(Integer.parseInt(m1.group(3)),-1);
						}	
					}else{
						if (m1.group(2)==null){
							polinom.addMonom(1, 1);
						}else{
							polinom.addMonom(Integer.parseInt(m1.group(3)),1);
						}
					}
				}else{
					try {		
						if (m1.group(2)==null){
							polinom.addMonom(1, Float.parseFloat(m1.group(1)));
						}else{
							polinom.addMonom(Integer.parseInt(m1.group(3)), Float.parseFloat(m1.group(1)));
						}
					} catch (java.lang.NumberFormatException e1) {
						polinom.addMonom(Integer.parseInt(m1.group(3)),1);
					}	
				}
			}
		}	
	}
}