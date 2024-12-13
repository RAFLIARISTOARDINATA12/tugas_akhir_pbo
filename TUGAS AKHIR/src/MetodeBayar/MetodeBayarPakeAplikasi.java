package MetodeBayar;
public interface MetodeBayarPakeAplikasi extends MetodeBayar {
    public double BayarGoPay(int idUser, double saldo, double belanjaTotal);
    public double BayarShopeePay(int idUser, double saldo, double belanjaTotal);
}
