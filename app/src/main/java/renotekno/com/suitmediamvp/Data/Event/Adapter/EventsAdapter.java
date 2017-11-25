package renotekno.com.suitmediamvp.Data.Event.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joooonho.SelectableRoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import renotekno.com.suitmediamvp.Data.AppDataManager;
import renotekno.com.suitmediamvp.Data.Base.ListItemListener;
import renotekno.com.suitmediamvp.Data.Event.Model.Event;
import renotekno.com.suitmediamvp.R;
import renotekno.com.suitmediamvp.View.Events.EventsMvpView;
import renotekno.com.suitmediamvp.View.Events.EventsPresenter;

import static android.view.View.GONE;

/**
 * Created by zcabez on 11/24/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventVH> {

    ListItemListener mListItemListener;

    public <V extends EventsMvpView> EventsAdapter(EventsPresenter eventsPresenter) {
        mListItemListener = eventsPresenter;
    }

    @Override
    public EventVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event, parent, false);
        return new EventVH(view);
    }

    @Override
    public void onBindViewHolder(EventVH holder, int position) {
        Event event = AppDataManager.events[position];
        holder.bindDataToView(event);
    }

    @Override
    public int getItemCount() {
        return AppDataManager.events.length;
    }

    class EventVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.eventSnap)
        SelectableRoundedImageView mSnap;
        @BindView(R.id.eventTitle) TextView mTitle;
        @BindView(R.id.eventDate) TextView mDate;
        @BindView(R.id.eventLabel1) TextView mLabel1;
        @BindView(R.id.eventLabel2) TextView mLabel2;
        @BindView(R.id.eventLabel3) TextView mLabel3;

        public EventVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void bindDataToView(Event event){
            mSnap.setImageResource(event.getSnap());
            mTitle.setText(event.getName());
            mDate.setText(event.getDate());

            hideLabels();
            if (event.getLabels().length == 0) return;
            for (int i = 0; i < event.getLabels().length; i++){
                String label = "#" + event.getLabels()[i];
                getLabelsView()[i].setText(label);
                getLabelsView()[i].setVisibility(View.VISIBLE);
            }
        }

        private TextView[] getLabelsView() {
            return new TextView[]{mLabel1, mLabel2, mLabel3};
        }

        private void hideLabels() {
            mLabel1.setVisibility(GONE);
            mLabel2.setVisibility(GONE);
            mLabel3.setVisibility(GONE);
        }

        @Override
        public void onClick(View view) {
            mListItemListener.onListItemClick(AppDataManager.events[getAdapterPosition()]);
        }
    }
}
