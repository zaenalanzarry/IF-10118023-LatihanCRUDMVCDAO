/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zaenalanzarry.latihanmvcjdbc.event;

import edu.zaenalanzarry.latihanmvcjdbc.entity.Pelanggan;
import edu.zaenalanzarry.latihanmvcjdbc.model.PelangganModel;

/**
 *
 * @author Zaenal
 * Nama     : Zaenal Anzarry 
 * NIM      : 10118023 
 * Kelas    : IF-1
 */
public interface PelangganListener {
    
    public void onChange (PelangganModel model);
    public void onInsert (Pelanggan pelanggan);
    public void onDelete();
    public void onUpdate (Pelanggan pelanggan);
}
