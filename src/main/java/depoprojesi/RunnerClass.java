package depoprojesi;

import java.util.Scanner;

public class RunnerClass {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int secim;
        do {
        System.out.println("Dev market e hosgeldini. Lutfen yapmak istediginiz islemi seciniz\n" +
                "1) Urun Tanimlama\n" +
                "2) Urun Listele\n" +
                "3) Urun Girisi\n" +
                "4) Urun Cikisi\n" +
                "5) Urunu Rafa Koy\n" +
                "6) Cikis");

            secim = input.nextInt();

            switch (secim) {

                case 1: {
                    int devam;
                    do {
                        System.out.println("Lutfen urun tanimlamasi yapiniz (orn : 1000, Çikolata, Snickers, miktar, birim(kg), raf no)");
                        MethodClass.urunTanimla(input.nextInt(), input.next(), input.next(), input.nextDouble(), input.next(), input.next());
                        System.out.println("Urun girisine devam etmek icin 1 e basiniz");
                        devam = input.nextInt();
                    } while (devam == 1);

                    break;
                }
                case 2: {
                    MethodClass.urunListele();
                    break;
                }
                case 3: {
                    System.out.print("Lutfen miktarini degistirmek istediginiz urun ID sini daha sonra eklemek istediginiz miktari giriniz");
                    MethodClass.urunGirisi(input.nextInt(), input.nextDouble());
                    break;
                }
                case 4: {
                    System.out.print("Lutfen miktarini degistirmek istediginiz urun ID sini daha sonra eklemek istediginiz miktari giriniz");
                    try {
                        MethodClass.urunCikisi(input.nextInt(), input.nextDouble());
                    } catch (IllegalCallerException e) {
                        System.out.println("Listede olmayan urunden cikis yapamazsin");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Stokta belirtilen miktarda urun yoktur. Bu durumda urun cikisi gerceklestirilemez");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Koymak istediginiz urun ID si ile rafi seciniz");
                    int id = input.nextInt();
                    input.nextLine();
                    String raf = input.nextLine();
                    MethodClass.rafaKoy(id, raf);
                }
                case 6: {
                    System.out.println("Bizi tercih ettiginiz icin tesekkur ederiz. Yine bekleriz :)");
                    break;
                }
                default:
                    System.out.println("Hatali giris yaptiniz tekrar deneyiniz.");
            }

        } while (secim != 6);

    }


}
