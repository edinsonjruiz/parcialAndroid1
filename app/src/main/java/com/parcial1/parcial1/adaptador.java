package com.parcial1.parcial1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.parcial1.parcialandroid.R;

import java.util.List;

public class adaptador extends ArrayAdapter<lista_conctacto> {

    public adaptador(Context context, List<lista_conctacto> objects) {
        super(context, 0, objects);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.lista_conctacto, parent, false);
        }

        TextView txtName = convertView.findViewById(R.id.txtNombre);
        TextView txtPhone = convertView.findViewById(R.id.txtTelefono);
        TextView txtGroup = convertView.findViewById(R.id.txtGrupo);

        lista_conctacto contact = getItem(position);

        assert contact != null;
        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());
        txtGroup.setText(contact.getGroup());

        return convertView;
    }

}