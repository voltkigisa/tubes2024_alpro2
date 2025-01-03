package record;

public class Barang {
    int iIdBarang, iJumlahStok;
    double dHarga;
    String sNamaBarang, sMerek, sKategori, sTanggalKadaluarsa;

    Barang() {

    }

    public Barang(int iIdBarang, String sNamaBarang, String sMerek, String sKategori, double dHarga,
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

    // Method untuk parsing dari string
    public static Barang fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 7) {
            throw new IllegalArgumentException("Format data tidak valid");
        }
        int idBarang = Integer.parseInt(parts[0]);
        String namaBarang = parts[1].replace("\"", "");
        String merek = parts[2].replace("\"", "");
        String kategori = parts[3].replace("\"", "");
        double harga = Double.parseDouble(parts[4]);
        int stok = Integer.parseInt(parts[5]);
        String tanggalKadaluarsa = parts[6].replace("\"", "");

        return new Barang(idBarang, namaBarang, merek, kategori, harga, stok, tanggalKadaluarsa);
    }

    @Override
    public String toString() {
        return iIdBarang + ",\"" + sNamaBarang + "\",\"" + sMerek + "\",\"" + sKategori + "\"," + dHarga + ","
                + iJumlahStok + ",\"" + sTanggalKadaluarsa + "\"";
    }
}