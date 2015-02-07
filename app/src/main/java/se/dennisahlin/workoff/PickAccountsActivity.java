package se.dennisahlin.workoff;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class PickAccountsActivity extends ActionBarActivity implements View.OnClickListener {

    public final static String EXTRA_ACCOUNTS = "se.dennisahlin.workoff.ACCOUNTS";
    private ArrayAdapter adapter;
    private ListView accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick_accounts);

        Account[] accounts = getAccounts();
        String[] accs = new String[accounts.length];
        for( int i = 0; i < accounts.length; i++ ){
            accs[i] = accounts[i].name + " (" + accounts[i].type + ")";
        }

        accountList = getListView();
        adapter = new AccountListAdapter( this, R.layout.account_item, accounts );
        accountList.setAdapter(adapter);
        accountList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Button button = (Button) findViewById( R.id.button );
        button.setOnClickListener(this);
    }

    private ListView getListView() {
        return (ListView) findViewById( R.id.accountList );
    }

    private Account[] getAccounts() {
        return AccountManager.get(this).getAccounts();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

    @Override
    public void onClick(View v) {
        SparseBooleanArray checked = accountList.getCheckedItemPositions();
        String result = "";
        for (int i = 0; i < checked.size(); i++){
            int pos = checked.keyAt(i);
            if(checked.valueAt(i))
                result += ((Account) adapter.getItem(pos)).name;
        }

        Toast.makeText(this, result, Toast.LENGTH_SHORT ).show();
    }
}
