package com.gildedrose.cucumber;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstageConcertPasses;
import com.gildedrose.items.ConjuredManaCake;
import com.gildedrose.items.ElixirOfTheMongoose;
import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.PlusFiveDexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StepDefinitionsForItems {

    private GildedRoseItem gildedRoseItem;

    @Given("The item name is {string} with an initial sell in as {int} and quality as {int}")
    public void initialSellInAndQuality(final String name, final int sellIn, final int quality) {
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
    }

    @When("^I update the quality over ([1]{1}) day$") // Using REGEX instead of {int}
    public void iUpdateTheQualityOver1Day(final int day) {
        gildedRoseItem.updateQuality(day);
    }

    @When("^I update the quality over (\\d+) days$") // Using REGEX instead of {int}
    public void iUpdateTheQualityOverSomeDays(final int days) {
        gildedRoseItem.updateQuality(days);
    }

    @Then("I should get sell in as {int} and quality as {int}")
    public void iShouldGetSellInAsAndQualityAs(final int sellIn, final int quality) {
        assertThat(gildedRoseItem.getSellIn(), is(sellIn));
        assertThat(gildedRoseItem.getQuality(), is(quality));
    }
}
