package ca.codemake.workout.adapters;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ca.codemake.workout.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    // IF the view under inflation and population is header or Item
    private static final int TYPE_ITEM = 1;

    private String drawerTitles[]; // String Array to store the passed titles Value from MainActivity.java
    private int drawerIcons[];       // Int Array to store the passed icons resource value from MainActivity.java

    private String title;        //String Resource for header View title

    // Creating a ViewHolder which extends the RecyclerView View Holder
    // ViewHolder are used to to store the inflated views in order to recycle them

    public static class ViewHolder extends RecyclerView.ViewHolder {
        int holderId;

        TextView title;

        TextView itemName;
        ImageView itemIcon;

        public ViewHolder(View itemView,int ViewType) {                 // Creating ViewHolder Constructor with View and viewType As a parameter
            super(itemView);

            // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

            if(ViewType == TYPE_ITEM) {
                itemName = (TextView) itemView.findViewById(R.id.drawer_item_name); // Creating TextView object with the id of itemName from item_row.xml
                itemIcon = (ImageView) itemView.findViewById(R.id.drawer_item_icon);// Creating ImageView object with the id of ImageView from item_row.xml
                holderId = 1;                                               // setting holder id as 1 as the object being populated are of type item row
            }
            else{
                title = (TextView) itemView.findViewById(R.id.drawer_header_title);         // Creating Text View object from header.xml for title
                holderId = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
            }
        }
    }

    public MyAdapter(String Titles[],int Icons[], String title){ // MyAdapter Constructor with titles and icons parameter
        // titles, icons, title, email, profile pic are passed from the main activity as we
        drawerTitles = Titles;                //have seen earlier
        drawerIcons = Icons;
        this.title = title;
        //here we assign those passed values to the values we declared here
        //in adapter
    }

    //Below first we override the method onCreateViewHolder which is called when the ViewHolder is
    //Created, In this method we inflate the item_row.xml layout if the viewType is Type_ITEM or else we inflate header.xml
    // if the viewType is TYPE_HEADER
    // and pass it to the view holder

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_list_item,parent,false); //Inflating the layout

            ViewHolder vhItem = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object

            //inflate your layout and pass it to view holder

        } else if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_list_header,parent,false); //Inflating the layout

            ViewHolder vhHeader = new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhHeader; //returning the object created
        }
        return null;

    }

    //Next we override a method which is called when the item in a row is needed to be displayed, here the int position
    // Tells us item at which position is being constructed to be displayed and the holder id of the holder object tell us
    // which view type is being created 1 for item row
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        if(holder.holderId == 1) {                              // as the list view is going to be called after the header view so we decrement the
            // position by 1 and pass it to the holder while setting the text and image
            holder.itemName.setText(drawerTitles[position - 1]); // Setting the Text with the array of our Titles
            holder.itemIcon.setImageResource(drawerIcons[position - 1]);// Setting the image with array of our icons
        }
        else{
            // Similarly we set the resources for header view
            holder.title.setText(title);
        }
    }

    // This method returns the number of items present in the list
    @Override
    public int getItemCount() {
        return drawerTitles.length+1; // the number of items in the list will be +1 the titles including the header view.
    }


    // With the following method we check what type of view is being passed
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}