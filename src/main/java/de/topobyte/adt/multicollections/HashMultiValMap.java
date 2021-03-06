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

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 * 
 * @param <K>
 *            keys type.
 * @param <V>
 *            values type.
 * 
 */
public class HashMultiValMap<K, V> implements MultiValMap<K, V>, Serializable
{

	private static final long serialVersionUID = -6028202660344028763L;

	Map<K, Set<V>> data = new HashMap<>();

	@Override
	public boolean containsKey(K key)
	{
		return data.containsKey(key);
	}

	@Override
	public Collection<V> get(K key)
	{
		return data.get(key);
	}

	@Override
	public void put(K key, V value)
	{
		Set<V> values;
		if (data.containsKey(key)) {
			values = data.get(key);
		} else {
			values = new HashSet<>();
			data.put(key, values);
		}
		values.add(value);
	}

	@Override
	public void put(K key, Collection<V> vs)
	{
		Set<V> values;
		if (data.containsKey(key)) {
			values = data.get(key);
		} else {
			values = new HashSet<>();
			data.put(key, values);
		}
		values.addAll(vs);
	}

	@Override
	public void remove(K key, V value)
	{
		if (!data.containsKey(key))
			return;
		Set<V> values = data.get(key);
		values.remove(value);
		if (values.size() == 0)
			data.remove(key);
	}

	@Override
	public void remove(K key, Collection<V> vs)
	{
		if (!data.containsKey(key))
			return;
		Set<V> values = data.get(key);
		values.removeAll(vs);
		if (values.size() == 0)
			data.remove(key);
	}

	@Override
	public void removeAll(K key)
	{
		if (!data.containsKey(key))
			return;
		Set<V> values = data.get(key);
		values.clear();
		data.remove(key);
	}

	@Override
	public Collection<K> keys()
	{
		return data.keySet();
	}

	@Override
	public int size()
	{
		return data.size();
	}

}
