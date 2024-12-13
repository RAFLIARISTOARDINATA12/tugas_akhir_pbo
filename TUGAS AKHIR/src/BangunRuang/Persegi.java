package BangunRuang;
public class Persegi extends BangunDatar{
	double sisi;
	double luas;
	double keliling;
	double hitungLuas() {
		luas = sisi * sisi;
		return luas;
	}
	
	double hitungKeliling() {
		keliling = sisi * 4;
		return keliling;
	}
}