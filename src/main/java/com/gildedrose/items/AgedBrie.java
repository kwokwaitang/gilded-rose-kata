package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedBrie extends GildedRoseItem {

    public AgedBrie(Item item) {
        super(item);
    }

    public AgedBrie(int sellIn, int quality) {
        this(new Item("Aged Brie", sellIn, quality));
    }

    @Override
    public void initialRule() {
        if (item.quality < 50) {
            ++item.quality;
        }
    }

    @Override
    public void endRule() {
        --item.sellIn;

        if (item.sellIn < 0 && item.quality < 50) {
            ++item.quality;
        }
    }
}
