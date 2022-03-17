package edu.sharif.mpqueraapp.view.authentication.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import edu.sharif.mpqueraapp.R;

public class SignUpTabFragment extends Fragment {

    private String[] titles = {"Student", "Professor"};

    TabLayout tabLayout;
    ViewPager2 viewPager;
    SignUpAdapter signUpAdapter;
    float v = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        titles[0] = getString(R.string.student);
        titles[1] = getString(R.string.professor);

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        tabLayout = root.findViewById(R.id.tab_layout);
        viewPager = root.findViewById(R.id.view_pager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        signUpAdapter = new SignUpAdapter(this.getActivity());
        viewPager.setAdapter(signUpAdapter);

        new TabLayoutMediator(tabLayout, viewPager,((tab, i) -> tab.setText(titles[i]))).attach();


        tabLayout.setTranslationY(300);
        tabLayout.setAlpha(v);
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        return root;

    }
}
