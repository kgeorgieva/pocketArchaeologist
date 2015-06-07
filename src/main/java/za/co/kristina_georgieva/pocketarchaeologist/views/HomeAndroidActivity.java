package za.co.kristina_georgieva.pocketarchaeologist.views;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import za.co.kristina_georgieva.pocketarchaeologist.R;
import za.co.kristina_georgieva.pocketarchaeologist.fragments.HomeDetailsFragment;
import za.co.kristina_georgieva.pocketarchaeologist.fragments.HomeMasterFragment;

public class HomeAndroidActivity extends Activity {

    private static String TAG = "pocketArchaeologist";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment masterFragment = fragmentManager.findFragmentById(R.id.fragment_master_home);
        Fragment detailsFragment = fragmentManager.findFragmentById(R.id.fragment_details_home);
        Fragment contentFragment = fragmentManager.findFragmentById(android.R.id.content);

        Configuration config = getResources().getConfiguration();

        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setUpLandscape(masterFragment,detailsFragment,contentFragment);
        } else {
            setUpPortrait(masterFragment,detailsFragment);
        }
    }

    private void setUpLandscape(Fragment masterFragment, Fragment detailsFragment, Fragment contentFragment) {
        FragmentManager fragmentManager = getFragmentManager();

        if(contentFragment != null) {
            fragmentManager.beginTransaction().remove(contentFragment).commit();
        }

        if (masterFragment == null) {
            masterFragment = new HomeMasterFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_master_home, masterFragment).commit();

        }

        if (detailsFragment == null) {
            detailsFragment = new HomeDetailsFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_details_home, detailsFragment).commit();

        }
    }

    private void setUpPortrait(Fragment masterFragment, Fragment detailsFragment) {
        FragmentManager fragmentManager = getFragmentManager();

        if(masterFragment != null) {
            fragmentManager.beginTransaction().remove(masterFragment).commit();
        }

        if(detailsFragment != null) {
            fragmentManager.beginTransaction().remove(detailsFragment).commit();
        }

        masterFragment = new HomeMasterFragment();

        fragmentManager.beginTransaction() .replace(android.R.id.content, masterFragment).commit();
    }
}

