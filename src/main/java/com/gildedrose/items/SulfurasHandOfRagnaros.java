package com.gildedrose.items;

public class SulfurasHandOfRagnaros extends GildedRoseItem {

    public SulfurasHandOfRagnaros(int sellIn, int quality) {
        this("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    public SulfurasHandOfRagnaros(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
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
