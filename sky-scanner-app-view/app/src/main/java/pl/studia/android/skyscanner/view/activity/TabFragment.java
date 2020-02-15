package pl.studia.android.skyscanner.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.ActiveConnection;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RetrofitClientInstance;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.Html.fromHtml;


public class TabFragment extends Fragment {


    MainActivity main;
    Context context = null;

    @BindView(R.id.TVadultsValue)
    TextView TVadultsValue;
    @BindView(R.id.TVchildsValue)
    TextView TVchildsValue;
    @BindView(R.id.TVdepLocValue)
    TextView TVdepLocValue;
    @BindView(R.id.TVarrLocValue)
    TextView TVarrLocValue;
    @BindView(R.id.TVdatesValue)
    TextView TVdatesValue;
    @BindView(R.id.TVmaxTransValue)
    TextView TVmaxTransValue;
    @BindView(R.id.TVmaxCostValue)
    TextView TVmaxCostValue;
    @BindView(R.id.Bedit)
    Button Bedit;
    @BindView(R.id.Bdel)
    Button Bdel;

    @BindView(R.id.Brefresh)
    Button Brefresh;
    @BindView(R.id.arrivalDateTextView)
    TextView arrivalDateTextView;
    @BindView(R.id.deparureDateTextView)
    TextView deparureDateTextView;
    @BindView(R.id.priceTextView)
    TextView priceTextView;
    @BindView(R.id.transfersNoTextView)
    TextView transfersNoTextView;
    @BindView(R.id.linkToOfferTextView)
    TextView linkToOfferTextView;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm");
//    DataRepository dataRepository = HashMapDataRepository.getInstance();

    public static TabFragment newInstance(ProfileData data) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putSerializable("profile-data", data);
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
        ButterKnife.bind(this, standard_tab_layout);

        if (data != null) {
            TVadultsValue.setText("" + data.getAdultsCount());
            TVchildsValue.setText("" + data.getChildCount());
            TVdepLocValue.setText("" + data.getDepartCity());
            TVarrLocValue.setText("" + data.getArrivalCity());
            TVdatesValue.setText(dateFormat.format(data.getStartDate())
                    + " - "
                    + dateFormat.format(data.getEndDate()));
            TVmaxTransValue.setText("" + data.getTransfersCount());
            TVmaxCostValue.setText(data.getMaxPrice().toString());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            String tmpStringData = data.getArrivalDate();
            tmpStringData = tmpStringData.replace("T", "<br/> ");
            tmpStringData = tmpStringData.replaceAll("\\.[0-9]*", "");
            tmpStringData = tmpStringData.replaceAll(":\\d\\d$", "");

            arrivalDateTextView.setText(fromHtml(tmpStringData));

            tmpStringData = "";
            tmpStringData = data.getDepartureDate();
            tmpStringData = tmpStringData.replace("T", "<br/> ");
            tmpStringData = tmpStringData.replaceAll("\\.[0-9]*", "");
            tmpStringData = tmpStringData.replaceAll(":\\d\\d$", "");

            deparureDateTextView.setText(fromHtml(tmpStringData));
            priceTextView.setText(data.getPrice() + " zł.");
            transfersNoTextView.setText(data.getRealTransfersNumber().toString());
            String value = "<html>Link do oferty <a href=\"" + data.getDeepLink() + "\">kiwi.com</a></html>";
            linkToOfferTextView.setText(fromHtml(value));
            linkToOfferTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        Bedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                Intent editIntent = new Intent(main.getBaseContext(), EditFormActivity.class);
                editIntent.putExtra("profile-data", data);
                main.startActivity(editIntent);
            }
        });

        Bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
//                dataRepository.removeProfile(UsersServiceMock.getSampleUser(), data);


                DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
                if(data.getId() != null) {
                    Call<Boolean> call = service.removeProfile(ActiveConnection.getInstance().getUserData().getEmail(), ActiveConnection.getInstance().getUserData().getPassword(), data.getId());

                    call.enqueue(new Callback<Boolean>() {

                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            Toast.makeText(getContext(), "Usunięto poprawnie!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Toast.makeText(getContext(), "Nie można usunąć rekordu. Sprawdź połączenie do internetu i spróbuj ponownie.", Toast.LENGTH_LONG).show();
                        }
                    });

                    main.onResume();
                }
                else{
                    Toast.makeText(getContext(), "Nie można usunąć rekordu. Rekord niepoprawny.", Toast.LENGTH_LONG).show();
                }
            }
        });


        return standard_tab_layout;
    }


}
