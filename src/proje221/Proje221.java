
package proje221;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.TimerTask;
import java.util.logging.*;
import javax.swing.*;


class hucre {

    int satir;
    int sutun;
    int puan;
}

class Izgara extends JFrame {

    int x;

    Izgara(int x) {
        this.x = x;
        problem2(x);
    }

    Izgara() {
    }

    public void problem1(int urlsec) throws MalformedURLException, IOException {
        if (urlsec == 1) {
            URL url = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt");
            HttpURLConnection baglanti = (HttpURLConnection) url.openConnection();//url ile bağlantı kurmak için
            baglanti.setRequestMethod("GET");
            BufferedReader url_oku = new BufferedReader(new InputStreamReader(baglanti.getInputStream()));
            List<List<String>> url_string_matris = new ArrayList<>();
            String veri;
            while ((veri = url_oku.readLine()) != null) {
                String[] values = veri.split(",");
                url_string_matris.add(Arrays.asList(values));
            }
            url_oku.close();//url yolunu kapattık
            int[][] ham_matris = new int[url_string_matris.size()][url_string_matris.size()];//stringi integer a donusturdu
            int[][] matris = new int[ham_matris.length][ham_matris.length];
            for (int j = 0; j < url_string_matris.size(); j++) {
                int matris_satir = Integer.parseInt(url_string_matris.get(j).get(0));//stringi integera cevirdik
                int y = 0;
                while (matris_satir > 0) {//aldığımız matrisi birimlere parçaladık
                    ham_matris[j][y] = matris_satir % 10;//sonucu bolerek hammatrise atadı
                    y++;
                    matris_satir = matris_satir / 10;//tek tek rakam oldu
                }
            }
            for (int j = 0; j < matris.length; j++) {//ham matrisin simetrigini aldı
                for (int i = 0; i < ham_matris.length; i++) {
                    matris[j][matris.length - i - 1] = ham_matris[j][i];
                }
            }

//            int[][] matris = {
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 3, 3, 3, 0, 1},
//                {0, 3, 3, 3, 0, 3, 3, 3, 0, 0},
//                {0, 3, 3, 3, 0, 3, 3, 3, 0, 0},
//                {0, 3, 3, 3, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 2, 2, 0},
//                {0, 0, 3, 3, 3, 0, 0, 2, 2, 0},
//                {0, 0, 3, 3, 3, 0, 0, 0, 0, 0},
//                {0, 0, 3, 3, 3, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},};

            problem1_izgara(matris);
        } else if (urlsec == 2) {
//         URL url = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt");
//            HttpURLConnection baglanti = (HttpURLConnection) url.openConnection();//url ile bağlantı kurmak için
//            baglanti.setRequestMethod("GET");
//            BufferedReader url_oku = new BufferedReader(new InputStreamReader(baglanti.getInputStream()));
//            List<List<String>> url_string_matris = new ArrayList<>();
//            String veri;
//            while ((veri = url_oku.readLine()) != null) {
//                String[] values = veri.split(",");
//                url_string_matris.add(Arrays.asList(values));
//            }
//            url_oku.close();//url yolunu kapattık
//            int[][] ham_matris = new int[url_string_matris.size()][url_string_matris.size()];//stringi integer a donusturdu
//            int[][] matris = new int[ham_matris.length][ham_matris.length];
//            for (int j = 0; j < url_string_matris.size(); j++) {
//                int matris_satir = Integer.parseInt(url_string_matris.get(j).get(0));//stringi integera cevirdik
//                int y = 0;
//                while (matris_satir > 0) {//aldığımız matrisi birimlere parçaladık
//                    ham_matris[j][y] = matris_satir % 10;//sonucu bolerek hammatrise atadı
//                    y++;
//                    matris_satir = matris_satir / 10;//tek tek rakam oldu
//                }
//            }
//            for (int j = 0; j < matris.length; j++) {//ham matrisin simetrigini aldı
//                for (int i = 0; i < ham_matris.length; i++) {
//                    matris[j][matris.length - i - 1] = ham_matris[j][i];
//                }
//            }

            //Eger verilen matris çalışmıyorsa:
            int[][] matris = {
                {0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 1, 0, 0, 2, 2, 0, 0},
                {0, 3, 3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0},
                {0, 3, 3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0},
                {0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0},
                {0, 1, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 3, 3, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 0},
                {0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 3, 3, 3, 0},
                {0, 2, 2, 0, 3, 3, 3, 0, 0, 2, 2, 0, 0, 0, 0, 0, 3, 3, 3, 0},
                {0, 0, 0, 0, 3, 3, 3, 0, 0, 2, 2, 0, 0, 0, 0, 0, 3, 3, 3, 0},
                {0, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 2, 2, 0, 0, 3, 3, 3, 0},
                {3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 3, 3, 3, 0},
                {3, 3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {3, 3, 3, 0, 0, 0, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 3, 3, 3, 0, 0, 2, 2, 0, 0, 0, 0, 2, 2, 0},
                {0, 2, 2, 0, 0, 0, 0, 0, 1, 0, 0, 2, 2, 0, 0, 0, 0, 2, 2, 0},
                {0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0}};

            problem1_izgara(matris);
        }
    }

