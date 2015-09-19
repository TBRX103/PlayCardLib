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

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Benjamin Schellenberger <benrain@gmail.com>
 */
public class PlayingCardUtils {

    private static final Set<PlayingCard.Rank> rankSet;
    private static final Set<PlayingCard.Suit> suitSet;

    static {
        rankSet = new TreeSet<>((PlayingCard.Rank r1, PlayingCard.Rank r2) -> Integer.compare(r1.getValue(), r2.getValue()));
        suitSet = new LinkedHashSet<>(4);
    }

    public static Set<PlayingCard.Rank> getRankedOrder() {
        synchronized (PlayingCardUtils.class) {
            if (rankSet.isEmpty()) {
                for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                    if (rank == PlayingCard.Rank.JOKER) {
                        continue;
                    }
                    rankSet.add(rank);
                }
            }
        }
        return new LinkedHashSet(rankSet);
    }

    public static Set<PlayingCard.Suit> getSuitOrder() {
        synchronized (PlayingCardUtils.class) {
            if (suitSet.isEmpty()) {
                suitSet.add(PlayingCard.Suit.SPADES);
                suitSet.add(PlayingCard.Suit.DIAMONDS);
                suitSet.add(PlayingCard.Suit.CLUBS);
                suitSet.add(PlayingCard.Suit.HEARTS);
            }
        }

        return new LinkedHashSet(suitSet);

    }

}
