package firmo.miranda.gasolinaoualcool;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void calcular(View view){
		
		EditText valAlcool = (EditText) findViewById(R.id.valorAlcool);
		EditText valGas = (EditText) findViewById(R.id.valorGasolina);
		TextView resultadoText = (TextView) findViewById(R.id.resultado);
		
		Double valorAlcool = Double.valueOf(valAlcool.getText().toString());
		Double valorGasolina = Double.valueOf(valGas.getText().toString());
		
		Double percetualAlcool = Math.round((valorAlcool/valorGasolina)*1000)/10.0;
		StringBuilder resultado = new StringBuilder();
		if(percetualAlcool>=70){
			resultado.append("Gasolina");
			valGas.setBackgroundColor(Color.GREEN);
			valAlcool.setBackgroundColor(Color.TRANSPARENT);
		}else{
			resultado.append("Alcool");
			valAlcool.setBackgroundColor(Color.GREEN);
			valGas.setBackgroundColor(Color.TRANSPARENT);

		}
		resultado.append(" (O Alcool esta custando: "+percetualAlcool+"% do valor da gasolina)");
		
		resultadoText.setText(resultado.toString());
	}

}
