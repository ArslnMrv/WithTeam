package depoprojesi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MethodClass {
    public static Scanner input = new Scanner(System.in);
    static HashMap<Integer, PojoClass> idUrunler = new HashMap<>();
    static List<PojoClass> urunListesi = new ArrayList<>();

    public static void urunTanimla(int id, String urunIsmi, String uretici, double miktar, String birim, String raf) {
        PojoClass urun = new PojoClass(id, urunIsmi, uretici, miktar, birim, raf);
        idUrunler.put(id, urun);
        System.out.println(id + " No'lu " + urun.getUrunIsmi() + " urununun ID'si tanimlanmistir");
        urunListesi.add(urun);


    }

    public static void urunListele() {

        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s", "|Urun ID|", "|Urun Ismi|", "|Uretici|", "|Miktar|", "|Birim|", "|Raf|");
        System.out.println("\n--------------------------------------------------------------------------------");
        for (PojoClass w : urunListesi) {
            System.out.printf("%-15d %-15s %-15s %-15s %-15s %-15s",
                    w.getId(), w.getUrunIsmi(), w.getUretici(), w.getMiktar(), w.getBirim(), w.getRaf());
            System.out.println();
        }

    }

    public static void urunGirisi(int id, double miktar) {

        if (idUrunler.containsKey(id)) {

            idUrunler.get(id).setMiktar(idUrunler.get(id).getMiktar() + miktar);

        } else {

            System.out.println("Bu ID:" + id + " urun listesinde yoktur. Urun tanimlama bolumunden ekleme yapabilirsiniz");

        }
        urunListele();

    }

    public static void urunCikisi(int id, double miktar) {

        if (!idUrunler.containsKey(id)) {
            throw new IllegalCallerException("Listede olmayan urunden cikis yapamazsin");

        } else if (idUrunler.get(id).getMiktar() < miktar) {

            throw new IllegalArgumentException("Stokta belirtilen miktarda urun yoktur. Bu durumda urun cikisi gerceklestirilemez");


        } else {

            idUrunler.get(id).setMiktar(idUrunler.get(id).getMiktar() - miktar);

        }
        urunListele();

    }

    public static void rafaKoy(int id, String raf) {

        if (idUrunler.containsKey(id)) {

            idUrunler.get(id).setRaf(raf);
            System.out.println("Urununuz " + raf + "a yerlestirildi");
            urunListele();

        } else {

            System.out.println("Bu ID:" + id + " urun listesinde yoktur. Urun tanimlama bolumunden ekleme yapabilirsiniz");

        }
    }
}





