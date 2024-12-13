package BangunRuang;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BangunDatarApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplikasi Bangun Datar");
        frame.setSize(500, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JPanel panel = new JPanel(new GridLayout(0, 1));

        JLabel titleLabel = new JLabel("Pilih Bangun Datar", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
    
        panel.add(titleLabel);

        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Lingkaran", "Persegi", "Persegi Panjang", "Segitiga"});
        panel.add(comboBox);

        JTextField inputField1 = new JTextField(), inputField2 = new JTextField(), inputField3 = new JTextField(), inputField4 = new JTextField(), inputField5 = new JTextField(), inputField6 = new JTextField();
        JLabel inputLabel1 = new JLabel("Sisi :");
        JLabel inputLabel2 = new JLabel("Panjang :");
        JLabel inputLabel3 = new JLabel("Alas :");
        JLabel inputLabel4 = new JLabel("Tinggi :");
        JLabel inputLabel5 = new JLabel("Jari-jari :");
        JLabel inputLabel6 = new JLabel("Lebar :");
        panel.add(inputLabel1);
        panel.add(inputField1);
        panel.add(inputLabel2);
        panel.add(inputField2);
        panel.add(inputLabel3);
        panel.add(inputField3);
        panel.add(inputLabel4);
        panel.add(inputField4);
        panel.add(inputLabel5);
        panel.add(inputField5);
        panel.add(inputLabel6);
        panel.add(inputField6);

        JTextArea resultArea = new JTextArea(5, 20);
        resultArea.setEditable(false);
        panel.add(new JLabel("Hasil:"));
        panel.add(new JScrollPane(resultArea));

        JButton calculateButton = new JButton("Hitung");
        panel.add(calculateButton);
        

        
        comboBox.addActionListener(e -> {
    String selectedShape = (String) comboBox.getSelectedItem();
    
    inputLabel1.setVisible(false);
    inputField1.setVisible(false);
    inputLabel2.setVisible(false);
    inputField2.setVisible(false);
    inputLabel3.setVisible(false);
    inputField3.setVisible(false);
    inputLabel4.setVisible(false);
    inputField4.setVisible(false);
    inputLabel5.setVisible(false);
    inputField5.setVisible(false);
    inputLabel6.setVisible(false);
    inputField6.setVisible(false);
    
    switch (selectedShape) {
        case "Lingkaran":
            inputLabel5.setVisible(true);
            inputField5.setVisible(true);
            break;
        case "Persegi":
            inputLabel1.setVisible(true);
            inputField1.setVisible(true);
            break;
        case "Persegi Panjang":
            inputLabel2.setVisible(true);
            inputField2.setVisible(true);
            inputLabel6.setVisible(true);
            inputField6.setVisible(true);
            break;
        case "Segitiga":
            inputLabel3.setVisible(true);
            inputField3.setVisible(true);
            inputLabel4.setVisible(true);
            inputField4.setVisible(true);
            break;
    }
});
calculateButton.addActionListener(e -> {
    try {
        String selectedShape = (String) comboBox.getSelectedItem();
        double value1 = inputField1.isVisible() && !inputField1.getText().isEmpty()
                ? Double.parseDouble(inputField1.getText()) : 0;
        double value2 = inputField2.isVisible() && !inputField2.getText().isEmpty()
                ? Double.parseDouble(inputField2.getText()) : 0;
        double value3 = inputField3.isVisible() && !inputField3.getText().isEmpty()
                ? Double.parseDouble(inputField3.getText()) : 0;
        double value4 = inputField4.isVisible() && !inputField4.getText().isEmpty()
                ? Double.parseDouble(inputField4.getText()) : 0;
        double value5 = inputField5.isVisible() && !inputField5.getText().isEmpty()
                ? Double.parseDouble(inputField5.getText()) : 0;
        double value6 = inputField6.isVisible() && !inputField6.getText().isEmpty()
                ? Double.parseDouble(inputField6.getText()) : 0;

        BangunDatar shape;

        switch (selectedShape) {
            case "Lingkaran":
                shape = new Lingkaran(value5);
                break;
            case "Persegi":
                shape = new Persegi(value1);
                break;
            case "Persegi Panjang":
                shape = new PersegiPanjang(value2, value6);
                break;
            case "Segitiga":
                shape = new Segitiga(value3, value4);
                break;
            default:
                resultArea.setText("Pilih bangun datar yang valid.");
                return;
        }
        resultArea.setText("Luas: " + shape.hitungLuas() + "\nKeliling: " + shape.hitungKeliling());
    } catch (NumberFormatException ex) {
        resultArea.setText("Input tidak valid! Masukkan angka.");
    }
});
        
            panel.setBackground(Color.PINK);
            titleLabel.setForeground(Color.BLACK);
            inputLabel1.setForeground(Color.BLACK);
            inputLabel2.setForeground(Color.BLACK);
            inputLabel3.setForeground(Color.BLACK);
            inputLabel4.setForeground(Color.BLACK);
            inputLabel5.setForeground(Color.BLACK);
            inputLabel6.setForeground(Color.BLACK);
            resultArea.setBackground(Color.WHITE);
            resultArea.setForeground(Color.BLACK);
            comboBox.setBackground(Color.GRAY);
            comboBox.setForeground(Color.WHITE);
            calculateButton.setBackground(Color.DARK_GRAY);
            calculateButton.setForeground(Color.WHITE);

        frame.add(panel);
        frame.setVisible(true);
    }

    interface BangunDatar {
        double hitungLuas();
        double hitungKeliling();
    }

    static class Lingkaran implements BangunDatar {
        private final double jejari;

        Lingkaran(double jejari) {
            this.jejari = jejari;
        }

        public double hitungLuas() {
            return Math.PI * jejari * jejari;
        }

        public double hitungKeliling() {
            return 2 * Math.PI * jejari;
        }
    }

    static class Persegi implements BangunDatar {
        private final double sisi;

        Persegi(double sisi) {
            this.sisi = sisi;
        }

        public double hitungLuas() {
            return sisi * sisi;
        }

        public double hitungKeliling() {
            return 4 * sisi;
        }
    }

    static class PersegiPanjang implements BangunDatar {
        private final double panjang, lebar;

        PersegiPanjang(double panjang, double lebar) {
            this.panjang = panjang;
            this.lebar = lebar;
        }

        public double hitungLuas() {
            return panjang * lebar;
        }

        public double hitungKeliling() {
            return 2 * (panjang + lebar);
        }
    }

    static class Segitiga implements BangunDatar {
        private final double alas, tinggi;

        Segitiga(double alas, double tinggi) {
            this.alas = alas;
            this.tinggi = tinggi;
        }

        private double hitungSisiMiring() {
            return Math.sqrt(alas * alas + tinggi * tinggi);
        }

        public double hitungLuas() {
            return 0.5 * alas * tinggi;
        }

        public double hitungKeliling() {
            return alas + tinggi + hitungSisiMiring();
        }
    }
}
