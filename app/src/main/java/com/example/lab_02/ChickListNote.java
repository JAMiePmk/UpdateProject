package com.example.lab_02;

import java.util.List;

public class ChickListNote extends Note{
    private List<String> items;

    //getter
public List<String> getItems (){
    return items;
}

    //setter
public void setItems(List<String> items) {
    this.items=items;
}


    public CharSequence getSummary(){
        // String strItems = //loop for get data from list
        StringBuilder strItem = new StringBuilder();
        if (items != null && items.isEmpty() ) {
            for (int i = 0; i < items.size(); i++) {
                strItem.append(items.get(i));
                if (i < items.size() - 1) {
                    strItem.append(", ");
                }
            }
        }  else{
                strItem.append("No Items");
            }
        return null;
    }

        // return title+":"+strItems+"("+createdDate+")";


    }

