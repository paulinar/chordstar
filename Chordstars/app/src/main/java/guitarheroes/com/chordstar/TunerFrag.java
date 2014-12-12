package guitarheroes.com.chordstar;

//import android.app.Fragment;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//public class TunerFrag extends Fragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        // called by Android system so that fragment creates its UI; returns a View component placed in <fragment> element of layout
//
//        return inflater.inflate(R.layout.tuner_frag, container, false); // inflate layout of XML file and return its view
//
//    }
//}
import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TunerFrag extends Activity {

    MediaPlayer playE1, playA, playB, playD, playG, playE2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuner_frag);

        playE1 = MediaPlayer.create(this, R.raw.guitare1);
        playA = MediaPlayer.create(this, R.raw.guitara);
        playB = MediaPlayer.create(this, R.raw.guitarb);
        playD = MediaPlayer.create(this, R.raw.guitard);
        playG = MediaPlayer.create(this, R.raw.guitarg);
        playE2 = MediaPlayer.create(this, R.raw.guitare2);

        Button buttonPlayE1 = (Button)findViewById(R.id.btn_e1);
        Button buttonPlayA = (Button)findViewById(R.id.btn_a);
        Button buttonPlayB = (Button)findViewById(R.id.btn_b);
        Button buttonPlayD = (Button)findViewById(R.id.btn_d);
        Button buttonPlayG = (Button)findViewById(R.id.btn_g);
        Button buttonPlayE2 = (Button)findViewById(R.id.btn_e2);
        buttonPlayE1.setOnClickListener(buttonPlayOnClickListener(playE1));
        buttonPlayA.setOnClickListener(buttonPlayOnClickListener(playA));
        buttonPlayB.setOnClickListener(buttonPlayOnClickListener(playB));
        buttonPlayD.setOnClickListener(buttonPlayOnClickListener(playD));
        buttonPlayG.setOnClickListener(buttonPlayOnClickListener(playG));
        buttonPlayE2.setOnClickListener(buttonPlayOnClickListener(playE2));

    }

    Button.OnClickListener buttonPlayOnClickListener(final MediaPlayer player){
            return new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Button btn = (Button) v;
                    if (!player.isPlaying()) {
                        player.start();
                        //btn.setBackgroundResource();
//                        btn.setBackgroundColor(Color.GREEN);
                        //btn.setFocusable(true);
                        btn.setFocusableInTouchMode(true);
                        btn.requestFocus();
                        Toast.makeText(getApplicationContext(), "Note is playing!", Toast.LENGTH_SHORT).show();
                    } else {
                        player.pause();
                        btn.setFocusableInTouchMode(false);
                        btn.clearFocus();
                        Toast.makeText(getApplicationContext(), "Note is paused!", Toast.LENGTH_SHORT).show();
                    }
                }
            };

    };

}