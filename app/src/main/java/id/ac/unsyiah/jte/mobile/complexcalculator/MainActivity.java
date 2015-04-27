package id.ac.unsyiah.jte.mobile.complexcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickTombolHasil(View view) {
        EditText angkaReal1 = (EditText) findViewById(R.id.angkaReal1);
        String angka1RealStr = String.valueOf(angkaReal1.getText());
        int angka1Real = Integer.valueOf(angka1RealStr);

        EditText angkaImajiner1 = (EditText) findViewById(R.id.angkaImajiner1);
        String angka1ImajinerStr = String.valueOf(angkaImajiner1.getText());
        int angka1Imajiner = Integer.valueOf(angka1ImajinerStr);

        EditText angkaReal2 = (EditText) findViewById(R.id.angkaReal2);
        String angka2RealStr = String.valueOf(angkaReal2.getText());
        int angka2Real = Integer.valueOf(angka2RealStr);

        EditText angkaImajiner2 = (EditText) findViewById(R.id.angkaImajiner2);
        String angka2ImajinerStr = String.valueOf(angkaImajiner2.getText());
        int angka2Imajiner = Integer.valueOf(angka2ImajinerStr);

        RadioButton tambah = (RadioButton) findViewById(R.id.optTambah);
        RadioButton kurang = (RadioButton) findViewById(R.id.optKurang);
        RadioButton kali = (RadioButton) findViewById(R.id.optKali);
        RadioButton bagi = (RadioButton) findViewById(R.id.optBagi);

        int Hasil1=0;
        int Hasil2=0;
        String tanda;

        if (tambah.isChecked()== true) {
            Hasil1=angka1Real+angka2Real;
            Hasil2=angka1Imajiner+angka2Imajiner;

        } else if (kurang.isChecked() == true) {
            Hasil1=angka1Real-angka2Real;
            Hasil2=angka1Imajiner-angka2Imajiner;

        } else if (kali.isChecked() == true) {
            Hasil1=angka1Real*angka2Real-angka1Imajiner*angka2Imajiner;
            Hasil2=angka1Imajiner*angka2Real+angka1Real*angka2Imajiner;

        } else if (bagi.isChecked() == true) {
            Hasil1=(angka1Real*angka2Real+angka1Imajiner*angka2Imajiner)/(angka2Real+angka2Imajiner*angka2Imajiner);
            Hasil2=(angka1Imajiner*angka2Real-angka1Real*angka2Imajiner)/(angka2Real*angka2Real+angka2Imajiner*angka2Imajiner);
        }

        String hasil1Str = String.valueOf(Hasil1);
        String hasil2Str = String.valueOf(Hasil2);

        if(Hasil2>=0){
            tanda="+";
        }
        else {
            tanda="";
        }
        TextView lblHasil = (TextView) findViewById(R.id.lblHasil);
        lblHasil.setText(hasil1Str+tanda+hasil2Str+"j");
    }
}
