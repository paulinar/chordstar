package guitarheroes.com.chordstar;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class ProgressFragment extends Fragment {
    private Spinner mSongSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // called by Android system so that fragment creates its UI; returns a View component placed in <fragment> element of layout

        View view = inflater.inflate(
                R.layout.fragment_progress, container, false); // inflate layout of XML file and return its view
        getActivity().setTitle("MY PROGRESS");
        mSongSpinner = (Spinner) view.findViewById(R.id.selectTimeFrameSpinner);
        setSpinnerContent();

        return view;
    }

    /**
     * setSpinnerContent sets the content of the spinners on the fragment.
     *
     * In this case, the only spinner is the song selection spinner.
     */
    private void setSpinnerContent() {
        ArrayAdapter<CharSequence> timeAdapter = ArrayAdapter.createFromResource(
                getActivity(), R.array.times, android.R.layout.simple_spinner_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSongSpinner.setAdapter(timeAdapter);
        mSongSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = (ImageView) view.findViewById(R.id.barchart);
                imageView.setImageResource(R.drawable.barchart1);
//                imageView.setBackgroundResource(R.drawable.barchart1);
//                switch (position) {
//                    case 0:
//                        imageView.setImageResource(R.drawable.barchart1);
//                        return;
//                    default:
//                        imageView.setImageResource(R.drawable.barchart1);
//                        return;
//                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }

        });
    }
}
