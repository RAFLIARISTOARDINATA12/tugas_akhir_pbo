package MetodeBayar;
public class MainClass {

    public static void main(String[] args) {
        PembayaranBelanja pb = new PembayaranBelanja();

        // Bayar Cash
        try {
            double kembalianCash = pb.BayarCash(100000, 75000);
            System.out.println("Kembalian Cash: " + kembalianCash);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Bayar QRIS
        try {
            double sisaSaldoQRIS = pb.BayarQRIS(1, 50000, 30000);
            System.out.println("Sisa Saldo QRIS: " + sisaSaldoQRIS);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Bayar GoPay
        try {
            double sisaSaldoGoPay = pb.BayarGoPay(123, 100000, 60000);
            System.out.println("Sisa Saldo GoPay: " + sisaSaldoGoPay);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Bayar ShopeePay
        try {
            double sisaSaldoShopeePay = pb.BayarShopeePay(456, 80000, 50000);
            System.out.println("Sisa Saldo ShopeePay: " + sisaSaldoShopeePay);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
