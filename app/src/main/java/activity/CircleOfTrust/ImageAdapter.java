package activity.CircleOfTrust;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rohan.pcsa_reloaded.R;

/**
 * Created by rohan on 25/12/15.
 */
public class ImageAdapter extends BaseAdapter {

    private Context context;
    private SharedPreferences sharedPreferences;

    public Integer[] mThumbIds = {
            R.mipmap.ic_comrade, R.mipmap.ic_comrade,
            R.mipmap.ic_comrade, R.mipmap.ic_comrade,
            R.mipmap.ic_comrade, R.mipmap.ic_comrade
    };
    public ImageAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearLayout;
        linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        ImageView imageView;
        imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(mThumbIds[position]);

        TextView textView;
        textView = new TextView(context);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(15);
        textView.setTextColor(context.getResources().getColor(R.color.windowBackground));
        sharedPreferences = context.getApplicationContext().getSharedPreferences(Trustees.MyPREFERENCES,Context.MODE_WORLD_READABLE);
        if(!sharedPreferences.getString("comrade"+(position+1)+"Key","Unregistered").equals(""))
            textView.setText(sharedPreferences.getString("comrade"+(position+1)+"Key","Unregistered"));
        else
            textView.setText("Unregistered");

        linearLayout.addView(imageView);
        linearLayout.addView(textView);

        return linearLayout;
    }
}
