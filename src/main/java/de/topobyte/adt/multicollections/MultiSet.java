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

import java.util.Collection;
import java.util.Set;

/**
 * A set which essentially is not a set since each key has an associated number
 * of occurrences.
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * 
 * @param <T>
 *            the type of elements.
 * 
 */
public interface MultiSet<T> extends Iterable<T>
{

	/**
	 * Put <code>key</code> to the MultiSet once.
	 * 
	 * @param key
	 *            the element to add.
	 */
	public void add(T key);

	public void add(T key, int n);

	/**
	 * Put all keys contained in <code>key</code> into the MultiSet once.
	 * 
	 * @param keys
	 *            a collection of keys.
	 */
	public void addAll(Collection<T> keys);

	public void addAll(Collection<T> keys, int n);

	/**
	 * Remove <cod>key</code> from the MultiSet once.
	 * 
	 * @param key
	 *            the element to remove.
	 */
	public void remove(T key);

	public void removeAll(Collection<? extends T> key);

	/**
	 * Remove key from the MultiSet once.
	 * 
	 * @param key
	 *            the element to remove.
	 * @param n
	 *            the number of times to remove the specified element.
	 */
	public void removeN(T key, int n);

	public void removeAllN(Collection<? extends T> key, int n);

	/**
	 * Remove all occurrences of <code>key</code>.
	 * 
	 * @param key
	 *            the element to remove.
	 */
	public void removeOccurences(T key);

	public void removeAllOccurences(Collection<? extends T> key);

	/**
	 * Get the number of times the element <code>key</code> is present in this
	 * MultiSet.
	 * 
	 * @param key
	 *            the element queried.
	 * @return the number of occurrences of <code>key</code> in this MultiSet.
	 */
	public int occurences(T key);

	/**
	 * Test whether <code>key</code> is present in this MultiSet.
	 * 
	 * @param key
	 *            the element queried.
	 * @return whether key is contained in this MultiSet.
	 */
	public boolean contains(T key);

	/**
	 * Get the set of keys in this MultiSet.
	 * 
	 * @return the set of keys.
	 */
	public Set<T> keySet();

}
