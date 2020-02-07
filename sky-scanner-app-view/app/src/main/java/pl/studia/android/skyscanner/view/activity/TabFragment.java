package pl.studia.android.skyscanner.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;
import android.widget.TextView;

import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;


public class TabFragment extends Fragment {


    MainActivity main;
    Context context = null;

    public static TabFragment newInstance(ProfileData data){
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putSerializable("profile-data",data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity(); // use this reference to invoke main callbacks
            main = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException(
                    "MainActivity must implement callbacks");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        ProfileData data = (ProfileData) arguments.getSerializable("profile-data");
        LinearLayout standard_tab_layout = (LinearLayout) inflater.inflate(R.layout.standard_tab_layout, null);
        ((TextView) standard_tab_layout.findViewById(R.id.TVadultsValue)).setText("" + data.getAdultsCount());
        ((TextView) standard_tab_layout.findViewById(R.id.TVchildsValue)).setText("" + data.getChildCount());
        ((TextView) standard_tab_layout.findViewById(R.id.TVdepLocValue)).setText("" + data.getDepartCity());
        ((TextView) standard_tab_layout.findViewById(R.id.TVarrLocValue)).setText("" + data.getArrivalCity());
        ((TextView) standard_tab_layout.findViewById(R.id.TVdatesValue))
                .setText(data.getStartDate().toString() + " - " + data.getEndDate());
        ((TextView) standard_tab_layout.findViewById(R.id.TVmaxTransValue)).setText("" + data.getTransfersCount());
        ((TextView) standard_tab_layout.findViewById(R.id.TVmaxCostValue)).setText(data.getMaxPrice().toString());
        ((TextView) standard_tab_layout.findViewById(R.id.TVweekendsValue)).setText(data.getJustWeekends().toString());
        return standard_tab_layout;
    }


}
