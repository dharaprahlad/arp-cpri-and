package cpri.fragment;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.dhara.cpriapp.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import cpri.activity.AddSiteInfoActivity;

public class AwsFragment extends Fragment {

    EditText edtAwsPort, edtAwsPort1;
    Switch linkSwitch;
    ImageView imgPrev, imgNext;
    String[] CPRI = {"Other", "Pass", "Fail"};
    String[] PatchCabels = {"OPS-Y", "GMS-Y", "NO"};
    String[] SFP = {"Other", "65-3", "47-2"};
    String[] VSWR = {"Other", "Pass", "Fail"};
    String[] AILG = {"Other", "Pass", "Fail"};
    String[] ALARMS = {"Other", "Pass", "Fail"};


    public AwsFragment() {
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
        View rootview = inflater.inflate(R.layout.fragment_aws, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, CPRI);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner) rootview.findViewById(R.id.cpri_spinner);
        materialDesignSpinner.setAdapter(adapter);

        ArrayAdapter<String> adapterPatch = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, PatchCabels);
        MaterialBetterSpinner patchCabelSpinner = (MaterialBetterSpinner) rootview.findViewById(R.id.patch_cabel_spinner);
        patchCabelSpinner.setAdapter(adapterPatch);

        ArrayAdapter<String> adapterSFP = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, SFP);
        MaterialBetterSpinner sfpSpinner = (MaterialBetterSpinner) rootview.findViewById(R.id.sfp_spinner);
        sfpSpinner.setAdapter(adapterSFP);

        ArrayAdapter<String> adapterVSWR = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, VSWR);
        MaterialBetterSpinner vswrSpinner = (MaterialBetterSpinner) rootview.findViewById(R.id.vswr_spinner);
        vswrSpinner.setAdapter(adapterVSWR);

        ArrayAdapter<String> adapterAILG = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, AILG);
        MaterialBetterSpinner ailgSpinner = (MaterialBetterSpinner) rootview.findViewById(R.id.AILG_spinner);
        ailgSpinner.setAdapter(adapterAILG);

        ArrayAdapter<String> adapterALARMS = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, ALARMS);
        MaterialBetterSpinner alarmsSpinner = (MaterialBetterSpinner) rootview.findViewById(R.id.ALARMS_spinner);
        alarmsSpinner.setAdapter(adapterALARMS);

        edtAwsPort = (EditText) rootview.findViewById(R.id.aws_port_assignment_edt);
        edtAwsPort1 = (EditText) rootview.findViewById(R.id.aws_port_assignment_edt1);
        linkSwitch = (Switch) rootview.findViewById(R.id.linkSwitch);

        edtAwsPort.setFocusableInTouchMode(false);
        edtAwsPort.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edtAwsPort.setFocusableInTouchMode(true);
                edtAwsPort.requestFocus();
                return false;
            }
        });

        edtAwsPort1.setFocusableInTouchMode(false);
        edtAwsPort1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                edtAwsPort1.setFocusableInTouchMode(true);
                edtAwsPort1.requestFocus();
                return false;
            }
        });

        imgPrev = (ImageView) rootview.findViewById(R.id.img_prev);
        imgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent newFrag = new Intent(getContext(), LTEFragment.class);
                startActivity(newFrag);*/
                /*LTEFragment fragment = new LTEFragment();
                Bundle bundle = new Bundle();
                bundle.putString("username", " ");
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.lteFrag,fragment).commit();*/


            }
        });
        return rootview;
    }


}
