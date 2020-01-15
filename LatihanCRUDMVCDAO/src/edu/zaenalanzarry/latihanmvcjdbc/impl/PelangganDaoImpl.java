/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.zaenalanzarry.latihanmvcjdbc.impl;

import edu.zaenalanzarry.latihanmvcjdbc.entity.Pelanggan;
import edu.zaenalanzarry.latihanmvcjdbc.error.PelangganException;
import edu.zaenalanzarry.latihanmvcjdbc.service.PelangganDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zaenal
 * Nama     : Zaenal Anzarry 
 * NIM      : 10118023 
 * Kelas    : IF-1
 */
public class PelangganDaoImpl implements PelangganDao{
    
    private Connection connection;
    
    private final String insertPelanggan = "INSERT INTO PELANGGAN (NAMA,ALAMAT,TELEPON,EMAIL) VALUES (?,?,?,?)";
    
    private final String updatePelanggan = "UPDATE PELANGGAN SET NAMA=?,ALAMAT=?,TELEPON=?,EMAIL=? WHERE ID=?";
    
    private final String deletePelanggan = "DELETE FROM PELANGGAN WHERE ID=?";
    
    private final String getById = "SELECT * FROM PELANGGAN WHERE ID=?";
    
    private final String getByEmail = "SELECT * FROM PELANGGAN WHERE EMAIL=?";

    private final String selectALl = "SELECT * FROM PELANGGAN";
    public PelangganDaoImpl(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public void insertPelanggan(Pelanggan pelanggan) throws PelangganException {
        PreparedStatement statment = null;
        try {
            connection.setAutoCommit(false);
            
            statment = connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statment.setString(1, pelanggan.getNama());
            statment.setString(2, pelanggan.getAlamat());
            statment.setString(3, pelanggan.getTelepon());
            statment.setString(4, pelanggan.getEmail());
            statment.executeUpdate();
            
            ResultSet result = statment.getGeneratedKeys();
            if (result.next()) {
                pelanggan.setId(result.getInt(1));
            }
            connection.commit();
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statment != null) {
                try {
                    statment.close();
                } catch (SQLException e) {
                }
            }   
        }
    }

    @Override
    public void updatePelanggan(Pelanggan pelanggan) throws PelangganException {
    
        PreparedStatement statment = null;
        try {
            connection.setAutoCommit(false);
            
            statment = connection.prepareStatement(updatePelanggan);
            statment.setString(1, pelanggan.getNama());
            statment.setString(2, pelanggan.getAlamat()); 
            statment.setString(3, pelanggan.getTelepon());
            statment.setString(4, pelanggan.getEmail());
            statment.setInt(5, pelanggan.getId());
            statment.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statment != null) {
                try {
                    statment.close();
                } catch (SQLException e) {
                }
            }   
        }
    }

    @Override
    public void deletePelanggan(Integer id) throws PelangganException {
    
        PreparedStatement statment = null;
        try {
            connection.setAutoCommit(false);
            
            statment = connection.prepareStatement(deletePelanggan);
            statment.setInt(1, id);
            statment.executeUpdate();
            
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statment != null) {
                try {
                    statment.close();
                } catch (SQLException e) {
                }
            }   
        }
    }

    @Override
    public Pelanggan getPelanggan(Integer id) throws PelangganException {
        
        PreparedStatement statment = null;
        try {
            connection.setAutoCommit(false);
            
            statment = connection.prepareStatement(getById);
            statment.setInt(1, id);
            
            ResultSet result = statment.executeQuery();
            Pelanggan pelanggan = null;
            
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL")); 
            } else {
                throw new PelangganException("Pelanggan dengan id "+id+"tidak ditemukkan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statment != null) {
                try {
                    statment.close();
                } catch (SQLException e) {
                }
            }   
        }
    }

    @Override
    public Pelanggan getPelanggan(String email) throws PelangganException {
        
        PreparedStatement statment = null;
        try {
            connection.setAutoCommit(false);
            
            statment = connection.prepareStatement(getByEmail);
            statment.setString(1, email);
            
            ResultSet result = statment.executeQuery();
            Pelanggan pelanggan = null;
            
            if (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL")); 
            } else {
                throw new PelangganException("Pelanggan dengan id "+email+"tidak ditemukkan");
            }
            connection.commit();
            return pelanggan;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statment != null) {
                try {
                    statment.close();
                } catch (SQLException e) {
                }
            }   
        }
    }

    @Override
    public List<Pelanggan> selectAllPelanggan() throws PelangganException {
   
        Statement statment = null;
        List<Pelanggan> list = new ArrayList<Pelanggan>();
        try {
            connection.setAutoCommit(false);
            
            statment = connection.createStatement();
          
            ResultSet result = statment.executeQuery(selectALl);
            Pelanggan pelanggan = null;
            
            while (result.next()) {
                pelanggan = new Pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL")); 
                list.add(pelanggan);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PelangganException(e.getMessage());
            
        } finally{
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statment != null) {
                try {
                    statment.close();
                } catch (SQLException e) {
                }
            }   
        }
    }
    }

    
    

