package MetodeBayar;
public interface MetodeBayar {
    public double BayarCash(double cash, double belanja);
    public double BayarQRIS(int idNasabah, double saldo, double totalBelanja);
    public double BayarEwallet(int idUser, String namaProviderWallet, double saldo, double totalBelanja);
    public double BayarCreditCard(int idNasabah, String namaBank, String exprCardDate, int cardNumber, int vccCode, double saldo, double totalBelanja);
    public double BayarDebitCard(int idNasabah, String namaBank, String exprCardDate, int cardNumber, int vccCode, double saldo, double totalBelanja);
}