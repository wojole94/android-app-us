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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.connection.RetrofitClientInstance;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.datamodel.ProfileRequest;
import pl.studia.android.skyscanner.view.datamodel.ProfileResponse;
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

    final EditFormActivity context = this;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");//for mock
    SimpleDateFormat dateParser = new SimpleDateFormat("dd-MM-yyyy");
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    DataRepository dataRepo = HashMapDataRepository.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_form_layout);
        ButterKnife.bind(this);

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
//                    data.setDepartCity(SdepLoc.getSelectedItem().toString());
//                    data.setArrivalCity(SarrLoc.getSelectedItem().toString());
//                    data.setAdultsCount(Integer.parseInt(ETadults.getText().toString()));
//                    data.setChildCount(Integer.parseInt(ETchilds.getText().toString()));
//                    data.setTransfersCount(Integer.parseInt(ETmaxTrans.getText().toString()));
//                    data.setMaxPrice(Double.parseDouble(ETmaxCost.getText().toString()));
//                    data.setJustWeekends(CBweekends.isChecked());
//                    data.setStartDate(dateFormat.parse(ETdateFrom.getText().toString()));
//                    data.setEndDate(dateFormat.parse(ETdateTo.getText().toString()));

                    ProfileRequest profileRequest = new ProfileRequest();
                    profileRequest.setCityFrom(SdepLoc.getSelectedItem().toString());
                    profileRequest.setCityTo(SarrLoc.getSelectedItem().toString());
                    profileRequest.setAdultsNumber(Integer.parseInt(ETadults.getText().toString()));
                    profileRequest.setChildrenNumber(Integer.parseInt(ETchilds.getText().toString()));
                    profileRequest.setTransfersNumber(Integer.parseInt(ETmaxTrans.getText().toString()));
                    profileRequest.setMaximumPrice(Double.parseDouble(ETmaxCost.getText().toString()));
                    profileRequest.setOnlyWeekendFlights(CBweekends.isChecked());
                    profileRequest.setSearchStartDate(dateFormatter.format(dateParser.parse(ETdateFrom.getText().toString())));
                    profileRequest.setSearchEndDate(dateFormatter.format(dateParser.parse(ETdateTo.getText().toString())));

                    DataRepository service = RetrofitClientInstance.getRetrofitInstance().create(DataRepository.class);
                    Call<ProfileResponse> call = service.addProfile("jan@web.pl", "jan1", profileRequest);
                    call.enqueue(new Callback<ProfileResponse>(){

                        @Override
                        public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
                            Toast.makeText(getApplicationContext(), "Zapisano nowe parametry wyszukiwania!", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<ProfileResponse> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Wystąpił błąd! Nie zapisano wprowadzonych parametrów wyszukiwania. Spróbuj ponownie.", Toast.LENGTH_LONG).show();
                        }
                    });
                    context.finish();


                } catch (ParseException ex){
                    Toast.makeText(getApplicationContext(), "Nieprawidłowy format daty!",
                            Toast.LENGTH_LONG)
                            .show();
                }
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
