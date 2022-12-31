package com.gildedrose

import com.gildedrose.items.*
import spock.lang.Specification

import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.Matchers.is

class GildedRoseForItemsSpec extends Specification {

    def "checking +5 Dexterity Vest after 3 day"() {
        given: "a +5 Dexterity Vest with an initial sell in and quality"
            GildedRoseItem gildedRoseItem = new PlusFiveDexterityVest(10, 20);

        when: "updating the quality over 3 days"
            gildedRoseItem.updateQuality(3);

        then: "ensure the sell in and quality are correct"
            assertThat(gildedRoseItem.getSellIn(), is(7));
            assertThat(gildedRoseItem.getQuality(), is(17));
    }

    def "checking Aged Brie after 18 days"() {
        given: "Aged Brie with an initial sell in and quality"
            GildedRoseItem gildedRoseItem = new AgedBrie(2, 0);

        when: "updating the quality over 18 days"
            gildedRoseItem.updateQuality(18);

        then: "ensure the sell in and quality are correct"
            assertThat(gildedRoseItem.getSellIn(), is(-16));
            assertThat(gildedRoseItem.getQuality(), is(34));
    }

    def "checking the Elixir of the Mongoose over 30 days"() {
        given: "Elixir of the Mongoose with an initial sell in and quality"
            GildedRoseItem gildedRoseItem = new ElixirOfTheMongoose(5, 7);

        when: "updating the quality over 30 days"
            gildedRoseItem.updateQuality(30);

        then: "ensure the sell in and quality are correct"
            assertThat(gildedRoseItem.getSellIn(), is(-25));
            assertThat(gildedRoseItem.getQuality(), is(0));
    }

    def "checking the Sulfuras, Hand Of Ragnaros after 80 days"() {
        given: "Sulfuras, Hand Of Ragnaros with an initial sell in and quality"
            GildedRoseItem gildedRoseItem = new SulfurasHandOfRagnaros(0, 80);

        when: "updating the quality over 80 days"
            gildedRoseItem.updateQuality(80);

        then: "ensure the sell in and quality are correct"
            assertThat(gildedRoseItem.getSellIn(), is(0));
            assertThat(gildedRoseItem.getQuality(), is(80));
    }

    def "checking the Backstage passes to a TAFKAL80ETC concert over 5 days"() {
        given: "Backstage passes to a TAFKAL80ETC concert with an initial sell in and quality"
            GildedRoseItem gildedRoseItem = new BackstageConcertPasses(10, 49);

        when: "updating the quality over 5 days"
            gildedRoseItem.updateQuality(5);

        then: "ensure the sell in and quality are correct"
            assertThat(gildedRoseItem.getSellIn(), is(5));
            assertThat(gildedRoseItem.getQuality(), is(50));
    }

    def "checking the Conjured Mana Cake over 6 days"() {
        given: "Conjured Mana Cake with an initial sell in and quality"
            GildedRoseItem gildedRoseItem = new ConjuredManaCake(3, 6);

        when: "updating the quality over 6 days"
            gildedRoseItem.updateQuality(6);

        then: "ensure the sell in and quality are correct"
            assertThat(gildedRoseItem.getSellIn(), is(-3));
            assertThat(gildedRoseItem.getQuality(), is(0));
    }
}
