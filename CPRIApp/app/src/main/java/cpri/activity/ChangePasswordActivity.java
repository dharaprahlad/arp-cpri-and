package cpri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhara.cpriapp.R;

import static android.app.PendingIntent.getActivity;

public class ChangePasswordActivity extends BaseActivity {
    private Toolbar toolbar;
    private Button  btnDone;
    private EditText inputCurrentPassword, inputNewPassword;
    private TextInputLayout inputLayoutCurrentPassword, inputLayoutNewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputLayoutCurrentPassword = (TextInputLayout) findViewById(R.id.input_layout_currentpassword);
        inputCurrentPassword = (EditText) findViewById(R.id.input_currentpassword);
        inputCurrentPassword.addTextChangedListener(new MyTextWatcher(inputCurrentPassword));

        inputLayoutNewPassword = (TextInputLayout) findViewById(R.id.input_layout_newpassword);
        inputNewPassword = (EditText) findViewById(R.id.input_newpassword);
        inputNewPassword.addTextChangedListener(new MyTextWatcher(inputNewPassword));

        btnDone = (Button) findViewById(R.id.btn_done);

        btnDone.setOnClickListener(new View.OnClickListener() {
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

        if (!validateCurrentPassword()) {
            return;
        }

        if (!validateNewPassword()) {
            return;
        }

        Toast.makeText(getApplicationContext(), "Successfully changed!", Toast.LENGTH_SHORT).show();
    }

    private boolean validateCurrentPassword() {
        if (inputCurrentPassword.getText().toString().trim().length()<8) {
            inputLayoutCurrentPassword.setError(getString(R.string.err_msg_crnt_pswd));
            requestFocus(inputCurrentPassword);
            return false;
        } else {
            inputLayoutCurrentPassword.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNewPassword() {
        if (inputNewPassword.getText().toString().trim().length()<8) {
            inputLayoutNewPassword.setError(getString(R.string.err_msg_new_pswd));
            requestFocus(inputNewPassword);
            return false;
        } else {
            inputLayoutNewPassword.setErrorEnabled(false);
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

                case R.id.input_currentpassword:
                    validateCurrentPassword();
                    break;

                case R.id.input_newpassword:
                    validateNewPassword();
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0 ){
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
