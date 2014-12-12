package guitarheroes.com.chordstar;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListenToSongFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // called by Android system so that fragment creates its UI; returns a View component placed in <fragment> element of layout

        getActivity().setTitle("LEARN A SONG");

        View view = inflater.inflate(
                R.layout.fragment_listen_to_song, container, false); // inflate layout of XML file and return its view

        Date minDate = null;
        try {
            minDate = new SimpleDateFormat("yyyy-MM-dd").parse("1950-12-01");
        } catch (ParseException e) {
            // will never happen
            e.printStackTrace();
        }
        Date maxDate = new Date();
        RangeSeekBar<Long> seekBar = new RangeSeekBar<Long>(minDate.getTime(), maxDate.getTime(), getActivity());
        seekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Long>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Long minValue, Long maxValue) {
                // handle changed range values
                Log.i("a", "User selected new date range: MIN=" + new Date(minValue) + ", MAX=" + new Date(maxValue));
            }
        });

        // add RangeSeekBar to pre-defined layout
        LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        params.setMargins(0, 0, 0, 40);
        seekBar.setLayoutParams(params);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.listen_to_song_layout);
        layout.addView(seekBar);

        return view;
    }
}
