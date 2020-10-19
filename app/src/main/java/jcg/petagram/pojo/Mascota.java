package jcg.petagram.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class Mascota implements Parcelable {

    private Integer id;
    private String nombre;
    private Foto foto;

    public Mascota(String nombre, int foto, int cantidadDeMeGusta, int id) {
        this.nombre = nombre;
        this.foto = new Foto(foto, cantidadDeMeGusta);
        this.id = id;
    }

    public Mascota(String nombre, int foto) {
        this.nombre = nombre;
        this.foto = new Foto(foto);
    }

    public Mascota() {
        foto = new Foto();
    }

    public String getNombre() {
        return nombre;
    }

    public int getFoto() {
        return foto.getFoto();
    }

    public int getLikes() {
        return foto.getCantidadDeMeGusta();
    }

    public Integer getId(){return id;}

    public void agregarLike(){
        foto.agregarLike();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFoto(int foto) {
        this.foto.setFoto(foto);
    }

    public void setLikes(int likes) {
        this.foto.setCantidadDeMeGusta(likes);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Mascota(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        nombre = in.readString();
        foto = in.readParcelable(Foto.class.getClassLoader());
    }

    public static final Creator<Mascota> CREATOR = new Creator<Mascota>() {
        @Override
        public Mascota createFromParcel(Parcel in) {
            return new Mascota(in);
        }

        @Override
        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(nombre);
        dest.writeParcelable(foto, flags);
    }
}
