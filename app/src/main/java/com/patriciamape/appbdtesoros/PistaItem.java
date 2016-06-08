package com.patriciamape.appbdtesoros;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PistaItem extends AppCompatActivity  {
    private TesoroDataSource datasource;
    private int idIntent;
    private Pista pista;
    private String nombreHerramienta;
    //Variables usadas en la geolocalizacion
    private LocationManager locationManager;
    private String provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pista_item);

        Intent pistaIntent = getIntent();
        // Recogemos el id de la pista
        idIntent = pistaIntent.getIntExtra("pistaID", 1);

        datasource = new TesoroDataSource(this);
        datasource.open();

        // Creamos un array con la pista correspondiente de la BD(solo tiene una pista)
        ArrayList<Pista> arrayPistas = new ArrayList<>(datasource.getPistasByID(idIntent));

        TextView tvPregunta = (TextView) findViewById(R.id.pregunta);
        pista = arrayPistas.get(0);
        tvPregunta.setText(pista.getPregunta());

        // Recogemos la herramienta que se usa para esta pista
        nombreHerramienta = datasource.getHerramienta(idIntent);

    }

    public void botonHerramienta(View view){
       if(nombreHerramienta.equalsIgnoreCase("geolocalizacion")){
            geolocalizacion();
      }else if(nombreHerramienta.equalsIgnoreCase("reconocimientoObjeto")){

       }
    }


    public void geolocalizacion(){
        Double latitude, longitude;
        // Recogemos la solucion de la pista
        String[] geolocalizacion = pista.getSolucion().split(", ");
        TextView tvSolucion = (TextView) findViewById(R.id.solucion);
        tvSolucion.setText("Solucion: " + geolocalizacion[0] + ", "+ geolocalizacion[1]);

        // Recogemos LocationManager que nos da acceso al proveedor de localizacion
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Definimos un objeto Criteria que nos permite seleccionar el proveedor ->
        // usamos el que viene por defecto
        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);


        // Recogemos los campos de la localizacion
        if (location != null) {
            System.out.println("Se ha seleccionado el proveedor: " + provider);
            latitude =  (location.getLatitude());
            longitude =  (location.getLongitude());
            TextView tvRespuesta = (TextView) findViewById(R.id.respuesta);
            tvRespuesta.setText("Respuesta: " + latitude + ", " + longitude);

            if(String.valueOf(latitude).equalsIgnoreCase(geolocalizacion[0]) &&
                    String.valueOf(longitude).equalsIgnoreCase(geolocalizacion[1])){
                Toast.makeText(this, "Localizacion correcta", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Localizacion no correcta, vuelva a intentarlo", Toast.LENGTH_LONG).show();
            }

        } else {
            Toast.makeText(this, "Localizacion no diponible", Toast.LENGTH_SHORT).show();
        }
    }


}
