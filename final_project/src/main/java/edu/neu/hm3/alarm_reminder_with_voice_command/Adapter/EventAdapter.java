package edu.neu.hm3.alarm_reminder_with_voice_command.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import edu.neu.hm3.alarm_reminder_with_voice_command.Database.EntityClass;
import edu.neu.hm3.alarm_reminder_with_voice_command.R;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private Context context;
    private List<EntityClass> entityClassList;

    public EventAdapter(Context context, List<EntityClass> entityClassList) {
        this.context = context;
        this.entityClassList = entityClassList;
    }

    @NonNull
    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.per_row, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.ViewHolder holder, int position) {
        holder.eventText.setText(entityClassList.get(position).getEventName());
        holder.time_date.setText(entityClassList.get(position).getEventDate() + " " + entityClassList.get(position).getEventTime());

    }

    @Override
    public int getItemCount() {
        return entityClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView eventText;
        private TextView time_date;
        private LinearLayout topLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventText = (TextView) itemView.findViewById(R.id.event);
            time_date = (TextView) itemView.findViewById(R.id.time_date);
            topLayout = (LinearLayout) itemView.findViewById(R.id.top_layout);
        }
    }
}
