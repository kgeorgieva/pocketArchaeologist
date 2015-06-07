package za.co.kristina_georgieva.pocketarchaeologist.fragments;

import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import za.co.kristina_georgieva.pocketarchaeologist.R;

import javax.annotation.Resource;

/**
 * Created by Kris on 3/29/2015.
 */
public class ContextDetailsFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details_context, container, false);

        initialiseView();

        return view;
    }

    private void initialiseView() {

    }

}