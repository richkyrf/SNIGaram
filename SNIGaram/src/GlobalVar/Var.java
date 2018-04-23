/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GlobalVar;

import LaporanLab.LaporanLab;
import File.*;
import List.*;
import ProsesLab.*;

/**
 *
 * @author richk
 */
public class Var {

    public static Login login;
    public static TambahUser tambahUser;
    public static ResetPasswordUser resetPasswordUser;
    public static GantiPassword gantiPassword;

    public static List listPengujianProdukJadi, listPengujianBahanBaku;
    
    public static PengujianProdukJadi tambahPengujianProdukJadi, ubahPengujianProdukJadi;
    public static PengujianBahanBaku tambahPengujianBahanBaku, ubahPengujianBahanBaku;
    
    public static LaporanLab laporanPengujianProdukJadi, laporanPengujianBahanBaku;
}
