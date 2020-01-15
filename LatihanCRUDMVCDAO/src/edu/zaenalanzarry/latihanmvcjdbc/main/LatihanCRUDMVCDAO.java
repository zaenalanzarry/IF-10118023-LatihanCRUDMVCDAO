/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zaenalanzarry.latihanmvcjdbc.main;

import edu.zaenalanzarry.latihanmvcjdbc.database.KingBarbershopDatabase;
import edu.zaenalanzarry.latihanmvcjdbc.entity.Pelanggan;
import edu.zaenalanzarry.latihanmvcjdbc.error.PelangganException;
import edu.zaenalanzarry.latihanmvcjdbc.service.PelangganDao;
import edu.zaenalanzarry.latihanmvcjdbc.view.MainViewPelanggan;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zaenal 
 * Nama     : Zaenal Anzarry 
 * NIM      : 10118023 
 * Kelas    : IF-1
 */
public class LatihanCRUDMVCDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                try {
                    MainViewPelanggan pelanggan = new MainViewPelanggan();
                    pelanggan.loadDatabase();
                    pelanggan.setVisible(true);
                } catch (SQLException e) {
                }
                catch (PelangganException ex) {
                        Logger.getLogger(LatihanCRUDMVCDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }

}
