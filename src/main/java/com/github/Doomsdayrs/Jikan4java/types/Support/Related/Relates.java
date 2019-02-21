package com.github.Doomsdayrs.Jikan4java.types.Support.Related;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 15 / November / 2018
 *
 * @author github.com/doomsdayrs
 */

public enum  Relates {
 PREQUEL(0),
 ALT_VERSION(1),
 SPIN_OFF(2),
 ADAPTATION(3),
 SEQUELS(4),
 SIDE_STORIES(5),
 OTHER (6),
 PARENT_STORIES(7),
 ALT_SETTING(8),
 CHARACTER(9),
 SUMMARY(10),
 FULL_STORIES(11);

 private final int id;

 Relates(int id) {
  this.id = id;
 }

 public int getId() {
  return this.id;
 }

 public static Relates getId(int id) {
  switch(id) {
   case 0:  return PREQUEL;
   case 1:  return ALT_VERSION;
   case 2:  return SPIN_OFF;
   case 3:  return ADAPTATION;
   case 4:  return SEQUELS;
   case 5:  return SIDE_STORIES;
   case 6:  return OTHER;
   case 7:  return PARENT_STORIES;
   case 8:  return ALT_SETTING;
   case 9:  return CHARACTER;
   case 10: return SUMMARY;
   case 11: return FULL_STORIES;
   default: return null;
  }
 }

}
