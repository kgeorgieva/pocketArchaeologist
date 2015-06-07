package za.co.kristina_georgieva.pocketarchaeologist.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import za.co.kristina_georgieva.pocketarchaeologist.R;

/**
 * Created by Kris on 3/29/2015.
 */
public class HomeMasterFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_home, container, false);

        listView = (ListView) view.findViewById(R.id.list_home);

        String[] values = new String[] { "Mapungubwe", "Pompeii", "Giza", "Tulum", "Ephesus", "Perperikon"};
        setUpList(values);

        return view;
    }

    private void setUpList(String[] values) {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
    }

    AdapterView.OnItemSelectedListener onSiteItemSelected = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}