package vn.com.fis.model;

import vn.com.fis.service.Calculator;
import vn.com.fis.service.impl.BadLocationCalcu;
import vn.com.fis.service.impl.GoodLocationCalcu;
import vn.com.fis.service.impl.HardLocationCalcu;
import vn.com.fis.service.impl.SpecicalLocationCalcu;

public class Info {
	private int hp;
	private int s;
	private int d;
	private String t;
	
	public Info(int hp, int d, int s, String t) {
		this.hp = hp;
		this.s = s;
		this.d = d;
		this.t = t;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}
	
	//public method
	public Calculator getCalculator() {
		if(this.d < 200) {
			return new BadLocationCalcu(hp,  d, s, t);
		}else if(this.d < 300) {
			return new SpecicalLocationCalcu(hp,  d, s, t);
		}else if(this.d <= 800) {
			return new GoodLocationCalcu(hp,  d, s, t);
		}else {
			return new HardLocationCalcu(hp,  d, s, t);
		}
	}
	
}
