package activity.CircleOfTrust;


import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.rohan.pcsa_reloaded.R;
import com.github.paolorotolo.appintro.AppIntro;
import activity.CircleOfTrust.slides.FirstSlide;
import activity.CircleOfTrust.slides.FourthSlide;
import activity.CircleOfTrust.slides.SecondSlide;
import activity.CircleOfTrust.slides.ThirdSlide;

/**
 * Created by rohan on 25/12/15.
 */
public class CircleIntro extends AppIntro {

    public SharedPreferences settings;
    public boolean firstRun;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SharedPreferences.Editor editor;
    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(new FirstSlide());
        addSlide(new SecondSlide());
        addSlide(new ThirdSlide());
        addSlide(new FourthSlide());
        setFadeAnimation();
    }
    @Override
    public void onSkipPressed() {
        finish();
    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onDonePressed() {
        finish();
    }

    @Override
    public void onSlideChanged() {

    }
}
