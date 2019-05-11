package com.github.Doomsdayrs.Jikan4java.connection.Club;

import com.github.Doomsdayrs.Jikan4java.connection.Retriever;
import com.github.Doomsdayrs.Jikan4java.types.Main.Club.Club;

import java.util.concurrent.CompletableFuture;

/**
 * Jikan4java
 * 05 / January / 2019
 *
 * @author github.com/doomsdayrs
 */
public class ClubConnection extends Retriever {

    public ClubConnection() {
        super();
    }

    /**
     * retreives a club
     *
     * @param ID id of the club
     * @return AnimePage
     */
    public CompletableFuture<Club> search(String ID) {
        return retrieve(Club.class, baseURL + "/club/" + ID);
    }
}
