import java.util.Scanner;

public class recordBarang {
    int iIdBarang, iJumlahStok;
    double dHarga;
    String sNamaBarang, sMerek, sKategori, sTanggalKadaluarsa;

    recordBarang() {

    }

    public recordBarang(int iIdBarang, String sNamaBarang, String sMerek, String sKategori, double dHarga,
            int iJumlahStok, String sTanggalKadaluarsa) {
        this.iIdBarang = iIdBarang;
        this.iJumlahStok = iJumlahStok;
        this.dHarga = dHarga;
        this.sNamaBarang = sNamaBarang;
        this.sMerek = sMerek;
        this.sKategori = sKategori;
        this.sTanggalKadaluarsa = sTanggalKadaluarsa;
    }

    public int getiIdBarang() {
        return iIdBarang;
    }

    public void setiIdBarang(int iIdBarang) {
        this.iIdBarang = iIdBarang;
    }

    public int getiJumlahStok() {
        return iJumlahStok;
    }

    public void setiJumlahStok(int iJumlahStok) {
        this.iJumlahStok = iJumlahStok;
    }

    public double getdHarga() {
        return dHarga;
    }

    public void setdHarga(double dHarga) {
        this.dHarga = dHarga;
    }

    public String getsNamaBarang() {
        return sNamaBarang;
    }

    public void setsNamaBarang(String sNamaBarang) {
        this.sNamaBarang = sNamaBarang;
    }

    public String getsMerek() {
        return sMerek;
    }

    public void setsMerek(String sMerek) {
        this.sMerek = sMerek;
    }

    public String getsKategori() {
        return sKategori;
    }

    public void setsKategori(String sKategori) {
        this.sKategori = sKategori;
    }

    public String getsTanggalKadaluarsa() {
        return sTanggalKadaluarsa;
    }

    public void setsTanggalKadaluarsa(String sTanggalKadaluarsa) {
        this.sTanggalKadaluarsa = sTanggalKadaluarsa;
    }

    public void inputBarang() {
        Scanner sc = new Scanner(System.in);
        System.out.print("id barang: ");
        iIdBarang = sc.nextInt();
        System.out.print("Nama barang: ");
        sNamaBarang = sc.next();
        System.out.print("Merek barang: ");
        sMerek = sc.next();
        System.out.print("Kategori barang: ");
        sKategori = sc.next();
        System.out.print("Harga barang: ");
        dHarga = sc.nextDouble();
        System.out.print("Jumlah barang di stok: ");
        iJumlahStok = sc.nextInt();
        System.out.print("Tanggal barang kadaluarsa: ");
        sTanggalKadaluarsa = sc.next();
        sc.close();
    }

    public void tampilBarang() {
        System.out.println("id:" + iIdBarang + ", Nama:" + sNamaBarang + ", Merek" + sMerek + ", Kategori:" + sKategori
                + ", Harga:" + dHarga + ", Stok:" + iJumlahStok + ", TanggalKadaluarsa:" + sTanggalKadaluarsa);
    }

    public static void main(String[] args) {
        recordBarang A = new recordBarang();
        A.inputBarang();
        A.tampilBarang();
    }
}