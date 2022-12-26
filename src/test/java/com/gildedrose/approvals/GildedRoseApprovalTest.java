package com.gildedrose.approvals;

import com.gildedrose.TextTestFixture;
import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.BackstageConcertPasses;
import com.gildedrose.items.ConjuredManaCake;
import com.gildedrose.items.ElixirOfTheMongoose;
import com.gildedrose.items.GildedRoseItem;
import com.gildedrose.items.PlusFiveDexterityVest;
import com.gildedrose.items.SulfurasHandOfRagnaros;
import com.oneeyedmen.okeydoke.Approver;
import com.oneeyedmen.okeydoke.junit5.ApprovalsExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@ExtendWith(ApprovalsExtension.class)
class GildedRoseApprovalTest {

    private final static String APPROVALS_PATH = "src/test/java/com/gildedrose/approvals/";

    @Test
    @DisplayName("Approval based test for making sure main output is correct over 3 days")
    void makingSureMainOutputIsCorrectOver3Days(Approver approver) throws Exception {
        String approvedContent = new String(Files.readAllBytes(Paths.get(APPROVALS_PATH + "GildedRoseApprovalTest.makingSureMainOutputIsCorrectOver3Days.approved")));

        whenApprovedItIs(approvedContent, approver);

        final int days = 4; // With day 0 being the initial set-up...

        List<? /* any object that */ extends GildedRoseItem> items = Arrays.asList(
            new PlusFiveDexterityVest(10, 20),
            new AgedBrie(2, 0),
            new ElixirOfTheMongoose(5, 7),
            new SulfurasHandOfRagnaros(0, 80),
            new SulfurasHandOfRagnaros(-1, 80),
            new BackstageConcertPasses(15, 20),
            new BackstageConcertPasses(10, 49),
            new BackstageConcertPasses(5, 49),
            new ConjuredManaCake(3, 6)
        );

        String output = TextTestFixture.generateOutput(days, items);
        assertThat(output, not(is(emptyString())));

        approver.assertApproved(output);
    }

    @Test
    @DisplayName("Approval based test for making sure main output is correct over 99 days")
    void makingSureMainOutputIsCorrectOver99Days(Approver approver) throws Exception {
        String approvedContent = new String(Files.readAllBytes(Paths.get(APPROVALS_PATH + "GildedRoseApprovalTest.makingSureMainOutputIsCorrectOver99Days.approved")));

        whenApprovedItIs(approvedContent, approver);

        final int days = 100; // With day 0 being the initial set-up...

        List<? /* any object that */ extends GildedRoseItem> items = Arrays.asList(
            new PlusFiveDexterityVest(10, 20),
            new AgedBrie(2, 0),
            new ElixirOfTheMongoose(5, 7),
            new SulfurasHandOfRagnaros(0, 80),
            new SulfurasHandOfRagnaros(-1, 80),
            new BackstageConcertPasses(15, 20),
            new BackstageConcertPasses(10, 49),
            new BackstageConcertPasses(5, 49),
            new ConjuredManaCake(3, 6)
        );

        String output = TextTestFixture.generateOutput(days, items);
        assertThat(output, not(is(emptyString())));

        approver.assertApproved(output);
    }

    private void whenApprovedItIs(String valueOrNull, Approver approver) throws IOException {
        if (valueOrNull == null)
            approver.removeApproved();
        else
            approver.makeApproved(valueOrNull);
    }
}
