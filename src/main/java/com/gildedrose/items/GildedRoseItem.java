package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class GildedRoseItem {
    protected final Item item;

    protected GildedRoseItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public int getQuality() {
        return item.quality;
    }

    public void updateQuality() {
        updateQuality(1);
    }

    public final /* to prevent this method from being overridden */ void updateQuality(final int days) {
        for (int i = 0; i < days; i++) {
            initialRule();
            endRule();
        }
    }

    public abstract void initialRule();

    public abstract void endRule();

    @Override
    public String toString() {
        return item.toString();
    }
}
