package se.dennisahlin.workoff;

import android.accounts.Account;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AccountListAdapter extends ArrayAdapter<Account> {
    public AccountListAdapter(Context context, int resource, Account[] accounts) {
        super(context, resource, accounts);
    }

    @Override
    public View getView( int position, View convertView, ViewGroup parent){
        ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(this.getContext()).inflate( R.layout.account_item, null );

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById( R.id.name );
            holder.type = (TextView) convertView.findViewById( R.id.type );

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Account account = getItem(position);
        if( account != null ){
            holder.name.setText(account.name);
            holder.type.setText( account.type );
        }
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView type;
    }
}
