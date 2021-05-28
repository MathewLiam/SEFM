package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Class for the second activity. Displays message when received and handles reply logic.
 */
public class SecondActivity extends AppCompatActivity {
    /**
     * The EditText component for the users reply.
     */
    private EditText mReply;

    /**
     * The identifier for the reply.
     */
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";

    /**
     * Method to create the view and retrieve the message received from main activity.
     * @param savedInstanceState The current state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        mReply = findViewById(R.id.editText_second);
    }

    /**
     * Reply logic when button is clicked.
     * @param view The button that was clicked.
     */
    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }


}