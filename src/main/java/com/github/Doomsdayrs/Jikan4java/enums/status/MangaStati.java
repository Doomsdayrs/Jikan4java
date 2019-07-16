package com.github.Doomsdayrs.Jikan4java.enums.status;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 * Jikan4java
 * 18 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
public enum MangaStati implements Stati {
    AIRING("publishing"),
    COMPLETED("completed"),
    COMPLETE(COMPLETED.status),
    TO_BE_PUBLISHED("to_be_published"),
    TBP(TO_BE_PUBLISHED.status),
    UPCOMING(TBP.status);

    private final String status;

    MangaStati(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
