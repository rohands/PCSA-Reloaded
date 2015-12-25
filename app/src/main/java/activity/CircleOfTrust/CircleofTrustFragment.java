package activity.CircleOfTrust;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.rohan.pcsa_reloaded.R;

/**
 * Created by rohan on 25/12/15.
 */
public class CircleofTrustFragment extends Fragment {

    public SharedPreferences settings;
    public boolean firstRun;
    Button requestButton;
    Button editButton;
    SharedPreferences sharedPreferences;
    private GridView gridView;
    private ImageAdapter imageAdapter;
    private String optionSelected;

    public CircleofTrustFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("OK", "Okay");
        imageAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_trust, container, false);
        settings = getActivity().getSharedPreferences("prefs", 0);
        firstRun = settings.getBoolean("firstRun", true);
        if(firstRun)
        {
            Intent intent = new Intent(getActivity(),CircleIntro.class);
            startActivity(intent);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("firstRun", false);
            editor.commit();
        }
        // Inflate the layout for this fragment

        requestButton = (Button) rootView.findViewById(R.id.requestButton);
        editButton = (Button) rootView.findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Trustees.class));
            }
        });
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptions();
            }
        });

        imageAdapter = new ImageAdapter(getActivity());
        gridView = (GridView) rootView.findViewById(R.id.gridview);
        gridView.setAdapter(imageAdapter);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Comrade number " + getActivity().getApplication().
                                getSharedPreferences("MyPrefs", Context.MODE_WORLD_READABLE).getString("comrade" + (position + 1) + "Key", "Unregistered"),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }
    public void showOptions()
    {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(
                getActivity());
        builderSingle.setTitle(R.string.select_request);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add(getString(R.string.come_get_me));
        arrayAdapter.add(getString(R.string.need_interruption));
        arrayAdapter.add(getString(R.string.need_to_talk));
        builderSingle.setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });


        builderSingle.setAdapter(arrayAdapter,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        optionSelected = arrayAdapter.getItem(which);
                        sendMessage(optionSelected);
                    }
                });
        builderSingle.show();
    }



    public void sendMessage(String optionSelected)
    {
        SmsManager sms = SmsManager.getDefault();
        String message = "";
        switch(optionSelected)
        {
            case "Come get me":
                message = getString(R.string.come_get_me_message);
                break;
            case "Call I need an interruption":
                message = getString(R.string.interruption_message);
                break;
            case "I need to talk":
                message = getString(R.string.need_to_talk_message);
                break;
        }

        try {
            sharedPreferences = this.getActivity().getSharedPreferences(Trustees.MyPREFERENCES, Context.MODE_PRIVATE);
            // The numbers variable holds the Comrades numbers
            String numbers[] = {sharedPreferences.getString(Trustees.comrade1, ""), sharedPreferences.getString(Trustees.comrade2, ""),
                    sharedPreferences.getString(Trustees.comrade3, ""), sharedPreferences.getString(Trustees.comrade4, ""),
                    sharedPreferences.getString(Trustees.comrade5, ""), sharedPreferences.getString(Trustees.comrade6, ""),};

            for(String number : numbers) {
                if(number != ""){
                    sms.sendTextMessage(number, null, message, null, null);
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(R.string.msg_sent); // title bar string
            builder.setPositiveButton(R.string.ok, null);

            builder.setMessage(getString(R.string.confirmation_message));

            AlertDialog errorDialog = builder.create();
            errorDialog.show(); // display the Dialog

        }catch (Exception e)
        {
            Toast.makeText(getActivity(), R.string.message_failed, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}