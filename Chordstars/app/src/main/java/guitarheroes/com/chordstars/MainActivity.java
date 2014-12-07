package guitarheroes.com.chordstars;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

    public void onOpenWebBrowser(View v) {
        Intent webPageIntent = new Intent(Intent.ACTION_VIEW);
        webPageIntent.setData(Uri.parse("https://play.google.com/store/music"));

        try {
            startActivity(webPageIntent);
        } catch (ActivityNotFoundException ex) {
        }
    }

    public void selectFrag(View view) {
        Fragment fr;

        if (view == findViewById(R.id.selectSongBtn)) {
            fr = new SelectSongFrag2();
            findViewById(R.id.selectSongBtn).setVisibility(View.GONE);
            findViewById(R.id.downloadMoreBtn).setVisibility(View.GONE);
            findViewById(R.id.musicalNote).setVisibility(View.GONE);

        } else if (view == findViewById(R.id.downloadMoreBtn)) {
            fr = new SelectSongFrag1(); // TODO: clean up code
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.google.com")));
        } else {
            fr = new SelectSongFrag1();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    public void endSession(View view) {
        Fragment fr;
        fr = new EndSessionFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    public void playOnGuitar(View view) {
        Fragment fr;
        fr = new PlayOnGuitarFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

}