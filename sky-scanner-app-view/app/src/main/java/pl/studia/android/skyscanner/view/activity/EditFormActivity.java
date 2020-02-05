package pl.studia.android.skyscanner.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.studia.android.skyscanner.view.R;
import pl.studia.android.skyscanner.view.connection.HashMapDataRepository;
import pl.studia.android.skyscanner.view.datamodel.ProfileData;
import pl.studia.android.skyscanner.view.mocks.UsersServiceMock;

public class EditFormActivity extends AppCompatActivity {
    @BindView(R.id.Bcancel) Button Bcancel;
    @BindView(R.id.Bsave) Button Bsave;
    @BindView(R.id.ETdepLoc) EditText ETdepLoc;
    @BindView(R.id.ETarrLoc) EditText ETarrLoc;

    final EditFormActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_form_layout);
        ButterKnife.bind(this);

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
                data.setDepartCity(ETdepLoc.getText().toString());
                data.setArrivalCity(ETarrLoc.getText().toString());
                HashMapDataRepository.getInstance().addProfile(UsersServiceMock.getSampleUser(), data);
                context.finish();
            }
        });
    }
}
