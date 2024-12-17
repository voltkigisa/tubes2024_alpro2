package tubes2024_alpro2;

public class recordBarang {
    int iIdBarang, iHarga, iJumlahStok;
    String sNamaBarang, sMerek, sKategori, sTanggalKadaluarsa;

    public Barang(int iIdBarang, int iHarga, int iJumlahStok, String sNamaBarang, String sMerek, String sKategori,
            String sTanggalKadaluarsa) {
        this.iIdBarang = iIdBarang;
        this.iHarga = iHarga;
        this.iJumlahStok = iJumlahStok;
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

    public int getiHarga() {
        return iHarga;
    }

    public void setiHarga(int iHarga) {
        this.iHarga = iHarga;
    }

    public int getiJumlahStok() {
        return iJumlahStok;
    }

    public void setiJumlahStok(int iJumlahStok) {
        this.iJumlahStok = iJumlahStok;
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

}
