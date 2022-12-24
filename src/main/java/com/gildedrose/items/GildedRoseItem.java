package com.gildedrose.items;

abstract class GildedRoseItem {
    protected String name;

    protected int sellIn;

    protected int quality;

    protected GildedRoseItem(int sellIn, int quality) {
        this.name = "";
        this.sellIn = sellIn;
        this.quality = quality;
    }

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

    public void updateQuality(final int days) {
        for (int i = 0; i < days; i++) {
            itemRules();
        }
    }

    public abstract void itemRules();

    @Override
    public String toString() {
        return name + ", " + sellIn + ", " + quality;
    }
}
