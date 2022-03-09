package edu.sharif.mpqueraapp.view.authentication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import edu.sharif.mpqueraapp.view.authentication.login.LoginTabFragment;
import edu.sharif.mpqueraapp.view.authentication.signup.SignUpTabFragment;

public class AuthAdapter extends FragmentStateAdapter {

    private String[] titles = {"Login", "Sign Up"};

    public AuthAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LoginTabFragment();
            case 1:
                return new SignUpTabFragment();
            default:
                return new LoginTabFragment();
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
