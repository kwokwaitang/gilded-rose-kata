package com.gildedrose.items;

import com.gildedrose.Item;

public class ElixirOfTheMongoose extends GildedRoseItem {

    public ElixirOfTheMongoose(Item item) {
        super(item);
    }

    public ElixirOfTheMongoose(int sellIn, int quality) {
        this(new Item("Elixir of the Mongoose", sellIn, quality));
    }

    @Override
    public void initialRule() {
        if (item.quality > 0) {
            --item.quality;
        }
    }

    @Override
    public void endRule() {
        --item.sellIn;

        if (item.sellIn < 0 && item.quality > 0) {
            --item.quality;
        }
    }
}
