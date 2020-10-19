package jcg.petagram.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Foto implements Parcelable {

    public int foto;
    public int cantidadDeMeGusta;

    public Foto(int foto, int cantidadDeMeGusta) {
        this.foto = foto;
        this.cantidadDeMeGusta = cantidadDeMeGusta;
    }

    public Foto(int foto) {
        this.foto = foto;
    }

    public Foto() {}

    public int getFoto() {
        return foto;
    }

    public int getCantidadDeMeGusta() {
        return cantidadDeMeGusta;
    }

    public void agregarLike() {
        cantidadDeMeGusta++;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void setCantidadDeMeGusta(int cantidadDeMeGusta) {
        this.cantidadDeMeGusta = cantidadDeMeGusta;
    }

    protected Foto(Parcel in) {
        foto = in.readInt();
        cantidadDeMeGusta = in.readInt();
    }

    public static final Creator<Foto> CREATOR = new Creator<Foto>() {
        @Override
        public Foto createFromParcel(Parcel in) {
            return new Foto(in);
        }

        @Override
        public Foto[] newArray(int size) {
            return new Foto[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(foto);
        dest.writeInt(cantidadDeMeGusta);
    }
}
