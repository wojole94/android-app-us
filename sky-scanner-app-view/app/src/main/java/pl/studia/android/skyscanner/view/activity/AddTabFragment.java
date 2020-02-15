package pl.studia.android.skyscanner.view.activity;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.SkyScannerService;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;


public class AddTabFragment extends Fragment {

    @BindView(R.id.Badd) Button addButon;
    MainActivity main;
    Context context = null;

    public static AddTabFragment newInstance(){
        AddTabFragment fragment = new AddTabFragment();
        Bundle args = new Bundle();
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
        RelativeLayout standard_tab_layout = (RelativeLayout) inflater.inflate(R.layout.add_new_tab_layout, null);
        ButterKnife.bind(this, standard_tab_layout);
        addButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SkyScannerService.getAllProfiles("jan@web.pl", "jan1");
                Intent editIntent = new Intent(main.getBaseContext(), EditFormActivity.class);
                main.startActivity(editIntent);
            }
        });

        return standard_tab_layout;
    }
}
