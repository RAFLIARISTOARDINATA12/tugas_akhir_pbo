package MetodeBayar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPembayaran {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Pembayaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.setBackground(new Color(225, 255, 245));

        JLabel labelMetode = new JLabel("Pilih Metode Pembayaran:");
        labelMetode.setForeground(new Color(0, 128, 128));
        String[] metodePembayaran = {"Cash", "QRIS", "E-Wallet", "Credit Card", "Debit Card"};
        JComboBox<String> comboMetode = new JComboBox<>(metodePembayaran);
        comboMetode.setBackground(new Color(224, 255, 255));
        comboMetode.setForeground(new Color(0, 64, 64));

        JLabel labelNominal = new JLabel("Masukkan Nominal:");
        JTextField fieldNominal = new JTextField();

        JLabel labelBelanja = new JLabel("Total Belanja:");
        JTextField fieldBelanja = new JTextField();

        JButton buttonBayar = new JButton("Bayar");
        buttonBayar.setBackground(new Color(0, 191, 255));
        buttonBayar.setForeground(Color.WHITE); // Warna teks tombol
        buttonBayar.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel labelResult = new JLabel("Hasil: ");
        labelResult.setForeground(new Color(0, 128, 128));

        panel.add(labelMetode);
        panel.add(comboMetode);
        panel.add(labelNominal);
        panel.add(fieldNominal);
        panel.add(labelBelanja);
        panel.add(fieldBelanja);
        panel.add(buttonBayar);
        panel.add(labelResult);

        frame.add(panel);

        buttonBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String metode = (String) comboMetode.getSelectedItem();
                double nominal;
                double belanja;
                try {
                    nominal = Double.parseDouble(fieldNominal.getText());
                    belanja = Double.parseDouble(fieldBelanja.getText());

                    PembayaranBelanja pembayaran = new PembayaranBelanja();
                    double hasil;

                    switch (metode) {
                        case "Cash":
                            hasil = pembayaran.BayarCash(nominal, belanja);
                            labelResult.setText("Kembalian: " + hasil);
                            break;
                        case "QRIS":
                            hasil = pembayaran.BayarQRIS(1, nominal, belanja);
                            labelResult.setText("Sisa Saldo: " + hasil);
                            break;
                        case "E-Wallet":
                            hasil = pembayaran.BayarEwallet(1, "E-Wallet", nominal, belanja);
                            labelResult.setText("Sisa Saldo: " + hasil);
                            break;
                        case "Credit Card":
                            hasil = pembayaran.BayarCreditCard(1, "Bank", "12/25", 123456, 123, nominal, belanja);
                            labelResult.setText("Sisa Limit: " + hasil);
                            break;
                        case "Debit Card":
                            hasil = pembayaran.BayarDebitCard(1, "Bank", "12/25", 123456, 123, nominal, belanja);
                            labelResult.setText("Sisa Saldo: " + hasil);
                            break;
                        default:
                            labelResult.setText("Metode tidak valid.");
                    }
                } catch (NumberFormatException ex) {
                    labelResult.setText("Input tidak valid.");
                } catch (IllegalArgumentException ex) {
                    labelResult.setText(ex.getMessage());
                }
            }
        });

        frame.setVisible(true);
    }
}