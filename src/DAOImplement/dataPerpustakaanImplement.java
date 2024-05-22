/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;

import java.util.List;
import Model.*;

/**
 *
 * @author L E N O V O
 */
public interface dataPerpustakaanImplement {

    public void insert(dataPerpustakaan listData);
    public void update(dataPerpustakaan listData);
    public void delete(String judul);
    public List<dataPerpustakaan> getAll();
}
