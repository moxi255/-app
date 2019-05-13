package com.example.abc.smarthome.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.abc.smarthome.model.mLog;
import com.smarthome.app.R;
import com.smarthome.app.model.mLog;

/**
 * @author smmh
 *
 */
public class LogListViewAdapter extends ArrayAdapter<mLog>
{
	private int resourceId;
	
	public LogListViewAdapter(Context context, int resource, List<mLog> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final mLog mlog = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.equipmentContext = (TextView) view.findViewById(R.id.item_lo_context);
			viewHolder.equipmentDate = (TextView) view.findViewById(R.id.item_lo_date);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.equipmentContext.setText(mlog.getContext());
		viewHolder.equipmentDate.setText(mlog.getDatetime());
		
		return view;
	}
	
	class ViewHolder {
		
		TextView equipmentContext;
		
		TextView equipmentDate;
	}
	
	
}

