package activity.reporting.types;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohan.pcsa_reloaded.R;

import org.w3c.dom.Text;

/**
 * Created by rohan on 26/12/15.
 */
public class ServicesOne extends Fragment{

    private TextView descBoth;

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
        return rootView;
    }
}

