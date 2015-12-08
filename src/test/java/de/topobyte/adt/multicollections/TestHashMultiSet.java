// Copyright 2015 Sebastian Kuerten
//
// This file is part of adt-multicollections.
//
// adt-multicollections is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// adt-multicollections is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with adt-multicollections. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.adt.multicollections;

import java.util.Iterator;

public class TestHashMultiSet
{

	/**
	 * Test the MultiSet and its iterator.
	 * 
	 * @param args
	 *            none
	 */
	public static void main(String[] args)
	{
		System.out.println("Testing the HashMultiSet and its iterator");

		HashMultiSet<Integer> hms = new HashMultiSet<Integer>();
		hms.add(1);
		hms.add(2);
		hms.add(2);
		hms.add(2);
		hms.add(2);
		hms.add(3);
		hms.add(5);
		hms.add(7);
		hms.add(7);
		System.out.println(hms);
		Iterator<Integer> iterator = hms.iterator();
		System.out.println(iterator);
		int i = 0;
		while (iterator.hasNext() && i++ < 10) {
			Integer next = iterator.next();
			System.out.println(next);
		}
	}

}
