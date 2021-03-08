package ro.pub.cs.systems.eim.lab01.myfirstandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.animation.*;

public class MainActivity extends AppCompatActivity {

    final private static long TRANSPARENCY_EFFECT_DURATION = 5000;

    private static Animation initialAnimation = null;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText userNameEditText = (EditText)findViewById(R.id.user_name_edit_text);
            TextView greetingTextView = (TextView)findViewById(R.id.greeting_text_view);
            greetingTextView.setAlpha(1);

            // TODO: exercise 9a

            String greeting = getString(R.string.gretting_text_view_content);
            greetingTextView.setText(greeting.replace("xxx", "\n"+userNameEditText.getText()));
            // TODO: exercise 9b
            String name = userNameEditText.getText().toString();
            if (!name.equals("vio")) {
                AlphaAnimation fadeEffect = new AlphaAnimation(1.0f, 0.0f);
                fadeEffect.setDuration(TRANSPARENCY_EFFECT_DURATION);
                fadeEffect.setFillAfter(true);
                greetingTextView.setAnimation(fadeEffect);
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(buttonClickListener);
    }
}
