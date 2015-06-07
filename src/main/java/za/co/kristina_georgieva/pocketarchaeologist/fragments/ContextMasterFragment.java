package za.co.kristina_georgieva.pocketarchaeologist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import za.co.kristina_georgieva.pocketarchaeologist.R;

/**
 * Created by Kris on 3/29/2015.
 */
public class ContextMasterFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_context, container, false);

        listView = (ListView) view.findViewById(R.id.list_context);

        String[] values = new String[] {"C0001", "C0002", "C0003", "C0004", "C0005", "C0006"};
        setUpList(values);

        return view;
    }

    private void setUpList(String[] values) {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
    }
}