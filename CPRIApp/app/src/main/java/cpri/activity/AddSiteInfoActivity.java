package cpri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.dhara.cpriapp.R;

public class AddSiteInfoActivity extends BaseActivity {

    private Toolbar toolbar1;
    private EditText inputSitename, inputHostname, inputFOPS, inputGC, inputENIB;
    private TextInputLayout inputLayoutSitename, inputLayoutHostname, inputLayoutFOPS, inputLayoutGC, inputLayoutENIB;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_site_info);

        toolbar1 = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputLayoutSitename = (TextInputLayout) findViewById(R.id.input_layout_sitename);
        inputLayoutHostname = (TextInputLayout) findViewById(R.id.input_layout_hostname);
        inputLayoutFOPS = (TextInputLayout) findViewById(R.id.input_layout_fops);
        inputLayoutGC = (TextInputLayout) findViewById(R.id.input_layout_gc);
        inputLayoutENIB = (TextInputLayout) findViewById(R.id.input_layout_enib);
        inputSitename = (EditText) findViewById(R.id.input_sitename);
        inputHostname = (EditText) findViewById(R.id.input_hostname);
        inputFOPS = (EditText) findViewById(R.id.input_fops);
        inputGC = (EditText) findViewById(R.id.input_gc);
        inputENIB = (EditText) findViewById(R.id.input_enib);
        btnNext = (Button) findViewById(R.id.btn_next);

        inputSitename.addTextChangedListener(new MyTextWatcher(inputSitename));
        inputHostname.addTextChangedListener(new MyTextWatcher(inputHostname));
        inputFOPS.addTextChangedListener(new MyTextWatcher(inputFOPS));
        inputGC.addTextChangedListener(new MyTextWatcher(inputGC));
        inputENIB.addTextChangedListener(new MyTextWatcher(inputENIB));

       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               submitForm();

           }
       });
    }

    @Override
    public void setReference() {

    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateSite()) {
            return;
        }

        if (!validateHost()) {
            return;
        }

        if (!validateFOPS()) {
            return;
        }

        if (!validateGC()) {
            return;
        }

        if (!validateENIB()) {
            return;
        }

        Intent iNext = new Intent(AddSiteInfoActivity.this, TechnologyActivity.class);
        startActivity(iNext);
    }

    private boolean validateSite() {
        if (inputSitename.getText().toString().trim().isEmpty()) {
            inputLayoutSitename.setError(getString(R.string.err_msg_sitename));
            requestFocus(inputSitename);
            return false;
        } else {
            inputLayoutSitename.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateHost() {
        if (inputHostname.getText().toString().trim().isEmpty()) {
            inputLayoutHostname.setError(getString(R.string.err_msg_hostname));
            requestFocus(inputHostname);
            return false;
        } else {
            inputLayoutHostname.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateFOPS() {
        if (inputFOPS.getText().toString().trim().isEmpty()) {
            inputLayoutFOPS.setError(getString(R.string.err_msg_fops));
            requestFocus(inputFOPS);
            return false;
        } else {
            inputLayoutFOPS.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateGC() {
        if (inputGC.getText().toString().trim().isEmpty()) {
            inputLayoutGC.setError(getString(R.string.err_msg_gc));
            requestFocus(inputGC);
            return false;
        } else {
            inputLayoutGC.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateENIB() {
        if (inputENIB.getText().toString().trim().isEmpty()) {
            inputLayoutENIB.setError(getString(R.string.err_msg_enib));
            requestFocus(inputENIB);
            return false;
        } else {
            inputLayoutENIB.setErrorEnabled(false);
        }

        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_sitename:
                    validateSite();
                    break;
                case R.id.input_hostname:
                    validateHost();
                    break;
                case R.id.input_fops:
                    validateFOPS();
                    break;
                case R.id.input_gc:
                    validateGC();
                    break;
                case R.id.input_enib:
                    validateENIB();
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      /*  MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);*/

        // return true so that the menu pop up is opened
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit) {
            //Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();

            return true;
        }

        // user is in notifications fragment


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
