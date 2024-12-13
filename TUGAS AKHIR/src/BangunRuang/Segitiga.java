package BangunRuang;
public class Segitiga extends BangunDatar{
	double alas;
	double tinggi;
	double sisiMiring;
	
	double hitungLuas() {
		luas = 0.5 * alas * tinggi;
		return luas;
	}
	
	double hitungSisiMiring() {
		sisiMiring = Math.sqrt((alas*alas) + (tinggi*tinggi));
		return sisiMiring;
	}
	
	double hitungKeliling() {
		keliling = alas + tinggi + sisiMiring;
		return keliling;
	}
}