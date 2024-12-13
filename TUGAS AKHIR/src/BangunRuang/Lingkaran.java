package BangunRuang;
public class Lingkaran extends BangunDatar{
	double jejari;
	double diameter;
	
	double hitungLuas() {
		luas = 2 * Math.PI * jejari * jejari;
		return luas;
	}
	double hitunngKeliling() {
		keliling = Math.PI * diameter;
		return keliling;
	}
}