    public void problem1_izgara(int[][] matris_ic) {
        int[][] matris = new int[matris_ic.length + 2][matris_ic.length + 2];
        hucre giris = new hucre();
        hucre cikis = new hucre();
        Random r = new Random();
        for (int i = 0; i < matris.length; i++) {//dış duvarlar
            matris[0][i] = 9;
            matris[matris.length - 1][i] = 9;
            matris[i][0] = 9;
            matris[i][matris.length - 1] = 9;
        }

        for (int i = 0; i < matris_ic.length; i++) {//matirisi duvarin içine yerleştirme
            for (int j = 0; j < matris_ic.length; j++) {
                matris[i + 1][j + 1] = matris_ic[i][j];
            }
        }

        for (int i = 0; i < matris.length; i++) {//bastan sonra birkaç kez dondugumuzde çıkmaz yollardan geri donme etkisi verecek

            for (int satir = 0; satir < matris.length; satir++) {
                for (int sutun = 0; sutun < matris.length; sutun++) {
                    int puan9 = 0;
                    if (matris[satir][sutun] == 9) {

                        if (sutun == 0) {//eger ilk sutunsa giris olup olamayacaginin kontrolu
                            if (matris[satir][sutun + 1] == 1 || matris[satir][sutun] + 1 == 2 || matris[satir][sutun + 1] == 3) {
                                puan9++;
                            }
                        } else if (sutun == matris.length - 1) {//eger son sutunsa giris olup olamayacaginin kontrolu
                            if (matris[satir][sutun - 1] == 1 || matris[satir][sutun - 1] == 2 || matris[satir][sutun - 1] == 3) {
                                puan9++;
                            }
                        } else {

                        }
                        if (satir == 0) {
                            if (matris[satir + 1][sutun] == 1 || matris[satir + 1][sutun] == 2 || matris[satir + 1][sutun] == 3) {
                                puan9++;
                            }
                        } else if (satir == matris.length - 1) {
                            if (matris[satir - 1][sutun] == 1 || matris[satir - 1][sutun] == 2 || matris[satir - 1][sutun] == 3) {
                                puan9++;
                            }
                        } else {

                        }
                    }
                    if (puan9 != 0) {
                        matris[satir][sutun] = 8;
                    }
                }
            }
        }
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris.length; j++) {
                System.out.print(matris[i][j] + " ");

            }
            System.out.println("");

        }

        int g_kenar_sec = r.nextInt(4);//girisin kenari
        int g_sec = r.nextInt(matris.length);//girisin indexi
        int ç_kenar_sec = r.nextInt(3);//cikisin kenari
        int ç_sec = r.nextInt(matris.length);//cikisin indexi
        if (g_kenar_sec == 0) {//sag
            while (matris[g_sec][matris.length - 1] == 8 || g_sec == 0 || g_sec == matris.length - 1 || matris[g_sec][matris.length - 2] == 1 || matris[g_sec][matris.length - 2] == 2 || matris[g_sec][matris.length - 2] == 3) {
                g_sec = r.nextInt(matris.length);
            }
            matris[g_sec][matris.length - 1] = 7;//giris secildi
            matris[g_sec][matris.length - 2] = 7;
            giris.satir = g_sec;
            giris.sutun = matris.length - 2;
            //bundan sonraki ifler çıkış secmek için
            if (ç_kenar_sec == 0) {//sol
                while (matris[ç_sec][0] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[ç_sec][1] == 7 || matris[ç_sec][1] == 1 || matris[ç_sec][1] == 2 || matris[ç_sec][1] == 3) {//koseler secilmemeli
                    ç_sec = r.nextInt(matris.length);
                }
                matris[ç_sec][0] = 6;
                matris[ç_sec][1] = 6;
                cikis.satir = ç_sec;
                cikis.sutun = 1;
            }
            if (ç_kenar_sec == 1) {//ust
                while (matris[0][ç_sec] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[1][ç_sec] == 7 || matris[1][ç_sec] == 1 || matris[1][ç_sec] == 2 || matris[1][ç_sec] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[0][ç_sec] = 6;
                matris[1][ç_sec] = 6;
                cikis.satir = 1;
                cikis.sutun = ç_sec;
            }
            if (ç_kenar_sec == 2) {//alt
                while (matris[matris.length - 1][ç_sec] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[matris.length - 2][ç_sec] == 7 || matris[matris.length - 2][ç_sec] == 1 || matris[matris.length - 2][ç_sec] == 2 || matris[matris.length - 2][ç_sec] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[matris.length - 1][ç_sec] = 6;
                matris[matris.length - 2][ç_sec] = 6;
                cikis.satir = matris.length - 2;
                cikis.sutun = ç_sec;
            }

        }
        if (g_kenar_sec == 1) {//sol
            while (matris[g_sec][0] == 8 || g_sec == 0 || g_sec == matris.length - 1 || matris[g_sec][1] == 1 || matris[g_sec][1] == 2 || matris[g_sec][1] == 3) {
                g_sec = r.nextInt(matris.length);
            }
            matris[g_sec][0] = 7;
            matris[g_sec][1] = 7;
            if (ç_kenar_sec == 0) {//sag
                while (matris[ç_sec][matris.length - 1] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[ç_sec][matris.length - 2] == 7 || matris[ç_sec][matris.length - 2] == 1 || matris[ç_sec][matris.length - 2] == 2 || matris[ç_sec][matris.length - 2] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[ç_sec][matris.length - 1] = 6;
                matris[ç_sec][matris.length - 2] = 6;
                cikis.satir = ç_sec;
                cikis.sutun = matris.length - 2;

            }
            if (ç_kenar_sec == 1) {//ust
                while (matris[0][ç_sec] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[1][ç_sec] == 7 || matris[1][ç_sec] == 1 || matris[1][ç_sec] == 2 || matris[1][ç_sec] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[0][ç_sec] = 6;
                matris[1][ç_sec] = 6;
                cikis.satir = 1;
                cikis.sutun = ç_sec;

            }
            if (ç_kenar_sec == 2) {//alt
                while (matris[matris.length - 1][ç_sec] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[matris.length - 2][ç_sec] == 7 || matris[matris.length - 2][ç_sec] == 1 || matris[matris.length - 2][ç_sec] == 2 || matris[matris.length - 2][ç_sec] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[matris.length - 1][ç_sec] = 6;
                matris[matris.length - 2][ç_sec] = 6;
                cikis.satir = matris.length - 2;
                cikis.sutun = ç_sec;

            }

        }
        if (g_kenar_sec == 2) {//ust
            while (matris[0][g_sec] == 8 || g_sec == 0 || g_sec == matris.length - 1 || matris[1][g_sec] == 1 || matris[1][g_sec] == 2 || matris[1][g_sec] == 3) {
                g_sec = r.nextInt(matris.length);
            }
            matris[0][g_sec] = 7;
            matris[1][g_sec] = 7;
            giris.satir = 1;
            giris.sutun = g_sec;
            if (ç_kenar_sec == 0) {//sag
                while (matris[ç_sec][matris.length - 1] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[ç_sec][matris.length - 2] == 7 || matris[ç_sec][matris.length - 2] == 1 || matris[ç_sec][matris.length - 2] == 2 || matris[ç_sec][matris.length - 2] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[ç_sec][matris.length - 1] = 6;
                matris[ç_sec][matris.length - 2] = 6;
                cikis.satir = ç_sec;
                cikis.sutun = matris.length - 2;

            }
            if (ç_kenar_sec == 1) {//sol
                while (matris[ç_sec][0] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[ç_sec][1] == 7 || matris[ç_sec][1] == 1 || matris[ç_sec][1] == 2 || matris[ç_sec][1] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[ç_sec][0] = 6;
                matris[ç_sec][1] = 6;
                cikis.satir = ç_sec;
                cikis.sutun = 1;

            }
            if (ç_kenar_sec == 2) {//alt
                while (matris[matris.length - 1][ç_sec] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[matris.length - 2][ç_sec] == 7 || matris[matris.length - 2][ç_sec] == 1 || matris[matris.length - 2][ç_sec] == 2 || matris[matris.length - 2][ç_sec] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[matris.length - 1][ç_sec] = 6;
                matris[matris.length - 2][ç_sec] = 6;
                cikis.satir = matris.length - 2;
                cikis.sutun = ç_sec;

            }

        }
        if (g_kenar_sec == 3) {//alt
            while (matris[matris.length - 1][g_sec] == 8 || g_sec == 0 || g_sec == matris.length - 1 || matris[matris.length - 2][g_sec] == 1 || matris[matris.length - 2][g_sec] == 2 || matris[matris.length - 2][g_sec] == 3) {
                g_sec = r.nextInt(matris.length);
            }
            matris[matris.length - 1][g_sec] = 7;
            matris[matris.length - 2][g_sec] = 7;
            giris.satir = matris.length - 2;
            giris.sutun = g_sec;
            if (ç_kenar_sec == 0) {//sag
                while (matris[ç_sec][matris.length - 1] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[ç_sec][matris.length - 2] == 7 || matris[ç_sec][matris.length - 2] == 1 || matris[ç_sec][matris.length - 2] == 2 || matris[ç_sec][matris.length - 2] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[ç_sec][matris.length - 1] = 6;
                matris[ç_sec][matris.length - 2] = 6;
                cikis.satir = ç_sec;
                cikis.sutun = matris.length - 2;
            }
            if (ç_kenar_sec == 1) {//sol
                while (matris[ç_sec][0] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[ç_sec][1] == 7 || matris[ç_sec][1] == 1 || matris[ç_sec][1] == 2 || matris[ç_sec][1] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[ç_sec][0] = 6;
                matris[ç_sec][1] = 6;
                cikis.satir = ç_sec;
                cikis.sutun = 1;

            }
            if (ç_kenar_sec == 2) {//ust
                while (matris[0][ç_sec] == 8 || ç_sec == 0 || ç_sec == matris.length - 1 || matris[1][ç_sec] == 7 || matris[1][ç_sec] == 1 || matris[1][ç_sec] == 2 || matris[1][ç_sec] == 3) {
                    ç_sec = r.nextInt(matris.length);
                }
                matris[0][ç_sec] = 6;
                matris[1][ç_sec] = 6;
                cikis.satir = 1;
                cikis.sutun = ç_sec;
            }
        }
        System.out.println("SON");
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris.length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println("");
        }

        Frame p1gorsel = new p1gorsel(matris, cikis.satir, cikis.sutun, giris.satir, giris.sutun);
        JOptionPane.setRootFrame(p1gorsel);
    }

    static int[][] matris;

    public void problem2(int x) {
        Uygulama uygulama = new Uygulama();
        uygulama.setTitle("LABİRENT");
        uygulama.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uygulama.setSize(725, 800);
        JPanel graphicsPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics kareler) {
                super.paintComponent(kareler);
                kareler.translate(20, 100);
                for (int satir = 0; satir < x; satir++) {
                    for (int sutun = 0; sutun < x; sutun++) {
                        Color color;
                        color = Color.GRAY;
                        kareler.setColor(color);
                        kareler.fillRect(30 * sutun, 30 * satir, 30, 30);
                        kareler.setColor(Color.darkGray);
                        kareler.drawRect(30 * sutun, 30 * satir, 30, 30);
                    }
                }
            }
        };

        JButton buton_calistir = new JButton("Çalıştır");
        buton_calistir.setBounds(20, 15, 160, 50); // Set the button's location and size
        buton_calistir.addActionListener(new ActionListener() {
            int sayac = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                int buton = 1;
                try {
                    if (sayac == 0) {
                        matris = uygulama.problem2coz(x, buton);
                        sayac++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Izgara.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton buton_degistir = new JButton("Labirent Değiştir");
        buton_degistir.setBounds(270, 15, 160, 50); // Set the button's location and size
        buton_degistir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Problem 2");
                JPanel panel = new JPanel();

                JLabel label = new JLabel("Matris boyutunu giriniz.");
                JTextField textField = new JTextField(10);
                panel.add(label);
                panel.add(textField);

                int result = JOptionPane.showConfirmDialog(frame, panel, "Matris Boyutu", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    int inputInt = Integer.parseInt(textField.getText());
                    Izgara p2gorsel = new Izgara(inputInt);
                    JOptionPane.setRootFrame(p2gorsel);
                    uygulama.setVisible(false);
                } else {
                    System.out.println("Yanış veya hatalı değer girdiniz.");
                }
            }
        });

        JButton buton_sonuc = new JButton("Sonuç Göster");
        buton_sonuc.setBounds(520, 15, 160, 50); // Set the button's location and size
        buton_sonuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int buton = 3;
                Engel arayuz = new Engel(matris);
            }
        });
        uygulama.add(buton_calistir);
        uygulama.add(buton_degistir);
        uygulama.add(buton_sonuc);
        uygulama.add(graphicsPanel, BorderLayout.CENTER);
        uygulama.setVisible(true);
    }
}

class Uygulama extends JFrame {

    Uygulama(int[][] matris, int cikis_satir, int cikis_sutun, int giris_satir, int giris_sutun, int buton) throws IOException {
        Problem1_Cozum cozum = new Problem1_Cozum(matris, cikis_satir, cikis_sutun, giris_satir, giris_sutun, buton);
        if (cozum.Cozum()) {
            cozum.Ilerleme(buton);
        } else {
            System.out.println("Yol Bulunamadı");
        }
    }

    Uygulama() {
    }

    public int[][] bulutlama(int[][] bulutla, int[][] myap, int satir, int sutun, int buton, int hamle) {
        for (int i = 0; i < myap.length; i++) {
            for (int j = 0; j < myap.length; j++) {
                if (satir == i && sutun == j) {
                    if (i == 0) {
                        bulutla[i + 1][j] = myap[i + 1][j];

                    } else if (i == myap.length - 1) {
                        bulutla[i - 1][j] = myap[i - 1][j];

                    } else {
                        bulutla[i + 1][j] = myap[i + 1][j];
                        bulutla[i - 1][j] = myap[i - 1][j];

                    }
                    if (j == 0) {
                        bulutla[i][j + 1] = myap[i][j + 1];

                    } else if (j == myap.length - 1) {
                        bulutla[i][j - 1] = myap[i][j - 1];
                    } else {
                        bulutla[i][j + 1] = myap[i][j + 1];
                        bulutla[i][j - 1] = myap[i][j - 1];
                    }
                    bulutla[satir][sutun] = 2;
                    Robot robot2 = new Robot(bulutla, satir, sutun, buton, hamle);
                    hamle++;
                }
            }
        }

        return bulutla;

    }

    public int[][] cozum1(int[][] myap, int buton) throws IOException {
        Random r = new Random();
        List<String> yon = new ArrayList<>();
        String sag = "sag";
        String alt = "alt";
        for (int i = 0; i < myap.length - 3; i++) {
            yon.add(alt);
        }
        for (int i = 0; i < myap.length - 3; i++) {
            yon.add(sag);
        }
        System.out.println(yon + " " + yon.size());
        int bsatir = 1;//baslangic indexleri
        int bsutun = 1;
        hucre[] cozum = new hucre[yon.size() + 3];
        hucre basla = new hucre();
        hucre basla2 = new hucre();
        hucre bitis = new hucre();
        int csay = 0;
        basla.satir = 1;
        basla.sutun = 0;
        cozum[csay] = basla;

        csay++;
        basla2.satir = 1;
        basla2.sutun = 1;
        cozum[csay] = basla2;
        csay++;
        DosyaSil("Dosya2.txt");
        while (!yon.isEmpty()) {
            int index = r.nextInt(yon.size());
            if (yon.get(index).equals(sag)) {
                //System.out.println("sag");
                bsutun++;
                myap[bsatir][bsutun] = 0;

                hucre yoldevam = new hucre();
                yoldevam.satir = cozum[csay - 1].satir;
                yoldevam.sutun = cozum[csay - 1].sutun + 1;
                cozum[csay] = yoldevam;
                csay++;

            } else if (yon.get(index).equals(alt)) {
                //System.out.println("alt");
                bsatir++;
                myap[bsatir][bsutun] = 0;
                hucre yoldevam = new hucre();

                yoldevam.satir = cozum[csay - 1].satir + 1;
                yoldevam.sutun = cozum[csay - 1].sutun;
                cozum[csay] = yoldevam;
                csay++;
            }
            yon.remove(index);
        }
        for (int i = 0; i < myap.length; i++) {//bastan sonra birkaç kez dondugumuzde çıkmaz yollardan geri donme etkisi verecek
            for (int satir = 0; satir < myap.length; satir++) {
                for (int sutun = 0; sutun < myap.length; sutun++) {

                    if (myap[satir][sutun] == 0 || myap[satir][sutun] == 4) {//0 ların degerini degistirecegiz
                        int puan = 0;
                        if (sutun == 0) {//eger ilk sutunsa giris olup olamayacaginin kontrolu
                            if (myap[satir][sutun + 1] == 1 || myap[satir][sutun] + 1 == 2 || myap[satir][sutun + 1] == 3) {
                                puan++;
                            }
                        } else if (sutun == myap.length - 1) {//eger son sutunsa giris olup olamayacaginin kontrolu
                            if (myap[satir][sutun - 1] == 1 || myap[satir][sutun - 1] == 2 || myap[satir][sutun - 1] == 3) {
                                puan++;
                            }
                        } else {
                            if (myap[satir][sutun + 1] == 1 || myap[satir][sutun + 1] == 5 || myap[satir][sutun + 1] == 2 || myap[satir][sutun + 1] == 3 || myap[satir][sutun + 1] == 9) {
                                puan++;
                            }
                            if (myap[satir][sutun - 1] == 1 || myap[satir][sutun - 1] == 5 || myap[satir][sutun - 1] == 2 || myap[satir][sutun - 1] == 3 || myap[satir][sutun - 1] == 9) {
                                puan++;
                            }
                        }
                        if (satir == 0) {
                            if (myap[satir + 1][sutun] == 1 || myap[satir + 1][sutun] == 2 || myap[satir + 1][sutun] == 3) {
                                puan++;
                            }
                        } else if (satir == myap.length - 1) {
                            if (myap[satir - 1][sutun] == 1 || myap[satir - 1][sutun] == 2 || myap[satir - 1][sutun] == 3) {
                                puan++;
                            }
                        } else {
                            if (myap[satir + 1][sutun] == 1 || myap[satir + 1][sutun] == 5 || myap[satir + 1][sutun] == 2 || myap[satir + 1][sutun] == 3 || myap[satir + 1][sutun] == 9) {
                                puan++;
                            }
                            if (myap[satir - 1][sutun] == 1 || myap[satir - 1][sutun] == 5 || myap[satir - 1][sutun] == 2 || myap[satir - 1][sutun] == 3 || myap[satir - 1][sutun] == 9) {
                                puan++;
                            }
                        }
                        if (puan == 4) {
                            myap[satir][sutun] = 8;
                        }
                        if (puan == 3) {
                            myap[satir][sutun] = 5;
                        }
                    }
                }
            }
        }
        System.out.println("MYAP");
        for (int i = 0; i < myap.length; i++) {
            for (int j = 0; j < myap.length; j++) {
                System.out.print(myap[i][j] + " ");

            }
            System.out.println("");
        }
        hucre bitir = new hucre();
        bitir.satir = cozum[csay - 1].satir;
        bitir.sutun = cozum[csay - 1].sutun + 1;
        cozum[csay] = bitir;

        System.out.println("");
        for (int i = 0; i < cozum.length; i++) {
            System.out.println(cozum[i].satir + "," + cozum[i].sutun + " ");   // ÖNEMLİ !!!!
            DosyayaEkle((i + 1) + " - " + cozum[i].satir + "," + cozum[i].sutun + " ");
            DosyayaEkle("\n");
        }
        System.out.println("");

        for (int i = 0; i < myap.length; i++) {
            for (int j = 0; j < myap.length; j++) {
                System.out.print(myap[i][j] + " ");
            }
            System.out.println("");
        }

        hucre sondogru = new hucre();
        hucre robot = new hucre();
        Robot robot1 = new Robot();

        int[][] bulutla = new int[myap.length][myap.length];
        for (int i = 0; i < bulutla.length; i++) {
            for (int j = 0; j < bulutla.length; j++) {
                bulutla[i][j] = 9;
            }
        }

        int hamle = 0;
        for (int k = 0; k < cozum.length; k++) {
            robot.satir = cozum[k].satir;
            robot.sutun = cozum[k].sutun;
            for (int i = 0; i < myap.length; i++) {
                for (int j = 0; j < myap.length; j++) {
                    if (robot.satir == i && robot.sutun == j) {
                        if (i == 0) {
                            bulutla[i + 1][j] = myap[i + 1][j];

                        } else if (i == myap.length - 1) {
                            bulutla[i - 1][j] = myap[i - 1][j];

                        } else {
                            bulutla[i + 1][j] = myap[i + 1][j];
                            bulutla[i - 1][j] = myap[i - 1][j];
                        }
                        if (j == 0) {
                            bulutla[i][j + 1] = myap[i][j + 1];

                        } else if (j == myap.length - 1) {
                            bulutla[i][j - 1] = myap[i][j - 1];
                        } else {
                            bulutla[i][j + 1] = myap[i][j + 1];
                            bulutla[i][j - 1] = myap[i][j - 1];
                        }
                        bulutla[robot.satir][robot.sutun] = 4;
                        myap[i][j] = 4;
                    }
                }
            }
            Robot robot21 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
            hamle++;
            robot.satir = cozum[k].satir;
            robot.sutun = cozum[k].sutun;

            if (robot.satir > 1 && robot.sutun > 1 && robot.satir < myap.length - 1 && robot.sutun < myap.length - 1) {

                if (myap[robot.satir + 1][robot.sutun] == 5) {
                    robot.satir = robot.satir + 1;
                    robot.sutun = robot.sutun;
                    if (robot.satir > 1 && robot.sutun > 1 && robot.satir < myap.length - 1 && robot.sutun < myap.length - 1) {
                        if ((myap[robot.satir + 1][robot.sutun] == 6 || myap[robot.satir + 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun + 1] == 6 || myap[robot.satir][robot.sutun + 1] == 1) && (myap[robot.satir][robot.sutun - 1] == 6 || myap[robot.satir][robot.sutun - 1] == 1)) {
                            myap[robot.satir][robot.sutun] = 6;
                            bulutla[robot.satir][robot.sutun] = 6;

                            for (int i = 0; i < myap.length; i++) {
                                for (int j = 0; j < myap.length; j++) {
                                    if (robot.satir == i && robot.sutun == j) {
                                        if (i == 0) {
                                            bulutla[i + 1][j] = myap[i + 1][j];

                                        } else if (i == myap.length - 1) {
                                            bulutla[i - 1][j] = myap[i - 1][j];

                                        } else {
                                            bulutla[i + 1][j] = myap[i + 1][j];
                                            bulutla[i - 1][j] = myap[i - 1][j];
                                        }
                                        if (j == 0) {
                                            bulutla[i][j + 1] = myap[i][j + 1];

                                        } else if (j == myap.length - 1) {
                                            bulutla[i][j - 1] = myap[i][j - 1];
                                        } else {
                                            bulutla[i][j + 1] = myap[i][j + 1];
                                            bulutla[i][j - 1] = myap[i][j - 1];
                                        }
                                        myap[robot.satir][robot.sutun] = 6;
                                        bulutla[robot.satir][robot.sutun] = 6;

                                        Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                        myap[robot.satir][robot.sutun] = 6;
                                        bulutla[robot.satir][robot.sutun] = 6;
                                        if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                                            robot.satir = robot.satir - 1;
                                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                            hamle++;
                                        }

                                    }
                                }
                            }
                        } else {
                            myap[robot.satir + 1][robot.sutun] = 1;
                            bulutla[robot.satir + 1][robot.sutun] = 1;
                            myap[robot.satir][robot.sutun] = 6;
                            bulutla[robot.satir][robot.sutun] = 6;

                            bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                            myap[robot.satir][robot.sutun] = 6;
                            bulutla[robot.satir][robot.sutun] = 6;
                            if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                                robot.satir = robot.satir - 1;
                                Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                hamle++;
                            }

                        }
                    }
                } else if (myap[robot.satir - 1][robot.sutun] == 5) {
                    robot.satir = robot.satir - 1;
                    robot.sutun = robot.sutun;
                    if ((myap[robot.satir - 1][robot.sutun] == 6 || myap[robot.satir - 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun + 1] == 6 || myap[robot.satir][robot.sutun + 1] == 1) && (myap[robot.satir][robot.sutun - 1] == 6 || myap[robot.satir][robot.sutun - 1] == 1)) {
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        for (int i = 0; i < myap.length; i++) {
                            for (int j = 0; j < myap.length; j++) {
                                if (robot.satir == i && robot.sutun == j) {
                                    if (i == 0) {
                                        bulutla[i + 1][j] = myap[i + 1][j];

                                    } else if (i == myap.length - 1) {
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    } else {
                                        bulutla[i + 1][j] = myap[i + 1][j];
                                        bulutla[i - 1][j] = myap[i - 1][j];
                                    }
                                    if (j == 0) {
                                        bulutla[i][j + 1] = myap[i][j + 1];

                                    } else if (j == myap.length - 1) {
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    } else {
                                        bulutla[i][j + 1] = myap[i][j + 1];
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    }
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                    hamle++;
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                                        robot.satir = robot.satir + 1;
                                        Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                    }
                                }
                            }
                        }
                    } else {
                        myap[robot.satir - 1][robot.sutun] = 1;
                        bulutla[robot.satir - 1][robot.sutun] = 1;

                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                        hamle++;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                            robot.satir = robot.satir + 1;
                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                        }
                    }

                } else if (myap[robot.satir][robot.sutun + 1] == 5) {
                    robot.satir = robot.satir;
                    robot.sutun = robot.sutun + 1;
                    if ((myap[robot.satir - 1][robot.sutun] == 6 || myap[robot.satir - 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun + 1] == 6 || myap[robot.satir][robot.sutun + 1] == 1) && (myap[robot.satir + 1][robot.sutun] == 6 || myap[robot.satir + 1][robot.sutun] == 1)) {
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        for (int i = 0; i < myap.length; i++) {
                            for (int j = 0; j < myap.length; j++) {
                                if (robot.satir == i && robot.sutun == j) {
                                    if (i == 0) {
                                        bulutla[i + 1][j] = myap[i + 1][j];

                                    } else if (i == myap.length - 1) {
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    } else {
                                        bulutla[i + 1][j] = myap[i + 1][j];
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    }
                                    if (j == 0) {
                                        bulutla[i][j + 1] = myap[i][j + 1];

                                    } else if (j == myap.length - 1) {
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    } else {
                                        bulutla[i][j + 1] = myap[i][j + 1];
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    }
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                    hamle++;
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {
                                        robot.sutun = robot.sutun - 1;
                                        Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                    }
                                }
                            }
                        }

                    } else {

                        myap[robot.satir][robot.sutun + 1] = 1;
                        bulutla[robot.satir][robot.sutun + 1] = 1;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;

                        bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                        hamle++;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {

                            robot.sutun = robot.sutun - 1;
                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                        }
                    }

                } else if (myap[robot.satir][robot.sutun - 1] == 5) {
                    robot.satir = robot.satir;
                    robot.sutun = robot.sutun - 1;

                    if ((myap[robot.satir - 1][robot.sutun] == 6 || myap[robot.satir - 1][robot.sutun] - 1 == 1) && (myap[robot.satir + 1][robot.sutun] == 6 || myap[robot.satir + 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun - 1] == 6 || myap[robot.satir][robot.sutun - 1] == 1)) {
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        for (int i = 0; i < myap.length; i++) {
                            for (int j = 0; j < myap.length; j++) {
                                if (robot.satir == i && robot.sutun == j) {
                                    if (i == 0) {
                                        bulutla[i + 1][j] = myap[i + 1][j];

                                    } else if (i == myap.length - 1) {
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    } else {
                                        bulutla[i + 1][j] = myap[i + 1][j];
                                        bulutla[i - 1][j] = myap[i - 1][j];
                                    }
                                    if (j == 0) {
                                        bulutla[i][j + 1] = myap[i][j + 1];

                                    } else if (j == myap.length - 1) {
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    } else {
                                        bulutla[i][j + 1] = myap[i][j + 1];
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    }
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    myap[robot.satir][robot.sutun] = 6;
                                    Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                    hamle++;
                                    if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {

                                        myap[robot.satir][robot.sutun] = 6;
                                        bulutla[robot.satir][robot.sutun] = 6;
                                        robot.sutun = robot.sutun + 1;
                                        Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                    }
                                }
                            }
                        }
                    } else {

                        myap[robot.satir][robot.sutun - 1] = 1;
                        bulutla[robot.satir][robot.sutun - 1] = 1;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                        hamle++;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {

                            robot.sutun = robot.sutun + 1;
                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                        }
                    }
                }

            }

        }
        return bulutla;
    }

    public int[][] cozum2(int[][] myap, int buton) throws IOException {
        Random r = new Random();
        List<String> yon = new ArrayList<>();
        String sag = "sag";
        String ust = "ust";
        for (int i = 0; i < myap.length - 3; i++) {
            yon.add(ust);
        }
        for (int i = 0; i < myap.length - 3; i++) {
            yon.add(sag);
        }
        System.out.println(yon + " " + yon.size());
        int bsatir = myap.length - 2;//baslangic indexleri
        int bsutun = 1;
        hucre[] cozum = new hucre[yon.size() + 3];//4 lerin oldugu dizi
        hucre basla = new hucre();
        hucre basla2 = new hucre();
        hucre bitis = new hucre();
        
        int csay = 0;
        basla.satir = myap.length - 2;
        basla.sutun = 0;
        cozum[csay] = basla;
        csay++;
        
        basla2.satir = myap.length - 2;
        basla2.sutun = 1;
        cozum[csay] = basla2;
        csay++;
        DosyaSil("Dosya2.txt");
        while (!yon.isEmpty()) {
            int index = r.nextInt(yon.size());
            if (yon.get(index).equals(sag)) {
                bsutun++;
                myap[bsatir][bsutun] = 0;

                hucre yoldevam = new hucre();
                yoldevam.satir = cozum[csay - 1].satir;
                yoldevam.sutun = cozum[csay - 1].sutun + 1;
                cozum[csay] = yoldevam;
                csay++;

            } else if (yon.get(index).equals(ust)) {
                bsatir--;
                myap[bsatir][bsutun] = 0;
                hucre yoldevam = new hucre();

                yoldevam.satir = cozum[csay - 1].satir - 1;
                yoldevam.sutun = cozum[csay - 1].sutun;
                cozum[csay] = yoldevam;
                csay++;
            }
            yon.remove(index);
        }
        for (int i = 0; i < myap.length; i++) {//bastan sonra birkaç kez dondugumuzde çıkmaz yollardan geri donme etkisi verecek

            for (int satir = 0; satir < myap.length; satir++) {
                for (int sutun = 0; sutun < myap.length; sutun++) {

                    if (myap[satir][sutun] == 0 || myap[satir][sutun] == 4) {//0 ların degerini degistirecegiz
                        int puan = 0;
                        if (sutun == 0) {//eger ilk sutunsa giris olup olamayacaginin kontrolu
                            if (myap[satir][sutun + 1] == 1 || myap[satir][sutun] + 1 == 2 || myap[satir][sutun + 1] == 3) {
                                puan++;
                            }
                        } else if (sutun == myap.length - 1) {//eger son sutunsa giris olup olamayacaginin kontrolu
                            if (myap[satir][sutun - 1] == 1 || myap[satir][sutun - 1] == 2 || myap[satir][sutun - 1] == 3) {
                                puan++;
                            }
                        } else {
                            if (myap[satir][sutun + 1] == 1 || myap[satir][sutun + 1] == 5 || myap[satir][sutun + 1] == 2 || myap[satir][sutun + 1] == 3 || myap[satir][sutun + 1] == 9) {
                                puan++;
                            }
                            if (myap[satir][sutun - 1] == 1 || myap[satir][sutun - 1] == 5 || myap[satir][sutun - 1] == 2 || myap[satir][sutun - 1] == 3 || myap[satir][sutun - 1] == 9) {
                                puan++;
                            }
                        }
                        if (satir == 0) {
                            if (myap[satir + 1][sutun] == 1 || myap[satir + 1][sutun] == 2 || myap[satir + 1][sutun] == 3) {
                                puan++;
                            }
                        } else if (satir == myap.length - 1) {
                            if (myap[satir - 1][sutun] == 1 || myap[satir - 1][sutun] == 2 || myap[satir - 1][sutun] == 3) {
                                puan++;
                            }
                        } else {
                            if (myap[satir + 1][sutun] == 1 || myap[satir + 1][sutun] == 5 || myap[satir + 1][sutun] == 2 || myap[satir + 1][sutun] == 3 || myap[satir + 1][sutun] == 9) {
                                puan++;
                            }
                            if (myap[satir - 1][sutun] == 1 || myap[satir - 1][sutun] == 5 || myap[satir - 1][sutun] == 2 || myap[satir - 1][sutun] == 3 || myap[satir - 1][sutun] == 9) {
                                puan++;
                            }
                        }
                        if (puan == 4) {
                            myap[satir][sutun] = 8;
                        }
                        if (puan == 3) {
                            myap[satir][sutun] = 5;
                        }
                    }
                }
            }
        }
        hucre bitir = new hucre();
        bitir.satir = cozum[csay - 1].satir;
        bitir.sutun = cozum[csay - 1].sutun + 1;
        cozum[csay] = bitir;

        System.out.println("");
        for (int i = 0; i < cozum.length; i++) {
            System.out.println(cozum[i].satir + "," + cozum[i].sutun + " ");
            DosyayaEkle((i + 1) + " - " + cozum[i].satir + "," + cozum[i].sutun + " ");
            DosyayaEkle("\n");
        }
        System.out.println("");

        for (int i = 0; i < myap.length; i++) {
            for (int j = 0; j < myap.length; j++) {
                System.out.print(myap[i][j] + " ");
            }
            System.out.println("");
        }

        hucre robot = new hucre();

        int[][] bulutla = new int[myap.length][myap.length];

        for (int i = 0; i < bulutla.length; i++) {
            for (int j = 0; j < bulutla.length; j++) {
                bulutla[i][j] = 9;
            }
        }

        int hamle = 0;
        
        for (int k = 0; k < cozum.length; k++) {
            robot.satir = cozum[k].satir;
            robot.sutun = cozum[k].sutun;
            for (int i = 0; i < myap.length; i++) {
                for (int j = 0; j < myap.length; j++) {
                    if (robot.satir == i && robot.sutun == j) {
                        if (i == 0) {
                            bulutla[i + 1][j] = myap[i + 1][j];

                        } else if (i == myap.length - 1) {
                            bulutla[i - 1][j] = myap[i - 1][j];

                        } else {
                            bulutla[i + 1][j] = myap[i + 1][j];
                            bulutla[i - 1][j] = myap[i - 1][j];
                        }
                        if (j == 0) {
                            bulutla[i][j + 1] = myap[i][j + 1];

                        } else if (j == myap.length - 1) {
                            bulutla[i][j - 1] = myap[i][j - 1];
                        } else {
                            bulutla[i][j + 1] = myap[i][j + 1];
                            bulutla[i][j - 1] = myap[i][j - 1];
                        }
                        bulutla[robot.satir][robot.sutun] = 4;
                        myap[i][j] = 4;
                    }
                }
            }
            Robot robot21 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
            hamle++;
            robot.satir = cozum[k].satir;
            robot.sutun = cozum[k].sutun;

            if (robot.satir > 1 && robot.sutun > 1 && robot.satir < myap.length - 1 && robot.sutun < myap.length - 1) {

                if (myap[robot.satir + 1][robot.sutun] == 5) {
                    robot.satir = robot.satir + 1;
                    robot.sutun = robot.sutun;
                    if (robot.satir > 1 && robot.sutun > 1 && robot.satir < myap.length - 1 && robot.sutun < myap.length - 1) {
                        if ((myap[robot.satir + 1][robot.sutun] == 6 || myap[robot.satir + 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun + 1] == 6 || myap[robot.satir][robot.sutun + 1] == 1) && (myap[robot.satir][robot.sutun - 1] == 6 || myap[robot.satir][robot.sutun - 1] == 1)) {
                            myap[robot.satir][robot.sutun] = 6;
                            bulutla[robot.satir][robot.sutun] = 6;

                            for (int i = 0; i < myap.length; i++) {
                                for (int j = 0; j < myap.length; j++) {
                                    if (robot.satir == i && robot.sutun == j) {
                                        if (i == 0) {
                                            bulutla[i + 1][j] = myap[i + 1][j];

                                        } else if (i == myap.length - 1) {
                                            bulutla[i - 1][j] = myap[i - 1][j];

                                        } else {
                                            bulutla[i + 1][j] = myap[i + 1][j];
                                            bulutla[i - 1][j] = myap[i - 1][j];
                                        }
                                        if (j == 0) {
                                            bulutla[i][j + 1] = myap[i][j + 1];

                                        } else if (j == myap.length - 1) {
                                            bulutla[i][j - 1] = myap[i][j - 1];
                                        } else {
                                            bulutla[i][j + 1] = myap[i][j + 1];
                                            bulutla[i][j - 1] = myap[i][j - 1];
                                        }
                                        myap[robot.satir][robot.sutun] = 6;
                                        bulutla[robot.satir][robot.sutun] = 6;

                                        Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                        myap[robot.satir][robot.sutun] = 6;
                                        bulutla[robot.satir][robot.sutun] = 6;
                                        if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                                            robot.satir = robot.satir - 1;
                                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                            hamle++;
                                        }

                                    }
                                }
                            }
                        } else {
                            myap[robot.satir + 1][robot.sutun] = 1;
                            bulutla[robot.satir + 1][robot.sutun] = 1;
                            myap[robot.satir][robot.sutun] = 6;
                            bulutla[robot.satir][robot.sutun] = 6;
                            bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                            myap[robot.satir][robot.sutun] = 6;
                            bulutla[robot.satir][robot.sutun] = 6;
                            if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                                robot.satir = robot.satir - 1;
                                Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                hamle++;
                            }
                        }
                    }
                } else if (myap[robot.satir - 1][robot.sutun] == 5) {
                    robot.satir = robot.satir - 1;
                    robot.sutun = robot.sutun;
                    if ((myap[robot.satir - 1][robot.sutun] == 6 || myap[robot.satir - 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun + 1] == 6 || myap[robot.satir][robot.sutun + 1] == 1) && (myap[robot.satir][robot.sutun - 1] == 6 || myap[robot.satir][robot.sutun - 1] == 1)) {
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        for (int i = 0; i < myap.length; i++) {
                            for (int j = 0; j < myap.length; j++) {
                                if (robot.satir == i && robot.sutun == j) {
                                    if (i == 0) {
                                        bulutla[i + 1][j] = myap[i + 1][j];

                                    } else if (i == myap.length - 1) {
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    } else {
                                        bulutla[i + 1][j] = myap[i + 1][j];
                                        bulutla[i - 1][j] = myap[i - 1][j];
                                    }
                                    if (j == 0) {
                                        bulutla[i][j + 1] = myap[i][j + 1];

                                    } else if (j == myap.length - 1) {
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    } else {
                                        bulutla[i][j + 1] = myap[i][j + 1];
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    }
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                    hamle++;
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                                        robot.satir = robot.satir + 1;
                                        Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                    }
                                }
                            }
                        }
                    } else {
                        myap[robot.satir - 1][robot.sutun] = 1;
                        bulutla[robot.satir - 1][robot.sutun] = 1;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                        hamle++;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        if (robot.satir < bulutla.length - 1 && robot.satir > 1) {
                            robot.satir = robot.satir + 1;
                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                        }
                    }

                } else if (myap[robot.satir][robot.sutun + 1] == 5) {
                    robot.satir = robot.satir;
                    robot.sutun = robot.sutun + 1;
                    if ((myap[robot.satir - 1][robot.sutun] == 6 || myap[robot.satir - 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun + 1] == 6 || myap[robot.satir][robot.sutun + 1] == 1) && (myap[robot.satir + 1][robot.sutun] == 6 || myap[robot.satir + 1][robot.sutun] == 1)) {
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        for (int i = 0; i < myap.length; i++) {
                            for (int j = 0; j < myap.length; j++) {
                                if (robot.satir == i && robot.sutun == j) {
                                    if (i == 0) {
                                        bulutla[i + 1][j] = myap[i + 1][j];

                                    } else if (i == myap.length - 1) {
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    } else {
                                        bulutla[i + 1][j] = myap[i + 1][j];
                                        bulutla[i - 1][j] = myap[i - 1][j];
                                    }
                                    if (j == 0) {
                                        bulutla[i][j + 1] = myap[i][j + 1];

                                    } else if (j == myap.length - 1) {
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    } else {
                                        bulutla[i][j + 1] = myap[i][j + 1];
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    }
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                    hamle++;
                                    myap[robot.satir][robot.sutun] = 6;
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {
                                        robot.sutun = robot.sutun - 1;
                                        Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                    }
                                }
                            }
                        }

                    } else {
                        myap[robot.satir][robot.sutun + 1] = 1;
                        bulutla[robot.satir][robot.sutun + 1] = 1;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                        hamle++;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {

                            robot.sutun = robot.sutun - 1;
                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                        }
                    }

                } else if (myap[robot.satir][robot.sutun - 1] == 5) {
                    robot.satir = robot.satir;
                    robot.sutun = robot.sutun - 1;
                    if ((myap[robot.satir - 1][robot.sutun] == 6 || myap[robot.satir - 1][robot.sutun] - 1 == 1) && (myap[robot.satir + 1][robot.sutun] == 6 || myap[robot.satir + 1][robot.sutun] == 1) && (myap[robot.satir][robot.sutun - 1] == 6 || myap[robot.satir][robot.sutun - 1] == 1)) {
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        for (int i = 0; i < myap.length; i++) {
                            for (int j = 0; j < myap.length; j++) {
                                if (robot.satir == i && robot.sutun == j) {
                                    if (i == 0) {
                                        bulutla[i + 1][j] = myap[i + 1][j];

                                    } else if (i == myap.length - 1) {
                                        bulutla[i - 1][j] = myap[i - 1][j];

                                    } else {
                                        bulutla[i + 1][j] = myap[i + 1][j];
                                        bulutla[i - 1][j] = myap[i - 1][j];
                                    }
                                    if (j == 0) {
                                        bulutla[i][j + 1] = myap[i][j + 1];

                                    } else if (j == myap.length - 1) {
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    } else {
                                        bulutla[i][j + 1] = myap[i][j + 1];
                                        bulutla[i][j - 1] = myap[i][j - 1];
                                    }
                                    bulutla[robot.satir][robot.sutun] = 6;
                                    myap[robot.satir][robot.sutun] = 6;
                                    Robot robot2 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                    hamle++;
                                    if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {

                                        myap[robot.satir][robot.sutun] = 6;
                                        bulutla[robot.satir][robot.sutun] = 6;
                                        robot.sutun = robot.sutun + 1;
                                        Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                                        hamle++;
                                    }
                                }
                            }
                        }
                    } else {
                        myap[robot.satir][robot.sutun - 1] = 1;
                        bulutla[robot.satir][robot.sutun - 1] = 1;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        bulutla = bulutlama(bulutla, myap, robot.satir, robot.sutun, buton, hamle);
                        hamle++;
                        myap[robot.satir][robot.sutun] = 6;
                        bulutla[robot.satir][robot.sutun] = 6;
                        if (robot.sutun < bulutla.length - 1 && robot.sutun > 1) {
                            robot.sutun = robot.sutun + 1;
                            Robot robot22 = new Robot(bulutla, robot.satir, robot.sutun, buton, hamle);
                            hamle++;
                        }
                    }
                }
            }
        }
        return bulutla;
    }

    public int[][] problem2coz(int x, int buton) throws IOException {
        
        int[][] matris_yap = new int[x][x];
        Random r = new Random();
        for (int i = 0; i < matris_yap.length; i++) {
            for (int j = 0; j < matris_yap.length; j++) {
                matris_yap[i][j] = r.nextInt(2);
            }
        }
        
        System.out.println("");

        for (int i = 0; i < matris_yap.length; i++) {
            matris_yap[0][i] = 1;//ust duvar
            matris_yap[matris_yap.length - 1][i] = 1;//sağ duvar
        }
        for (int i = 2; i < matris_yap.length; i++) {
            matris_yap[i][0] = 1;//sol duvar
        }
        for (int i = 0; i < matris_yap.length - 2; i++) {
            matris_yap[i][matris_yap.length - 1] = 1;//alt duvar
        }

        int[] bas = {0, 1};
        int RNDbaslangic = r.nextInt(bas.length) + 0;
        int[][] matris = null;
        if (RNDbaslangic == bas[0]) {
            matris_yap[1][0] = 0;//giris;
            matris_yap[1][1] = 0;
            matris_yap[matris_yap.length - 2][matris_yap.length - 1] = 0;//cikis
            matris_yap[matris_yap.length - 2][matris_yap.length - 2] = 0;
            matris = cozum1(matris_yap, buton);
        }
        if (RNDbaslangic == bas[1]) {
            matris_yap[matris_yap.length - 2][0] = 0;//giris;
            matris_yap[matris_yap.length - 2][1] = 0;
            matris_yap[matris_yap.length - 4][matris_yap.length - 1] = 0;//cikis
            matris_yap[matris_yap.length - 4][matris_yap.length - 2] = 0;
            matris = cozum2(matris_yap, buton);
        }
        return matris;
    }

    private static void DosyayaEkle(String metin) throws IOException {

        File dosya = new File("Dosya2.txt");
        FileWriter yazici = new FileWriter(dosya, true);
        BufferedWriter yaz = new BufferedWriter(yazici);
        yaz.write(metin);
        yaz.close();

    }

    private static void DosyaSil(String metin) throws IOException {

        File f = new File(metin);
        if (!f.exists()) {
            System.out.println("Dosya bulunamadığından silinemedi");
        } else {
            f.delete(); // eğer dosyamız varsa.. // silme işlemi gerçekleştirir.
            System.out.println(f.getName() + " adlı dosya başarılı bir şekilde silinmiştir.");
        }
    }
}

