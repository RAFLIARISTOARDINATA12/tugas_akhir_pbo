package MetodeBayar;
public class PembayaranBelanja implements MetodeBayarPakeAplikasi {

    private double kembalian;

    @Override
    public double BayarCash(double cash, double belanja) {
        if (cash < belanja) {
            throw new IllegalArgumentException("Uang cash tidak mencukupi.");
        }
        kembalian = cash - belanja;
        return kembalian;
    }

    @Override
    public double BayarQRIS(int idNasabah, double saldo, double totalBelanja) {
        if (saldo < totalBelanja) {
            throw new IllegalArgumentException("Saldo QRIS tidak mencukupi.");
        }
        return saldo - totalBelanja;
    }

    @Override
    public double BayarEwallet(int idUser, String namaProviderWallet, double saldo, double totalBelanja) {
        if (saldo < totalBelanja) {
            throw new IllegalArgumentException("Saldo E-wallet tidak mencukupi.");
        }
        return saldo - totalBelanja;
    }

    @Override
    public double BayarCreditCard(int idNasabah, String namaBank, String exprCardDate, int cardNumber, int vccCode, double saldo, double totalBelanja) {
        if (saldo < totalBelanja) {
            throw new IllegalArgumentException("Limit kartu kredit tidak mencukupi.");
        }
        return saldo - totalBelanja;
    }

    @Override
    public double BayarDebitCard(int idNasabah, String namaBank, String exprCardDate, int cardNumber, int vccCode, double saldo, double totalBelanja) {
        if (saldo < totalBelanja) {
            throw new IllegalArgumentException("Saldo kartu debit tidak mencukupi.");
        }
        return saldo - totalBelanja;
    }

    @Override
    public double BayarGoPay(int idUser, double saldo, double belanjaTotal) {
        if (saldo < belanjaTotal) {
            throw new IllegalArgumentException("Saldo GoPay tidak mencukupi.");
        }
        return saldo - belanjaTotal;
    }

    @Override
    public double BayarShopeePay(int idUser, double saldo, double belanjaTotal) {
        if (saldo < belanjaTotal) {
            throw new IllegalArgumentException("Saldo ShopeePay tidak mencukupi.");
        }
        return saldo - belanjaTotal;
    }

    // Getter untuk kembalian
    public double getKembalian() {
        return kembalian;
    }
}
