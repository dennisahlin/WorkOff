package se.dennisahlin.workoff;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    AccountListAdapter accountAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayAccounts();
    }

    private void displayAccounts() {
        Account[] accounts = AccountManager.get(this).getAccounts();
        accountAdapter = new AccountListAdapter(this, R.layout.account_item, accounts );
        ListView accountList = (ListView) findViewById( R.id.accountList );
        accountList.setAdapter(accountAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