class Problem1_Cozum {

    private int[][] matris;
    private boolean[][] gidildi;
    private int baslasatir, baslasutun, bitissatir, bitissutun;
    private Stack<int[]> yol = new Stack<>();
    int buton;

    public Problem1_Cozum(int[][] matris, int baslasatir, int baslasutun, int bitissatir, int bitissutun, int buton) {
        this.matris = matris;
        this.gidildi = new boolean[matris.length][matris[0].length];
        this.baslasatir = baslasatir;
        this.baslasutun = baslasutun;
        this.bitissatir = bitissatir;
        this.bitissutun = bitissutun;
        this.buton = buton;
    }

    public boolean Cozum() {

        yol.push(new int[]{baslasatir, baslasutun});
        while (!yol.isEmpty()) {
            int[] eleman = yol.peek();
            if (eleman[0] == bitissatir && eleman[1] == bitissutun) {
                return true;
            }
            gidildi[eleman[0]][eleman[1]] = true;
            if ((eleman[1] < matris[0].length - 1 && matris[eleman[0]][eleman[1] + 1] == 0 || eleman[1] < matris[0].length - 1 && matris[eleman[0]][eleman[1] + 1] == 4 || eleman[1] < matris[0].length - 1 && matris[eleman[0]][eleman[1] + 1] == 6 || eleman[1] < matris[0].length - 1 && matris[eleman[0]][eleman[1] + 1] == 7) && !gidildi[eleman[0]][eleman[1] + 1]) {
                yol.push(new int[]{eleman[0], eleman[1] + 1});
                continue;
            }
            if ((eleman[0] < matris.length - 1 && matris[eleman[0] + 1][eleman[1]] == 0 || eleman[0] < matris.length - 1 && matris[eleman[0] + 1][eleman[1]] == 4 || eleman[0] < matris.length - 1 && matris[eleman[0] + 1][eleman[1]] == 6 || eleman[0] < matris.length - 1 && matris[eleman[0] + 1][eleman[1]] == 7) && !gidildi[eleman[0] + 1][eleman[1]]) {
                yol.push(new int[]{eleman[0] + 1, eleman[1]});
                continue;
            }
            if ((eleman[0] > 0 && matris[eleman[0] - 1][eleman[1]] == 0 || eleman[0] > 0 && matris[eleman[0] - 1][eleman[1]] == 4 || eleman[0] > 0 && matris[eleman[0] - 1][eleman[1]] == 6 || eleman[0] > 0 && matris[eleman[0] - 1][eleman[1]] == 7) && !gidildi[eleman[0] - 1][eleman[1]]) {
                yol.push(new int[]{eleman[0] - 1, eleman[1]});
                continue;
            }
            if ((eleman[1] > 0 && matris[eleman[0]][eleman[1] - 1] == 0 || eleman[1] > 0 && matris[eleman[0]][eleman[1] - 1] == 4 || eleman[1] > 0 && matris[eleman[0]][eleman[1] - 1] == 6 || eleman[1] > 0 && matris[eleman[0]][eleman[1] - 1] == 7) && !gidildi[eleman[0]][eleman[1] - 1]) {
                yol.push(new int[]{eleman[0], eleman[1] - 1});
                continue;
            }
            yol.pop();
        }
        return false;
    }

