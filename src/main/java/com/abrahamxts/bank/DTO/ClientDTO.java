package com.abrahamxts.bank.DTO;

import com.abrahamxts.bank.models.CuentaModel;

public class ClientDTO {

    private int ID;
    private String Nombre;
    private String Apellido;
    private String Curp;
    private CuentaModel[] cuentas = new CuentaModel[3];
    private boolean Token;

    public ClientDTO(int ID, String Nombre, String Apellido, String Curp){
        this.ID = ID;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Curp = Curp;
        this.Token = Token;
    }

    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }

    public String getNombre(){
        return Nombre;
    }

    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }

    public String getApellido(){
        return Apellido;
    }

    public void setApellido(String Apellido){
        this.Apellido = Apellido;
    }

    public String getCurp(){
        return Curp;
    }

    public void setCurp(String Curp){
        this.Curp = Curp;
    }

    public boolean getToken(){
        return Token;
    }

    public void setToken(boolean Token){
        this.Token = Token;
    }
}