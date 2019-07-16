package com.github.Doomsdayrs.Jikan4java.types.Support.Forum.Topic;

import com.fasterxml.jackson.annotation.JsonProperty;

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
 * 30 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
public class Topic {
    @JsonProperty("topic_id")
    public int topic_id;
    @JsonProperty("url")
    public String url;
    @JsonProperty("title")
    public String title;
    @JsonProperty("date_posted")
    public String date_posted;
    @JsonProperty("author_name")
    public String author_name;
    @JsonProperty("author_url")
    public String author_url;
    @JsonProperty("replies")
    public int replies;
    @JsonProperty("last_post")
    public LastPost lastPost;

    @Override
    public String toString() {
        return "Topic{" +
                "topic_id=" + topic_id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", date_posted='" + date_posted + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_url='" + author_url + '\'' +
                ", replies=" + replies +
                ", lastPost=" + lastPost +
                '}';
    }
}