    public void Ilerleme(int buton) throws IOException {

        int m = 0;
        int[][] bulutla = new int[matris.length][matris.length];

        for (int i = 0; i < bulutla.length; i++) {//tamamını bulutluyor
            for (int j = 0; j < bulutla.length; j++) {
                bulutla[i][j] = 9;
            }
        }
        int hamle = 0;
        DosyaSil("Dosya1.txt");
        int sonsatir=0;
        int sonsutun=0;
        while (!yol.isEmpty()) {
            int[] eleman = yol.pop();

            System.out.println(m + "(" + eleman[0] + ", " + eleman[1] + ")");
            DosyayaEkle(m + " - " + eleman[0] + ", " + eleman[1]);
            DosyayaEkle("\n");

            m++;
            System.out.println("");
            hamle++;

            for (int i = 0; i < matris.length; i++) {//ilerledikçe çevresini açıyor
                for (int j = 0; j < matris.length; j++) {
                    if (eleman[0] == i && eleman[1] == j) {
                        if (i == 0) {
                            bulutla[i + 1][j] = matris[i + 1][j];

                        } else if (i == matris.length - 1) {
                            bulutla[i - 1][j] = matris[i - 1][j];

                        } else {
                            bulutla[i + 1][j] = matris[i + 1][j];
                            bulutla[i - 1][j] = matris[i - 1][j];
                        }
                        if (j == 0) {
                            bulutla[i][j + 1] = matris[i][j + 1];
                        } else if (j == matris.length - 1) {
                            bulutla[i][j - 1] = matris[i][j - 1];
                        } else {
                            bulutla[i][j + 1] = matris[i][j + 1];
                            bulutla[i][j - 1] = matris[i][j - 1];
                        }
                        bulutla[eleman[0]][eleman[1]] = 4;
                        matris[i][j] = 4;
                    }
                }
            }

            for (int i = 0; i < bulutla.length; i++) {
                for (int j = 0; j < bulutla.length; j++) {
                    if (i == eleman[0] && j == eleman[1]) {
                        System.out.print("R ");
                    } else {
                        System.out.print(bulutla[i][j] + " ");
                    }

                }
                System.out.println("");
            }
            if (buton == 1) {
                Engel Arayuz1 = new Engel(bulutla, buton, hamle, eleman[0], eleman[1]);
            }
            sonsatir = eleman[0];
            sonsutun = eleman[1];

        }
        if (buton == 3) {
            Engel Arayuz11 = new Engel(bulutla, hamle, sonsatir, sonsutun);
        }
    }

