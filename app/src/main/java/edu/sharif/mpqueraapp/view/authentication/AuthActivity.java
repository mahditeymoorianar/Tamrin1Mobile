package edu.sharif.mpqueraapp.view.authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import edu.sharif.mpqueraapp.R;
import edu.sharif.mpqueraapp.controller.data.Load;

public class AuthActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    AuthAdapter authAdapter;
    public static SharedPreferences mPrefs;
    private String[] titles = {"Login", "Sign Up"};
    float v = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        authAdapter = new AuthAdapter(this);
        mPrefs = getPreferences(MODE_PRIVATE);
        Load.loadUsers(mPrefs);
        Load.loadCourses(mPrefs);
        viewPager.setAdapter(authAdapter);
        new TabLayoutMediator(tabLayout, viewPager,((tab, i) -> tab.setText(titles[i]))).attach();

        tabLayout.setTranslationY(300);
        tabLayout.setAlpha(v);
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();


    }
}