package pl.studia.android.skyscanner.view.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.ApiClient;
import pl.studia.android.skyscanner.view.connection.ApiInterface;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RestApiDataRepository;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.UserData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditFormActivity extends AppCompatActivity {
    @BindView(R.id.Bcancel) Button Bcancel;
    @BindView(R.id.Bsave) Button Bsave;
    @BindView(R.id.SdepLoc) Spinner SdepLoc;
    @BindView(R.id.SarrLoc) Spinner SarrLoc;
    @BindView(R.id.ETadults) EditText ETadults;
    @BindView(R.id.ETchilds) EditText ETchilds;
    @BindView(R.id.ETmaxTrans) EditText ETmaxTrans;
    @BindView(R.id.ETmaxCost) EditText ETmaxCost;
    @BindView(R.id.CBweekends) CheckBox CBweekends;
    @BindView(R.id.ETdateFrom) EditText ETdateFrom;
    @BindView(R.id.ETdateTo) EditText ETdateTo;
    @BindView(R.id.BdateFrom) ImageButton BdateFrom;
    @BindView(R.id.BdateTo) ImageButton BdateTo;
    @BindView(R.id.buttonTest) Button buttonTest;

    final EditFormActivity context = this;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_form_layout);
        ButterKnife.bind(this);
        DataRepository dataRepo = HashMapDataRepository.getInstance();
        List<String> citiesList =  dataRepo.getCitiesList();
        Bundle extras = getIntent().getExtras();
        ProfileData data;
        if (extras == null || extras.getSerializable("profile-data") == null){
            data = new ProfileData();
        } else {
            data = (ProfileData) extras.getSerializable("profile-data");
        }

        String[] spinnerElems = {};
        spinnerElems = citiesList.toArray(spinnerElems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerElems);
        SdepLoc.setAdapter(adapter);
        SarrLoc.setAdapter(adapter);

        SdepLoc.setSelection(citiesList.indexOf(data.getDepartCity()));
        SarrLoc.setSelection(citiesList.indexOf(data.getArrivalCity()));
        ETadults.setText(data.getAdultsCount().toString());
        ETchilds.setText(data.getChildCount().toString());
        ETmaxTrans.setText(data.getTransfersCount().toString());
        ETmaxCost.setText(data.getMaxPrice().toString());
        CBweekends.setChecked(data.getJustWeekends());
        ETdateFrom.setText(dateFormat.format(data.getStartDate()));
        ETdateTo.setText(dateFormat.format(data.getEndDate()));


        BdateFrom.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation") @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                showDialog(1);
            }
        });


        BdateTo.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation") @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                showDialog(2);
            }
        });

        Bcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                context.finish();
            }
        });

        Bsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting new fragment at tab
                //Taking data from form and create profile
                try{

                    data.setDepartCity(SdepLoc.getSelectedItem().toString());
                    data.setArrivalCity(SarrLoc.getSelectedItem().toString());
                    data.setAdultsCount(Integer.parseInt(ETadults.getText().toString()));
                    data.setChildCount(Integer.parseInt(ETchilds.getText().toString()));
                    data.setTransfersCount(Integer.parseInt(ETmaxTrans.getText().toString()));
                    data.setMaxPrice(Double.parseDouble(ETmaxCost.getText().toString()));
                    data.setJustWeekends(CBweekends.isChecked());
                    data.setStartDate(dateFormat.parse(ETdateFrom.getText().toString()));
                    data.setEndDate(dateFormat.parse(ETdateTo.getText().toString()));

                    HashMapDataRepository.getInstance().addProfile(UsersServiceMock.getSampleUser(), data);
                    context.finish();


                } catch (ParseException ex){
                    Toast.makeText(getApplicationContext(), "Nieprawidłowy format daty!",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }
        });

        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<List<UserData>> call = apiInterface.getUsers();
                call.enqueue(new Callback<List<UserData>>() {
                    @Override
                    public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                        int status = response.code();
                        ArrayList<UserData> questionModels = (ArrayList<UserData>) response.body();
                        System.out.println(questionModels.toString());
                    }

                    @Override
                    public void onFailure(Call<List<UserData>> call, Throwable t) {
                        int i=0;
                    }
                });
            }
        });




    }

    @SuppressWarnings("deprecation") @Override
    protected Dialog onCreateDialog(int id) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        if (id == 1) {
            DatePickerDialog.OnDateSetListener fromDateListener = new
                    DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker arg0,
                                              int arg1, int arg2, int arg3) {
                            // arg1 = year
                            // arg2 = month
                            // arg3 = day
                            ETdateFrom.setText(new StringBuilder().append(arg3).append("-")
                                        .append(arg2+1).append("-").append(arg1));
                        }
                    };
            return new DatePickerDialog(this,
                    fromDateListener, year, month, day);
        }
        if (id == 2) {
            DatePickerDialog.OnDateSetListener fromDateListener = new
                    DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker arg0,
                                              int arg1, int arg2, int arg3) {
                            // arg1 = year
                            // arg2 = month
                            // arg3 = day
                            ETdateTo.setText(new StringBuilder().append(arg3).append("-")
                                    .append(arg2+1).append("-").append(arg1));
                        }
                    };
            return new DatePickerDialog(this,
                    fromDateListener, year, month, day);
        }

        return null;
    }

}
