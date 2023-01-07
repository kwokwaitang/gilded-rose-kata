package com.gildedrose.items;

import com.gildedrose.Item;

public class SulfurasHandOfRagnaros extends GildedRoseItem {

    public SulfurasHandOfRagnaros(Item item) {
        super(item);
    }

    public SulfurasHandOfRagnaros(int sellIn, int quality) {
        this(new Item("Sulfuras, Hand of Ragnaros", sellIn, quality));
    }

    @Override
    public void initialRule() {
        // No rules to apply
    }

    @Override
    public void endRule() {
        // No rules to apply
    }
}