    private static void DosyayaEkle(String metin) throws IOException {

        File dosya = new File("Dosya1.txt");
        FileWriter yazici = new FileWriter(dosya, true);
        BufferedWriter yaz = new BufferedWriter(yazici);
        yaz.write(metin);
        yaz.close();
    }

    private static void DosyaSil(String metin) throws IOException {
        File f = new File(metin);
        if (!f.exists()) {
            System.out.println("Dosya bulunamadığından silinemedi");
        } else {
            f.delete(); // eğer dosyamız varsa.. // silme işlemi gerçekleştirir.
            System.out.println(f.getName() + " adlı dosya başarılı bir şekilde silinmiştir.");
        }
    }
}

class p1gorsel extends JFrame {

    public static int sayac_url = 1;
    public int[][] labirent;
    static int[][] sonuc;
    static int hamle;

    public int[][] getmaze() {
        return labirent;
    }

    public void setmaze(int[][] maze) {
        this.labirent = maze;
    }

    public p1gorsel() {
    }

    p1gorsel(int[][] matris, int cikis_satir, int cikis_sutun, int giris_satir, int giris_sutun) {

        labirent = new int[matris.length][matris.length];
        for (int i = 0; i < matris.length; i++) {
            for (int j = 1; j < matris.length; j++) {
                labirent[i][j] = 9;
            }
        }
        setTitle("Problem 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(725, 800);

        JPanel kare_panel = new JPanel() {
            @Override
            public void paintComponent(Graphics kare) {
                super.paintComponent(kare);
                kare.translate(20, 50);
                for (int satir = 1; satir < labirent.length - 1; satir++) {
                    for (int sutun = 1; sutun < labirent[0].length - 1; sutun++) {
                        Color renk;
                        switch (labirent[satir][sutun]) {
                            case 9:
                                renk = Color.GRAY;
                                break;
                            default:
                                renk = Color.WHITE;
                        }
                        kare.setColor(renk);
                        kare.fillRect(30 * sutun, 30 * satir, 30, 30);
                        kare.setColor(Color.darkGray);
                        kare.drawRect(30 * sutun, 30 * satir, 30, 30);

                    }
                }
            }
        };
        
        JButton buton_calistir = new JButton("Çalıştır");
        buton_calistir.setBounds(20, 15, 160, 50);
        buton_calistir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int buton = 1;
                    Uygulama uygulama = new Uygulama(matris, cikis_satir, cikis_sutun, giris_satir, giris_sutun, buton);
                } catch (IOException ex) { 
                    Logger.getLogger(p1gorsel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Izgara matris_son = new Izgara();
        JButton buton_url = new JButton("URL Değiştir");
        buton_url.setBounds(270, 15, 160, 50); 
        buton_url.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sayac_url % 2 == 0) {
                    try {
                        matris_son.problem1(1);
                        sayac_url++;
                    } catch (IOException ex) {
                        Logger.getLogger(p1gorsel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        sayac_url++;
                        matris_son.problem1(2);
                    } catch (IOException ex) {
                        Logger.getLogger(p1gorsel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        JButton buton_sonuc = new JButton("Sonuç Göster");
        buton_sonuc.setBounds(520, 15, 160, 50); // Set the button's location and size
        buton_sonuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int buton = 3;
                    Uygulama uygulama = new Uygulama(matris, cikis_satir, cikis_sutun, giris_satir, giris_sutun, buton);
                } catch (IOException ex) {
                    Logger.getLogger(p1gorsel.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        add(buton_calistir);
        add(buton_url);
        add(buton_sonuc);
        add(kare_panel, BorderLayout.CENTER);
        setVisible(true);
    }
}

class Engel extends JFrame {

    int deger;
    String renk;

    Engel(int deger, String renk) {
    }

    Engel(int[][] bulutla, int buton, int hamle, int robotsatir, int robotsutun) {//çalıştır
        Frame Arayuz1 = new Arayuz1(bulutla, buton, hamle, robotsatir, robotsutun);

    }

    Engel(int[][] bulutla, int hamle, int robotsatir, int robotsutun) {//sonuc goster
        Frame Arayuz11 = new Arayuz1(bulutla, hamle, robotsatir, robotsutun);
    }

    Engel(int[][] matris) {
        Arayuz2 arayuz = new Arayuz2(matris);
    }
}

class Engel_1 extends Engel {

    Engel_1(int deger, String renk) {
        super(deger, renk);
        this.deger = 1;
        this.renk = "Sarı";
    }

}

class Engel_2 extends Engel {

    Engel_2(int deger, String renk) {
        super(deger, renk);
        this.deger = 2;
        this.renk = "Turuncu";
    }

}

class Engel_3 extends Engel {

    Engel_3(int deger, String renk) {
        super(deger, renk);
        this.deger = 3;
        this.renk = "Kırmızı";
    }
}

class Arayuz1 extends JFrame {

    static int hamle;
    static int robotsatir;
    static int robotsutun;
    public int[][] matris;

    public int[][] getmaze() {
        return matris;
    }

    public void setmaze(int[][] maze) {
        this.matris = maze;
    }

    public Arayuz1() {
    }

    Arayuz1(int[][] matrisic, int buton, int hamle, int robotsatir, int robotsutun) {

        this.hamle = hamle;
        this.robotsatir = robotsatir;
        this.robotsutun = robotsutun;
        matris = new int[matrisic.length][matrisic.length];
        for (int i = 0; i < matrisic.length; i++) {
            for (int j = 0; j < matrisic.length; j++) {
                matris[i][j] = matrisic[i][j];
                if (matrisic[i][j] == 7) {
                    if (i == 0) {
                        matris[i + 1][j] = 7;
                    }
                    if (matris.length - 1 == i) {
                        matris[i - 1][j] = 7;
                    }
                    if (j == 0) {
                        matris[i][j + 1] = 7;
                    }
                    if (matris.length - 1 == j) {
                        matris[i][j - 1] = 7;
                    }
                }
            }
        }
        matris[robotsatir][robotsutun] = 10;
        this.setTitle(hamle + ". Hamle");
        this.setSize(725, 800);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setBounds(750, 0, 750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

//        Timer timer = new Timer();
//        TimerTask t = new TimerTask() {
//            public void run() {
//                setVisible(true);
//            }
//        };timer.schedule(t, 0, 5000);
    }

    Arayuz1(int[][] matrisic, int hamle, int robotsatir, int robotsutun) {
        matris = new int[matrisic.length][matrisic.length];
        this.robotsatir = robotsatir;
        this.robotsutun = robotsutun;
        for (int i = 0; i < matrisic.length; i++) {
            for (int j = 0; j < matrisic.length; j++) {
                matris[i][j] = matrisic[i][j];
                if (matrisic[i][j] == 7) {
                    if (i == 0) {
                        matris[i + 1][j] = 7;
                    }
                    if (matris.length - 1 == i) {
                        matris[i - 1][j] = 7;
                    }
                    if (j == 0) {
                        matris[i][j + 1] = 7;
                    }
                    if (matris.length - 1 == j) {
                        matris[i][j - 1] = 7;
                    }
                }
            }
        }
        matris[robotsatir][robotsutun] = 10;
        this.setTitle(hamle + " Hamle");
        this.setSize(725, 800);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setBounds(400, 100, 750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics kareler) {
        super.paint(kareler);
        kareler.translate(20, 50);
        for (int satir = 1; satir < matris.length - 1; satir++) {
            for (int sutun = 1; sutun < matris[0].length - 1; sutun++) {
                Color renk;
                switch (matris[satir][sutun]) {
                    case 0:
                        renk = Color.WHITE;
                        break;
                    case 1:
                        renk = Color.YELLOW;
                        break;
                    case 2:
                        renk = Color.ORANGE;
                        break;
                    case 3:
                        renk = Color.RED;
                        break;
                    case 4:
                        renk = Color.CYAN;
                        break;
                    case 6:
                        renk = Color.BLACK;
                        break;
                    case 7:
                        renk = Color.GREEN;
                        break;
                    case 8:
                        renk = Color.GRAY;
                        break;
                    case 9:
                        renk = Color.GRAY;
                        break;
                    case 10:
                        renk = Color.BLUE;
                        break;
                    default:
                        renk = Color.WHITE;
                }
                kareler.setColor(renk);
                if (matris[satir][sutun] == 10) {
                    kareler.fillOval(30 * sutun, 30 * satir, 30, 30);

                } else {
                    kareler.fillRect(30 * sutun, 30 * satir, 30, 30);
                }
                kareler.setColor(Color.darkGray);
                kareler.drawRect(30 * sutun, 30 * satir, 30, 30);

            }
        }
    }

}

class Arayuz2 extends JFrame {

    static int hamle;
    public int[][] matris;
    static int robotsatir;
    static int robotsutun;
    int buton;

    public int[][] getmaze() {
        return matris;
    }

    public void setmaze(int[][] maze) {
        this.matris = maze;
    }

    public Arayuz2() {
    }

    Arayuz2(int[][] matrisic, int robotsatir, int robotsutun, int buton, int hamle) {
        matris = new int[matrisic.length][matrisic.length];
        this.robotsatir = robotsatir;
        this.robotsutun = robotsutun;
        this.hamle = hamle;

        for (int i = 0; i < matrisic.length; i++) {
            for (int j = 0; j < matrisic.length; j++) {
                matris[i][j] = matrisic[i][j];
                if (matrisic[i][j] == 7) {
                    if (i == 0) {
                        matris[i + 1][j] = 7;
                    }
                    if (matris.length - 1 == i) {
                        matris[i - 1][j] = 7;
                    }
                    if (j == 0) {
                        matris[i][j + 1] = 7;
                    }
                    if (matris.length - 1 == j) {
                        matris[i][j - 1] = 7;
                    }
                }
            }
        }
        matris[robotsatir][robotsutun] = 3;
        this.setTitle(hamle + ". Hamle");
        this.setSize(725, 800);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setBounds(750, 0, 750, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    Arayuz2(int[][] matrisic) {
        matris = new int[matrisic.length][matrisic.length];

        for (int i = 0; i < matrisic.length; i++) {
            for (int j = 0; j < matrisic.length; j++) {
                matris[i][j] = matrisic[i][j];
            }
        }
        this.setTitle(hamle + " Hamle");
        this.setSize(725, 800);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setBounds(400, 100, 750, 800);
        setVisible(true);
    }

    @Override
    public void paint(Graphics kareler) {
        super.paint(kareler);
        kareler.translate(20, 50);
        for (int satir = 0; satir < matris.length; satir++) {
            for (int sutun = 0; sutun < matris.length; sutun++) {
                Color color;

                switch (matris[satir][sutun]) {
                    case 0:
                        color = Color.WHITE;
                        break;
                    case 1:
                        color = Color.YELLOW;
                        break;
                    case 3:
                        color = Color.BLUE;
                        break;
                    case 4:
                        color = Color.CYAN;
                        break;
                    case 5:
                        color = Color.WHITE;
                        break;
                    case 6:
                        color = Color.RED;
                        break;
                    case 7:
                        color = Color.GREEN;
                        break;
                    case 8:
                        color = Color.GRAY;
                        break;
                    case 9:
                        color = Color.GRAY;
                        break;
                    default:
                        color = Color.WHITE;
                }
                kareler.setColor(color);
                if (matris[satir][sutun] == 3) {
                    kareler.fillOval(30 * sutun, 30 * satir, 30, 30);

                } else {
                    kareler.fillRect(30 * sutun, 30 * satir, 30, 30);
                }
                kareler.setColor(Color.darkGray);
                kareler.drawRect(30 * sutun, 30 * satir, 30, 30);
            }
        }
    }
}

class Robot {
    Robot() {
        System.out.println("");
        System.out.println("Robot labirente yerlestirildi.");
    }
    Robot(int[][] bulutla, int satir, int sutun, int buton,int hamle) {
        hucre robot = new hucre();
        for (int i = 0; i < bulutla.length; i++) {
            for (int j = 0; j < bulutla.length; j++) {
                if (i ==satir && j == sutun) {
                    System.out.print("R ");
                    if (buton == 1) {
                        Frame Arayuz2 = new Arayuz2(bulutla, satir, sutun, buton, hamle);
                        JOptionPane.setRootFrame(Arayuz2);
                    }
                } else {
                    System.out.print(bulutla[i][j] + " ");
                }
            }
            System.out.println("");
        }
        int hamle2=hamle;
        if (buton == 3) {
            Frame Arayuz2 = new Arayuz2(bulutla, robot.satir, robot.sutun, buton, hamle2);
            JOptionPane.setRootFrame(Arayuz2);
        }
    }
}

public class Proje221 extends JFrame {

    public static void main(String[] args) throws IOException {
        Engel_1 engel1 = new Engel_1(1, "engel");
        Engel_2 engel2 = new Engel_2(2, "engel");
        Engel_3 engel3 = new Engel_3(3, "engel");
        System.out.println("Bilgilendirme:");
        System.out.println("1x1 tipindeki engeller için renk ve değer bilgileri:"+engel1.renk+", "+engel1.deger);
        System.out.println("2x2 tipindeki engeller için renk ve değer bilgileri:"+engel2.renk+", "+engel2.deger);
        System.out.println("3x3 tipindeki engeller için renk ve değer bilgileri:"+engel3.renk+", "+engel3.deger);

        JFrame ekran = new JFrame();
        ekran.setTitle("Labirent");
        ekran.setSize(500, 100);
        ekran.setLocation(500, 300);
        ekran.getContentPane().setLayout(new FlowLayout());
        JLabel label1 = new JLabel();
        label1.setText("Seçim yapınız.");
        JButton buton1 = new JButton("Problem 1");
        JButton buton2 = new JButton("Problem 2");
        buton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Izgara problem1_izgara = new Izgara();
                    problem1_izgara.problem1(1);
                } catch (IOException ex) {
                    Logger.getLogger(Proje221.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        buton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Problem 2");
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Matris boyutunu giriniz.");
                JTextField textField = new JTextField(10);
                panel.add(label);
                panel.add(textField);
                int girdi = JOptionPane.showConfirmDialog(frame, panel, "Matris Boyutu", JOptionPane.OK_CANCEL_OPTION);
                if (girdi == JOptionPane.OK_OPTION) {
                    int matris_boyutu = Integer.parseInt(textField.getText());
                    Izgara Arayuz2 = new Izgara(matris_boyutu);
                    JOptionPane.setRootFrame(Arayuz2);
                } else {
                    System.out.println("Yanış veya hatalı değer girdiniz.");
                }
            }
        });
        ekran.add(label1);
        ekran.add(buton1);
        ekran.add(buton2);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ekran.setResizable(false);
        ekran.setVisible(true);
    }
}

