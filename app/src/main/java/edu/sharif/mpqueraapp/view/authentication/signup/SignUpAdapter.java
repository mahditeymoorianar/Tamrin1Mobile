package edu.sharif.mpqueraapp.view.authentication.signup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SignUpAdapter extends FragmentStateAdapter {

    private String[] titles = {"Student", "Professor"};

    public SignUpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new StudentSignUpTabFragment();
            case 1:
                return new ProfSignUpTabFragment();
            default:
                return new StudentSignUpTabFragment();
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

}
