package com.patriciamape.appbdtesoros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Patri on 04/02/2016.
 */
public class CustomAdapter extends ArrayAdapter<Tesoro> {
    public CustomAdapter(Context context, ArrayList<Tesoro> tesoros) {
        super(context, 0, tesoros);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recogemos el item para esta posicion(position)
        Tesoro tesoro = getItem(position);
        // Comprueba si una vista existente esta siendo utilizada, si no 'infla' la vista
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_tesoro, parent, false);
        }

        TextView tvFirstLine = (TextView) convertView.findViewById(R.id.firstLine);
        TextView tvSecondLine = (TextView) convertView.findViewById(R.id.secondLine);
        // Guardamos los datos del objeto en el view
        tvFirstLine.setText(tesoro.getNombre());
        tvSecondLine.setText(String.valueOf(tesoro.getEstrellas()));
        // Devolvemos la vista para pasar a la pantalla
        return convertView;
    }
}
