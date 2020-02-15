package pl.studia.android.skyscanner.view.activity;

import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import butterknife.BindView;
import butterknife.ButterKnife;
import lombok.SneakyThrows;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RetrofitClientInstance;
import pl.studia.android.skyscanner.view.connection.SkyScannerService;
import pl.studia.android.skyscanner.view.datamodel.LoginInformation;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.ProfileResponse;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    static final Integer ADD_TAB_ID = -1;
    @BindView(R.id.viewgroup)
    ViewGroup scrollViewgroup;
    private static Context context;
    DataRepository dataAccess = HashMapDataRepository.getInstance();
    //    Map<Integer, ProfileData> items;
    Map<Integer, ProfileResponse> itemsResponse;
    UserData user;


    @SneakyThrows
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        ButterKnife.bind(this);

/*        //Fake user for alpha version
        user = UsersServiceMock.getSampleUser();
        //Call for already assigned profiles
                items = dataAccess.getProfiles(user);
        buildTabsList(items);*/

        getUserProfiles();

    }

    private void getUserProfiles() throws IOException {
        user = LoginInformation.getInstance().getUserData();
        DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
        Call<List<ProfileResponse>> allProfiles = service.getAllProfiles("jan@web.pl", "jan1");
        allProfiles.enqueue(new Callback<List<ProfileResponse>>() {
            @Override
            public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
                List<ProfileResponse> profileResponseList = response.body();
                itemsResponse = new HashMap<>();
                int i = 0;
                for (ProfileResponse profileResponse : profileResponseList)
                    itemsResponse.put(++i, profileResponse);
                buildTabsList(itemsResponse);
            }

            @Override
            public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {

            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        scrollViewgroup.removeAllViews();
//        items = dataAccess.getProfiles(user);
//        buildTabsList(items);
//
//    }

    @SneakyThrows
    @Override
    protected void onResume() {
        super.onResume();
        scrollViewgroup.removeAllViews();

        getUserProfiles();

    }

//    private void buildTabsList(Map<Integer, ProfileData> items) {
//
//        for (Map.Entry<Integer, ProfileData> entry : items.entrySet()) {
//            final View singleFrame = getLayoutInflater().inflate(
//                    R.layout.frame_icon_caption, null);
//            singleFrame.setId(entry.getValue().getId());
//            TextView caption = singleFrame.findViewById(R.id.caption);
//
//            scrollViewgroup.addView(singleFrame);
//            caption.setText(entry.getValue().toString());
//            singleFrame.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //Setting new fragment at tab
//                    Integer dataID = v.getId();
//                    Map<Integer, ProfileData> data = dataAccess.getProfiles(user);
//                    FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    TabFragment tabFragment = TabFragment.newInstance(data.get(dataID));
//                    ft.replace(R.id.tab_holder, tabFragment);
//                    ft.commit();
//                }
//            });
//        }
//
//        final View singleFrame = getLayoutInflater().inflate(
//                R.layout.frame_icon_caption, null);
//        TextView caption = singleFrame.findViewById(R.id.caption);
//        singleFrame.setId(ADD_TAB_ID);
//        caption.setText(R.string.add_new_profile_tab_caption);
//        scrollViewgroup.addView(singleFrame);
//        singleFrame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Setting new fragment at tab
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                AddTabFragment addTabFragment = AddTabFragment.newInstance();
//                ft.replace(R.id.tab_holder, addTabFragment);
//                ft.commit();
//            }
//        });
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        AddTabFragment addTabFragment = AddTabFragment.newInstance();
//        ft.replace(R.id.tab_holder, addTabFragment);
//        ft.commit();
//    }

    private void buildTabsList(Map<Integer, ProfileResponse> items) {

        for (Map.Entry<Integer, ProfileResponse> entry : items.entrySet()) {
            final View singleFrame = getLayoutInflater().inflate(
                    R.layout.frame_icon_caption, null);
            singleFrame.setId(entry.getValue().getId());
            TextView caption = singleFrame.findViewById(R.id.caption);

            scrollViewgroup.addView(singleFrame);
            String tabDescription = "UNKNOWN";
            if (entry.getValue().getFlyFrom() != null && entry.getValue().getFlyTo() != null)
                tabDescription = entry.getValue().getFlyFrom() + " >" + entry.getValue().getFlyTo();
            caption.setText(tabDescription);
            singleFrame.setOnClickListener(new View.OnClickListener() {
                @SneakyThrows
                @Override
                public void onClick(View v) {
                    //Setting new fragment at tab
                    Integer dataID = v.getId();
//                    Map<Integer, ProfileData> data = dataAccess.getProfiles(user);

                    DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
                    Call<List<ProfileResponse>> allProfiles = service.getAllProfiles(user.getEmail(), LoginInformation.getInstance().getPassword());
                    allProfiles.enqueue(new Callback<List<ProfileResponse>>(){

                        @Override
                        public void onResponse(Call<List<ProfileResponse>> call, Response<List<ProfileResponse>> response) {
                            Map<Integer, ProfileResponse> data = itemsResponse;
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            TabFragment tabFragment = TabFragment.newInstance(data.get(dataID));
                            ft.replace(R.id.tab_holder, tabFragment);
                            ft.commit();
                        }

                        @Override
                        public void onFailure(Call<List<ProfileResponse>> call, Throwable t) {

                        }
                    } );

//                    Map<Integer, ProfileResponse> data = dataAccess.getProfiles(user);
//                    FragmentTransaction ft = getFragmentManager().beginTransaction();
//                    TabFragment tabFragment = TabFragment.newInstance(data.get(dataID));
//                    ft.replace(R.id.tab_holder, tabFragment);
//                    ft.commit();
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

    public static Context getContext() {
        return context;
    }
}