package pl.studia.android.skyscanner.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EditFormActivity extends AppCompatActivity {
    @BindView(R.id.Bcancel) Button Bcancel;
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
    }
}
