package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Defines the MainActivity class for sending a message to the second activity.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The log tag for the main activity.
     */
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    /**
     * The message text box view element.
     */
    private EditText mMessageEditText;

    /**
     * The extra message tag.
     */
    public static final String EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE";

    /**
     * The text request result code.
     */
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    /**
     * The onCreate method to assemble the view.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    /**
     * On send button click will send message to the second activity.
     * @param view
     */
    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    /**
     * Handles the result from the second activity to display the reply.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                mReplyHeadTextView.setVisibility(View.VISIBLE);

                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}