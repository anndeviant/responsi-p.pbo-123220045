/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import DAOData.dataPerpustakaanDAO;
import DAOImplement.dataPerpustakaanImplement;
import Model.*;
import View.MainView;

/**
 *
 * @author L E N O V O
 */
public class dataPerpustakaanController {

    MainView frame;
    dataPerpustakaanImplement implDataPerpus;
    List<dataPerpustakaan> listData;
    private Float P;
    private Float H;
    private Float R;
    private final Integer K = 500;

    public dataPerpustakaanController(MainView frame) {
        this.frame = frame;
        implDataPerpus = new dataPerpustakaanDAO();
        listData = implDataPerpus.getAll();
    }

    public void isiTabel() {
        listData = implDataPerpus.getAll();
        modelTabelDataPerpustakaan modelTabel = new modelTabelDataPerpustakaan(listData);
        frame.getTabelPerpustakaan().setModel(modelTabel);
    }

    public void insert() {
        dataPerpustakaan perpus = new dataPerpustakaan();
        perpus.setJudul(frame.getInputJudul().getText());
        perpus.setPenulis(frame.getInputPenulis().getText());
        perpus.setRating(Float.parseFloat(frame.getInputRating().getText()));
        H = Float.parseFloat(frame.getInputHarga().getText());
        R = Float.parseFloat(frame.getInputRating().getText());
        P = (H + K + (R * 100));
        perpus.setHarga(P);
        implDataPerpus.insert(perpus);
    }

    public void update() {
        dataPerpustakaan perpus = new dataPerpustakaan();
        perpus.setJudul(frame.getInputJudul().getText());
        perpus.setPenulis(frame.getInputPenulis().getText());
        perpus.setRating(Float.parseFloat(frame.getInputRating().getText()));
        H = Float.parseFloat(frame.getInputHarga().getText());
        R = Float.parseFloat(frame.getInputRating().getText());
        P = (H + K + (R * 100));
        perpus.setHarga(P);
        implDataPerpus.update(perpus);
    }
    
    public void delete(){
        String delete = frame.getInputJudul().getText();
        implDataPerpus.delete(delete);
    }
}
