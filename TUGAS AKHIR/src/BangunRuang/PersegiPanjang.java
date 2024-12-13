package BangunRuang;
public class PersegiPanjang extends BangunDatar{
	double panjang;
	double lebar;
	double luas;
	double keliling;
	
	double hitungLuas() {
		luas = panjang * lebar;
		return luas;
	}
	double hitungKeliling() {
		keliling = 2 * (panjang + lebar);
		return keliling;
	}
}