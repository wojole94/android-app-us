package pl.studia.android.skyscanner.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
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
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RetrofitClientInstance;
import pl.studia.android.skyscanner.view.datamodel.LoginInformation;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.ProfileResponse;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
    @BindView(R.id.TVweekendsValue)
    TextView TVweekendsValue;
    @BindView(R.id.Bedit)
    Button Bedit;
    @BindView(R.id.Bdel)
    Button Bdel;


    @BindView(R.id.linkToOfferTextView)
    TextView linkToOfferTextView;
    @BindView((R.id.Brefresh))
    Button Brefresh;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    DataRepository dataRepository = HashMapDataRepository.getInstance();

    String testString = "wersja startowa";

    //    public static TabFragment newInstance(ProfileData data){
//        TabFragment fragment = new TabFragment();
//        Bundle args = new Bundle();
//        args.putSerializable("profile-data",data);
//        fragment.setArguments(args);
//        return fragment;
//    }
    public static TabFragment newInstance(ProfileResponse data) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putSerializable("profile-response", data);
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
        ProfileResponse data = (ProfileResponse) arguments.getSerializable("profile-response");
        LinearLayout standard_tab_layout = (LinearLayout) inflater.inflate(R.layout.standard_tab_layout, null);
        ButterKnife.bind(this, standard_tab_layout);

        TVadultsValue.setText("" + data.getAdults());
        TVchildsValue.setText("" + data.getChildren());
        TVdepLocValue.setText("" + data.getFlyFrom());
        TVarrLocValue.setText("" + data.getFlyTo());
        TVdatesValue.setText(dateFormat.format(data.getDepartureDate())
                + " - "
                + dateFormat.format(data.getArrivalDate()));
        TVmaxTransValue.setText("" + data.getTransfersCount());
        TVmaxCostValue.setText(data.getPrice().toString());
        TVweekendsValue.setText(data.getOnlyWeekends().toString());

        Bedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                Intent editIntent = new Intent(main.getBaseContext(), EditFormActivity.class);
                editIntent.putExtra("profile-response", data);
                main.startActivity(editIntent);
            }
        });

        Bdel.setOnClickListener(new View.OnClickListener() {
            @SneakyThrows
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
//                dataRepository.removeProfile(UsersServiceMock.getSampleUser(), data);

                DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
                Call<Boolean> tmp = service.removeProfile(LoginInformation.getInstance().getUserData().getEmail(), LoginInformation.getInstance().getPassword(), data);
                tmp.enqueue(new Callback<Boolean>() {

                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        Toast.makeText(MainActivity.getContext(), "Usunięto!", Toast.LENGTH_LONG).show();
                        main.onResume();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        Toast.makeText(MainActivity.getContext(), "Podczas usuwania wystąpiły błędy! Spróbuj ponownie", Toast.LENGTH_LONG).show();
                        main.onResume();
                    }
                });

            }
        });

        Brefresh.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
//                Call<List<ProfileResponse>> call = service.getAllProfiles("jan@web.pl", "jan1");
//
//                System.out.println("test1");
//                call.enqueue(new Callback<List<ProfileResponse>>() {
//
//                    @Override
//                    public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
//                        System.out.println("test2");
////                        linkToOfferTextView.setText();
//                        Linkify.addLinks(linkToOfferTextView, Linkify.WEB_URLS);
////                        List<ProfileResponse> apiResponse = response.body();
//
////                        System.out.println(apiResponse);
//                    }
//
//                    @Override
//                    public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {
//                        System.out.println("test3");
//                        int i=0;
//                    }
//                });


            }
        }));


        return standard_tab_layout;
    }


}
