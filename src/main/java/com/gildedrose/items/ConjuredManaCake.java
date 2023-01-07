package com.gildedrose.items;

import com.gildedrose.Item;

public class ConjuredManaCake extends GildedRoseItem {

    public ConjuredManaCake(Item item) {
        super(item);
    }

    public ConjuredManaCake(int sellIn, int quality) {
        this(new Item("Conjured Mana Cake", sellIn, quality));
    }

    @Override
    public void initialRule() {
        if (item.quality > 0) {
            item.quality -= 2;
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
