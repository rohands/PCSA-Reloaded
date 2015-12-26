package activity.reporting.types;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohan.pcsa_reloaded.R;

/**
 * Created by rohan on 26/12/15.
 */
public class ServicesTwo extends Fragment {

    private TextView descStandard;

    public ServicesTwo()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.services_two,container,false);
        descStandard = (TextView) view.findViewById(R.id.reporting_standard);
        descStandard.setText(R.string.reporting_desc_standard);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
