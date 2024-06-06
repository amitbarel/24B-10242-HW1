package dev.amitb.a24b_10242_hw1;

import java.util.ArrayList;

import dev.amitb.common.BaseDataManager;
import dev.amitb.common.ItemToStore;

public class NotesDataManager extends BaseDataManager {
    @Override
    public ArrayList<ItemToStore> getItems() {
        ArrayList<ItemToStore> items = new ArrayList<>();

        items.add(new ItemToStore()
                .setTitle("Note 1")
                .setDescription("Lorem ipsum dolor sit amet, " +
                        "consectetur adipiscing elit.\n" +
                        "Nulla vitae elit libero."));

        items.add(new ItemToStore()
                .setTitle("Note 2")
                .setDescription("Sed libero nunc, placerat eleifend est non, " +
                        "blandit pharetra ligula.\n" +
                        "Sed laoreet a augue et tincidunt."));

        items.add(new ItemToStore()
                .setTitle("Note 3")
                .setDescription("Etiam ut justo eu eros mollis pellentesque.\n" +
                        "Donec id nisi tincidunt, rutrum purus sed, porta massa."));

        items.add(new ItemToStore()
                .setTitle("Note 4")
                .setDescription("Vestibulum orci purus, " +
                        "scelerisque vitae malesuada at, maximus a turpis.\n" +
                        "Phasellus sit amet tincidunt neque."));

        items.add(new ItemToStore()
                .setTitle("Note 5")
                .setDescription("Proin sodales maximus lacus vitae porta.\n" +
                        "Nam finibus vel metus eu ornare"));

        return items;
    }
}
