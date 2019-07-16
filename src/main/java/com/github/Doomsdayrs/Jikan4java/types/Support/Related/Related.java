package com.github.Doomsdayrs.Jikan4java.types.Support.Related;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

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
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Related {


    @JsonProperty("Prequel")
    public ArrayList<RelatedType> prequel;

    @JsonProperty("Alternative version")
    public ArrayList<RelatedType> altVersion;

    @JsonProperty("Spin-off")
    public ArrayList<RelatedType> spinOff;

    @JsonProperty("Adaptation")
    public ArrayList<RelatedType> adaptation;

    @JsonProperty("Summary")
    public ArrayList<RelatedType> summaries;

    @JsonProperty("Sequel")
    public ArrayList<RelatedType> sequels;

    @JsonProperty("Side story")
    public ArrayList<RelatedType> sideStories;

    @JsonProperty("Other")
    public ArrayList<RelatedType> other;

    @JsonProperty("Parent story")
    public ArrayList<RelatedType> parentStories;

    @JsonProperty("Alternative setting")
    public ArrayList<RelatedType> alternativeSettings;

    @JsonProperty("Character")
    public ArrayList<RelatedType> characters;

    @JsonProperty("Full story")
    public ArrayList<RelatedType> fullStories;

    @Override
    public String toString() {
        return "Related{" +
                "prequel=" + prequel +
                ", altVersion=" + altVersion +
                ", spinOff=" + spinOff +
                ", adaptation=" + adaptation +
                ", summaries=" + summaries +
                ", sequels=" + sequels +
                ", sideStories=" + sideStories +
                ", other=" + other +
                ", parentStories=" + parentStories +
                ", alternativeSettings=" + alternativeSettings +
                ", characters=" + characters +
                ", fullStories=" + fullStories +
                '}';
    }
}
