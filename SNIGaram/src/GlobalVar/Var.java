/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalVar;

import ProsesTeknik.BarangTeknik;
import LaporanLab.*;
import File.*;
import LaporanProduksi.LaporanProduksi;
import List.*;
import ProsesLab.*;
import ProsesTeknik.Pemeliharaan;

/**
 *
 * @author richk
 */
public class Var {

    public static Login login;
    public static TambahUser tambahUser;
    public static ResetPasswordUser resetPasswordUser;
    public static GantiPassword gantiPassword;

    public static List listPengujianProdukJadi, listPengujianBahanBaku, listBarangTeknik, listPemeliharaan;
    
    public static BarangTeknik tambahBarangTeknik, ubahBarangTeknik;
    public static Pemeliharaan tambahPemeliharaan, ubahPemeliharaan;
    
    public static PengujianProdukJadi tambahPengujianProdukJadi, ubahPengujianProdukJadi;
    public static PengujianBahanBaku tambahPengujianBahanBaku, ubahPengujianBahanBaku;
    
    public static LaporanLab laporanPengujianProdukJadi, laporanPengujianBahanBaku;
    public static LaporanProduksi laporanIndentifikasiProdukJadi, laporanPenyerahanProdukJadi, laporanDataProduksi;
}
