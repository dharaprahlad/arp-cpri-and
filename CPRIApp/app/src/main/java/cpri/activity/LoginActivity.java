package cpri.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhara.cpriapp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText inputPassword;
    private EditText inputEmail;
    private TextInputLayout inputLayoutEmail, inputLayoutPassword;
    private Button btnLogin, btnSignUp;
    private TextView txtFrgtPsd;
    ArrayAdapter adapter;

    private String[] domain = {" "};

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);

//                development purpose only
        inputEmail.setText("manisha@gmobility.com");
        inputPassword.setText("12345678");

        txtFrgtPsd = (TextView) findViewById(R.id.frgtPsd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnSignUp = (Button) findViewById(R.id.btn_signup);

        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));

        GradientDrawable drawable = (GradientDrawable)btnLogin.getBackground();
        drawable.setStroke(2, Color.GRAY);

        GradientDrawable drawable1 = (GradientDrawable)btnSignUp.getBackground();
        drawable1.setStroke(2, Color.GRAY);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iReg = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(iReg);
            }
        });

        txtFrgtPsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ifrgt = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(ifrgt);
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

        if (!validatePassword()) {
            return;
        }
        Intent iadminLogin = new Intent(LoginActivity.this, SiteListActivity.class);
            //iLogin.putExtra("email", String.valueOf(inputEmail));
            startActivity(iadminLogin);

            Toast.makeText(getApplicationContext(), "Successfully login!", Toast.LENGTH_SHORT).show();
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

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().length()<8) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {

        boolean getString;
        boolean getEnd;
        boolean getResult = !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if ( email.endsWith("@gmobility.com")){
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
                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
