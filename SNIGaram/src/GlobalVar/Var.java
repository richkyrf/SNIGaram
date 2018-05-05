/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalVar;

import ProsesTeknik.BarangTeknik;
import LaporanLab.*;
import File.*;
import LaporanPersonalia.LaporanPersonalia;
import LaporanProduksi.LaporanProduksi;
import LaporanTeknik.LaporanTeknik;
import List.*;
import ProsesLab.*;
import ProsesPemasran.*;
import ProsesPemasran.SurveyKepuasanPelanggan;
import ProsesPersonalia.KebutuhanKaryawan;
import ProsesTeknik.*;

/**
 *
 * @author richk
 */
public class Var {

    public static Login login;
    public static TambahUser tambahUser;
    public static ResetPasswordUser resetPasswordUser;
    public static GantiPassword gantiPassword;

    public static List listPengujianProdukJadi, listPengujianBahanBaku, listBarangTeknik, listPemeliharaan, listPengaduanPelanggan, listSurveyKepuasanPelanggan, listDataPenjualan, listKebutuhanKaryawan;
    
    public static BarangTeknik tambahBarangTeknik, ubahBarangTeknik;
    public static Pemeliharaan tambahPemeliharaan, ubahPemeliharaan;

    public static PengujianProdukJadi tambahPengujianProdukJadi, ubahPengujianProdukJadi;
    public static PengujianBahanBaku tambahPengujianBahanBaku, ubahPengujianBahanBaku;
    public static SurveyKepuasanPelanggan tambahSurveyKepuasanPelanggan, ubahSurveyKepuasanPelanggan;
    public static PengaduanPelanggan tambahPengaduanPelanggan, ubahPengaduanPelanggan;

    public static KebutuhanKaryawan tambahKebutuhanKaryawan, ubahKebutuhanKaryawan;
    
    public static LaporanLab laporanPengujianProdukJadi, laporanPengujianBahanBaku;
    public static LaporanTeknik laporanDaftarPeralatan, laporanPemeliharaan;
    public static LaporanProduksi laporanBahanBakuBahanPenolong, laporanPersediaanBarang, laporanIndentifikasiProdukJadi, laporanPenyerahanProdukJadi, laporanOrderPesanan, laporanDataProduksi;
    public static LaporanPersonalia laporanKebutuhanKaryawan;
}
