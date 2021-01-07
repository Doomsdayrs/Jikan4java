package com.github.doomsdayrs.jikan4java;

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 */

import com.github.doomsdayrs.jikan4java.core.JikanResult;
import com.github.doomsdayrs.jikan4java.core.Retriever;
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * jikan4java
 * 05 / 01 / 2021
 *
 * @author github.com/doomsdayrs
 */
public class JavaTester {
    final Retriever retriever = new Retriever();

    interface OnSuccess<T> {
        public void invoke(T data);
    }

    interface OnException {
        public void invoke(Exception exception);
    }

    interface OnEmpty {
        public void invoke();
    }

    private <T> void handleJikanResult(@NotNull JikanResult<T> jikanResult,
                                       @NotNull OnSuccess<T> onSuccess,
                                       @NotNull OnException onException,
                                       @NotNull OnEmpty onEmpty) {
        if (jikanResult instanceof JikanResult.Success) {
            T data = ((JikanResult.Success<T>) jikanResult).getData();
            onSuccess.invoke(data);
        } else if (jikanResult instanceof JikanResult.JException) {
            Exception exception =
                    ((JikanResult.JException) jikanResult).getException();
            onException.invoke(exception);
        } else if (jikanResult instanceof JikanResult.Empty) {
            onEmpty.invoke();
        }
    }

    private <T> void handleResult(@NotNull JikanResult<T> jikanResult) {
        OnSuccess<T> onSuccess = (T data) -> System.out.println(data.toString());
        OnException onException = (Exception exception) -> exception.printStackTrace();
        OnEmpty onEmpty = () -> System.out.println("Empty loading");

        handleJikanResult(jikanResult, onSuccess, onException, onEmpty);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new JavaTester().animeTest();

    }

    @Test
    void animeTest() throws ExecutionException, InterruptedException {
        CompletableFuture<JikanResult<Anime>> animeCompletableFuture =
                Anime.getByID(retriever, 1);
        JikanResult<Anime> animeJikanResult =
                animeCompletableFuture.get();
        handleResult(animeJikanResult);
    }
}
