package se.dennisahlin.workoff;

import android.accounts.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class AccountListAdapter extends ArrayAdapter<Account> {

    private Account[] accounts;

    public AccountListAdapter(Context context, int resource, Account[] accounts) {
        super(context, resource, accounts);
        this.accounts = accounts;
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater li = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView = li.inflate( R.layout.account_item, null );

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById( R.id.account );
            holder.checked = (CheckBox) convertView.findViewById( R.id.checkbox );
            holder.type = (TextView) convertView.findViewById( R.id.type );

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Account account = accounts[position];
        holder.name.setText( account.name );
        holder.type.setText( account.type );
        holder.account = account;

        return convertView;
    }

    private class ViewHolder {
        Account account;
        TextView name;
        TextView type;
        CheckBox checked;
    }
}
