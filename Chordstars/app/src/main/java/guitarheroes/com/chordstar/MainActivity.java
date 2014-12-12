package guitarheroes.com.chordstar;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.*;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Fragment firstFragment = new SelectSongFrag1();
        firstFragment.setArguments(getIntent().getExtras());
        FragmentTransaction t = getFragmentManager().beginTransaction();
        t.add(R.id.fragment_place, firstFragment);
        t.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_view_progress:
                switchToProgressFragment();
                return true;
            default:
                return true;
        }
    }

    private void switchToProgressFragment() {
        Fragment fr;
        fr = new ProgressFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
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
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void endSession(View view) {
        Fragment fr;
        fr = new SessionSummaryFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void restartSession(View view) {
        Fragment fr;
        fr = new EndSessionFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void playOnGuitar(View view) {
        Fragment fr;
        fr = new PlayOnGuitarFrag();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.addToBackStack(null);
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
                newFT.addToBackStack(null);
                newFT.commit();
            }
        }, 5000);

        // UNCOMMENT WHEN SARAH IMPLEMENTS TOQACTIVITY CLASS
//        Intent intent = new Intent(MainActivity.this, ToqActivity.class);
//        startActivity(intent);
    }

    public void listenToSong(View view) {
        Fragment fr;
        fr = new ListenToSongFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void playbackSession(View view) {
        Fragment fr;
        fr = new PlaybackSessionFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.animator.slide_in_left, R.animator.slide_out_left);
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void openVoiceRecorder(View v) {
        Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        startActivity(intent);
    }

}