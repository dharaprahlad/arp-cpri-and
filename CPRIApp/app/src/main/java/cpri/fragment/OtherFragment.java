package cpri.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Switch;

import com.example.dhara.cpriapp.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class OtherFragment extends Fragment {

    EditText edt850Port, edt850Port1;
    Switch linkSwitch;
    String[] CPRI = {"Other", "Pass", "Fail"};
    String[] PatchCabels = {"OPS-Y", "GMS-Y", "NO"};
    String[] SFP = {"Other", "65-3", "47-2"};
    String[] VSWR = {"Other", "Pass", "Fail"};
    String[] AILG = {"Other", "Pass", "Fail"};
    String[] ALARMS = {"Other", "Pass", "Fail"};

    public OtherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_other, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, CPRI);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) v.findViewById(R.id.cpri_spinner);
        materialDesignSpinner.setAdapter(adapter);

        ArrayAdapter<String> adapterPatch = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, PatchCabels);
        MaterialBetterSpinner patchCabelSpinner = (MaterialBetterSpinner) v.findViewById(R.id.patch_cabel_spinner);
        patchCabelSpinner.setAdapter(adapterPatch);

        ArrayAdapter<String> adapterSFP = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, SFP);
        MaterialBetterSpinner sfpSpinner = (MaterialBetterSpinner) v.findViewById(R.id.sfp_spinner);
        sfpSpinner.setAdapter(adapterSFP);

        ArrayAdapter<String> adapterVSWR = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, VSWR);
        MaterialBetterSpinner vswrSpinner = (MaterialBetterSpinner) v.findViewById(R.id.vswr_spinner);
        vswrSpinner.setAdapter(adapterVSWR);

        ArrayAdapter<String> adapterAILG = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, AILG);
        MaterialBetterSpinner ailgSpinner = (MaterialBetterSpinner) v.findViewById(R.id.AILG_spinner);
        ailgSpinner.setAdapter(adapterAILG);

        ArrayAdapter<String> adapterALARMS = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, ALARMS);
        MaterialBetterSpinner alarmsSpinner = (MaterialBetterSpinner) v.findViewById(R.id.ALARMS_spinner);
        alarmsSpinner.setAdapter(adapterALARMS);

        edt850Port = (EditText) v.findViewById(R.id.other_port_assignment_edt);
        edt850Port1 = (EditText) v.findViewById(R.id.other_port_assignment_edt1);
        linkSwitch = (Switch) v.findViewById(R.id.linkSwitch);

        edt850Port.setFocusableInTouchMode(false);
        edt850Port.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edt850Port.setFocusableInTouchMode(true);
                edt850Port.requestFocus();
                return false;
            }
        });

        edt850Port1.setFocusableInTouchMode(false);
        edt850Port1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edt850Port1.setFocusableInTouchMode(true);
                edt850Port1.requestFocus();
                return false;
            }
        });
        return v;
    }
}
