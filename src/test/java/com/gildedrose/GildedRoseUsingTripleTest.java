package com.gildedrose;

import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseUsingTripleTest {
    @Test
    void usingTripleForThreeItemsOver3Days() {
        // Given...
        Triple<String, Integer, Integer> plus5DexterityVest = Triple.of("+5 Dexterity Vest", 10, 20);
        Triple<String, Integer, Integer> elixirOfTheMongoose = Triple.of("Elixir of the Mongoose", 5, 7);
        Triple<String, Integer, Integer> backstagePassesToConcert = Triple.of("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        List<Triple<String, Integer, Integer>> items = Arrays.asList(plus5DexterityVest, elixirOfTheMongoose, backstagePassesToConcert);

        // When...
        GildedRose app = new GildedRose(items);
        app.updateQuality(3);

        // Then...
        Item firstItem = app.items[0];
        Item secondItem = app.items[1];
        Item thirdItem = app.items[2];

        assertEquals("+5 Dexterity Vest",firstItem.name);
        assertEquals(7,firstItem.sellIn);
        assertEquals(17,firstItem.quality);

        assertEquals("Elixir of the Mongoose", secondItem.name);
        assertEquals(2, secondItem.sellIn);
        assertEquals(4, secondItem.quality);

        assertEquals("Backstage passes to a TAFKAL80ETC concert", thirdItem.name);
        assertEquals(12, thirdItem.sellIn);
        assertEquals(23, thirdItem.quality);
    }

    @Test
    void usingTripleForElixirOfTheMongooseOver3Days() {
        // Given...
        Triple<String, Integer, Integer> item = Triple.of("Elixir of the Mongoose", 5, 7);
        List<Triple<String, Integer, Integer>> items = Arrays.asList(item);

        // When...
        GildedRose app = new GildedRose(items);
        app.updateQuality(3);

        // Then...
        Item item1 = app.items[0];
        assertThat(item1.name, is("Elixir of the Mongoose"));
        assertThat(item1.sellIn, is(2));
        assertThat(item1.quality, is(4));
    }
}
