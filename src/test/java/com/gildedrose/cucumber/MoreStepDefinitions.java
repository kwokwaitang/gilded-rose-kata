package com.gildedrose.cucumber;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstageConcertPasses;
import com.gildedrose.items.ConjuredManaCake;
import com.gildedrose.items.ElixirOfTheMongoose;
import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.PlusFiveDexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;
import io.cucumber.java8.En;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MoreStepDefinitions implements En {

    private GildedRoseItem gildedRoseItem;

    public MoreStepDefinitions() {
        Given("abc {string} def {int} ghi {int}", (String name, Integer sellIn, Integer quality) -> {
            if (name.equalsIgnoreCase("+5 Dexterity Vest")) {
                gildedRoseItem = new PlusFiveDexterityVest(sellIn, quality);
            } else if (name.equalsIgnoreCase("Aged Brie")) {
                gildedRoseItem = new AgedBrie(sellIn, quality);
            } else if (name.equalsIgnoreCase("Elixir of the Mongoose")) {
                gildedRoseItem = new ElixirOfTheMongoose(sellIn, quality);
            } else if (name.equalsIgnoreCase("Sulfuras, Hand of Ragnaros")) {
                gildedRoseItem = new SulfurasHandOfRagnaros(sellIn, quality);
            } else if (name.equalsIgnoreCase("Backstage passes to a TAFKAL80ETC concert")) {
                gildedRoseItem = new BackstageConcertPasses(sellIn, quality);
            } else if (name.equalsIgnoreCase("Conjured Mana Cake")) {
                gildedRoseItem = new ConjuredManaCake(sellIn, quality);
            }
        });

        When("^jkl (\\d+) days$", (Integer days) -> {
            gildedRoseItem.updateQuality(days);
        });

        Then("mno {int} pqr {int}", (Integer sellIn, Integer quality) -> {
            assertThat(gildedRoseItem.getSellIn(), is(sellIn));
            assertThat(gildedRoseItem.getQuality(), is(quality));
        });
    }
}
