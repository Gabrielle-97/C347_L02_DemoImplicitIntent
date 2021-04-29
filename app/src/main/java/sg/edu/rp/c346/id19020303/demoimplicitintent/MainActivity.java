package sg.edu.rp.c346.id19020303.demoimplicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button btnEmail, btnRP;
    EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage=(EditText)findViewById(R.id.editTextTextMessage);
        btnEmail = (Button)findViewById(R.id.buttonEmail);
        btnRP = (Button)findViewById(R.id.buttonRP);

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //The action you want this intent to do:
                //ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);

                //Put essentials like email address, subject and body text
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"Jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT, new String[]{"Test Email from C347"});
                email.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText());

                //This MIME type indicates email
                email.setType("message/rfc822");

                //createChooser shows user a list of app that can handle
                //this MIME type, which is, email
                startActivity(Intent.createChooser(email,"Choose an Email client: "));

            }
        });


        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);

                //Set the URL ot be used
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });
    }
}