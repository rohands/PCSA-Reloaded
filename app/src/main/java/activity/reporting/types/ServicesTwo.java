package activity.reporting.types;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rohan.pcsa_reloaded.R;
import com.melnykov.fab.FloatingActionButton;

import activity.reporting.FAQ;

/**
 * Created by rohan on 26/12/15.
 */
public class ServicesTwo extends Fragment {

    private TextView descStandard;
    private Button faq;
    private FloatingActionButton floatingActionButton;

    public ServicesTwo()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.services_two,container,false);
        descStandard = (TextView) view.findViewById(R.id.reporting_standard);
        descStandard.setText(R.string.reporting_desc_standard);
        floatingActionButton = (FloatingActionButton) view.findViewById(R.id.reporting_faq);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faqPage = new Intent(getActivity(), FAQ.class);
                startActivity(faqPage);
            }
        });
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
