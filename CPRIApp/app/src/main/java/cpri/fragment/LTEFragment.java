package cpri.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.dhara.cpriapp.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class LTEFragment extends Fragment {

    EditText edtLtePort, edtLtePort1;
    Switch linkSwitch;
    ImageView imgPrev, imgNext;
    String[] CPRI = {"Other", "Pass", "Fail"};
    String[] PatchCabels = {"OPS-Y", "GMS-Y", "NO"};
    String[] SFP = {"Other", "65-3", "47-2"};
    String[] VSWR = {"Other", "Pass", "Fail"};
    String[] AILG = {"Other", "Pass", "Fail"};
    String[] ALARMS = {"Other", "Pass", "Fail"};

    public LTEFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_lte, container, false);

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

        edtLtePort = (EditText) v.findViewById(R.id.lte_port_assignment_edt);
        edtLtePort1 = (EditText) v.findViewById(R.id.lte_port_assignment_edt1);
        linkSwitch = (Switch) v.findViewById(R.id.linkSwitch);

        edtLtePort.setFocusableInTouchMode(false);
        edtLtePort.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edtLtePort.setFocusableInTouchMode(true);
                edtLtePort.requestFocus();
                return false;
            }
        });

        edtLtePort1.setFocusableInTouchMode(false);
        edtLtePort1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edtLtePort1.setFocusableInTouchMode(true);
                edtLtePort1.requestFocus();
                return false;
            }
        });

        return v;
    }
}
