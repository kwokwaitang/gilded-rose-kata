package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstageConcertPasses;
import com.gildedrose.items.ConjuredManaCake;
import com.gildedrose.items.ElixirOfTheMongoose;
import com.gildedrose.items.PlusFiveDexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GildedRoseUsingItemsTest {

    @ParameterizedTest
    @CsvSource({
        "3, 7, 17",
        "4, 6, 16",
        "8, 2, 12"
    })
    void usingPlusFiveDexterityVestWithArgumentsAccessor(ArgumentsAccessor arguments) {
        int days = arguments.get(0, Integer.class);
        int sellIn = arguments.get(1, Integer.class);
        int quality = arguments.get(2, Integer.class);

        PlusFiveDexterityVest plusFiveDexterityVest = new PlusFiveDexterityVest("+5 Dexterity Vest", 10, 20);
        plusFiveDexterityVest.updateQuality(days);

        assertThat(plusFiveDexterityVest.getName(), is("+5 Dexterity Vest"));
        assertThat(plusFiveDexterityVest.getSellIn(), is(sellIn));
        assertThat(plusFiveDexterityVest.getQuality(), is(quality));
    }

    @Test
    void usingPlusFiveDexterityVestOver17Days() {
        PlusFiveDexterityVest plusFiveDexterityVest = new PlusFiveDexterityVest(10, 20);
        plusFiveDexterityVest.updateQuality(17);

        assertThat(plusFiveDexterityVest.getName(), is("+5 Dexterity Vest"));
        assertThat(plusFiveDexterityVest.getSellIn(), is(-7));
        assertThat(plusFiveDexterityVest.getQuality(), is(0));
    }

    @Test
    void usingPlusFiveDexterityVestOver30Days() {
        PlusFiveDexterityVest plusFiveDexterityVest = new PlusFiveDexterityVest("+5 Dexterity Vest", 10, 20);
        plusFiveDexterityVest.updateQuality(30);

        assertThat(plusFiveDexterityVest.getName(), is("+5 Dexterity Vest"));
        assertThat(plusFiveDexterityVest.getSellIn(), is(-20));
        assertThat(plusFiveDexterityVest.getQuality(), is(0));
    }

    @ParameterizedTest
    @CsvSource({
        "1, 1, 1",
        "2, 0, 2",
        "9, -7, 16",
        "18, -16, 34",
        "30, -28, 50"
    })
    void usingAgedBrieWithArgumentsAccessor(ArgumentsAccessor arguments) {
        int days = arguments.get(0, Integer.class);
        int sellIn = arguments.get(1, Integer.class);
        int quality = arguments.get(2, Integer.class);

        AgedBrie agedBrie = new AgedBrie("Aged Brie", 2, 0);
        agedBrie.updateQuality(days);

        assertThat(agedBrie.getName(), is("Aged Brie"));
        assertThat(agedBrie.getSellIn(), is(sellIn));
        assertThat(agedBrie.getQuality(), is(quality));
    }

    @Test
    void usingAgedBrieOver3Days() {
        AgedBrie agedBrie = new AgedBrie("Aged Brie", 2, 0);
        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);

        assertThat(agedBrie.getName(), is("Aged Brie"));
        assertThat(agedBrie.getSellIn(), is(-1));
        assertThat(agedBrie.getQuality(), is(4));
    }

    @Test
    void usingAgedBrieOver9DaysChecksOn3rdAnd9thDays() {
        AgedBrie agedBrie = new AgedBrie("Aged Brie", 2, 0);
        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);

        assertThat(agedBrie.getName(), is("Aged Brie"));
        assertThat(agedBrie.getSellIn(), is(-1));
        assertThat(agedBrie.getQuality(), is(4));

        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);

        assertThat(agedBrie.getName(), is("Aged Brie"));
        assertThat(agedBrie.getSellIn(), is(-4));
        assertThat(agedBrie.getQuality(), is(10));

        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);
        agedBrie.updateQuality(1);

        assertThat(agedBrie.getSellIn(), is(-7));
        assertThat(agedBrie.getQuality(), is(16));
    }

    @Test
    void usingElixirOfTheMongooseOver1Day() {
        ElixirOfTheMongoose elixirOfTheMongoose = new ElixirOfTheMongoose("Elixir of the Mongoose", 5, 7);
        elixirOfTheMongoose.updateQuality(1);

        assertThat(elixirOfTheMongoose.getName(), is("Elixir of the Mongoose"));
        assertThat(elixirOfTheMongoose.getSellIn(), is(4));
        assertThat(elixirOfTheMongoose.getQuality(), is(6));
    }

    @Test
    void usingElixirOfTheMongooseOver23Days() {
        ElixirOfTheMongoose elixirOfTheMongoose = new ElixirOfTheMongoose("Elixir of the Mongoose", 5, 7);
        elixirOfTheMongoose.updateQuality(23);

        assertThat(elixirOfTheMongoose.getName(), is("Elixir of the Mongoose"));
        assertThat(elixirOfTheMongoose.getSellIn(), is(-18));
        assertThat(elixirOfTheMongoose.getQuality(), is(0));
    }

    @Test
    void usingElixirOfTheMongooseOver30Days() {
        ElixirOfTheMongoose elixirOfTheMongoose = new ElixirOfTheMongoose(5, 7);
        elixirOfTheMongoose.updateQuality(30);

        assertThat(elixirOfTheMongoose.getName(), is("Elixir of the Mongoose"));
        assertThat(elixirOfTheMongoose.getSellIn(), is(-25));
        assertThat(elixirOfTheMongoose.getQuality(), is(0));
    }

    @Test
    void usingSulfurasHandOfRagnarosWithNoChangeOver8Days() {
        SulfurasHandOfRagnaros sulfurasHandOfRagnaros = new SulfurasHandOfRagnaros("Sulfuras, Hand of Ragnaros", 0, 80);
        sulfurasHandOfRagnaros.updateQuality(8);

        assertThat(sulfurasHandOfRagnaros.getName(), is("Sulfuras, Hand of Ragnaros"));
        assertThat(sulfurasHandOfRagnaros.getSellIn(), is(0));
        assertThat(sulfurasHandOfRagnaros.getQuality(), is(80));
    }

    @Test
    void usingBackstageConcertPassesForFirstConcertOver3Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        tafkal80etcConcert.updateQuality(3);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(12));
        assertThat(tafkal80etcConcert.getQuality(), is(23));
    }

    @Test
    void usingBackstageConcertPassesForFirstConcertOver11Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        tafkal80etcConcert.updateQuality(11);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(4));
        assertThat(tafkal80etcConcert.getQuality(), is(38));
    }

    @Test
    void usingBackstageConcertPassesForFirstConcertOver25Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        tafkal80etcConcert.updateQuality(25);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(-10));
        assertThat(tafkal80etcConcert.getQuality(), is(0));
    }

    @Test
    void usingBackstageConcertPassesForSecondConcertOver3Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        tafkal80etcConcert.updateQuality(5);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(5));
        assertThat(tafkal80etcConcert.getQuality(), is(50));
    }

    @Test
    void usingBackstageConcertPassesForSecondConcertOver15Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        tafkal80etcConcert.updateQuality(15);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(-5));
        assertThat(tafkal80etcConcert.getQuality(), is(0));
    }

    @Test
    void usingBackstageConcertPassesForSecondConcertOver21Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        tafkal80etcConcert.updateQuality(21);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(-11));
        assertThat(tafkal80etcConcert.getQuality(), is(0));
    }

    @Test
    void usingBackstageConcertPassesForThirdConcertOver2Days() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        tafkal80etcConcert.updateQuality(2);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(3));
        assertThat(tafkal80etcConcert.getQuality(), is(50));
    }

    @Test
    void usingBackstageConcertPassesForThirdConcertOver29ays() {
        BackstageConcertPasses tafkal80etcConcert = new BackstageConcertPasses(5, 49);
        tafkal80etcConcert.updateQuality(29);

        assertThat(tafkal80etcConcert.getName(), is("Backstage passes to a TAFKAL80ETC concert"));
        assertThat(tafkal80etcConcert.getSellIn(), is(-24));
        assertThat(tafkal80etcConcert.getQuality(), is(0));
    }

    @Test
    void usingConjuredManaCakeOver3Days() {
        ConjuredManaCake conjuredManaCake = new ConjuredManaCake("Conjured Mana Cake", 3, 6);
        conjuredManaCake.updateQuality(3);

        assertThat(conjuredManaCake.getName(), is("Conjured Mana Cake"));
        assertThat(conjuredManaCake.getSellIn(), is(0));
        assertThat(conjuredManaCake.getQuality(), is(0));
    }

    @Test
    void usingConjuredManaCakeOver4Days() {
        ConjuredManaCake conjuredManaCake = new ConjuredManaCake("Conjured Mana Cake", 3, 6);
        conjuredManaCake.updateQuality(4);

        assertThat(conjuredManaCake.getName(), is("Conjured Mana Cake"));
        assertThat(conjuredManaCake.getSellIn(), is(-1));
        assertThat(conjuredManaCake.getQuality(), is(0));
    }

    @Test
    void usingConjuredManaCakeOver6Days() {
        ConjuredManaCake conjuredManaCake = new ConjuredManaCake("Conjured Mana Cake", 3, 6);
        conjuredManaCake.updateQuality(6);

        assertThat(conjuredManaCake.getName(), is("Conjured Mana Cake"));
        assertThat(conjuredManaCake.getSellIn(), is(-3));
        assertThat(conjuredManaCake.getQuality(), is(0));
    }
}
