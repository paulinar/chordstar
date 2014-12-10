package guitarheroes.com.chordstar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SelectSongFrag1 extends Fragment {
    private Spinner mSongSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // called by Android system so that fragment creates its UI; returns a View component placed in <fragment> element of layout

        View view = inflater.inflate(
                R.layout.select_song_frag1, container, false); // inflate layout of XML file and return its view
        mSongSpinner = (Spinner) view.findViewById(R.id.selectSongSpinner);

        setSpinnerContent();
        getActivity().setTitle("SELECT A SONG");

        return view;
    }

    /**
     * setSpinnerContent sets the content of the spinners on the fragment.
     *
     * In this case, the only spinner is the song selection spinner.
     */
    private void setSpinnerContent() {
        String[] songs = getResources().getStringArray(R.array.songs);
        ArrayAdapter<String> genderAdapter = new HintAdapter(
                getActivity(), android.R.layout.simple_spinner_item, songs);
        mSongSpinner.setAdapter(genderAdapter);
        mSongSpinner.setSelection(genderAdapter.getCount());
    }
}
