package com.nestor.camara;

import java.io.File;






import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	private static final int CAPTURE_IMAGE = 1; // Indentificador de la sub-Actividad
	private Uri rutaImagen; // Ruta para almacenar la imagen
	static Bitmap bmp3 = BitmapFactory.decodeFile("/sdcard/saved_images");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		
	    
        Button miBoton = (Button) findViewById(R.id.selfieBoton);
        miBoton.setOnClickListener(new View.OnClickListener() 
        {
			
			@Override
			public void onClick(View v)
			{
				// create Intent to take a picture and return control to the calling application
				//Crea el intent para capturar la imagen y devolver el control a la aplicacion que llama 
			    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    ;
			    File fichero = new File(Environment.getExternalStorageDirectory(), "foto.png");
			    rutaImagen = Uri.fromFile(fichero); // convierte el fichero en URI
			    
			    intent.putExtra(MediaStore.EXTRA_OUTPUT, rutaImagen); // indica la ruta de la imagen

			    // start the image capture Intent
			    startActivityForResult(intent, CAPTURE_IMAGE);

			}
		});
        
		
	}
	
	

}
