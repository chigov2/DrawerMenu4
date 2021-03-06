package techmarket.uno.drawermenu4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import techmarket.uno.drawermenu4.R;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataHolder> {
    private Context context;
    private RecOnClickListenerInterface recOnClickListenerInterface;
    private List <ListItem> listItemArray;

    public DataAdapter(Context context, RecOnClickListenerInterface recOnClickListenerInterface, List<ListItem> listItemArray) {
        this.context = context;
        this.recOnClickListenerInterface = recOnClickListenerInterface;
        this.listItemArray = listItemArray;
    }

    class DataHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView textViewTitle;
        private TextView textViewItem;
        private ImageButton imageButtonFavorite;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textItemTitle);
            textViewItem = itemView.findViewById(R.id.textItemText);
            imageButtonFavorite = itemView.findViewById(
                    R.id.imageButtonFavorite);
            itemView.setOnClickListener(this);
        }

        void setData(ListItem listItem){
            textViewTitle.setText(listItem.getText_title());
            textViewItem.setText(listItem.getText());
        }

        @Override
        public void onClick(View v) {
            recOnClickListenerInterface.onItemClicked(getAdapterPosition());

        }
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.setData(listItemArray.get(position));
    }

    @Override
    public int getItemCount() {
        return listItemArray.size();
    }

   public void updateList(List<ListItem> listArray){
        listItemArray.clear();
        listItemArray.addAll(listArray);
        notifyDataSetChanged();
    }
}
