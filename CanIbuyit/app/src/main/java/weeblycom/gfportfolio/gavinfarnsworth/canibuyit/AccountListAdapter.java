package weeblycom.gfportfolio.gavinfarnsworth.canibuyit;

/**
 * Created by gavinfarnsworth on 2/24/15.
 */
    import android.content.Context;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ArrayAdapter;
    import android.widget.TextView;

    import java.util.List;

    import weeblycom.gfportfolio.gavinfarnsworth.canibuyit.Accounts.Account;

public class AccountListAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final List<Account> accountList;

        public AccountListAdapter(Context context, List<Account> accountList) {
            super(context, R.layout.customaccount);
            this.context = context;
            this.accountList = accountList;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.customaccount, parent, false);
            TextView nameTextView = (TextView) rowView.findViewById(R.id.NameTextView_customaccount);
            TextView totalTextView = (TextView) rowView.findViewById(R.id.TotalTextView_currentaccount);
            TextView availableTextView = (TextView) rowView.findViewById(R.id.availabletextView_customaccount);
            nameTextView.setText(accountList.get(position).getName());
            totalTextView.setText(accountList.get(position).getCurrentBalance()+"");
            availableTextView.setText(accountList.get(position).getCurrentBalance()+"");

            return rowView;
        }

}
