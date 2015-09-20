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
package cards.french;

import cards.french.PlayingCard.Rank;
import cards.french.PlayingCard.Suit;
import cards.util.CardDeck;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 */
public class PlayingCardFactoryTest {

    public PlayingCardFactoryTest() {
    }

    @Test
    public void testNewDeckOrder() {
        CardDeck<PlayingCard> deck = PlayingCardFactory.getDeck();
        assertEquals(52, deck.size()); //Check deck size.
        Iterator<PlayingCard> it = deck.iterator();
        PlayingCard curCard;
        for (Suit suit : PlayingCardUtils.getSuitOrder()) {
            for (Rank rank : PlayingCardUtils.getRankedOrder()) {
                curCard = it.next();
                assertEquals(suit, curCard.getSuit());
                assertEquals(rank, curCard.getRank());
            }
        }
    }

}
