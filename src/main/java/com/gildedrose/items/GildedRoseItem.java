package com.gildedrose.items;

public abstract class GildedRoseItem {
    protected String name;

    protected int sellIn;

    protected int quality;

    protected GildedRoseItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
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
        return name + ", " + sellIn + ", " + quality;
    }
}
