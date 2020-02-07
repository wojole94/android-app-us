package pl.studia.android.skyscanner.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.DataRepository;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;

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

    final EditFormActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_form_layout);
        ButterKnife.bind(this);

        DataRepository dataRepo = HashMapDataRepository.getInstance();

        String[] spinnerElems = {};

        spinnerElems = dataRepo.getCitiesList().toArray(spinnerElems);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                spinnerElems);

        SdepLoc.setAdapter(adapter);
        SarrLoc.setAdapter(adapter);


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
                ProfileData data = new ProfileData();

                //Taking data from form
                //TODO look for data picker, check visibility of data on tab
                data.setDepartCity(SdepLoc.getSelectedItem().toString());
                data.setArrivalCity(SarrLoc.getSelectedItem().toString());
                data.setAdultsCount(Integer.parseInt(ETadults.getText().toString()));
                data.setChildCount(Integer.parseInt(ETchilds.getText().toString()));
                data.setTransfersCount(Integer.parseInt(ETmaxTrans.getText().toString()));
                data.setMaxPrice(Double.parseDouble(ETmaxCost.getText().toString()));
                data.setJustWeekends(CBweekends.isChecked());

                HashMapDataRepository.getInstance().addProfile(UsersServiceMock.getSampleUser(), data);
                context.finish();
            }
        });
    }

}
