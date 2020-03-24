package com.parcial1.parcial1;

import android.os.Parcel;
import android.os.Parcelable;

public class lista_conctacto implements Parcelable {
    private String nombre;
    private String telefono;
    private String grupo;

    public lista_conctacto(String nombre, String telefono, String grupo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.grupo = grupo;
    }

    protected lista_conctacto(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        grupo = in.readString();
    }

    public static final Creator<lista_conctacto> CREATOR = new Creator<lista_conctacto>() {
        @Override
        public lista_conctacto createFromParcel(Parcel in) {
            return new lista_conctacto(in);
        }

        @Override
        public lista_conctacto[] newArray(int size) {
            return new lista_conctacto[size];
        }
    };

    public String getName() {
        return nombre;
    }

    public void setName(String name) {
        this.nombre = nombre;
    }

    public String getPhone() {
        return telefono;
    }

    public void setPhone(String phone) {
        this.telefono = phone;
    }

    public String getGroup() {
        return grupo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(telefono);
        dest.writeString(grupo);
    }
}
