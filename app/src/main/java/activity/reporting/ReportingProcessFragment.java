package activity.reporting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.rohan.pcsa_reloaded.R;

import activity.reporting.types.Types;

/**
 * Created by rohan on 25/12/15.
 */
public class ReportingProcessFragment extends Fragment {

    Button reportingSteps,reportingTypes,reportingMoreResources,reportingConfidentiality,reportingContactStaff;

    private static final String TAG = "ReportingProcessFragment";
    public ReportingProcessFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_reportprocess, container, false);

        reportingSteps = (Button) rootView.findViewById(R.id.reporting_steps);
        reportingTypes = (Button) rootView.findViewById(R.id.reporting_types);
        reportingMoreResources = (Button) rootView.findViewById(R.id.reporting_resources);
        reportingConfidentiality = (Button) rootView.findViewById(R.id.reporting_confidentiality);
        reportingContactStaff = (Button) rootView.findViewById(R.id.reporting_contact);

        reportingSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent steps = new Intent(getActivity(), Steps.class);
                startActivity(steps);
            }
        });

        reportingTypes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent types = new Intent(getActivity(), Types.class);
                startActivity(types);
            }
        });

        reportingMoreResources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Temporarily commented out until the functionality is implemented
                Intent types = new Intent(HomeScreen.this, Resources.class);
                startActivity(types);
                */

                Toast.makeText(getActivity(), getString(R.string.unavailable_function), Toast.LENGTH_SHORT).show();
            }
        });

        reportingConfidentiality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Temporarily commented out until the functionality is implemented.
                Intent types = new Intent(HomeScreen.this, Confidentiality.class);
                startActivity(types);
                */

                Toast.makeText(getActivity(), getString(R.string.unavailable_function), Toast.LENGTH_SHORT).show();
            }
        });

        reportingContactStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent types = new Intent(getActivity(), ContactPostStaff.class);
                startActivity(types);
            }
        });

        // Inflate the layout for this fragment
        return rootView;
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