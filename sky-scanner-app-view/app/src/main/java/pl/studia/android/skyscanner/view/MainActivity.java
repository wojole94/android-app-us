package pl.studia.android.skyscanner.view;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import pl.studia.android.skyscanner.view.ui.main.PageViewModel;
import pl.studia.android.skyscanner.view.ui.main.PlaceholderFragment;
import pl.studia.android.skyscanner.view.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        //Getting current selected page pageviewmodel text
        //TODO right now it returns null refernce (check edit button) - to investigate why by using logger - remind in xieskis notes
        //TODO more datails desribed in evernote notepad under name "Android - notatki".
        Integer currItemID = viewPager.getCurrentItem();
        Fragment currentFragment = sectionsPagerAdapter.getItem(currItemID);
        final PageViewModel pageViewModel = ((PlaceholderFragment) currentFragment).getPageViewModel();


        FloatingActionButton add_fab = findViewById(R.id.add_fab);
        FloatingActionButton edit_fab = findViewById(R.id.edit_fab);

        add_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace kurwa gunwo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        edit_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Invoking edit button on " + pageViewModel.getText(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
}