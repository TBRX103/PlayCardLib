/*
 * Copyright 2015 Benjamin Schellenberger <benrain@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cards.util;

import cards.french.PlayingCard;
import cards.french.PlayingCardFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 */
public class CardDeckTest {

    public CardDeckTest() {
    }

    @Test
    public void ensureSeparateDecksAreNotEqual() {
        CardDeck deck1 = new CardDeck();
        Assert.assertFalse(deck1.equals(new CardDeck()));

        CardDeck<PlayingCard> standardDeck1 = PlayingCardFactory.getDeck();
        CardDeck<PlayingCard> standardDeck2 = PlayingCardFactory.getDeck();
        Assert.assertFalse(standardDeck1.equals(standardDeck2));

        CardDeck<PlayingCard> standardDeck3 = standardDeck1;
        Assert.assertTrue(standardDeck3.equals(standardDeck1));
    }

}
