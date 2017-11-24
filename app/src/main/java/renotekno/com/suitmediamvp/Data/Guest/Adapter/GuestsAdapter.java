package renotekno.com.suitmediamvp.Data.Guest.Adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Base.ListItemListener;
import renotekno.com.suitmediamvp.Data.Guest.Model.Guest;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Guests.GuestsPresenter;

/**
 * Created by zcabez on 11/24/2017.
 */

public class GuestsAdapter extends RecyclerView.Adapter<GuestsAdapter.GuestVH> {

    private Context mContext;
    private ListItemListener mListItemListener;

    public GuestsAdapter(GuestsPresenter guestsPresenter, Context context) {
        mListItemListener = guestsPresenter;
        mContext = context;
    }

    @Override
    public GuestVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_guest, parent, false);
        return new GuestVH(view);
    }

    @Override
    public void onBindViewHolder(GuestVH holder, int position) {
        Guest guest = AppDataManager.mGuests.get(position);
        holder.bindDataToView(guest);
    }

    @Override
    public int getItemCount() {
        return AppDataManager.mGuests.size();
    }

    class GuestVH extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.photoProfile)
        ImageView mPhotoProfile;
        @BindView(R.id.name)
        TextView mName;

        public GuestVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindDataToView (Guest guest) {
            mPhotoProfile.setImageDrawable(ContextCompat.getDrawable(mContext, guest.getImage(mContext)));
            mName.setText(guest.getName());
        }

        @Override
        public void onClick(View view) {
            mListItemListener.onListItemClick(AppDataManager.mGuests.get(getAdapterPosition()));
        }
    }
}
