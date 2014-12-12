package guitarheroes.com.chordstar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlaybackSessionFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // called by Android system so that fragment creates its UI; returns a View component placed in <fragment> element of layout

        getActivity().setTitle("PLAYBACK RECORDING");

        return inflater.inflate(
                R.layout.fragment_playback_session, container, false); // inflate layout of XML file and return its view
    }
}
