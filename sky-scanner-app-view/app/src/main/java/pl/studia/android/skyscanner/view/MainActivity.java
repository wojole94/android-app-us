package pl.studia.android.skyscanner.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity{

    protected ViewPager viewPager;
    protected TabLayout tabs;
     TextView txtMsg;
    ViewGroup scrollViewgroup;

    String[] items = { "Data-1", "Dodaj..." };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollViewgroup = findViewById(R.id.viewgroup);
        ButterKnife.bind(this);



        for (int i = 0; i < items.length; i++) {
            final View singleFrame = getLayoutInflater().inflate(
                    R.layout.frame_icon_caption, null);
            singleFrame.setId(i);
            TextView caption = singleFrame.findViewById(R.id.caption);
            caption.setText(items[i]);
            scrollViewgroup.addView(singleFrame);
            if (i != items.length - 1) {
                singleFrame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Setting new fragment at tab
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        TabFragment tabFragment = TabFragment.newInstance();
                        ft.replace(R.id.tab_holder, tabFragment);
                        ft.commit();
                    }
                });
            } else {
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
            }


        }






    }
}