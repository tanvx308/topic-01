package vn.com.fis.service.impl;

import java.util.HashMap;
import java.util.Map;

import vn.com.fis.service.Calculator;
import vn.com.fis.util.ValidateUtil;


// d<= 800
public class GoodLocationCalcu extends Calculator{

	public GoodLocationCalcu(int hp, int s, int d, String t) {
		super(hp, s, d, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculatorF() {
		return (40 - Math.abs(this.getD() - 500)/20 + gs()) * (1 + pt());
	}

	//hàm tính giá trị loại giống
	public double gs() {
		int res = this.getS() % 6;
		switch (res) {
		case 1: {
			return this.getS() * 2;
		}
		case 2: {
			return -1.0 * Math.pow((this.getS() % 9), 3)/5;
		}
		case 3: {
			return -1.0 * Math.pow((this.getS() % 30), 2) + 3 * this.getS();
		}
		case 4: {
			return this.getS() * -1.0;
		}
		case 5: {
			//fake data
			return -1.0 * ValidateUtil.getTriangular((this.getS() % 5) + 5);
		}
		default:
			return this.getS()/2;
		}
	}

	
	//hàm tính năng suất thu hoach
	public double pt() {
		double data[][] = new double[6][6];
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				if(i == j) {
					data[i][j] = 0.0;
				}else if(Math.abs(i - j) == 1) {
					if(i > j) {
						data[i][j] = 0.05;
					}else {
						data[i][j] = -0.05;
					}
				}else if(Math.abs(i - j) == 2) {
					if(i > j) {
						data[i][j] = 0.1;
					}else {
						data[i][j] = -0.1;
					}
				}else if(Math.abs(i - j) == 3) {
					if(i > j) {
						data[i][j] = 0.15;
					}else {
						data[i][j] = -0.15;
					}
				}else if(Math.abs(i - j) == 4) {
					if(i > j) {
						data[i][j] = 0.2;
					}else {
						data[i][j] = -0.2;
					}
				}else if(Math.abs(i - j) == 5) {
					if(i > j) {
						data[i][j] = 0.25;
					}else {
						data[i][j] = -0.25;
					}
				}
			}
		}
		
		Map<String, Integer> weatherMap = new HashMap<>();
		weatherMap.put("Flood", 0);
		weatherMap.put("Storm", 1);
		weatherMap.put("Rain", 2);
		weatherMap.put("Shower", 3);
		weatherMap.put("Drizzle", 4);
		weatherMap.put("Cloudy", 5);
		
		Map<Integer, Integer> categoryMap = new HashMap<>();
		categoryMap.put(5, 0);
		categoryMap.put(4, 1);
		categoryMap.put(0, 2);
		categoryMap.put(1, 3);
		categoryMap.put(2, 4);
		categoryMap.put(3, 5);
		
		return data[weatherMap.get(this.getT())][categoryMap.get(this.getS() % 6)];
	}
}
