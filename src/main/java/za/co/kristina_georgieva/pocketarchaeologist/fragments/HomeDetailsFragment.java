package za.co.kristina_georgieva.pocketarchaeologist.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import za.co.kristina_georgieva.pocketarchaeologist.R;
import za.co.kristina_georgieva.pocketarchaeologist.views.ContextAndroidActivity;
import za.co.kristina_georgieva.pocketarchaeologist.views.HomeAndroidActivity;

/**
 * Created by Kris on 3/29/2015.
 */
public class HomeDetailsFragment extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details_home, container, false);

        initialiseView();

        return view;
    }

    private void initialiseView() {
        TextView siteName = (TextView) view.findViewById(R.id.text_site);
        siteName.setText("Mapungubwe");

        Button location = (Button) view.findViewById(R.id.button_location);
        location.setText("lat; long;");

        String[] values = new String[] { "C0001", "C0002", "C0003", "C0004", "C0005", "C0006"};
        setUpContexts(values);
    }

    private void setUpContexts(String[] values) {
        ListView listView = (ListView) view.findViewById(R.id.list_contexts);
        listView.setOnItemClickListener(onContextItemSelected);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
    }

    AdapterView.OnItemClickListener onContextItemSelected = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(getActivity(), ContextAndroidActivity.class);
            startActivity(intent);
        }
    };

}