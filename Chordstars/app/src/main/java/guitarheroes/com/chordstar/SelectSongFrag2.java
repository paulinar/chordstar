package guitarheroes.com.chordstar;

/**
 * Created by paulina on 12/5/14.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SelectSongFrag2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // called by Android system so that fragment creates its UI; returns a View component placed in <fragment> element of layout

        getActivity().setTitle("LEARN A SONG");

        return inflater.inflate(
                R.layout.select_song_frag2, container, false); // inflate layout of XML file and return its view
    }
}
