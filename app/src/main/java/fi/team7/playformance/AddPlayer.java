package fi.team7.playformance;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import fi.team7.playformance.data.Player;
import fi.team7.playformance.teams.NewPlayerOld;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddPlayer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddPlayer extends Fragment {

    private EditText firstName, lastName, number;
    private Button btnSave;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddPlayer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewPlayerOld.
     */
    // TODO: Rename and change types and number of parameters
    public static AddPlayer newInstance(String param1, String param2) {
        AddPlayer fragment = new AddPlayer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_player, container, false);

        firstName = view.findViewById(R.id.txtNewPfirstName2);
        lastName = view.findViewById(R.id.txtNewPlaststName2);
        number = view.findViewById(R.id.txtNewPlayerNumber2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fistNameSt = firstName.getText().toString();
                String lastNameSt = lastName.getText().toString();
                int numberInt = Integer.parseInt(number.getText().toString());
                Player p = new Player(0, fistNameSt, lastNameSt, numberInt, 1);
                NewPlayerOld.appDB.playerDAO().createPlayer(p);
                Toast.makeText(getActivity(), "Player added", Toast.LENGTH_SHORT).show();

                firstName.setText("");
                lastName.setText("");
                number.setText("");
            }
        });


        return view;
        // Inflate the layout for this fragment
    }
}