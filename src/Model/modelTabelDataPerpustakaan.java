/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author L E N O V O
 */
public class modelTabelDataPerpustakaan extends AbstractTableModel {

    List<dataPerpustakaan> listData;

    public modelTabelDataPerpustakaan(List<dataPerpustakaan> listData) {
        this.listData = listData;
    }

    @Override
    public int getRowCount() {
        return listData.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Judul";
            case 1:
                return "Penulis";
            case 2:
                return "Rating";
            case 3:
                return "Harga";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listData.get(row).getJudul();
            case 1:
                return listData.get(row).getPenulis();

            case 2:
                return listData.get(row).getRating();

            case 3:
                return listData.get(row).getHarga();
            default:
                return null;
        }
    }

}
