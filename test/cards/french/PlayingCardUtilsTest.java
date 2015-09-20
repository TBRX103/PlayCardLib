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

import java.util.Iterator;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 */
public class PlayingCardUtilsTest {

    public PlayingCardUtilsTest() {
    }

    @Test
    public void testRankOrder() { //Ensure we estabalish the correct order.
        Set<PlayingCard.Rank> ranks = PlayingCardUtils.getRankedOrder();
        Iterator<PlayingCard.Rank> it = ranks.iterator();

        PlayingCard.Rank rank = it.next();
        assertEquals(PlayingCard.Rank.ACE, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.TWO, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.THREE, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.FOUR, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.FIVE, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.SIX, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.SEVEN, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.EIGHT, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.NINE, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.TEN, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.JACK, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.QUEEN, rank);
        rank = it.next();
        assertEquals(PlayingCard.Rank.KING, rank);

    }

    @Test
    public void testSuitOrder() { //Ensure we estabalish the correct order.
        Set<PlayingCard.Suit> suits = PlayingCardUtils.getSuitOrder();
        Iterator<PlayingCard.Suit> it = suits.iterator();

        PlayingCard.Suit suit = it.next();
        assertEquals(PlayingCard.Suit.SPADES, suit);
        suit = it.next();
        assertEquals(PlayingCard.Suit.DIAMONDS, suit);
        suit = it.next();
        assertEquals(PlayingCard.Suit.CLUBS, suit);
        suit = it.next();
        assertEquals(PlayingCard.Suit.HEARTS, suit);
    }

}
