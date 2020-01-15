/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zaenalanzarry.latihanmvcjdbc.service;

import edu.zaenalanzarry.latihanmvcjdbc.entity.Pelanggan;
import edu.zaenalanzarry.latihanmvcjdbc.error.PelangganException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Zaenal
 * Nama     : Zaenal Anzarry 
 * NIM      : 10118023 
 * Kelas    : IF-1
 */
public interface PelangganDao {
    
    public void insertPelanggan (Pelanggan pelanggan) throws PelangganException;
    
    public void updatePelanggan (Pelanggan pelanggan) throws PelangganException;
    
    public void deletePelanggan (Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan (Integer id) throws PelangganException;
    
    public Pelanggan getPelanggan (String email) throws PelangganException;
    
    public List<Pelanggan> selectAllPelanggan () throws PelangganException;
    
    
    
    
}
