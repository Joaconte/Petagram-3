package jcg.petagram.vista.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import jcg.petagram.R;
import jcg.petagram.adapter.FotoAdaptador;
import jcg.petagram.pojo.Foto;
import jcg.petagram.pojo.Mascota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    ArrayList<Foto> fotos = new ArrayList<>();
    private RecyclerView listaFotos;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        Mascota mascota = new Mascota("Vaca", R.drawable.vaca);

        CircularImageView imgFoto = v.findViewById(R.id.civFotoPerfil);
        imgFoto.setImageResource(mascota.getFoto());

        TextView tvNombrePerfil = v.findViewById(R.id.tvNombrePerfil);
        tvNombrePerfil.setText(mascota.getNombre());

        listaFotos = v.findViewById(R.id.rvProfileFragment);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaFotos.setLayoutManager(glm);
        duplicarFotos(mascota);
        inicializarAdaptador();

        return v;
    }

    private void duplicarFotos(Mascota mascota){

        for (int i = 0; i < 12; i++){
            fotos.add(new Foto(mascota.getFoto(), i));
        }
    }

    public void inicializarAdaptador(){
        FotoAdaptador adaptador = new FotoAdaptador(fotos);
        listaFotos.setAdapter(adaptador);

    }

}