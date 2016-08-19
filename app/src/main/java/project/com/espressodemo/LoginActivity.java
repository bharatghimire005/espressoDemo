package project.com.espressodemo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 9001;

    @BindView(R.id.edittext_email)
    EditText mEditTextEmail;
    @BindView(R.id.edittext_password)
    EditText mEditTextPassword;
    @BindView(R.id.button_login)
    Button mButtonLogin;

    Activity mActivity;
    ProgressDialog progressDialog;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mActivity = this;
        findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid()) {

                    startActivity(new Intent(mActivity,MainActivity.class));
                    //// TODO: 12/8/16 Add code to validate email from the server
                }
            }
        });

    }


    /**
     * Validate Login and show proper message on the basis of the error
     *
     * @return boolean value true if validation is success and false if validation is failed.
     */
    private boolean isValid() {
        if (!LoginUtility.isFieldEmpty(mEditTextPassword.getText().toString())) {
            Toast.makeText(mActivity, "Password field should not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!LoginUtility.isValidEmail(mEditTextEmail.getText().toString())) {
            Toast.makeText(mActivity, "Not a valid email id ", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
