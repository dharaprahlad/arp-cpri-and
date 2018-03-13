package cpri.activity;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dhara.cpriapp.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText inputEmail;
    private TextInputLayout inputLayoutEmail;
    private Button btnSubmit;

    ArrayAdapter adapter;

    private String[] domain = {" "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forgot_password);

       /* toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);*/

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputEmail = (EditText) findViewById(R.id.input_email);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));

        GradientDrawable drawable = (GradientDrawable)btnSubmit.getBackground();
        drawable.setStroke(2, Color.GRAY);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

    }



    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateEmail()) {
            return;
        }
        Toast.makeText(getApplicationContext(), "Reset done", Toast.LENGTH_SHORT).show();
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }
    private static boolean isValidEmail(String email) {
        boolean getEnd;
        boolean getResult = !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if (email.endsWith("@gmobility.com")){
            getEnd = true;
        }else {
            getEnd = false;
        }
        return  (getResult && getEnd);
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
                case R.id.input_email:
                    validateEmail();
                    break;

            }
        }
    }
}
