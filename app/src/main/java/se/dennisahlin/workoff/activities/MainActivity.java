package se.dennisahlin.workoff.activities;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import se.dennisahlin.workoff.R;
import se.dennisahlin.workoff.SerializableArrayList;

/**
 * Created by Dennis on 2015-02-07.
 */
public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_ACCOUNTS = "se.dennisahlin.workoff.ACCOUNTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Intent intent = getIntent();
        String result = intent.getStringExtra(EXTRA_ACCOUNTS);
        Toast.makeText(this,result, Toast.LENGTH_LONG).show();
        /*
        SerializableArrayList<Account> serializedAccounts = (SerializableArrayList<Account>) intent.getSerializableExtra(EXTRA_ACCOUNTS);
        if(serializedAccounts != null){
            ArrayList<Account> accounts = serializedAccounts.getContent();
            String result = "";
            for(int i = 0; i < accounts.size(); i++){
                result += accounts.get(i).name;
            }
            Toast.makeText(this,result, Toast.LENGTH_LONG).show();
        }
        */
    }

    public void pickAccounts(View view) {
        startActivity(new Intent(this, PickAccountsActivity.class));
    }
}
