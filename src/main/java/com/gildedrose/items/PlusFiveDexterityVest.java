package com.gildedrose.items;

public class PlusFiveDexterityVest extends GildedRoseItem {

    public PlusFiveDexterityVest(int sellIn, int quality) {
        this("+5 Dexterity Vest", sellIn, quality);
    }

    public PlusFiveDexterityVest(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void initialRule() {
        if (quality > 0) {
            --quality;
        }
    }

    @Override
    public void endRule() {
        --sellIn;

        if (sellIn < 0 && quality > 0) {
            --quality;
        }
    }
}
