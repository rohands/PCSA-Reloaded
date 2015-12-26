package activity.reporting.types;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rohan.pcsa_reloaded.R;
import com.melnykov.fab.FloatingActionButton;

import org.w3c.dom.Text;

import activity.reporting.FAQ;

/**
 * Created by rohan on 26/12/15.
 */
public class ServicesOne extends Fragment{

    private TextView descBoth;
    private FloatingActionButton floatingActionButton;

    public ServicesOne()
    {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.services_one, container, false);

        descBoth = (TextView) rootView.findViewById(R.id.reporting_both);
        descBoth.setText(R.string.reporting_desc_standard);
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.reporting_faq);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent faqPage = new Intent(getActivity(), FAQ.class);
                startActivity(faqPage);
            }
        });
        return rootView;
    }
}

