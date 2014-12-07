package guitarheroes.com.chordstars;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;
import android.os.*;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        hiddenBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                try {
//                    Thread.sleep(2000);
//                    Fragment fr = new EndSessionFrag();
//                    FragmentManager fm = getFragmentManager();
//                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
//                    fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_in_left);
//                    fragmentTransaction.replace(R.id.fragment_place, fr);
//                    fragmentTransaction.commit();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }


    public void onOpenWebBrowser(View v) {
        Intent webPageIntent = new Intent(Intent.ACTION_VIEW);
        webPageIntent.setData(Uri.parse("https://play.google.com/store/music"));

        try {
            startActivity(webPageIntent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
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

        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    public void endSession(View view) {
        Fragment fr;
        fr = new SessionSummaryFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    public void restartSession(View view) {
        Fragment fr;
        fr = new EndSessionFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

    }

    public void playOnGuitar(View view) {
        Fragment fr;
        fr = new PlayOnGuitarFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Fragment endSessionFrag = new EndSessionFrag();
                FragmentManager newFM = getFragmentManager();
                FragmentTransaction newFT = newFM.beginTransaction();
                newFT.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
                newFT.replace(R.id.fragment_place, endSessionFrag);
                newFT.commit();
            }
        }, 5000);

        // UNCOMMENT WHEN SARAH IMPLEMENTS TOQACTIVITY CLASS
//        Intent intent = new Intent(MainActivity.this, ToqActivity.class);
//        startActivity(intent);
    }

}