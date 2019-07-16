package com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Anime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Doomsdayrs.Jikan4java.types.Support.Reviews.Scores;

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
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
public class AnimeScore extends Scores {
    @JsonProperty("overall")
    public int overall;

    @JsonProperty("story")
    public int story;

    @JsonProperty("animation")
    public int animation;

    @JsonProperty("sound")
    public int sound;

    @JsonProperty("character")
    public int character;

    @JsonProperty("enjoyment")
    public int enjoyment;
    
    @Override
    public String toString() {
        return "AnimeScore{" +
                "overall=" + overall +
                ", story=" + story +
                ", animation=" + animation +
                ", sound=" + sound +
                ", character=" + character +
                ", enjoyment=" + enjoyment +
                '}';
    }
}
