package com.gildedrose.items;

import com.gildedrose.Item;

public class PlusFiveDexterityVest extends GildedRoseItem {

    public PlusFiveDexterityVest(Item item) {
        super(item);
    }

    public PlusFiveDexterityVest(int sellIn, int quality) {
        this(new Item("+5 Dexterity Vest", sellIn, quality));
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
