package activity.CircleOfTrust;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rohan.pcsa_reloaded.R;

/**
 * Created by rohan on 25/12/15.
 */
public class Trustees extends AppCompatActivity {
    EditText comrade1editText;
    EditText comrade2editText;
    EditText comrade3editText;
    EditText comrade4editText;
    EditText comrade5editText;
    EditText comrade6editText;
    Button okButton;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String comrade1 = "comrade1Key";
    public static final String comrade2 = "comrade2Key";
    public static final String comrade3 = "comrade3Key";
    public static final String comrade4 = "comrade4Key";
    public static final String comrade5 = "comrade5Key";
    public static final String comrade6 = "comrade6Key";

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trustees);
        comrade1editText = (EditText) findViewById(R.id.comrade1EditText);
        comrade2editText = (EditText) findViewById(R.id.comrade2EditText);
        comrade3editText = (EditText) findViewById(R.id.comrade3EditText);
        comrade4editText = (EditText) findViewById(R.id.comrade4EditText);
        comrade5editText = (EditText) findViewById(R.id.comrade5EditText);
        comrade6editText = (EditText) findViewById(R.id.comrade6EditText);
        okButton = (Button) findViewById(R.id.okButton);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_WORLD_READABLE);
        editor = sharedpreferences.edit();

        comrade1editText.setText(sharedpreferences.getString(comrade1, ""));
        comrade2editText.setText(sharedpreferences.getString(comrade2, ""));
        comrade3editText.setText(sharedpreferences.getString(comrade3, ""));
        comrade4editText.setText(sharedpreferences.getString(comrade4, ""));
        comrade5editText.setText(sharedpreferences.getString(comrade5, ""));

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString(comrade1, comrade1editText.getText().toString());
                editor.putString(comrade2, comrade2editText.getText().toString());
                editor.putString(comrade3, comrade3editText.getText().toString());
                editor.putString(comrade4, comrade4editText.getText().toString());
                editor.putString(comrade5, comrade5editText.getText().toString());
                editor.putString(comrade6, comrade6editText.getText().toString());


                editor.commit();
                Toast.makeText(getApplicationContext(), getString(R.string.updated_phone_numbers), Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
