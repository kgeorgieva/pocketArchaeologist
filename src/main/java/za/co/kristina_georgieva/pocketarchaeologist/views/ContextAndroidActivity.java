package za.co.kristina_georgieva.pocketarchaeologist.views;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import za.co.kristina_georgieva.pocketarchaeologist.R;
import za.co.kristina_georgieva.pocketarchaeologist.fragments.ContextDetailsFragment;
import za.co.kristina_georgieva.pocketarchaeologist.fragments.ContextMasterFragment;
import za.co.kristina_georgieva.pocketarchaeologist.fragments.HomeDetailsFragment;
import za.co.kristina_georgieva.pocketarchaeologist.fragments.HomeMasterFragment;

public class ContextAndroidActivity extends Activity {

    private static String TAG = "pocketArchaeologist";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context);

        FragmentManager fragmentManager = getFragmentManager();
        Fragment masterFragment = fragmentManager.findFragmentById(R.id.fragment_master_context);
        Fragment detailsFragment = fragmentManager.findFragmentById(R.id.fragment_details_context);
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
            masterFragment = new ContextMasterFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_master_context, masterFragment).commit();

        }

        if (detailsFragment == null) {
            detailsFragment = new ContextDetailsFragment();

            fragmentManager.beginTransaction()
                    .add(R.id.fragment_details_context, detailsFragment).commit();

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

        masterFragment = new ContextMasterFragment();

        fragmentManager.beginTransaction() .replace(android.R.id.content, masterFragment).commit();
    }
}

