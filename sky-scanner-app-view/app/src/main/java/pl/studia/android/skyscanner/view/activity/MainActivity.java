package pl.studia.android.skyscanner.view.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RestApiDataRepository;
import pl.studia.android.skyscanner.view.connection.RestApiImplementation;
import pl.studia.android.skyscanner.view.connection.RetrofitClientInstance;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    static final Integer ADD_TAB_ID = -1;
    @BindView(R.id.viewgroup) ViewGroup scrollViewgroup;
    DataRepository dataAccess;
    Map<Integer, ProfileData> items;
    UserData user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Fake user for alpha version
        user = UsersServiceMock.getSampleUser();
        //Call for already assigned profiles
        dataAccess = HashMapDataRepository.getInstance();
        items = dataAccess.getProfiles(user);
        buildTabsList(items);

//        //TODO test
//        DataRepository apiService = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
//        UserData userData = RestApiImplementation.getInstance().getUser("janusz@web.pl");
////        Call<UserData> call = apiService.getUser("janusz@web.pl");
////        call.enqueue(new Callback<UserData>() {
////            @Override
////            public void onResponse(Call<UserData> call, Response<UserData> response) {
////                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
////            }
////
////            @Override
////            public void onFailure(Call<UserData> call, Throwable t) {
////
////            }
////        });
//int i=0;
    }

    @Override
    protected void onResume(){
        super.onResume();
        scrollViewgroup.removeAllViews();
        items = dataAccess.getProfiles(user);
        buildTabsList(items);

    }

    private void buildTabsList(Map<Integer, ProfileData> items){

        for (Map.Entry<Integer,ProfileData> entry : items.entrySet()) {
            final View singleFrame = getLayoutInflater().inflate(
                    R.layout.frame_icon_caption, null);
            singleFrame.setId(entry.getKey());
            TextView caption = singleFrame.findViewById(R.id.caption);

            scrollViewgroup.addView(singleFrame);
            caption.setText(entry.getValue().toString());
            singleFrame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Setting new fragment at tab
                    Integer dataID = v.getId();
                    Map<Integer, ProfileData> data = dataAccess.getProfiles(user);
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    TabFragment tabFragment = TabFragment.newInstance(data.get(dataID));
                    ft.replace(R.id.tab_holder, tabFragment);
                    ft.commit();
                }
            });
        }

        final View singleFrame = getLayoutInflater().inflate(
                R.layout.frame_icon_caption, null);
        TextView caption = singleFrame.findViewById(R.id.caption);
        singleFrame.setId(ADD_TAB_ID);
        caption.setText(R.string.add_new_profile_tab_caption);
        scrollViewgroup.addView(singleFrame);
        singleFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                AddTabFragment addTabFragment = AddTabFragment.newInstance();
                ft.replace(R.id.tab_holder, addTabFragment);
                ft.commit();
            }
        });
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AddTabFragment addTabFragment = AddTabFragment.newInstance();
        ft.replace(R.id.tab_holder, addTabFragment);
        ft.commit();
    }
}